package client.controller;

import java.rmi.RemoteException;

import client.remote.RMIServiceLocator_Book;

public class SMSController_Book
{
    private RMIServiceLocator_Book rsl = null;
	
	public SMSController_Book(String[] args) throws RemoteException 
	{		

        //aqui se deberian abrir las ventanas

        this.rsl = new RMIServiceLocator_Book();
        this.rsl.setService(args[0],args[1],args[2]);
	}

    public static void main(String[] args) throws RemoteException {    	
    	new SMSController_Book(args);
    }

  
}