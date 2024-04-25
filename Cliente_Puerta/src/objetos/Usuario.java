package objetos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

//FALTA PONER EL LOOMBOK Y GETTERS Y SETTERS
@AllArgsConstructor
public class Usuario implements Serializable{


    @Getter private int idUsuario;
    @Getter private String nombre;
    @Getter private String apellido; 
    @Getter private String username;
    @Getter private String contrasenya;
    @Getter private String email; 
    
}
