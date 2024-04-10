package objetos;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Reserva extends PeticionReserva{

    int idReserva; 
    Usuario personaQueReserva; 
    
}
