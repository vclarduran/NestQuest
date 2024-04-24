package objetos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;

//FALTA PONER EL LOOMBOK Y GETTERS Y SETTERS
@AllArgsConstructor
@PersistenceCapable
public class Usuario {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Getter private int idUsuario;
    @Getter @Persistent private String nombre;
    @Getter @Persistent private String apellido; 
    @Getter @Persistent private String username;
    @Getter @Persistent private String contrasenya;
    @Getter @Persistent private String email; 
    
}
