package br.com.projectMVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projectMVC.model.Client;
import br.com.projectMVC.model.Product;
import br.com.projectMVC.util.ConnectionFactory;

	public class ClientDAOImpl implements GenericDAO {

		private Connection conn;

		public ClientDAOImpl() throws Exception {

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
			
			String sql = "SELECT * FROM client ORDER by description";

			try {
				
				stmt = conn.prepareStatement(sql);
				
				rs = stmt.executeQuery();

				while (rs.next()) {
				
					Client client = new Client();
					client.setId(rs.getInt("id"));                                         // "happy routine"
					client.setName(rs.getString("name"));
					client.setAddress(rs.getString("address"));
					client.setStatus(rs.getBoolean("status"));
					list.add(client);
				}

			} catch (SQLException e) {
				// Catching and showing the error
				System.out.println("Problems with the DAO when you are listing the Client! Erro: " + e.getMessage());
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

			Client client = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			String sql = "SELECT * FROM client WHERE id = ?";
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, id);
				rs = stmt.executeQuery();

				if (rs.next()) {
					client = new Client();
					client.setId(rs.getInt("id"));
					client.setName(rs.getString("name"));
					client.setAddress(rs.getString("address"));
					client.setStatus(rs.getBoolean("status"));
					
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
			return client;

		}

		@Override
		public Boolean insert(Object object) {

			Client client = (Client) object;

			PreparedStatement stmt = null;

			String sql = "INSERT INTO client (name,address,status) VALUES (?,?,?)";                            
			try {

				stmt = conn.prepareStatement(sql);

				stmt.setString(1, client.getName());
				stmt.setString(2, client.getAddress());
				stmt.setBoolean(3, client.getStatus());

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
			Client client = (Client) object;
			PreparedStatement stmt = null;
			String sql = "UPDATE client SET name = ? , address = ? , status = ? WHERE id = ?";                               //PAREI AQUI
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, client.getName());
				stmt.setString(2, client.getAddress());
				stmt.setBoolean(3, client.getStatus());
				stmt.setInt(4, client.getId());
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
			String sql = "DELETE FROM client WHERE id = ?";
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
	}
	
