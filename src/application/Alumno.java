package application;

public class Alumno {
	
	private String DNI_Alumno;
	private String Nombre; 
	private String Apellido;
	private String Telefono;
	private String Provincia;
	private String Localidad;
	private String Correoelectronico; 
	private String Nacionalidad;
	private String DNI_Tutor;
	
	public Alumno(String dNI_Alumno, String nombre, String apellido, String telefono, String provincia, 
	String localidad, String correoelectronico, String nacionalidad, String dNI_Tutor) {
		
		this.DNI_Alumno = dNI_Alumno;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Telefono = telefono;
		this.Provincia = provincia;
		this.Localidad = localidad;
		this.Correoelectronico = correoelectronico;
		this.Nacionalidad = nacionalidad;
		this.DNI_Tutor = dNI_Tutor;
		
	}


	public String getDNI_Alumno() {
		return DNI_Alumno;
	}

	public void setDNI_Alumno(String dNI_Alumno) {
		DNI_Alumno = dNI_Alumno;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getCorreoelectronico() {
		return Correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		Correoelectronico = correoelectronico;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getDNI_Tutor() {
		return DNI_Tutor;
	}

	public void setDNI_Tutor(String dNI_Tutor) {
		DNI_Tutor = dNI_Tutor;
	}	
}
