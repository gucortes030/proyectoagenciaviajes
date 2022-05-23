
package modelo.basedatos;
import java.sql.Connection;//conexion a BD
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;//resultado final de datos
import java.sql.ResultSetMetaData;//resultado de metadatos
import java.sql.SQLException;//Tratamiento de Errros de BD SQL
import java.sql.Statement;//Generador de sentencias SQL    DDL,DML,DCL


public class FechasDAO {
    private AdminBD admin;
    private Connection conexion;
    private boolean conexionTransferida;
    private Date date;
    
    
    

    public FechasDAO() {
        admin= new AdminBD();
    }

    public FechasDAO(Connection conexion) {
        this.conexion=conexion;
	conexionTransferida=true;
        
    }
    
    public void consultarFechas(){
        PreparedStatement prepSta=null;//pst
	String sql=null;
	ResultSet tablaResultSet=null;//rs
        int idAux=0;
        
        try {
            conexion=admin.dameConexion();
            if(conexion!=null){
                
                sql = "SELECT * FROM fechas";
                prepSta = conexion.prepareStatement(sql);
                tablaResultSet = prepSta.executeQuery();
                
                while(tablaResultSet.next()) {                
                    System.out.println ("ID-FECHA:"+tablaResultSet.getString("idfecha"));
                    date=tablaResultSet.getDate("fecha");
                    System.out.println ("FECHA:"+date.toString());
                    
                    
                    
                    System.out.println();
                }//termina while
                
            
            }else{
                System.err.println("Tuvimos problemas al establecer la conexión con la Base de Datos");            
            }
            
        } catch (Exception e) {
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
        }//termina finally
        
    }//termina consultarFechas
    
    public int insertarFecha(String fecha,int idFijo){
        int state=0; //No. filas que devuelve el  ps.executeUpdate()
        
	PreparedStatement ps=null;
        ResultSet rs;
        
        String sql="INSERT INTO fechas(idfecha, fecha) VALUES(?,?);";
        
        if(conexionTransferida==false)
            /*En caso de que no se conecte a la base de datos.Solicita una*/
            conexion=admin.dameConexion();
        
        try {
            ps=conexion.prepareStatement(sql);
            //prepareStatement.setString(noColumn,((TextField)datePicker.getEditor()).getText())
            ps.setInt(1,idFijo);
            //ps.setDate(2, date);
            ps.setString(2,fecha);
	    state=ps.executeUpdate();/* Ejecuta el query y devuelve el no. de filas afectadas*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
	    try {
		ps.close();
		    if(conexionTransferida==false)
			conexion.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

	}//termina finall
        return state;
    
    }//Termina insertar fecha
    
}
