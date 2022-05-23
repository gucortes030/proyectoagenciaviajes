
package modelo.basedatos;

import java.util.List;
import modelo.entidades.Usuario;


public interface UsuarioDAOIntf {
    public int login (String user, String password);
    public int insertar(String correo, String contraseña);
    public int actualiza(Usuario cliente);
    public int borrar(Usuario cliente);
    
}
