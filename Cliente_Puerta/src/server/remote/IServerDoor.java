package server.remote;


import java.rmi.Remote;
import java.rmi.RemoteException;

import objetos.Reserva;

public interface IServerDoor extends Remote 
{
	/* CONSULTA RESERVAS */
	Reserva comprobarReserva(int idAlojamiento, int idReserva) throws RemoteException;

}