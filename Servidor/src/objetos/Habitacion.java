package objetos;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.*;

import java.io.Serializable;

import java.util.List;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter private int id;
	@NonNull @Getter @Setter private String nombre;
	@NonNull @Getter @Setter private String descripcion;
    @Getter @Setter private String imagenes;
    @NonNull @Getter @Setter private String aforo;
    // @Getter @Setter private List<Disponiblidad> disponiblidad;


    
    
}