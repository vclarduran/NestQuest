package objetos;
import lombok.AllArgsConstructor;

import java.util.Date;


@AllArgsConstructor
public class PeticionReserva {

    Alojamiento alojamiento;
    Date fechaIni;
    Date fechaFin; 
}
