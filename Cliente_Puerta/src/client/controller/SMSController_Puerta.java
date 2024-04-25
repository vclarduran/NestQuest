package client.controller;

import java.rmi.RemoteException;

import client.remote.RMIServiceLocator_Puerta;
import client.controller.SMSController_Puerta;

import client.gui.VentanaDoor;

import objetos.*;

public class SMSController_Puerta
{
    private RMIServiceLocator_Puerta rsl = null;
	
	public SMSController_Puerta(String[] args) throws RemoteException 
	{		

        VentanaDoor ventanaPrincipal = new VentanaDoor(this);
        ventanaPrincipal.setVisible(true);

        this.rsl = new RMIServiceLocator_Puerta();
        this.rsl.setService(args[0],args[1],args[2]);
	}

    public static void main(String[] args) throws RemoteException {    	
    	new SMSController_Puerta(args);
    }

    public Reserva comprobarReserva(int codAlojamiento, String codRes){
        return rsl.getService().comprobarReserva(codAlojamiento, codRes);
    }

  
}