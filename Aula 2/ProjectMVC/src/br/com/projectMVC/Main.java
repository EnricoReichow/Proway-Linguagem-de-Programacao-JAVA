package br.com.projectMVC;

import java.sql.Connection;

import br.com.projectMVC.util.ConnectionFactory;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();

		if(connection != null) {
			System.out.println("The connection has been established.");
		}else {
			System.out.println("Failing to connect.");
		}
		
		connection.close();
		
	}

}
