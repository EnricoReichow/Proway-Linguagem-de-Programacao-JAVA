package br.com.projectHeritageMVC.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projectHeritageMVC.DAO.GenericDAO;
import br.com.projectHeritageMVC.DAO.CustomerDAOImpl;
import br.com.projectHeritageMVC.model.Customer;

public class CustomerController {

	public void insert(Customer customer) {
		try {

			GenericDAO dao = new CustomerDAOImpl();
			boolean returning = dao.insert(customer);

			if (returning == true) {
				System.out.println("Successfull Insertion");
			}

		} catch (Exception e) {
			System.out.println("Problems to insert a new customer! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}

	public List<Customer> getAll() {

		try {
			GenericDAO dao = new CustomerDAOImpl();
			List<Customer> list = new ArrayList<Customer>();

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
				list.add((Customer) o);
			}

			return list;
		} catch (Exception e) {
			System.out.println("Problems to list customer! ERROR: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Customer getById(int id) {
		try {
			GenericDAO dao = new CustomerDAOImpl();
			return (Customer) dao.getById(id); 
		} catch (Exception e) {
			System.out.println("Problems to load the customer! ERROR: " + e.getMessage());
			return null;
		}
	}

	public void delete(int id) {
		try {
			GenericDAO dao = new CustomerDAOImpl();
			dao.delete(id);
			System.out.println("Successfull DELETE");
		} catch (Exception e) {
			System.out.println("Problems to delete customer! ERROR: " +e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void update(Customer customer) {
		try {

			GenericDAO dao = new CustomerDAOImpl();
			boolean returning = dao.update(customer);

			if (returning == true) {
				System.out.println("Successfull UPDATE");
			}

		} catch (Exception e) {
			System.out.println("Problems to Update a customer! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}
}
