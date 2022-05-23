
package modelo.basedatos;
import java.sql.Connection;//conexion a BD
import java.sql.DriverManager;
import java.sql.ResultSet;//resultado final de datos
import java.sql.ResultSetMetaData;//resultado de metadatos
import java.sql.SQLException;//Tratamiento de Errros de BD SQL
import java.sql.Statement;//Generador de sentencias SQL    DDL,DML,DCL
import javax.swing.JOptionPane;


public class AdminBD {
    private String URL;
    private String usuario;
    private String contra;
    private String esquema;
    private String host;
    private String puerto;
    private String baseDatos;
    
    //public Connection cn;
    public Statement stmt;
    public ResultSet rs;
    
    public AdminBD() {
	esquema="jdbc:mysql:";
	host="localhost"; //Quiere decirque se va a conectar de forma local, 127.0.0.1 
	puerto="3306";//Puerto que le asigna Xamp a MySQL
	baseDatos="proyectoagenciaviajes";
	URL=esquema+"//"+host+":"+puerto+"/"+baseDatos;
	usuario="root";
	contra=""; //En este caso no se le asigno contraseña a la base de datos
    }
    
    /*
    public Connection cn;
    public Statement stmt;
    public ResultSet rs;
    */
    public Connection dameConexion() {
	Connection conexion=null;     //"jdbc:mysql://127.0.0.1:5432/banco"
	try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(URL,usuario, contra);
            //JOptionPane.showMessageDialog(null, "Conexion a BD OK\n\nCORTES");
            System.out.println("Conexion a BD Exitosa");
            stmt=conexion.createStatement();//genera sentencias sobre objetos de base de datos
	}catch(SQLException esql) {
            //esql.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error MySql de base de datos 1:\n"+esql);
	}catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error General de base de datos 2:\n"+e);
        }
	return conexion;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getEsquema() {
        return esquema;
    }

    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getBaseDatos() {
        return baseDatos;
    }

    public void setBaseDatos(String baseDatos) {
        this.baseDatos = baseDatos;
    }
    
    
    
    
}
