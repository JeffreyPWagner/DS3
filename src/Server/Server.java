package Server;

import java.net.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket servSock = new ServerSocket(33333);
			int clientNumber = 1;
			System.out.println("The server is running");
			while (true) {
				Socket socket = servSock.accept();
				String welcomeMessage = "Hello, you are client " + clientNumber++;
				ClientHandler handler = new ClientHandler(socket, welcomeMessage);
				handler.start();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}