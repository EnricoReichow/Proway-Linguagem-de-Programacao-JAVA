package br.com.AuthenticationMVC.DAO;

import java.util.List;

public interface GenericDAO {
	
public List<Object> getAll();
	
	public Object getById (int id);
	
	public Boolean insert (Object object);  //this interface can be used for all the projects that use CRUD
	
	public Boolean update(Object object);
	
	public void delete(int id);
	
}

