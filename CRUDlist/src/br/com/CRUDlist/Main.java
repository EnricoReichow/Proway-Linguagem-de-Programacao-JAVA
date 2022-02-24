package br.com.CRUDlist;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Car> cars = new ArrayList<Car>();

		Car car1 = new Car();
		car1.setId(1);
		car1.setModel("Corola");
		car1.setColor("Black");
		car1.setYear("2022");

		Car car2 = new Car();
		car2.setId(2);
		car2.setModel("Velar");
		car2.setColor("White");
		car2.setYear("2021");

		Car car3 = new Car();
		car3.setId(3);
		car3.setModel("CRV");
		car3.setColor("Red");
		car3.setYear("2017");

		// inserting values in the list - CREATE
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		// reading values from list - READ
		for (Car c : cars) {

			// System.out.println(c.getModel());
			// System.out.println(c.getColor());
			// System.out.println(c.getYear());
			System.out.println(c.toString()); // to show all the items once
			System.out.println("--===08{|||}80===--");

		}

		// removing values from the list - DELETE
		cars.remove(2);

		System.out.println("\n");
		for (Car c : cars) {
			System.out.println(c.toString());

		}

		// Updating values of the list using - UPDATE
		cars.set(1, car3);

		System.out.println("\n");
		for (Car c : cars) {
			System.out.println(c.toString());

		}

	}

}
