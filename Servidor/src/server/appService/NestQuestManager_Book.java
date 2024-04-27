package server.appService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remote.ServerBook;
import server.remote.IServerBook;

import objetos.*;


public class NestQuestManager_Book {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
            System.exit(0);
        }

        String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

        try {
            NestQuestService_Book appServiceBook = new NestQuestService_Book();
            IServerBook objServer = new ServerBook(appServiceBook);
            Registry registry = LocateRegistry.createRegistry(Integer.valueOf(args[1]));
            registry.rebind(name, objServer);
            System.out.println("* Server '" + name + "' active and waiting...");

        } catch (Exception e) {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}