package objetos;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;

import java.util.List;
import java.util.Arrays;


@AllArgsConstructor
@NoArgsConstructor
public class Alojamiento implements Serializable {

    private static final long serialVersionUID = 1L;

	@Getter @Setter private int id;
	@Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    @Getter @Setter private String direccion;
    @Getter @Setter private List<Habitacion> habitacion;


    
}
