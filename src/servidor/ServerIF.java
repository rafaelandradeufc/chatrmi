package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import cliente.ClienteIF;

public interface ServerIF extends Remote {

	void conectClienteChat(ClienteIF clienteIF, String name) throws RemoteException;

	void disconnectClienteChat(ClienteIF clienteIF) throws RemoteException;

	void sendMenssage(String menssage) throws RemoteException;

}
