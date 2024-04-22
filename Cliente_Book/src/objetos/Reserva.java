package objetos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@PersistenceCapable
public class Reserva extends PeticionReserva{

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    int idReserva;
    int idConsumido; //este es el id de HotelProvider 
    Usuario personaQueReserva; 
    //PODEMOS TMB GUARDAR EL ALOJAMIENTO, TENDRÍA SENTIDO POR SI POR EJEMPLO QUEREMOS HACER SECCION "TUS ALOJAMIENTOS PREFERIDOS"
    
}
