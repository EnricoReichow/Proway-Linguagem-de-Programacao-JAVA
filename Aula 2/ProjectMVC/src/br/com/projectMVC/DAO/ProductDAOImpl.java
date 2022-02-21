package br.com.projectMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.projectMVC.model.Product;
import br.com.projectMVC.util.ConnectionFactory;

public class ProductDAOImpl implements GenericDAO {
	
	private Connection conn;
	
	public ProductDAOImpl() throws Exception {
	
		try {
			this.conn = ConnectionFactory.getConnection();
			System.out.println("Successfull connection");
		}catch(Exception e) {
			throw new Exception (e.getMessage());
		}
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insert(Object object) {
		Product product = (Product) object;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO PRODUCT (description) VALUES (?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getDescription());
			stmt.execute();
			return true;
		}catch (SQLException e) {
			System.out.println("Problems with the DAO when you are trying to register! ERROR: " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt);
			} catch(Exception e) {
				System.out.println("Problems to close the connectio! ERROR: " +e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public Boolean update(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
