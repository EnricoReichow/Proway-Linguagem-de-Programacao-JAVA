package br.com.projectHeritageMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projectHeritageMVC.model.Provider;
import br.com.projectHeritageMVC.util.ConnectionFactory;

public class ProviderDAOImpl implements GenericDAO {

	private Connection conn;

	public ProviderDAOImpl() throws Exception {

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
		
		String sql = "SELECT * FROM provider ORDER by id";

		try {
			
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();

			while (rs.next()) {
			
				Provider provider = new Provider();
				provider.setId(rs.getInt("id"));                                         // "happy routine"
				provider.setName(rs.getString("name"));
				provider.setAddress(rs.getString("address"));
				provider.setStatus(rs.getBoolean("status"));
				provider.setCnpj(rs.getString("cnpj"));
				provider.setOpenCapital(rs.getBoolean("openCapital"));
				list.add(provider);
			}

		} catch (SQLException e) {
			
			System.out.println("Problems with the DAO when you are listing the Provider! Erro: " + e.getMessage());
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

		Provider provider = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM customer WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				provider = new Provider();
				provider.setId(rs.getInt("id"));
				provider.setName(rs.getString("name"));
				provider.setAddress(rs.getString("address"));
				provider.setStatus(rs.getBoolean("status"));
				provider.setCnpj(rs.getString("cnpj"));
				provider.setOpenCapital(rs.getBoolean("openCapital"));
				
			}

		} catch (Exception e) {
			System.out.println("Problems in the DAO to load Provider! ERROR: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception e) {
				System.out.println("Problems to close connection! ERROR: " + e.getMessage());
			}
		}
		return provider;

	}

	@Override
	public Boolean insert(Object object) {

		Provider provider = (Provider) object;

		PreparedStatement stmt = null;

		String sql = "INSERT INTO provider (name,address,status) VALUES (?,?,?,?,?)";                            
		try {

			stmt = conn.prepareStatement(sql);

			stmt.setString(1, provider.getName());
			stmt.setString(2, provider.getAddress());
			stmt.setBoolean(3, provider.getStatus());
			stmt.setString(4, provider.getCnpj());
			stmt.setBoolean(5, provider.getOpenCapital());

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
		Provider provider = (Provider) object;
		PreparedStatement stmt = null;
		String sql = "UPDATE provider SET name = ? , address = ? , status = ? , cnpj = ? ,  openCapital = ? WHERE id = ?";                               //PAREI AQUI
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, provider.getName());
			stmt.setString(2, provider.getAddress());
			stmt.setBoolean(3, provider.getStatus());
			stmt.setString(4, provider.getCnpj());
			stmt.setBoolean(5, provider.getOpenCapital());
			stmt.setInt(6, provider.getId());
			
			stmt.execute();
			return true;
		} catch (Exception e) {
			System.out.println("Problems in the DAO and to change the Provider! ERROR: " + e.getMessage());
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
		String sql = "DELETE FROM provider WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Problems in the DAO when you are trying to delete Provider! ERROR: " +e.getMessage());
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
