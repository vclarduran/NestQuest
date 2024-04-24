package client.controller;

import java.rmi.RemoteException;

import client.remote.RMIServiceLocator_Puerta;

public class SMSController_Puerta
{
    private RMIServiceLocator_Puerta rsl = null;
	
	public SMSController_Puerta(String[] args) throws RemoteException 
	{		

        //aqui se deberian abrir las ventanas

        this.rsl = new RMIServiceLocator_Puerta();
        this.rsl.setService(args[0],args[1],args[2]);
	}

    public static void main(String[] args) throws RemoteException {    	
    	new SMSController_Puerta(args);
    }

    public boolean comprobarReserva(int codAlojamiento, String codRes,){
        RMIServiceLocator_Puerta service = rsl.getService();
        return service.comprobarReserva(codRes, codAlojamiento);
    }

  
}