package client.controller;
// Cliente_Book\src\client\controller\SMSController_Book.java;

import java.rmi.RemoteException;

import java.util.List;
import java.util.ArrayList;

import client.remote.RMIServiceLocator_Book;
import client.gui.VentanaPpal;

import objetos.*;

public class SMSController_Book
{
    private RMIServiceLocator_Book rsl = null;
	
	public SMSController_Book(String[] args) throws RemoteException 
	{		
        
        VentanaPpal ventana= new VentanaPpal(this);
        ventana.setVisible(true);

        this.rsl = new RMIServiceLocator_Book();
        this.rsl.setService(args[0],args[1],args[2]);

        //////////////////////////EJEMPLO RECORRIDO getAlojamientos() por consola //////////////////////

         List<Alojamiento> alojamientos = new ArrayList<>();
         alojamientos = this.getAlojamientos();

         List<Alojamiento> alojamientosConHabitaciones = new ArrayList<>();
         alojamientosConHabitaciones = this.getHabitaciones(alojamientos);

        System.out.println("");
        System.out.println("ALOJAMIENTOS:");
        for(Alojamiento alojamiento : alojamientosConHabitaciones){
          
           System.out.println(alojamiento.getId());
          System.out.println(alojamiento.getNombre());
           System.out.println(alojamiento.getDireccion());
           System.out.println(alojamiento.getDescripcion());  
           for(Habitacion habitacion : alojamiento.getHabitacion()){
                System.out.println(habitacion.getId());
                System.out.println(habitacion.getNombre());
                System.out.println(habitacion.getDescripcion());
                System.out.println(habitacion.getAforo());
           }
        }

    
	}

    	List<Alojamiento> getAlojamientos() throws RemoteException {
            return this.rsl.getService().getAlojamientos();
        }

        List<Alojamiento> getHabitaciones(List<Alojamiento> alojamientos)throws RemoteException{
            return this.rsl.getService().getHabitaciones(alojamientos);
        }

        public Usuario comprobarUsuario (String usuario, String contrasenya) throws RemoteException{
            return this.rsl.getService().comprobarUsuario(usuario, contrasenya);
        }

        public boolean crearUsuario (Usuario usuario) throws RemoteException{
            return this.rsl.getService().crearUsuario(usuario);
        }


    public static void main(String[] args) throws RemoteException {    	
    	new SMSController_Book(args);
    }

  
}