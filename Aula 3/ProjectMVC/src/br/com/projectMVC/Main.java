package br.com.projectMVC;

import java.util.Scanner;

import br.com.projectMVC.controller.ProductController;
import br.com.projectMVC.model.Product;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		Product product = new Product();

		System.out.println("Type the product description");

		product.setDescription(scan.next());

		ProductController controller = new ProductController();

		controller.insert(product);

	}

}
