package servidor;

import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import cliente.ClienteIF;
import model.ClienteModel;

public class Server extends UnicastRemoteObject implements ServerIF {

	private List<ClienteModel> clientes;

	private static final long serialVersionUID = 1L;

	protected Server() throws RemoteException {
		clientes = new ArrayList<ClienteModel>();
	}

	public synchronized void conectClienteChat(ClienteIF clienteIF, String name) throws RemoteException {
		clientes.add(new ClienteModel(clienteIF, name));
		System.out.println(name + " conectou-se ao servidor!");

	}

	public synchronized void sendMenssage(String menssage) throws RemoteException {

		for (ClienteModel cliente : clientes) {

			try {
				cliente.getClienteIF().recuperaMessage(menssage);
			} catch (ConnectException e) {
				System.out.println(cliente.getName() + " não esta respondendo!");
			}

		}

	}

	public synchronized void disconnectClienteChat(ClienteIF clienteIF) throws RemoteException {

		for (ClienteModel cliente : clientes) {
			if (cliente.getClienteIF().equals(clienteIF)) {
				System.out.println(cliente.getName() + " desconectou-se!");
				clientes.remove(cliente);
			}
		}

	}

}
