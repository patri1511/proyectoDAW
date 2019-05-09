package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladoraPrincipal {
	
	   @FXML
	   private Button Administracion;

	   @FXML
	   private Button AsignarPracticas;
	   
	   @FXML
	   private Button GenerarAnexos;

	   @FXML
	   public void initialize() {

	       // TODO (don't really need to do anything here).

	   }

	   // When user click on myButton
	   // this method will be called.
	   public void Admi(ActionEvent event) throws IOException{

	 		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_2.fxml"));
	 		AnchorPane ventanaDos = (AnchorPane) loader.load();
	        Stage ventana = new Stage();
	        ventana.setTitle("Ventana Secundaria");
	        Scene scene = new Scene(ventanaDos);
	        ventana.setScene(scene);
	        ventana.show();
	 	}
}
