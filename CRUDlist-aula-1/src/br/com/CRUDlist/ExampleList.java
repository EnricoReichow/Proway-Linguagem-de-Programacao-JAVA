package br.com.CRUDlist;

import java.util.ArrayList;
import java.util.List;

public class ExampleList {

	public static void main(String[] args) {

		// creating a list with Integer elements
		List<Integer> numbers = new ArrayList<Integer>();

		// adding dynamically values to the list
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);

		// showing the list in way
		System.out.println("List in way");
		System.out.println(numbers);

		// going through the list using ForEach where we can manipulate the elements
		System.out.println("\nList in way");
		for (int n : numbers) {
			System.out.println(n + 2);

		}

	}

}
