package server.appService; 

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Date;
import java.io.IOException;


import server.remote.ServerBook;
import server.accesoBD.DBManagerHotelProvider;
import server.accesoBD.DbManagerNestQuest;
import server.remote.IServerBook;

import java.util.List;
import java.util.ArrayList;

import objetos.Alojamiento;
import objetos.*;

public class NestQuestService_Book {

	private static NestQuestService_Book instance = new NestQuestService_Book();

	public static NestQuestService_Book getInstance(){
		return instance; 
	}

    public List<Alojamiento> conseguirAlojamientos(){
		return DBManagerHotelProvider.getAlojamientos();
    }

	public Usuario comprobarUsuario(String usuario, String contrasenya){
		return DbManagerNestQuest.comprobarUsuario(usuario, contrasenya);
	}

	public boolean crearUsuario(Usuario usuario){
		return DbManagerNestQuest.crearUsuario(usuario);
	}

}
