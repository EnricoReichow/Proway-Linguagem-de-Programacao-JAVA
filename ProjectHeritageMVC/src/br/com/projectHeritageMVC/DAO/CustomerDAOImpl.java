package br.com.projectHeritageMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projectHeritageMVC.model.Customer;
import br.com.projectHeritageMVC.util.ConnectionFactory;

public class CustomerDAOImpl implements GenericDAO{

	private Connection conn;

	public CustomerDAOImpl() throws Exception {

		try {
			this.conn = ConnectionFactory.getConnection();
			System.out.println("Successfull connection");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Object> getAll() { 
		
		List<Object> list = new ArrayList<Object>();
		
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		
		String sql = "SELECT * FROM customer ORDER by id";

		try {
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
			
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));                                         // "happy routine"
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setStatus(rs.getBoolean("status"));
				customer.setCpf(rs.getString("cpf"));
				customer.setRg(rs.getString("rg"));
				list.add(customer);
			}

		} catch (SQLException e) {
			
			System.out.println("Problems with the DAO when you are listing the Customer! Erro: " + e.getMessage());
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
	public Object getById (int id) {

		Customer customer = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM customer WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setStatus(rs.getBoolean("status"));
				customer.setCpf(rs.getString("cpf"));
				customer.setRg(rs.getString("rg"));
				
			}

		} catch (Exception e) {
			System.out.println("Problems in the DAO to load customer! ERROR: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problems to close connection! ERROR: " + e.getMessage());
			}
		}
		return customer;

	}

	@Override
	public Boolean insert(Object object) {

		Customer customer = (Customer) object;

		PreparedStatement stmt = null;

		String sql = "INSERT INTO customer (name,address,status,cpf,rg) VALUES (?,?,?,?,?)";                            
		try {

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getAddress());
			stmt.setBoolean(3, customer.getStatus());
			stmt.setString(4, customer.getCpf());
			stmt.setString(5, customer.getRg());

			stmt.execute();

			return true;
		} catch (SQLException e) {

			System.out.println("Problems with the DAO when you are trying to register! ERROR: " + e.getMessage());

			e.printStackTrace();
			return false;
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt);
			} catch (Exception e) {
				System.out.println("Problems to close the connection! ERROR: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	public Boolean update(Object object) {
		Customer customer = (Customer) object;
		PreparedStatement stmt = null;
		String sql = "UPDATE customer SET name = ? , address = ? , status = ? , cpf = ? , rg = ? WHERE id = ?";                               //PAREI AQUI
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getAddress());
			stmt.setBoolean(3, customer.getStatus());
			stmt.setString(4, customer.getCpf());
			stmt.setString(5, customer.getRg());
			stmt.setInt(6, customer.getId());
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Problems in the DAO and to change the Customer! ERROR: " + e.getMessage());
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
		String sql = "DELETE FROM customer WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Problems in the DAO when you are trying to delete Customer! ERROR: " +e.getMessage());
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
