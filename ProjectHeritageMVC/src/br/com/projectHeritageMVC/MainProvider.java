package br.com.projectHeritageMVC;

import java.util.List;
import java.util.Scanner;

import br.com.projectHeritageMVC.controller.ProviderController;
import br.com.projectHeritageMVC.model.Provider;

public class MainProvider {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Provider provider = new Provider();

		ProviderController controller = new ProviderController();

		Integer option = 0;

		do {
			System.out.println("Welcome to Provider Registration");
			System.out.println("Choose the option that you want:");
			System.out.println("1 - Insert new Provider");
			System.out.println("2 - Show all Provider list");
			System.out.println("3 - Show a Provider by the ID");
			System.out.println("4 - Update a Provider information");
			System.out.println("5 - Delete a Provider from the list");
			System.out.println("6 - Show if CNPJ is positive or nagative");
			System.out.println("0 - To exit");
			option = scan.nextInt();

			switch (option) {

			case 1:
				System.out.println("Inform the Provider name:");
				provider.setName(scan.next());
				System.out.println("Now the Provider address:");
				provider.setAddress(scan.next());
				System.out.println("Now the status of the Provider((true -  The registration is positive || false - The registration is negative):");
				provider.setStatus(scan.nextBoolean());
				System.out.println("Type the CNPJ:");
				provider.setCnpj(scan.next());                                 
				System.out.println("To finish, the if it is a Open Capital (true) or not (false):");
				provider.setOpenCapital(scan.nextBoolean());
				controller.insert(provider);
				break;

			case 2:

				List<Provider> providers = controller.getAll();
				for (Provider p : providers) {                               //error
					System.out.println(p.toString());
				}
				break;

			case 3:
				System.out.println("Which ID you want to show in the screen?");
				Integer optionalId = scan.nextInt();
				provider = controller.getById(optionalId);                          //error
				System.out.println(provider.toString());
				break;

			case 4:
				providers = controller.getAll();
				for (Provider p : providers) {
					System.out.println(p.toString());
				}
				System.out.println("Which field you want to update");
				System.out.println("1 - NAME ");
				System.out.println("2 - ADDRESS ");
				System.out.println("3 - STATUS ");
				System.out.println("4 - CNPJ ");
				System.out.println("5 - CAPITAL SITUATUON ");
				Integer updateOption = scan.nextInt();

				switch (updateOption) {

				case 1:
					System.out.println("Which ID you want to UPDATE:");
					Integer nameOption = scan.nextInt();
					provider = controller.getById(nameOption);
					System.out.println("Type the new name");
					provider.setName(scan.next());
					controller.update(provider);
					break;

				case 3:
					System.out.println("Which ID you want to UPDATE:");
					Integer statusOption = scan.nextInt();
					provider = controller.getById(statusOption);
					System.out.println(
							"Type the new status (true -  The registration is positive || false - The registration is nagative");
					provider.setStatus(scan.nextBoolean());
					controller.update(provider);
					break;

				case 2:
					System.out.println("Which ID you want to UPDATE:");
					Integer addressOption = scan.nextInt();
					provider = controller.getById(addressOption);
					System.out.println("Type the new address");
					provider.setAddress(scan.next());
					controller.update(provider);
					break;

				case 4:
					System.out.println("Which ID you want to UPDATE:");
					Integer cpfOption = scan.nextInt();
					provider = controller.getById(cpfOption);
					System.out.println("Type the CNPJ");
					provider.setCnpj(scan.next());
					controller.update(provider);
					break;

				case 5:
					System.out.println("Which ID you want to UPDATE:");
					Integer rgOption = scan.nextInt();
					provider = controller.getById(rgOption);
					System.out.println("Type the new Capital Situation (true - Open Capital || false - Closed Capital");
					provider.setOpenCapital(scan.nextBoolean());
					controller.update(provider);
					break;

				}

				break;

			case 5:
				providers = controller.getAll();
				for (Provider p : providers) {
					System.out.println(p.toString());
				}
				System.out.println("Which ID you want to DELETE");
				Integer deleteOption = scan.nextInt();
				controller.delete(deleteOption);
				break;

			case 6:
				break;

			// TO EXIT

			case 0:
				System.out.println("Exiting System");
				break;
				
			default:
				System.out.println("Invalid Option");
			}

		} while (option != 0);

	}

}
