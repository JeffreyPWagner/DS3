package Server;

import java.io.Serializable;

public class DateRpcRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String method;
	private String command;
	
	public DateRpcRequest (String method, String command) {
		this.method = method;
		this.command = command;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
	
	
	
}
