package controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import modelo.Jugador;





public class contolador {

	
public void guardarenbasesededatos(Jugador jugador){
		
		
		
		try {
			Class.forName("org.sqlite.JDBC");
			String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\Examen\\jugadoresbasededatos.txt";
			
			Connection conexion = DriverManager.getConnection(url);
			
			if(conexion!=null) {
				
				System.out.println("Hay conección");
				
			}else {
				
				System.out.println("No hay conección");
				
			}
			
			
			var pt = conexion.prepareStatement("INSERT INTO jugadores VALUES ( ?,?,?,?)");
			pt.setInt(1, jugador.getID());
			pt.setString(2, jugador.getNombre());
			pt.setInt(3, jugador.getDorsal());
			pt.setDouble(4, jugador.getAltura());

			pt.executeUpdate();
			
			if(conexion!=null) {
				
				conexion.close();
			
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
public boolean exiteenbasdedatos(Jugador jugador) {
	
	try {
		Class.forName("org.sqlite.JDBC");
		String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\Examen\\jugadoresbasededatos.txt";
		
		Connection conexion = DriverManager.getConnection(url);
		
		if(conexion!=null) {
			
			System.out.println("Hay conección");
			
		}else {
			
			System.out.println("No hay conección");
			
		}
		
		
		var pt = conexion.prepareStatement("SELECT * FROM jugadores WHERE ID= ?");
		pt.setInt(1, jugador.getID());
		
		
		ResultSet rs = pt.executeQuery();
		
		
		if(conexion!=null) {
			
			conexion.close();
		
		}
		
		return rs.next();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}


	return false;
	
}

public String listarbasededatos() {
	
	try {
		Class.forName("org.sqlite.JDBC");
		String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\Examen\\jugadoresbasededatos.txt";
		
		Connection conexion = DriverManager.getConnection(url);
		
		if(conexion!=null) {
			
			System.out.println("Hay conección");
			
		}else {
			
			System.out.println("No hay conección");
			
		}
		
		
		var pt = conexion.prepareStatement("SELECT * FROM jugadores order by ID");
		ResultSet rs = pt.executeQuery();
		
		
		String mensage= "";
		mensage +=	"ID"+"    "+ "Nonbre"+"    "+ "Nº Jugador"+"    "+ "Altura";
		mensage += "\n";
		while (rs.next()) {
			
		mensage +=	rs.getInt(1)+"     "+ rs.getString(2)+"                 "+ rs.getInt(3)+"                      "+ rs.getDouble(4);
			mensage += "\n";
		}
		
		if(conexion!=null) {
			
			conexion.close();
		
		}
		
	
		return mensage;
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	
	return null;
}
public void eliminardelabasededatos(Jugador jugador ) {
	
	try {
		Class.forName("org.sqlite.JDBC");
		String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\Examen\\jugadoresbasededatos.txt";
		
		Connection conexion = DriverManager.getConnection(url);
		
		if(conexion!=null) {
			
			System.out.println("Hay conección");
			
		}else {
			
			System.out.println("No hay conección");
			
		}
		
		
		var pt = conexion.prepareStatement("DELETE FROM jugadores WHERE ID= ?");
		pt.setInt(1, jugador.getID());
		

		pt.executeUpdate();
		
		if(conexion!=null) {
			
			conexion.close();
		
		}
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	return ;
}

public void modificarenbasadedatos(Jugador jugador) {
	
	
	try {
		Class.forName("org.sqlite.JDBC");
		String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\Examen\\jugadoresbasededatos.txt";
		
		Connection conexion = DriverManager.getConnection(url);
		
		if(conexion!=null) {
			
			System.out.println("Hay conección");
			
		}else {
			
			System.out.println("No hay conección");
			
		}
		
		
		var pt = conexion.prepareStatement("UPDATE jugadores SET nombre=?, dorsal=?, altura=? WHERE ID=? ");
		
		pt.setString(1, jugador.getNombre());
		pt.setInt(2, jugador.getDorsal());
		pt.setDouble(3, jugador.getAltura());
		pt.setInt(4, jugador.getID());
		
		pt.executeUpdate();
		
		if(conexion!=null) {
			
			conexion.close();
		
		}
		
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
}



public int  modificarID(){
	
	try {
		Class.forName("org.sqlite.JDBC");
		String url="jdbc:sqlite:C:\\Users\\alumno tarde\\Desktop\\dj\\Examen\\jugadoresbasededatos.txt";
		
		Connection conexion = DriverManager.getConnection(url);
		
		if(conexion!=null) {
			
			System.out.println("Hay conección");
			
		}else {
			
			System.out.println("No hay conección");
			
		}
		
		
		var pt = conexion.prepareStatement("SELECT max(ID) FROM jugadores");
		
	ResultSet rs = pt.executeQuery();
		
		int respuesta = rs.getInt(1);
		
		if(conexion!=null) {
			
			conexion.close();
		
		}
		
		
		return respuesta += 1;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
	
	
	
	
	
	
	
}





}
