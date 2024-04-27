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

@PersistenceCapable
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario implements Serializable{

    private static final long serialVersionUID = 4L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Getter private int idUsuario;
    @NonNull @Getter private String nombre;
    @NonNull @Getter private String apellido; 
    @NonNull @Getter private String username;
    @NonNull @Getter private String contrasenya;
    @NonNull @Getter private String email; 
    
}
