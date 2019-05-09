package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Conexion {

	private String bd;
	private String url= "";
	private String usr = "";
	private String pwd = "";
	private static Connection Conexion;
	

	public Conexion()  {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url = propiedades.getProperty("url");
				usr = propiedades.getProperty("usr");	
				pwd = propiedades.getProperty("pwd");
			}else 
				System.out.println("Fichero no encontrado");
		}catch (IOException ex) {
		ex.printStackTrace();
		
		}finally {
			if (entrada != null ) {
				try {
					entrada.close();
					System.out.println(url + " " + usr + " " + pwd);
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Conexion = DriverManager.getConnection(url, usr, pwd);
					
					if(!Conexion.isClosed()) {
						System.out.println("Conexión establecida");
						//conexion.close();
					}
					else
						System.out.println("Fallo en Conexión");	
					

				}catch (Exception e) {
					System.out.println("ERROR en conexión con ORACLE");	
					e.printStackTrace();
				}
			}
		}
		
	}


	
	public ObservableList<Alumno> Consulta() {
		
	ObservableList<Alumno> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = Conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT DNI_Alumno, Nombre, Apellido, Telefono, Provincia,  Localidad, "
			+ "Correoelectronico, Nacionalidad, DNI_Tutor FROM PATRICIA.ALUMNO" );
			while(rset.next()) {
				String DNI_Alumno = rset.getString(1);
				String Nombre = rset.getString(2); 
				String Apellido = rset.getString(3);
				String Telefono = rset.getString(4);
				String Provincia = rset.getString(5);
				String Localidad = rset.getString(6);
				String Correoelectronico = rset.getString(7); 
				String Nacionalidad = rset.getString(8);
				String DNI_Tutor = rset.getString(9);
				Alumno auxAlum = new Alumno(DNI_Alumno, Nombre, Apellido, Telefono, Provincia,  Localidad, Correoelectronico, Nacionalidad, DNI_Tutor);
				aux.add(auxAlum);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}
	
	public static int InsertarAlumno(String DNI_Alumno, String  Nombre, String  Apellido, String  Telefono, String  Provincia,  String  Localidad, String  Correoelectronico, String  Nacionalidad, String  DNI_Tutor) throws SQLException{
		
		Statement stmt = Conexion.createStatement();//Introduce los datos
		
		//INSERT INTO SCHEMA.NOMBRE_TABLA VALUES ();
		System.out.println("INSERT INTO PATRICIA.ALUMNO VALUES (" + DNI_Alumno + "," + "'" + Nombre + "," + "'" + Apellido + "," + "'" + Telefono + "," + "'" + Provincia + "," + "'" + Localidad + "," + "'" + Correoelectronico + "," + "'" + Nacionalidad + "," + "'" + DNI_Tutor+"')");
		int num = stmt.executeUpdate("INSERT INTO PATRICIA.ALUMNO VALUES (" + DNI_Alumno + "," + "'" + Nombre + "," + "'" + Apellido + "," + "'" + Telefono + "," + "'" + Provincia + "," + "'" + Localidad + "," + "'" + Correoelectronico + "," + "'" + Nacionalidad + "," + "'" + DNI_Tutor+"')");
		return num;
	}
}