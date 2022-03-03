package br.com.AuthenticationMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.AuthenticationMVC.model.User;
import br.com.AuthenticationMVC.util.ConnectionFactory;

	public class UserDAOImpl implements GenericDAO {

	private Connection conn;

	public UserDAOImpl() throws Exception {

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
		
		String sql = "SELECT * FROM users ORDER by id";

		try {
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
			
				User user = new User();
				user.setId(rs.getInt("id"));                                         // "happy routine"
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("active"));
				list.add(user);
			}

		} catch (SQLException e) {
			// Catching and showing the error
			System.out.println("Problems with the DAO when you are listing the User! Erro: " + e.getMessage());
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

		User user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM users WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setActive(rs.getBoolean("active"));				
			}

		} catch (Exception e) {
			System.out.println("Problems in the DAO to load User! ERROR: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problems to close connection! ERROR: " + e.getMessage());
			}
		}
		return user;

	}

	@Override
	public Boolean insert(Object object) {

		User user = (User) object;

		PreparedStatement stmt = null;

		String sql = "INSERT INTO users (name,email,password,active) VALUES (?,?,MD5(?),?)";                            
		try {

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());			
			stmt.setBoolean(4, user.getActive());

			stmt.execute();

			return true;
		} catch (SQLException e) {

			System.out.println("Problems with the DAO when you are trying to insert! ERROR: " + e.getMessage());

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
		User user = (User) object;
		PreparedStatement stmt = null;
		String sql = "UPDATE users SET name = ? , email = ? , password = MD5(?) , active = ? WHERE id = ?";                               //PAREI AQUI
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());	
			stmt.setBoolean(4, user.getActive());
			stmt.setInt(5, user.getId());
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Problems in the DAO and to change the Client! ERROR: " + e.getMessage());
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
		String sql = "DELETE FROM users WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Problems in the DAO when you are trying to delete Client! ERROR: " +e.getMessage());
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
	
	public User authenticate (String email, String password) {
		User user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM users WHERE email = ? AND password = MD5(?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, sql);
			stmt.setString(2, sql);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			System.out.println("Problems in the DAO to authenticate the user! ERROR: " + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
			ConnectionFactory.closeConnection(conn, stmt, rs);	
			} catch (Exception e2) {
				System.out.println("Problems to close connection! ERROR: " + e2.getMessage());
				e2.printStackTrace();
			}
		}
		
		return user;
	}
	
}
