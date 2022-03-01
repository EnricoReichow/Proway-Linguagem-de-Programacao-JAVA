package br.com.projectHeritageMVC.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projectHeritageMVC.DAO.GenericDAO;
import br.com.projectHeritageMVC.DAO.ProviderDAOImpl;
import br.com.projectHeritageMVC.model.Customer;
import br.com.projectHeritageMVC.model.Provider;

public class ProviderController {

	public void insert(Provider provider) {
		try {

			GenericDAO dao = new ProviderDAOImpl();
			boolean returning = dao.insert(provider);

			if (returning == true) {
				System.out.println("Successfull Insertion");
			}

		} catch (Exception e) {
			System.out.println("Problems to insert a new provider! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}

	public List<Provider> getAll() {

		try {
			GenericDAO dao = new ProviderDAOImpl();
			List<Provider> list = new ArrayList<Provider>();

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
				list.add((Provider) o);
			}

			return list;
		} catch (Exception e) {
			System.out.println("Problems to list provider! ERROR: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Provider getById(int id) {
		try {
			GenericDAO dao = new ProviderDAOImpl();
			return (Provider) dao.getById(id); 
		} catch (Exception e) {
			System.out.println("Problems to load the provider! ERROR: " + e.getMessage());
			return null;
		}
	}

	public void delete(int id) {
		try {
			GenericDAO dao = new ProviderDAOImpl();
			dao.delete(id);
			System.out.println("Successfull DELETE");
		} catch (Exception e) {
			System.out.println("Problems to delete provider! ERROR: " +e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void update(Provider provider) {
		try {

			GenericDAO dao = new ProviderDAOImpl();
			boolean returning = dao.update(provider);

			if (returning == true) {
				System.out.println("Successfull UPDATE");
			}

		} catch (Exception e) {
			System.out.println("Problems to Update a provider! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}
	
}
