package objetos;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class PeticionReserva implements Serializable{

    private static final long serialVersionUID = 2L;

    @Getter private Alojamiento alojamiento;
    @Getter private Date fechaIni;
    @Getter private Date fechaFin; 
}
