package server.appService; 

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remote.ServerDoor;
import server.accesoBD.DbManagerNestQuest;
import server.remote.IServerDoor;
import objetos.Reserva;

public class NestQuestService_Door {

    private static NestQuestService_Door instance = new NestQuestService_Door();

	public static NestQuestService_Door getInstance(){
		return instance; 
	}
    
	public static Reserva comprobarReserva(int codAlojamiento, String codReserva){
		return DbManagerNestQuest.comprobarReserva(codAlojamiento, codReserva);
	}
}
