package br.com.projectMVC;

import java.util.List;
import java.util.Scanner;

import br.com.projectMVC.controller.ClientController;
import br.com.projectMVC.model.Client;

public class MainClient {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Client client = new Client(); 

		ClientController controller = new ClientController();

		Integer option = 0;
		
		do {
		System.out.println("Welcome to Client Registration");
		System.out.println("Choose the option that you want:");
		System.out.println("1 - Insert new Client");
		System.out.println("2 - Show all Client list");
		System.out.println("3 - Show a Client by the ID");
		System.out.println("4 - Update a Client information");
		System.out.println("5 - Delete a Client from the list");
		System.out.println("6 - Show if CPF is positive or nagative");
		System.out.println("0 - To exit");
		option = scan.nextInt();

		switch (option) {

		case 1:
			System.out.println("Inform the Client name:");
			client.setName(scan.next());
			System.out.println("Now the Client address:");
			client.setAddress(scan.next());
			System.out.println("Type the new status (true -  The registration is positive || false - The registration is negative");
			client.setStatus(scan.nextBoolean());
			controller.insert(client);
			break;

		case 2:
			
			List<Client> clients = controller.getAll();
			for (Client c : clients) {
				System.out.println(c.toString());
			}
			break;

		case 3:
			System.out.println("Which ID you want to show in the screen?");
			Integer optionalId = scan.nextInt();
			client = controller.getById(optionalId);
			System.out.println(client.toString());
			break;

		case 4:
			clients = controller.getAll();
			for (Client c : clients) {
				System.out.println(c.toString());
			}
			System.out.println("Which field you want to update");
			System.out.println("1 - NAME ");
			System.out.println("2 - ADDRESS ");
			System.out.println("3 - STATUS ");
			Integer updateOption = scan.nextInt();
			
			switch (updateOption) {
			
			case 1:
				System.out.println("Which ID you want to UPDATE:");
				Integer nameOption = scan.nextInt();
				client = controller.getById(nameOption);
				System.out.println("Type the new name");
				client.setName(scan.next());
				controller.update(client);
			break;
				
			case 3:
				System.out.println("Which ID you want to UPDATE:");
				Integer statusOption = scan.nextInt();
				client = controller.getById(statusOption);
				System.out.println("Type the new status (true -  The registration is positive || false - The registration is negative");
				client.setStatus(scan.nextBoolean());
				controller.update(client);
			break;
				
			case 2:
				System.out.println("Which ID you want to UPDATE:");
				Integer addressOption = scan.nextInt();
				client = controller.getById(addressOption);
				System.out.println("Type the new address");
				client.setAddress(scan.next());
				controller.update(client);
			break;
	
			}
			
			break;

		case 5:
			clients = controller.getAll();
			for (Client c : clients) {
				System.out.println(c.toString());
			}
			System.out.println("Which ID you want to DELETE");
			Integer deleteOption = scan.nextInt();
			controller.delete(deleteOption);
			break;
		
		// TO EXIT

		case 0:
			System.out.println("Exiting System");
			break;
		
		default:
			System.out.println("Invalid Option");
		}
		
		}while(option != 0);
	}
}
