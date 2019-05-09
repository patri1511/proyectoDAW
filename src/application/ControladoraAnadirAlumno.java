package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraAnadirAlumno {
	
	@FXML
	private Button GUARDARCAMBIOS;
	
	@FXML
	private Button BORRARCAMPOS;
	
	@FXML
    private TextField DNI_AlumnoTextField;
	
	@FXML
    private TextField NombreTextField;
	
	@FXML
    private TextField ApellidoTextField;
	
	@FXML
    private TextField TelefonoTextField;

	@FXML
    private TextField ProvinciaTextField;
	
	@FXML
    private TextField LocalidadTextField;
	
	@FXML
    private TextField CorreoelectronicoTextField;
	
	@FXML
    private TextField NacionalidadTextField;
	
	@FXML
    private TextField DNI_TutorTextField;
	
	private Stage ventana;
	private Alumno alumno; 
    private boolean guardarClicked = false;
	
    @FXML
    private void initialize() {
    }

	public boolean isGuardarClicked() {
	      return guardarClicked;
	}
	
	@FXML
    private void guardar() {
        
        if (datosValidos()) {
            
            //Asigno datos a propiedades de persona
            alumno.setDNI_Alumno(DNI_AlumnoTextField.getText());
            alumno.setNombre(NombreTextField.getText());
            alumno.setApellido(ApellidoTextField.getText());
            alumno.setTelefono(TelefonoTextField.getText());
            alumno.setProvincia(ProvinciaTextField.getText());
            alumno.setLocalidad(LocalidadTextField.getText());
            alumno.setCorreoelectronico(CorreoelectronicoTextField.getText());
            alumno.setNacionalidad(NacionalidadTextField.getText());
            alumno.setDNI_Tutor(DNI_TutorTextField.getText());
            
            Conexion conexionBBDD = new Conexion();
            conexionBBDD.InsertarAlumno();
 	       
            guardarClicked = true; //Cambio valor booleano
            ventana.close(); //Cierro el escenario de edición
            
        }
    }
    
    //LLamado cuando se pulsa Cancelar
    @FXML
    private void cancelar() {
        ventana.close();
    }
    
    //Validación de datos
    private boolean datosValidos(){
        
        //Inicializo string para mensajes
        String mensajeError = "";

        //Compruebo los campos
        if (DNI_AlumnoTextField.getText() == null || DNI_AlumnoTextField.getText().length() == 0) {
            mensajeError += "DNI_Alumno no válido.\n"; 
        }
        if (NombreTextField.getText() == null || NombreTextField.getText().length() == 0) {
            mensajeError += "Nombre no válidos.\n"; 
        }
        if (ApellidoTextField.getText() == null || ApellidoTextField.getText().length() == 0) {
            mensajeError += "Apellido no válida.\n"; 
        }

        if (TelefonoTextField.getText() == null || TelefonoTextField.getText().length() == 0) {
            mensajeError += "Telefono no válido.\n"; 
        } 

        if (ProvinciaTextField.getText() == null || ProvinciaTextField.getText().length() == 0) {
            mensajeError += "Provincia no válida.\n"; 
        }

        if (LocalidadTextField.getText() == null || LocalidadTextField.getText().length() == 0) {
            mensajeError += "Localidad no válida.\n";
        } 
        
        if (CorreoelectronicoTextField.getText() == null || CorreoelectronicoTextField.getText().length() == 0) {
            mensajeError += "Correoelectronico no válida.\n";
        } 
        
        if (NacionalidadTextField.getText() == null ||NacionalidadTextField.getText().length() == 0) {
            mensajeError += "Nacionalidad no válida.\n";
        } 
        
        if (DNI_TutorTextField.getText() == null || DNI_TutorTextField.getText().length() == 0) {
            mensajeError += "DNI_Tutor no válida.\n";
        } 
        
        //Si no hay errores devuelvo true, si no, una alerta con los errores y false
        if (mensajeError.length() == 0) {
            return true;
        } else {
            //Muestro alerta y devuelvo false
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos no válidos");
            alerta.setContentText("Por favor, corrige los errores");
            alerta.showAndWait();
            return false;
        }
        
    }
}
