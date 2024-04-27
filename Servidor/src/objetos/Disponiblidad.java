package objetos;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
public class Disponiblidad implements Serializable {

    private static final long serialVersionUID = 1L;

	@Getter @Setter private LocalDate fecha_ini;
	@Getter @Setter private LocalDate fecha_fin;
    @Getter @Setter private Float precio_base;


    
    
}