package objetos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@PersistenceCapable
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario implements Serializable{

    private static final long serialVersionUID = 4L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Getter @Setter private int idUsuario;
    
    @Persistent @NonNull @Getter @Setter private String nombre;
    @Persistent @NonNull @Getter @Setter private String apellido; 
    @Persistent @NonNull @Getter @Setter private String username;
    @Persistent @NonNull @Getter @Setter private String contrasenya;
    @Persistent @NonNull @Getter @Setter private String email; 
    
}
