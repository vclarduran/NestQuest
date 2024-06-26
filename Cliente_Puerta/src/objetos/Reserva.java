package objetos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;


@AllArgsConstructor
public class Reserva extends PeticionReserva implements Serializable{

    private static final long serialVersionUID = 3L;

    @Getter private int idReserva;
    @Getter private int idConsumido; //este es el id de HotelProvider 
    @Getter private Usuario personaQueReserva; 
    @Getter private int idAlojamiento;
    //PODEMOS TMB GUARDAR EL ALOJAMIENTO, TENDRÍA SENTIDO POR SI POR EJEMPLO QUEREMOS HACER SECCION "TUS ALOJAMIENTOS PREFERIDOS"
    
}
