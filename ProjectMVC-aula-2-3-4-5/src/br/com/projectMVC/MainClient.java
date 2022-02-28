package br.com.projectMVC;

import java.util.List;
import java.util.Scanner;

import br.com.projectMVC.controller.ClientController;
import br.com.projectMVC.controller.ProductController;
import br.com.projectMVC.model.Client;
import br.com.projectMVC.model.Product;

public class MainClient {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Client client = new Client();

		ClientController controller = new ClientController();
//		//CREATE
//		System.out.println("Type the product description");
//		product.setDescription(scan.next());
//		controller.insert(product);

		System.out.println("Welcome to Client Registration");
		System.out.println("Choose the option that you want:");
		System.out.println("1 - Insert new Client");
		System.out.println("2 - Show all Clients list");
		System.out.println("3 - Show a Client by the ID");
		System.out.println("4 - Update a Client information");
		System.out.println("5 - Delete a Client from the list");
		System.out.println("0 - to exit");
		Integer option = scan.nextInt();

		switch (option) {

		case 1:
			System.out.println("Inform the client name:");
			client.setName(scan.next());
			System.out.println("Now the client address:");
			client.setAddress(scan.next());
			System.out.println("And to finish, the status of the client(Type: true - I'm already a client || false - First contact)");
			client.setStatus(scan.nextBoolean());
			controller.insert(client);
			break;

//
		// READ
//		System.out.println("\nShowing the registers from the product table: ");	
//		List<Product> products = controller.getAll(); //giving the list <products> the method <getAll> results
//
//		for (Product p : products) {
//			System.out.println(p.toString());
//		}

		case 2:
			System.out.println("");
			break;

//		//READ BY ID
//		product = controller.getById(3);
//		System.out.println(product.toString());

		case 3:
			System.out.println("");
			break;

		// //UPDATE
//		product = controller.getById(4);
//		product.setDescription("eraser");
//		System.out.println(product.toString());
//		product.toString();
//		controller.update(product);

		case 4:
			System.out.println("");
			break;

//		//DELETE
//		
//		controller.delete(3); //pass to ProductController and then execute the method written in ProductDAOImpl(this is applied to all CRUD methods
//		products = controller.getAll();
//		for (Product p : products) {
//			System.out.println(p.toString());
//		}

		case 5:
			System.out.println("");
			break;

		// TO EXIT

		case 0:
			System.out.println("");
			break;

		}
	}
}
