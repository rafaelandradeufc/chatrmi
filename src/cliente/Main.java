package cliente;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import servidor.ServerIF;

public class Main {

	public static void main(String[] args) throws NotBoundException, IOException, ParseException, InterruptedException {

		//System.setProperty("java.rmi.server.hostname", "192.168.43.58");
		ServerIF server = (ServerIF) Naming.lookup("//192.168.43.58/servico");
		String name = JOptionPane.showInputDialog("Nome do cliente: ");
		new Thread(new Cliente(name, server)).start();

	}

}
