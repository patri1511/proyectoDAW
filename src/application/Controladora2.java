package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controladora2 {
	
	@FXML
	private Button Alumno;

	@FXML
	private Button Instituto;
	   
	@FXML
	private Button Empresa;
	
	@FXML
	private Button Ciclo;
	
	@FXML
	public void initialize() {

	 // TODO (don't really need to do anything here).

    }
	
	public void Alumno(ActionEvent event) throws IOException{
		
	  FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_3_tabla_alumno.fxml"));
 	  AnchorPane ventanaDos = (AnchorPane) loader.load();
      Stage ventana = new Stage();
      ventana.setTitle("Ventana Alumno");
      Scene scene = new Scene(ventanaDos);
      ventana.setScene(scene);
      ventana.show();
 	}
}
