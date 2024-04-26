package objetos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.*;

//FALTA PONER EL LOOMBOK Y GETTERS Y SETTERS
@AllArgsConstructor
@RequiredArgsConstructor
public class Usuario implements Serializable{

    private static final long serialVersionUID = 4L;

    @Getter private int idUsuario;
    @NonNull @Getter private String nombre;
    @NonNull @Getter private String apellido; 
    @NonNull @Getter private String username;
    @NonNull @Getter private String contrasenya;
    @NonNull @Getter private String email; 
    
}
