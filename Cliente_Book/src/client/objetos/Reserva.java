package objetos;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class Reserva extends PeticionReserva{

    @Getter private int idReserva;
    @Getter private int idConsumido; //este es el id de HotelProvider 
    @Getter private Usuario personaQueReserva; 
    @Getter @Persistent private int idAlojamiento;
    //PODEMOS TMB GUARDAR EL ALOJAMIENTO, TENDRÍA SENTIDO POR SI POR EJEMPLO QUEREMOS HACER SECCION "TUS ALOJAMIENTOS PREFERIDOS"
    
}
