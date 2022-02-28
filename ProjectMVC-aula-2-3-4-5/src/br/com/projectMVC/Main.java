package br.com.projectMVC;

import java.util.List;
import java.util.Scanner;

import br.com.projectMVC.controller.ProductController;
import br.com.projectMVC.model.Product;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		Product product = new Product();
		
		ProductController controller = new ProductController();
//		//CREATE
//		System.out.println("Type the product description");
//		product.setDescription(scan.next());
//		controller.insert(product);
//
		//READ
//		System.out.println("\nShowing the registers from the product table: ");	
//		List<Product> products = controller.getAll(); //giving the list <products> the method <getAll> results
//
//		for (Product p : products) {
//			System.out.println(p.toString());
//		}
		
//		//READ BY ID
//		product = controller.getById(3);
//		System.out.println(product.toString());
		
//		//DELETE
//		
//		controller.delete(3); //pass to ProductController and then execute the method written in ProductDAOImpl(this is applied to all CRUD methods
//		products = controller.getAll();
//		for (Product p : products) {
//			System.out.println(p.toString());
//		}
		
		//UPDATE 
		product = controller.getById(4);
		product.setDescription("eraser");
		System.out.println(product.toString());
		product.toString();
		controller.update(product);
		
	}

}
