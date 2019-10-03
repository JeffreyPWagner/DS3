package Client;

import Server.DateProvider;
import Server.DateRpcRequest;

import java.io.*;
import java.net.*;

public class DateProviderRemoteImpl implements DateProvider {
	
	String serverIP;;
	
	public DateProviderRemoteImpl(String serverIP) {
		this.serverIP = serverIP;
	}
	
	@Override
	public String getDateOrCaps(String command) {
		try {
			Socket sock = new Socket(serverIP, 33333);
			
			DateRpcRequest dateRpcRequest = new DateRpcRequest("getDateOrCaps", command);
			ObjectOutputStream outputStream = new ObjectOutputStream(sock.getOutputStream());
			
			outputStream.writeObject(dateRpcRequest);
			
			ObjectInputStream inputStream = new ObjectInputStream(sock.getInputStream());
			Object response = inputStream.readObject();
			
			if (response instanceof String) {
				sock.close();
				return (String) response;
			} else {
				sock.close();
				throw new InternalError();
			}
		} catch (Exception e) {
			throw new InternalError();
		}
	}
}
