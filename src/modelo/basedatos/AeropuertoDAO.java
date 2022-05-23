
package modelo.basedatos;
import java.sql.Connection;//conexion a BD
import java.sql.PreparedStatement;
import java.sql.ResultSet;//resultado final de datos
import java.sql.ResultSetMetaData;//resultado de metadatos
import java.sql.SQLException;//Tratamiento de Errros de BD SQL
import java.sql.Statement;//Generador de sentencias SQL    DDL,DML,DCL
import java.util.ArrayList;
import modelo.entidades.Aeropuerto;

public class AeropuertoDAO {
    private AdminBD admin;
    private Connection conexion;
    private boolean conexionTransferida;
    
    public AeropuertoDAO() {
	admin= new AdminBD();
    }
    
   public AeropuertoDAO(Connection conexion) {
	this.conexion=conexion;
	conexionTransferida=true;
    }
    
    
    
    public ArrayList<Aeropuerto> consultaAeropuertos(){
        ArrayList <Aeropuerto> listAeropuertos = new ArrayList<>();
        Aeropuerto aeropuerto=null;
        
        PreparedStatement prepSta=null;//pst
	String sql=null;
	ResultSet tablaResultSet=null;//rs

	try {        
            conexion=admin.dameConexion();//Connection connect=null;
            
            if(conexion!=null){
            
                sql = "SELECT * FROM aeropuertos WHERE 1 ORDER BY ciudad";
                prepSta = conexion.prepareStatement(sql);
                tablaResultSet = prepSta.executeQuery();
                
                while(tablaResultSet.next()){

                    aeropuerto = new Aeropuerto();                    
                    aeropuerto.setId(tablaResultSet.getInt("idaeropuerto"));
                    aeropuerto.setEstado(tablaResultSet.getString("estado"));
                    aeropuerto.setCiudad(tablaResultSet.getString("ciudad"));
                    
                    listAeropuertos.add(aeropuerto);                               
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
        
        
        return listAeropuertos;
    
    }//Termina metodo consultaAeropuertos
    
    
    public ArrayList<Aeropuerto> consultaAeropuertos(int identificador){
        ArrayList <Aeropuerto> listAeropuertos = new ArrayList<>();
        Aeropuerto aeropuerto=null;
        
        PreparedStatement prepSta=null;//pst
	String sql=null;
	ResultSet tablaResultSet=null;//rs

	try {        
            conexion=admin.dameConexion();//Connection connect=null;
            
            if(conexion!=null){
            
                sql = "SELECT * FROM aeropuertos WHERE NOT idaeropuerto = ? ORDER BY ciudad";
                       
                
                prepSta = conexion.prepareStatement(sql);
                prepSta.setInt(1, identificador);
                tablaResultSet = prepSta.executeQuery();
                
                
                while(tablaResultSet.next()){

                    aeropuerto = new Aeropuerto();                    
                    aeropuerto.setId(tablaResultSet.getInt("idaeropuerto"));
                    aeropuerto.setEstado(tablaResultSet.getString("estado"));
                    aeropuerto.setCiudad(tablaResultSet.getString("ciudad"));
                    
                    listAeropuertos.add(aeropuerto);                               
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
        
        
        return listAeropuertos;
    
    }
    
    
    
    
    
}
