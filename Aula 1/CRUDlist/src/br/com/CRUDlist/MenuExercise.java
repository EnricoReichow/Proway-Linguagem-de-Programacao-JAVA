package br.com.CRUDlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuExercise {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<Car> cars = new ArrayList<Car>();
		Car car;
		
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
				car = new Car();
				String model = scan.next();
				car.setModel(model);
				System.out.println("Type your car year:");;
				String year = scan.next();
				car.setYear(year);
				System.out.println("Type your car color:");
				String color = scan.next();
				car.setColor(color);
				cars.add(car);
				System.out.println(cars);
				
				break;

			case 2:
				
				System.out.println("Showing registered cars:");
				for (Car c : cars) {
					System.out.println(c.toString());

				}
				
				break;

			case 3:

				for (Car c : cars) {
					System.out.println(c.toString());

				}
				System.out.println("Type the index you want to delete (the index starts from 0)");
				int index = scan.nextInt();
				
				System.out.println("Type the new model:");
				car.setModel(scan.next());
				System.out.println("Type the color:");
				car.setColor(scan.next());
				System.out.println("Then, the year of fabrication");
				car.setYear(scan.next());
				
				//car = new Car;
				
				break;

			case 4:

				for (Car c : cars) {
					System.out.println(c.toString());
				}
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
