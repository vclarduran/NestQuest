package client.controller;

import java.rmi.RemoteException;

import client.remote.RMIServiceLocator_Book;
import client.gui.VentanaPpal;

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

    public static void main(String[] args) throws RemoteException {    	
    	new SMSController_Book(args);
    }

  
}