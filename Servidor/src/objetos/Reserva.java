package objetos;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Getter;

@PersistenceCapable
@AllArgsConstructor
public class Reserva extends PeticionReserva implements Serializable{

    private static final long serialVersionUID = 3L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Getter private int idReserva;  //TENDRIAMOS QUE CREAR CODIGOS UNICOS
    @Getter private int idConsumido; //este es el id de HotelProvider 
    @Getter private Usuario personaQueReserva;
    @Getter private int idAlojamiento;
    //PODEMOS TMB GUARDAR EL ALOJAMIENTO, TENDRÍA SENTIDO POR SI POR EJEMPLO QUEREMOS HACER SECCION "TUS ALOJAMIENTOS PREFERIDOS"
    
}
