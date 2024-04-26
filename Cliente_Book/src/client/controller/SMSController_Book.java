package client.controller;

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

        List<Alojamiento> alojamientos = new ArrayList<>();
        alojamientos = this.getAlojamientos();

        System.out.println("");
        System.out.println("ALOJAMIENTOS:");
        for(Alojamiento alojamiento : alojamientos){
          
        //   System.out.println(alojamiento.getId());
          System.out.println(alojamiento.getNombre());
        //   System.out.println(alojamiento.getDireccion());
        //   System.out.println(alojamiento.getDescripcion());  
        }
        
	}

    	List<Alojamiento> getAlojamientos() throws RemoteException {
            return this.rsl.getService().getAlojamientos();
        }

    public static void main(String[] args) throws RemoteException {    	
    	new SMSController_Book(args);
    }

  
}