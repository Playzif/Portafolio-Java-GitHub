package com.playzif.amazonviewer.db;

import java.sql.DriverManager;
import java.sql.Connection;
import static com.playzif.amazonviewer.db.DataBase.*;

public interface IDBConnection {
	
	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);
			if (connection != null) {
				System.out.println("Se establecio la conexion");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return connection;
		}
		
	}

}