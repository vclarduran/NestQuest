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
    
	}

    	List<Alojamiento> getAlojamientos() throws RemoteException {
            return this.rsl.getService().getAlojamientos();
        }

        List<Habitacion> getHabitaciones() throws RemoteException {
            return this.rsl.getService().getHabitaciones();
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