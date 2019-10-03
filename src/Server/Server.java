package Server;

import java.net.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket servSock = new ServerSocket(33333);
			System.out.println("The server is running");
			while (true) {
				Socket socket = servSock.accept();
				ClientHandler handler = new ClientHandler(socket);
				handler.start();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}