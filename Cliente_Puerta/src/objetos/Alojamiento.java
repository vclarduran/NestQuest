package objetos;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
public class Alojamiento implements Serializable {

    private static final long serialVersionUID = 1L;

	@Getter @Setter private int id;
	@Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    @Getter @Setter private String direccion;
    
}
