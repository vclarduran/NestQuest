package server.appService; 

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Date;
import java.io.IOException;


import server.remote.ServerBook;
import server.accesoBD.DBManagerHotelProvider;
import server.remote.IServerBook;

public class NestQuestService_Book {

	private static NestQuestService_Book instance = new NestQuestService_Book();

	public static NestQuestService_Book getInstance(){
		return instance; 
	}

    public List<Alojamiento> conseguirAlojamientos(){
		return DBManagerHotelProvider.getAlojamientos();
    }
}
