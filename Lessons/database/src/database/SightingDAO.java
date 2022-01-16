package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SightingDAO {
	
	// Classe che rende accessibili ad altre classi i dati estratti dal database
	
	// Le altre classi non hanno alcun bisogno di conoscere i dettagli del database 
	// o di "parlare" il linguaggio JDBC, utilizzare SQL, ecc.

	String url = "jdbc:mysql://localhost:3306/ufo_sightings?user=root";
	
	public List<String> readShapes(){
		
		LinkedList<String> shapes = new LinkedList<String>();

		try {

			Connection conn = DriverManager.getConnection(url);
			
			String querySql = " SELECT DISTINCT shape "+
							  " FROM sighting "+
					          " WHERE shape <> '' "+
							  " ORDER BY shape ASC ";
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(querySql);
			
			while(rs.next()) {

				String shape = rs.getString("shape");
				// String datetime  = rs.getString("datetime"); // Se presente nella query SQL
				// String country  = rs.getString("country");
				
				// System.out.println(shape);
				
				shapes.add(shape); // Costruisco la mia struttura dati (lista) di shape
			}

			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return shapes;
	}
	
	public int cntShapes(String sh) {

		try {
			
			Connection conn = DriverManager.getConnection(url);

			//String sh = "light";
			
			String querySql2 = "SELECT COUNT(*) FROM sighting WHERE shape = ? ";
					  
			PreparedStatement st2 = conn.prepareStatement(querySql2); // prepareStatement
			
			st2.setString(1, sh); // Assegniamo un valore al ? (il primo, uno solo in questo caso, quindi 1)
			
			ResultSet rs2 = st2.executeQuery();

			rs2.next();
			
			int cnt = rs2.getInt(1);
			
			// System.out.println("Numero di forme di tipo "+sh+": "+cnt);

			conn.close();
			
			return cnt;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}

}










