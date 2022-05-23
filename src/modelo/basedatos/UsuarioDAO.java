
package modelo.basedatos;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.entidades.Usuario;


public class UsuarioDAO implements UsuarioDAOIntf{
    private AdminBD admin;
    private Connection conexion;
    private boolean conexionTransferida;

    public UsuarioDAO() {
        admin = new AdminBD();		
	conexion=null;
        
    }

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
        conexionTransferida=true;
    }
    
    
    @Override
    public int login(String user, String password) {
        int state=-1;
        PreparedStatement ps=null;
	ResultSet rs=null;
	Usuario usuario= null;
        try {
            conexion=admin.dameConexion();
            if(conexion!=null){
                
                String sql = "SELECT * FROM usuarios WHERE correo=? AND password=?";
                
                ps = conexion.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, password);
                
                rs = ps.executeQuery();
                
                if(rs.next()){  //Se encontro un registro con los datos que le pasamos
                    state = 1;
                }else{
                    state = 0;//No se encontro registro con esos datos
                }
                
            }else{
              JOptionPane.showMessageDialog(null, "Hubo un error al conectarse con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
             
            }
            
            
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Hubo un error de ejecución, posibles errores:\n"
                                              + ex.getMessage());
        }finally{
            
            try{
                if(conexion != null){
                    conexion.close();
                    //ConnectionPoolMySQL.getInstance().closeConnection(connection);            
                }            
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
                //ex.printStackTrace();
            }

        }
        return state;
        /*Se produce cuando se llama a un código que depende de un teclado, pantalla o mouse en un entorno que no admite un teclado, pantalla o mouse.
        */
        
    }
    

    

    @Override
    public int insertar(String correo, String contraseña) {
        Usuario usuario=new Usuario(correo,contraseña);
        int state=0; //No. filas que devuelve el  ps.executeUpdate()
        
	PreparedStatement ps=null;
        ResultSet rs;
            
        String sqlAux="SELECT idusuario FROM usuarios ORDER BY idusuario DESC LIMIT 1;";
        //String altaLibro="INSERT INTO libro (`id`, `titulo`, `ISBN`, `autor`) values('"+objLibro.getId()+"','"+objLibro.getTitulo()+"','"+objLibro.getISBN()+"','"+objLibro.getAutor()+"')";
	String sql="INSERT INTO usuarios(idusuario, correo, password) VALUES(?,?,?);";
        
	if(conexionTransferida==false)
            /*En caso de que no se conecte a la base de datos.Solicita una*/
            conexion=admin.dameConexion();
		
	try {
            int idAux=0;
            System.out.println("CONSULTA 1");
            /*Consulta 1 obtener el ultimo 'idusuario'*/
            ps=conexion.prepareStatement(sqlAux);
	    rs=ps.executeQuery();//Ejecuta el query
            
            while(rs.next()) {                
                idAux=rs.getInt("idusuario");
	    }
            
            
            //rs.getInt("idusuario");//Obtiene el idusuarrio
            System.out.println("    EL ULTIMO idusario ES:"+idAux);
            usuario.setId(idAux+1);//Le asigna un id al nuevo usuario
            
           
            
            /*Consulta 2 Insertar los datos del usuario*/
            System.out.println("CONSULTA 2");
            ps=null;
            //rs=null;
            ps=conexion.prepareStatement(sql);
            ps.setInt(1,usuario.getId());
	    ps.setString(2,usuario.getCorreo());
	    ps.setString(3,usuario.getContraseña());
	    state=ps.executeUpdate();/* Ejecuta el query y devuelve el no. de filas afectadas por un INSERT, UPDATE y DELETE*/
	
	   } catch (SQLException e) {
		e.printStackTrace();
	   }finally {
		try {
		    ps.close();
		    if(conexionTransferida==false)
			conexion.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

	    }		
	return state;
        
              
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualiza(Usuario cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int borrar(Usuario cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
