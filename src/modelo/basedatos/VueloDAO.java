/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.basedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.entidades.Aerolinea;
import modelo.entidades.Aeropuerto;
import modelo.entidades.Vuelo;

public class VueloDAO {
    private AdminBD admin;
    private Connection conexion;
    private boolean conexionTransferida;
    private int idViaje=0;
    private String horaSalida="";
    private String horaLlegada="";
    private int idAvion=0;
    private int lugaresDisponibles=0;
    private int lugaresReservados=0;
    private int totalLugares=0;
    private int tarifa=0;

    public VueloDAO() {
        admin= new AdminBD();
    }

    public VueloDAO(Connection conexion) {
        this.conexion = conexion;
        conexionTransferida=true;
    }
    
    public ArrayList<Vuelo> consultarVuelos(Aeropuerto origen,Aeropuerto destino,String fechaSelec,int noPasajeros){
        //(String cdOrigen,String cdDestino,String fechaSelec,int noPasajeros)
        System.out.println("Entrando a consultarVuelos");
        ArrayList<Vuelo> listaVuelos=new ArrayList<Vuelo>();
        Vuelo vuelo=null;
        Aerolinea aerolinea=null;
        int contador=0;
        String cdOrigen=origen.getCiudad();
        String cdDestino=destino.getCiudad();
        
        PreparedStatement prepSta=null;//pst
	String sql=null;
	ResultSet tablaResultSet=null;//rs
        
        try {
            conexion=admin.dameConexion();
            if(conexion!=null){
                System.out.println("Entrando a conexion!=null");
                sql = "SELECT * FROM vuelos WHERE viaje=(SELECT idviaje FROM viajes WHERE origen IN(SELECT idaeropuerto FROM aeropuertos WHERE ciudad= ? ) AND destino IN(SELECT idaeropuerto FROM aeropuertos WHERE ciudad= ? )) AND fecha= ? AND lugdispo>= ?";
                
                prepSta = conexion.prepareStatement(sql);
                prepSta.setString(1, cdOrigen);
                prepSta.setString(2, cdDestino);
                prepSta.setString(3, fechaSelec);
                prepSta.setInt(4, noPasajeros);
                tablaResultSet = prepSta.executeQuery();//Se desplaza en fila por fila
                
                
                if(tablaResultSet==null){
                    System.out.println("CONSULTA NO TIENE RESULTADOS");
                }else{
                    System.out.println("Entrando a while(tablaResultSet.next())");
                    while(tablaResultSet.next()){//Se ejecutara mientras encuentre registros

                        vuelo = new Vuelo();
                        aerolinea=new Aerolinea();
                    
                        vuelo.setId(tablaResultSet.getInt("idvuelo"));
                    
                        aerolinea.setNombre(tablaResultSet.getString("aerolinea"));
                        System.out.println("Aerolinea:"+aerolinea.getNombre());
                        vuelo.setAerolinea(aerolinea);
                    
                        idViaje=tablaResultSet.getInt("viaje");//No es necesario
                        //System.out.println("IDviaje:"+idViaje);
                        vuelo.setOrigen(origen);
                        vuelo.setDestino(destino);
             
                        //fecha=tablaResultSet.getString("fecha");
                        //System.out.println("fecha:"+fechaSelec);
                        vuelo.setFechaSalida(fechaSelec);
                    
                        horaSalida=tablaResultSet.getString("horasalida");
                          //System.out.println("horaSalida:"+horaSalida);
                        vuelo.setHoraSalida(horaSalida);
                        
                        horaLlegada=tablaResultSet.getString("horallegada");
                        vuelo.setHoraLlegada(horaLlegada);
                    
                        lugaresDisponibles=tablaResultSet.getInt("lugdispo");
                        //System.out.println("lugaresDisponibles:"+lugaresDisponibles);
                        vuelo.setLugDisponibles(lugaresDisponibles);
                    
                        lugaresReservados=tablaResultSet.getInt("lugreser");
                        //System.out.println("lugaresReservados:"+lugaresReservados);
                        vuelo.setLugReservados(lugaresReservados);
                    
                        totalLugares=tablaResultSet.getInt("totallugares");
                        //System.out.println("totalLugares:"+totalLugares);
                        vuelo.setTotalLugares(totalLugares);
                    
                        tarifa=tablaResultSet.getInt("tarifa");
                        //System.out.println("tarifa:"+tarifa);
                        vuelo.setTarifa(tarifa);
                    
                    
                        listaVuelos.add(vuelo);
                        //System.out.println("IDvuelo:"+listaVuelos.get(contador).getId());
                        //System.out.println("IDviaje:"+idViaje);
                        //contador=contador+1;
                    }//termina While
            
            
                }
                
            
            }else{
                System.err.println("Tuvimos problemas al establecer la conexión con la Base de Datos");
            }
            
        } catch (SQLException e) {
            System.err.println("Surgieron errores en el proceso de consulta: "+e.getMessage());
        }finally{
            try {
                if(conexion!=null){//Si la conexion se establecio de forma exitosa
                    //Cerramos la conexion
                    conexion.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        return listaVuelos;
    }//termina consultarVuelos
    
}
