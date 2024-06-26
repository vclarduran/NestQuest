package server.accesoBD;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

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
import objetos.*;


//PARA ACCESOS A BD (JDO)

public class DbManagerNestQuest {

    private static final PersistenceManagerFactory persistentManagerFactory;

    static {
        try{
            persistentManagerFactory = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            System.out.println("pmf bien");
        }catch(Exception ex){
            System.err.println("* Exception creating PersistenceManagerFactory: " + ex.getMessage());
            throw ex;
        }
    }

    public static Usuario comprobarUsuario(String usuarioParam, String contrasenyaParam) {
        System.out.println(usuarioParam);
        System.out.println(contrasenyaParam);

        // ACCESO A BD
        PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
        Transaction transaction = persistentManager.currentTransaction();
        Usuario usuarioDevuelto = null;
        List<Usuario> usuariosTodos = new ArrayList<>();


        try{
            transaction.begin();

            Query<Usuario> query = persistentManager.newQuery("SELECT FROM "+ Usuario.class.getName() + " WHERE 1");
            usuariosTodos = query.executeList();

            System.out.println(usuariosTodos);
            //SACA UNA LISTA VACIA NO ENCUENTRA LOS DATOS DE LA BD ??????????????

            for (Usuario u : usuariosTodos){
                if(u.getUsername().equals(usuarioParam) && u.getContrasenya().equals(contrasenyaParam)){
                    usuarioDevuelto = u;
                }
            }
 

            // Query<Usuario> query = persistentManager.newQuery(Usuario.class);
            // query.setFilter("username == usuarioParam && contrasenya == contrasenyaParam");
            // query.declareParameters("String usuarioParam, String contrasenyaParam");

            // List<Usuario> usuarios = (List<Usuario>) query.execute(usuarioParam, contrasenyaParam);
            // System.out.println(usuarios);

            // if(!usuarios.isEmpty()){
            //     usuarioDevuelto = usuarios.get(0);
            // }

            transaction.commit();
        }catch (Exception ex){
            System.err.println("* Exception executing a query: " + ex.getMessage());
        }finally{
            if (transaction.isActive()){
                transaction.rollback();
            }
            persistentManager.close();
        }
        
        return new Usuario();
        //return usuarioDevuelto;
    }

    public static boolean crearUsuario(Usuario usuario){
        // ACCESO A BD
        PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
        System.out.println("pm bien");
        Transaction transaction = persistentManager.currentTransaction();
        System.out.println("transaction bien");
        boolean registradoCorrecto = false;


        try{
            transaction.begin();

            persistentManager.makePersistent(usuario);
            System.out.println("Registrado: "+ usuario);
            registradoCorrecto=true;
 

            transaction.commit();
        }catch (Exception ex){
            System.err.println("* Exception executing a query: " + ex.getMessage());
        }finally{
            if (transaction.isActive()){
                transaction.rollback();
            }
            persistentManager.close();
        }
        
        return registradoCorrecto;
    }
    

    //ESTO NO DEVUELVE NADA (no puede acceder a BD)
    public static Reserva comprobarReserva(int codAlojamiento, String codReserva) {

        Reserva encontrada = null; 

        PersistenceManager persistentManager = persistentManagerFactory.getPersistenceManager();
        Transaction transaction = persistentManager.currentTransaction();

        try {
            transaction.begin();

            
            @SuppressWarnings("unchecked")
            Query<Reserva> reservas = persistentManager.newQuery("SELECT FROM " + Reserva.class.getName() +" WHERE idReserva == " +  codReserva);

            for (Reserva r : reservas.executeList()) {
                System.out.println(r.getIdReserva());
            }

            reservas.setUnique(true);
        
            Reserva reserva = (Reserva) reservas.execute(codReserva);

            // if(reserva.getIdAlojamiento() == codAlojamiento && 
            // reserva.getFechaIni().compareTo(LocalDate.now()) <= 0 && 
            // LocalDate.now().compareTo(reserva.getFechaFin()) <= 0){
            //     encontrada = reserva;
            // }
                
            transaction.commit();

        } catch(Exception ex) {
            System.err.println("* Exception executing a query: " + ex.getMessage());
       
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            persistentManager.close();

            return encontrada;
        }

    }

}
