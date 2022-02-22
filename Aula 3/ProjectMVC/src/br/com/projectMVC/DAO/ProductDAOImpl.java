package br.com.projectMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projectMVC.model.Product;
import br.com.projectMVC.util.ConnectionFactory;

public class ProductDAOImpl implements GenericDAO {

	private Connection conn;

	public ProductDAOImpl() throws Exception {

		try {
			this.conn = ConnectionFactory.getConnection();
			System.out.println("Successfull connection");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Object> getAll() { //Read from CRUD
		List<Object> list = new ArrayList<Object>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM product ORDER by description";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setDescription(rs.getString("description"));
				list.add(product);
			}
		} catch (SQLException e) {
			System.out.println("Problems with the DAO when you are listing the Product! Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problems to close the connection! ERROR: " + e.getMessage());
			}
		}

		return list;

	}

	@Override
	public Object getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean insert(Object object) {

		// creating an object of the class Product
		// and changing to a generic object also to the type Product
		Product product = (Product) object;

		// Creating a object of the class PreparedStatement with null value
		PreparedStatement stmt = null;

		// Creating a variable (String) to keep a SQL command
		String sql = "INSERT INTO PRODUCT (description) VALUES (?)";
		try {

			// Transforming a String to a SQL command and keeping in a stmt object
			stmt = conn.prepareStatement(sql);

			// Setting value inside the first Question Mark(represented in SQL), setting the
			// position by
			// the SET method of stmt object
			stmt.setString(1, product.getDescription());

			// Executing the SQL command inside the database
			stmt.execute();

			return true;
		} catch (SQLException e) {
			// Catching the error and showing, in case the error was in the INSERTION

			System.out.println("Problems with the DAO when you are trying to register! ERROR: " + e.getMessage());
			// Print in the console the way to the error

			e.printStackTrace();
			return false;
		} finally {
			try {
				// Closing the connection of the object conn and stmt
				ConnectionFactory.closeConnection(conn, stmt);
			} catch (Exception e) {
				System.out.println("Problems to close the connection! ERROR: " + e.getMessage());
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
