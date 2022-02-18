package br.com.CRUDlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuExercise {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<Car> cars = new ArrayList<Car>();
		Car car1 = new Car();
		
		Integer option = 1;
		
		while (option != 0) {
			
			System.out.println("Welcome to EnricoCar Website. Choose the option that you want and follow the instructions");
			System.out.println(" 1 - Register new CAR");
			System.out.println(" 2 - Show the list of registered CARS");
			System.out.println(" 3 - Edit CAR");
			System.out.println(" 4 - Delete CAR");
			System.out.println(" 0 - To EXIT the program");
			option = scan.nextInt();
			
			switch (option) {
					
			case 1:
				
				System.out.println("Type your car model:");
				String model = scan.next();
				car1.setModel(model);
				System.out.println("Type your car year:");;
				String year = scan.next();
				car1.setYear(year);
				System.out.println("Type your car color:");
				String color = scan.next();
				car1.setColor(color);
				cars.add(car1);
				
				break;

			case 2:

				System.out.println(cars);
				
				break;

			case 3:

				System.out.println("Nothing yet");				
				
				break;

			case 4:
				
				System.out.println(cars);
				System.out.println("Which position you want to delete (positions start from 0)");
				Integer delete = scan.nextInt();
				cars.remove(delete);
				
				break;
				
				default:
					
				System.out.println("Invalid Option");

			}
		}
	}
}
