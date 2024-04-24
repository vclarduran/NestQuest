package server.appService; 

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remote.ServerDoor;
import server.remote.IServerDoor;

public class NestQuestService_Door {

    private NestQuestService_Door instance = new NestQuestService_Door();

	public static NestQuestManager_Door getInstance(){
		return instance; 
	}
    
}
