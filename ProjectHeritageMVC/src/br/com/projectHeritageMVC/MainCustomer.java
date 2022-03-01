package br.com.projectHeritageMVC;

import java.util.List;
import java.util.Scanner;

import br.com.projectHeritageMVC.controller.CustomerController;
import br.com.projectHeritageMVC.model.Customer;

public class MainCustomer {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Customer customer = new Customer(); 

		CustomerController controller = new CustomerController();

		Integer option = 0;
		
		do {
		System.out.println("Welcome to Customer Registration");
		System.out.println("Choose the option that you want:");
		System.out.println("1 - Insert new Customer");
		System.out.println("2 - Show all Customer list");
		System.out.println("3 - Show a Customer by the ID");
		System.out.println("4 - Update a Customer information");
		System.out.println("5 - Delete a Customer from the list");
		System.out.println("6 - Show if CPF is positive or nagative");
		System.out.println("0 - To exit");
		option = scan.nextInt();

		switch (option) {

		case 1:
			System.out.println("Inform the Customer name:");
			customer.setName(scan.next());
			System.out.println("Now the Customer address:");
			customer.setAddress(scan.next());
			System.out.println("Type the new status (true -  The registration is positive || false - The registration is negative");
			customer.setStatus(scan.nextBoolean());
			System.out.println("Type the CPF:");
			customer.setCpf(scan.next());
			System.out.println("To finish, the RG:");
			customer.setRg(scan.next());
			controller.insert(customer);
			break;

		case 2:
			
			List<Customer> customers = controller.getAll();
			for (Customer c : customers) {
				System.out.println(c.toString());
			}
			break;

		case 3:
			System.out.println("Which ID you want to show in the screen?");
			Integer optionalId = scan.nextInt();
			customer = controller.getById(optionalId);
			System.out.println(customer.toString());
			break;

		case 4:
			customers = controller.getAll();
			for (Customer c : customers) {
				System.out.println(c.toString());
			}
			System.out.println("Which field you want to update");
			System.out.println("1 - NAME ");
			System.out.println("2 - ADDRESS ");
			System.out.println("3 - STATUS ");
			System.out.println("4 - CPF ");
			System.out.println("5 - RG ");
			Integer updateOption = scan.nextInt();
			
			switch (updateOption) {
			
			case 1:
				System.out.println("Which ID you want to UPDATE:");
				Integer nameOption = scan.nextInt();
				customer = controller.getById(nameOption);
				System.out.println("Type the new name");
				customer.setName(scan.next());
				controller.update(customer);
			break;
				
			case 3:
				System.out.println("Which ID you want to UPDATE:");
				Integer statusOption = scan.nextInt();
				customer = controller.getById(statusOption);
				System.out.println("Type the new status (true -  The registration is positive || false - The registration is negative");
				customer.setStatus(scan.nextBoolean());
				controller.update(customer);
			break;
				
			case 2:
				System.out.println("Which ID you want to UPDATE:");
				Integer addressOption = scan.nextInt();
				customer = controller.getById(addressOption);
				System.out.println("Type the new address");
				customer.setAddress(scan.next());
				controller.update(customer);
			break;
				
			case 4:
				System.out.println("Which ID you want to UPDATE:");
				Integer cpfOption = scan.nextInt();
				customer = controller.getById(cpfOption);
				System.out.println("Type the CPF");
				customer.setCpf(scan.next());
				controller.update(customer);
			break;
			
			case 5: 
				System.out.println("Which ID you want to UPDATE:");
				Integer rgOption = scan.nextInt();
				customer = controller.getById(rgOption);
				System.out.println("Type the new RG");
				customer.setRg(scan.next());
				controller.update(customer);
			break;
			
			}
			
			break;

		case 5:
			customers = controller.getAll();
			for (Customer c : customers) {
				System.out.println(c.toString());
			}
			System.out.println("Which ID you want to DELETE");
			Integer deleteOption = scan.nextInt();
			controller.delete(deleteOption);
			break;
		
		case 6:
			System.out.println("Which ID you want to see the CPF situation");
			Integer cpfOption = scan.nextInt();
			customer = controller.getById(cpfOption);
			customer.consultarCPF();
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


