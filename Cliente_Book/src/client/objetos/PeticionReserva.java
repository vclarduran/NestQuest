package objetos;
import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class PeticionReserva {

    @Getter private Alojamiento alojamiento;
    @Getter private Date fechaIni;
    @Getter private Date fechaFin; 
}
