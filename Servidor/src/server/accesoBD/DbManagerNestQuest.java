package server.accesoBD;

import java.time.LocalDate;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import java.util.Properties;

import java.io.FileInputStream;

import objetos.Reserva;
import objetos.Usuario;

//PARA ACCESOS A BD (JDO)

public class DbManagerNestQuest {

    //ESTO NO DEVUELVE LO QUE TOCA 
    public static Reserva comprobarReserva(int codAlojamiento, String codReserva) {

        return new Reserva(22, 22, new Usuario(), 22);

        // Reserva encontrada = null; 

        // PersistenceManagerFactory persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        // PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
        // Transaction transaction = persistentManager.currentTransaction();

        // try {
        //     transaction.begin();

            
        //     @SuppressWarnings("unchecked")
        //     Query<Reserva> reservas = persistentManager.newQuery("SELECT FROM " + Reserva.class.getName() + " WHERE idReserva =" + codReserva);

        //     reservas.setUnique(true);
        
        //     encontrada = (Reserva) reservas.execute(codReserva);

        //     // if(reserva.getIdAlojamiento() == codAlojamiento && 
        //     // reserva.getFechaIni().compareTo(LocalDate.now()) <= 0 && 
        //     // LocalDate.now().compareTo(reserva.getFechaFin()) <= 0){
        //     //     encontrada = reserva;
        //     // }
                
        //     transaction.commit();

        // } catch(Exception ex) {
        //     System.err.println("* Exception executing a query: " + ex.getMessage());
       
        // } finally {
        //     if (transaction.isActive()) {
        //         transaction.rollback();
        //     }

        //     persistentManager.close();

        //     return encontrada;
        // }

    }

}
