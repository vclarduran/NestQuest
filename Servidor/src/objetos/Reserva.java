package objetos;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva extends PeticionReserva{

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    int idReserva; 
    Usuario personaQueReserva; 
    //PODEMOS TMB GUARDAR EL ALOJAMIENTO, TENDRÍA SENTIDO POR SI POR EJEMPLO QUEREMOS HACER SECCION "TUS ALOJAMIENTOS PREFERIDOS"
    
}
