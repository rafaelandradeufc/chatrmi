package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClienteIF extends Remote {

	void recuperaMessage(String message) throws RemoteException;

	String getNameCliente() throws RemoteException;

}
