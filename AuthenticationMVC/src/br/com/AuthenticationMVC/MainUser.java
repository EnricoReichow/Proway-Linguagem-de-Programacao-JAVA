package br.com.AuthenticationMVC;

import java.util.List;
import java.util.Scanner;

import br.com.AuthenticationMVC.controller.UserController;
import br.com.AuthenticationMVC.model.User;

public class MainUser {

	public static void main(String[] args) {
		
//		User user = new User();
//		UserController controller = new UserController();
//
////		//CREATE
////		System.out.println("Type the product description");
////		user.setName("Sonia");
////		user.setEmail("soninpleini@gmail.com");
////		user.setPassword("#Euamotortas123");
////		user.setActive(true);
////		controller.insert(user);
//
//		//READ
//		System.out.println("\nShowing the registers from the users table: ");	
//		List<User> users = controller.getAll(); //giving the list <user> the method <getAll> results
//
//		for (User u : users) {
//			System.out.println(u.toString());
//		}
//		
//		//READ BY ID
//		user = controller.getById(1);
//		System.out.println(user.toString());
//		
//		//UPDATE 
////				user = controller.getById(2);
////				user.setPassword("cake987");
////				System.out.println(user.toString());
////				user.toString();
////				controller.update(user);
//		
//		//DELETE
//		controller.delete(2); //pass to ProductController and then execute the method written in ProductDAOImpl(this is applied to all CRUD methods
//		users = controller.getAll();
//		for (User u : users) {
//			System.out.println(u.toString());
//		}
		
		Scanner scan = new Scanner(System.in);

		User user = new User(); 

		UserController controller = new UserController();

		Integer option = 0;
		
		do {
		System.out.println("**************** MENU ****************");
		System.out.println("Welcome to User Registration");
		System.out.println("Choose the option that you want:");
		System.out.println("1 - Insert new User");
		System.out.println("2 - Show all User list");
		System.out.println("3 - Show a User by the ID");
		System.out.println("4 - Update a User information");
		System.out.println("5 - Delete a User from the list");
		System.out.println("6 - See Authentication");
		System.out.println("0 - To exit");
		option = scan.nextInt();

		switch (option) {

		case 1:
			System.out.println("Inform the User name:");
			user.setName(scan.next());
			System.out.println("Now the User email:");
			user.setEmail(scan.next());
			System.out.println("Now the User password:");
			user.setPassword(scan.next());
			System.out.println("Now the User status (true - active || false - inactive):");
			user.setActive(scan.nextBoolean());
			controller.insert(user);
			break;

		case 2:
			
			List<User> users = controller.getAll();
			for (User u : users) {
				System.out.println(u.toString());
			}
			break;

		case 3:
			System.out.println("Which ID you want to show in the screen?");
			Integer optionalId = scan.nextInt();
			user = controller.getById(optionalId);
			System.out.println(user.toString());
			break;

		case 4:
			users = controller.getAll();
			for (User u : users) {
				System.out.println(u.toString());
			}
			System.out.println("Which field you want to update");
			System.out.println("1 - NAME ");
			System.out.println("2 - EMAIL ");
			System.out.println("3 - PASSWORD ");
			System.out.println("4 - STATUS ");
			Integer updateOption = scan.nextInt();
			
			switch (updateOption) {
			
			case 1:
				System.out.println("Which ID you want to UPDATE:");
				Integer nameOption = scan.nextInt();
				user = controller.getById(nameOption);
				System.out.println("Type the new name");
				user.setName(scan.next());
				controller.update(user);
			break;
				
			case 4:
				System.out.println("Which ID you want to UPDATE:");
				Integer statusOption = scan.nextInt();
				user = controller.getById(statusOption);
				System.out.println("Type the new status (true - active || false - inactive):");
				user.setActive(scan.nextBoolean());
				controller.update(user);
			break;
				
			case 2:
				System.out.println("Which ID you want to UPDATE:");
				Integer addressOption = scan.nextInt();
				user = controller.getById(addressOption);
				System.out.println("Type the new email");
				user.setEmail(scan.next());
				controller.update(user);
			break;
			
			case 3:
				System.out.println("Which ID you want to UPDATE:");
				Integer passwordOption = scan.nextInt();
				user = controller.getById(passwordOption);
				System.out.println("Type the new password:");
				user.setPassword(scan.next());
				controller.update(user);
				break;
	
			}
			
			break;

		case 5:
			users = controller.getAll();
			for (User u : users) {
				System.out.println(u.toString());
			}
			System.out.println("Which ID you want to DELETE");
			Integer deleteOption = scan.nextInt();
			controller.delete(deleteOption);
			break;
			
		case 6: 
			System.out.println("Type your email:");
			String email = scan.next();
			
			System.out.println("Type your password:");
			String password = scan.next();
			
			controller.authenticate(email, password);
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
