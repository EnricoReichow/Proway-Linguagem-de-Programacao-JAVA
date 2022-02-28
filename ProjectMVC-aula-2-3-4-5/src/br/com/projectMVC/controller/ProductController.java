package br.com.projectMVC.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projectMVC.DAO.GenericDAO;
import br.com.projectMVC.DAO.ProductDAOImpl;
import br.com.projectMVC.model.Product;

public class ProductController {

	public void insert(Product product) {
		try {

			GenericDAO dao = new ProductDAOImpl();
			boolean returning = dao.insert(product);

			if (returning == true) {
				System.out.println("Successfull Insertion");
			}

		} catch (Exception e) {
			System.out.println("Problems to insert a new product! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}

	public List<Product> getAll() {

		try {
			GenericDAO dao = new ProductDAOImpl();
			List<Product> list = new ArrayList<Product>();

//			List<Object> listDao = dao.getAll();
//			
//			for (Object o : listDao) {
//																//other way to do the FOR (more details
//				Product product = new Product();
//				product = (Product) o;
//				
//				list.add(product);
//				
//			}

			for (Object o : dao.getAll()) {
				list.add((Product) o);
			}

			return list;
		} catch (Exception e) {
			System.out.println("Problems to list products! ERROR: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Product getById(int id) {
		try {
			GenericDAO dao = new ProductDAOImpl();
			return (Product) dao.getById(id); //transforming the generic object into a Product object
		} catch (Exception e) {
			System.out.println("Problems to load the product! ERROR: " + e.getMessage());
			return null;
		}
	}

	public void delete(int id) {
		try {
			GenericDAO dao = new ProductDAOImpl();
			dao.delete(id);
			System.out.println("Successfull DELETE");
		} catch (Exception e) {
			System.out.println("Problems to delete produto! ERROR: " +e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void update(Product product) {
		try {

			GenericDAO dao = new ProductDAOImpl();
			boolean returning = dao.update(product);

			if (returning == true) {
				System.out.println("Successfull UPDATE");
			}

		} catch (Exception e) {
			System.out.println("Problems to Update a product! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}
	
}
