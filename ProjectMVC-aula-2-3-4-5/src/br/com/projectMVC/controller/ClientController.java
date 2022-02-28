package br.com.projectMVC.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projectMVC.DAO.GenericDAO;
import br.com.projectMVC.DAO.ClientDAOImpl;
import br.com.projectMVC.model.Client;

public class ClientController {

	public void insert(Client client) {
		try {

			GenericDAO dao = new ClientDAOImpl();
			boolean returning = dao.insert(client);

			if (returning == true) {
				System.out.println("Successfull Insertion");
			}

		} catch (Exception e) {
			System.out.println("Problems to insert a new client! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}

	public List<Client> getAll() {

		try {
			GenericDAO dao = new ClientDAOImpl();
			List<Client> list = new ArrayList<Client>();

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
				list.add((Client) o);
			}

			return list;
		} catch (Exception e) {
			System.out.println("Problems to list clients! ERROR: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Client getById(int id) {
		try {
			GenericDAO dao = new ClientDAOImpl();
			return (Client) dao.getById(id); //transforming the generic object into a Product object
		} catch (Exception e) {
			System.out.println("Problems to load the client! ERROR: " + e.getMessage());
			return null;
		}
	}

	public void delete(int id) {
		try {
			GenericDAO dao = new ClientDAOImpl();
			dao.delete(id);
			System.out.println("Successfull DELETE");
		} catch (Exception e) {
			System.out.println("Problems to delete client! ERROR: " +e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void update(Client client) {
		try {

			GenericDAO dao = new ClientDAOImpl();
			boolean returning = dao.update(client);

			if (returning == true) {
				System.out.println("Successfull UPDATE");
			}

		} catch (Exception e) {
			System.out.println("Problems to Update a client! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}
	
}
	

