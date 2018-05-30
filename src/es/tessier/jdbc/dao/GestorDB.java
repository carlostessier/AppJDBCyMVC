package es.tessier.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * La clase Conector gestiona las conexiones con varias bases de datos y utiliza
 * un patrón Singleton2 para devolver una sola instancia. Para flexibilizar las
 * conexiones con varias bases de datos de manera local
 * 
 * @author carlosfernandez
 *
 */
public class GestorDB {

	private static Connection conexion;
	private String url;
	private String baseDatos;
	private String user;
	private String passwd;
    private ResourceBundle rb;
    
	public GestorDB() {
		 rb = ResourceBundle.getBundle("es.tessier.jdbc.dao.jdbc");

		this.url = rb.getString("url");
		this.baseDatos = rb.getString("bbdd");
		this.user = rb.getString("usuario");
		this.passwd = rb.getString("clave");
		
		abrirConexion();
		// this("jdbc:mysql://localhost:3306/","EJEMPLO","EJEMPLO","EJEMPLO");

	}

	GestorDB(String url, String baseDatos, String user, String pass) {
		this.url = url;
		this.baseDatos = baseDatos;
		this.user = user;
		this.passwd = pass;

		abrirConexion();
	}

	public void abrirConexion() {
		try {

			// establecer la conexion:
			// conexion=DriverManager.getConnection("jdbc:mysql://localhost/pruebas","root","mariadb");
			conexion = DriverManager.getConnection(url + baseDatos, user, passwd);
			System.out.println("Conectado a " + baseDatos);

		} catch (SQLException e) {
			System.out.println("Error de conexion con la BD: " + e.getMessage());

		}
	}

	public void cierraConexion() {

		try {
			conexion.close();
		} catch (SQLException e) {

			e.printStackTrace();
		} // Cierro conexion

	}

	public static Connection getConexion() {
		return conexion;
	}

	public ResourceBundle getRb() {
		return rb;
	}

	

	
	
}
