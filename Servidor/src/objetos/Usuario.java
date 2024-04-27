package objetos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.*;

import java.io.Serializable;

//FALTA PONER EL LOOMBOK Y GETTERS Y SETTERS
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@PersistenceCapable
public class Usuario implements Serializable{

    private static final long serialVersionUID = 4L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Getter private int idUsuario;
    @NonNull @Getter @Persistent private String nombre;
    @NonNull @Getter @Persistent private String apellido; 
    @NonNull @Getter @Persistent private String username;
    @NonNull @Getter @Persistent private String contrasenya;
    @NonNull @Getter @Persistent private String email; 
    
}
