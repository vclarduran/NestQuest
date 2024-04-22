package objetos;
import lombok.Getter;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Alojamiento {
	
	@Getter private String nombre;
    @Getter private String descripcion;
    @Getter private String direccion;
    
}
