package objetos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import lombok.AllArgsConstructor;

//FALTA PONER EL LOOMBOK Y GETTERS Y SETTERS
@AllArgsConstructor
@PersistenceCapable
public class Usuario {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    private int idUsuario;
    private String nombre;
    private String apellido; 
    private String username;
    private String contrasenya;
    private String email; 
    
}
