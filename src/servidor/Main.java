package servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main {
	public static void main(String[] args) {

		Server server;
		try {
			server = new Server();
			System.setProperty("java.rmi.server.hostname", "192.168.43.58");// meu ip
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("servico", server);
			
		} catch (RemoteException e) {
			System.err.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
