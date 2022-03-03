package br.com.AuthenticationMVC.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.AuthenticationMVC.DAO.GenericDAO;
import br.com.AuthenticationMVC.DAO.UserDAOImpl;
import br.com.AuthenticationMVC.model.User;

public class UserController {

	public void insert(User user) {
		try {

			GenericDAO dao = new UserDAOImpl();
			boolean returning = dao.insert(user);

			if (returning == true) {
				System.out.println("Successfull Insertion");
			}

		} catch (Exception e) {
			System.out.println("Problems to insert a new User! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}

	public List<User> getAll() {

		try {
			GenericDAO dao = new UserDAOImpl();
			List<User> list = new ArrayList<User>();

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
				list.add((User) o);
			}

			return list;
		} catch (Exception e) {
			System.out.println("Problems to list User! ERROR: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public User getById(int id) {
		try {
			GenericDAO dao = new UserDAOImpl();
			return (User) dao.getById(id); 
		} catch (Exception e) {
			System.out.println("Problems to load the User! ERROR: " + e.getMessage());
			return null;
		}
	}

	public void delete(int id) {
		try {
			GenericDAO dao = new UserDAOImpl();
			dao.delete(id);
			System.out.println("Successfull DELETE");
		} catch (Exception e) {
			System.out.println("Problems to delete user! ERROR: " +e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void update(User user) {
		try {

			GenericDAO dao = new UserDAOImpl();
			boolean returning = dao.update(user);

			if (returning == true) {
				System.out.println("Successfull UPDATE");
			}

		} catch (Exception e) {
			System.out.println("Problems to Update a User! ERROR: " + e.getMessage());
			e.printStackTrace();

		}
	}
	
	public Boolean authenticate(String email, String password) {
		try {
			UserDAOImpl dao = new UserDAOImpl();
			
			User validUser = dao.authenticate(email, password);
			
			if (validUser != null) {
				System.out.println("User logged in successfully!");
				return true;
			}else {
				System.out.println("Incorrect email or password!");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Problems to authenticate user! ERROR: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
}
