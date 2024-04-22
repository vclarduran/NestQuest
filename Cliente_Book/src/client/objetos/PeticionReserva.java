package objetos;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class PeticionReserva {

    @Getter private Alojamiento alojamiento;
    @Getter private Date fechaIni;
    @Getter private Date fechaFin; 
}
