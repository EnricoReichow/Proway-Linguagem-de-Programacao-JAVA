package br.com.projectMVC.controller;

import br.com.projectMVC.DAO.GenericDAO;
import br.com.projectMVC.DAO.ProductDAOImpl;
import br.com.projectMVC.model.Product;

public class ProductController {

	public void insert (Product product) {
		try {
			
			GenericDAO dao = new ProductDAOImpl();
			boolean returning = dao.insert(product);
			
			if (returning == true) {
				System.out.println("Successfull Insertion");
			}
			
		}catch(Exception e) {
			System.out.println("Problems to insert a new product! ERROR: " + e.getMessage());
			e.printStackTrace();
			
		}
	}	
}
