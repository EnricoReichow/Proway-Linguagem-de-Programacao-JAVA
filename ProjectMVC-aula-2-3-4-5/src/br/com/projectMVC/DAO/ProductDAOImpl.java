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
	public List<Object> getAll() { // Read from CRUD
		// creating a list to keep the registers that will return from SELECT
		List<Object> list = new ArrayList<Object>();
		// creating one object of the class PreparedStatement, that is responsible to
		// send
		// data to the DB
		PreparedStatement stmt = null;
		// creating one object of the class ResultSet, that is responsible to send
		// data to the DB
		ResultSet rs = null;
		// creating a SQL command e keep it inside a String type variable
		String sql = "SELECT * FROM product ORDER by description";

		try {
			// attribute to a object stmt a SQL command, that was by the prepareStatement()
			// method
			stmt = conn.prepareStatement(sql);
			// attribute to a object rs the return of the execution of the SQL in the DB,
			// made through the
			rs = stmt.executeQuery();

			// run a WHILE while have registers in the return of SQL
			while (rs.next()) {
				// creating a object of the class Product
				Product product = new Product();
				product.setId(rs.getInt("id"));                                         // "happy routine"
				product.setDescription(rs.getString("description"));
				list.add(product);
			}

		} catch (SQLException e) {
			// Catching and showing the error
			System.out.println("Problems with the DAO when you are listing the Product! Erro: " + e.getMessage());
			e.printStackTrace();
			// exception if TRY is not working

		} finally {
			// Trying to close the connection whit DB and catching the error if it cannot
			// close
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);

			} catch (Exception e) {
				System.out.println("Problems to close the connection! ERROR: " + e.getMessage());
			}
		}

		// return the full list with the registers of the SQL return
		return list;

	}

	@Override
	public Object getById(int id) {

		Product product = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM product WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setDescription(rs.getString("description"));
			}

		} catch (Exception e) {
			System.out.println("Problems in the DAO to load Product! ERROR: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problems to close connection! ERROR: " + e.getMessage());
			}
		}
		return product;

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
		Product product = (Product) object;
		PreparedStatement stmt = null;
		String sql = "UPDATE product SET description = ? WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getDescription());
			stmt.setInt(2, product.getId());
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Problems in the DAO and to change the Product! ERROR: " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt);
			} catch (Exception e) {
				System.out.println("Problems to close connection! ERROR: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(int id) {

		PreparedStatement stmt = null;
		String sql = "DELETE FROM product WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Problems in the DAO when you are trying to delete Product! ERROR: " +e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt);
			} catch (Exception e) {
				System.out.println("Problems to close the connection! ERROR: " +e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
