package Client;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter date server IP address:");
		DateProviderRemoteImpl dateProvider = new DateProviderRemoteImpl(scanner.nextLine());
		String command;
		String result;
		boolean running = true;
		while (running) {
			System.out.println("Please enter a command: ");
			command = scanner.nextLine();
			result = dateProvider.getDateOrCaps(command);
			System.out.println(result);
			if (result.equals("closing connection")) {
				running = false;
			}
		}
		scanner.close();
	}
}
