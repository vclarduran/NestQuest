package objetos;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@PersistenceCapable
public class Reserva extends PeticionReserva implements Serializable{

    private static final long serialVersionUID = 3L;

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @Getter private int idReserva;  //TENDRIAMOS QUE CREAR CODIGOS UNICOS
    @Getter @Persistent private int idConsumido; //este es el id de HotelProvider 
    @Getter @Persistent private Usuario personaQueReserva;
    @Getter @Persistent private int idAlojamiento;
    //PODEMOS TMB GUARDAR EL ALOJAMIENTO, TENDRÍA SENTIDO POR SI POR EJEMPLO QUEREMOS HACER SECCION "TUS ALOJAMIENTOS PREFERIDOS"
    
}
