package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {

	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
    private DateProvider dateProvider;

    public ClientHandler(Socket socket) {
        try {
        	objectInputStream = new ObjectInputStream(socket.getInputStream());
        	objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
           
            dateProvider = new DateProviderImpl();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void run() {
        try {
            boolean running = true;
            while (running) {
                Object object = objectInputStream.readObject();
                String result = "";
                if (object instanceof DateRpcRequest) {
                	DateRpcRequest dateRpcRequest = (DateRpcRequest) object;
                	if (dateRpcRequest.getMethod().equals("getDateOrCaps")) {
                		result = dateProvider.getDateOrCaps(dateRpcRequest.getCommand());
                	} else {
                		throw new UnsupportedOperationException();
                	}
                } 
                objectOutputStream.writeObject(result);
            }
        } catch (Exception e) {
        }
    }
}