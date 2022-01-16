package database;

import java.sql.*;
import javax.sql.*;
import java.util.*;

public class ProvaJDBC {

	public static void main(String[] args) {

		LinkedList<String> shapes = new LinkedList<String>();
		
		try {

			String url = "jdbc:mysql://localhost:3306/ufo_sightings?user=root";
			
			Connection conn = DriverManager.getConnection(url);
			
			String querySql = " SELECT DISTINCT shape "+
							  " FROM sighting "+
					          " WHERE shape <> '' "+
							  " ORDER BY shape ASC ";
			
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(querySql);
			
			while(rs.next()) {

				String shape = rs.getString("shape");
				// String datetime  = rs.getString("datetime"); // Se nella query SQL
				// String country  = rs.getString("country");
				
				// System.out.println(shape);
				
				shapes.add(shape); // Costruisco la mia struttura dati (lista) di shape
			}
			
			rs.close(); // Da chiudere se non serve piu'
			
			// conn.close(); // Ricordarsi di chiudere la connessione
			              // se non ho necessita' di eseguire altre query
			
			// for(String s : shapes)
			// 	System.out.println(s);
			
			// Posso eseguire altre query sulla stessa connessione, se non l'ho chiusa
			
			/*
			String sh = "light";
			
			String querySql2 = "SELECT COUNT(*) FROM sighting WHERE shape = '"+sh+"' ";
					  
			Statement st2 = conn.createStatement();
			
			ResultSet rs2 = st2.executeQuery(querySql2);

			rs2.next();
			
			int cnt = rs2.getInt(1);
			
			System.out.println("Numero di forme di tipo "+sh+": "+cnt);
			
			*/
			
			// Preferibile, per motivi di sicurezza e prestazioni, utilizzare PreparedStatement
			
			String sh = "light";
			
			String querySql2 = "SELECT COUNT(*) FROM sighting WHERE shape = ? ";
					  
			PreparedStatement st2 = conn.prepareStatement(querySql2); // prepareStatement
			
			st2.setString(1, sh); // Assegniamo un valore al ? (il primo, uno solo in questo caso, quindi 1)
			
			ResultSet rs2 = st2.executeQuery();

			rs2.next();
			
			int cnt = rs2.getInt(1);
			
			System.out.println("Numero di forme di tipo "+sh+": "+cnt);

			conn.close();
			

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
