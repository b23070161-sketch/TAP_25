package org.example.demofx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class RegistroController {
    @FXML
    private TextField nombreField;
    @FXML
    private ComboBox<Integer> diaBox;
    @FXML
    private ComboBox<String> mesBox;
    @FXML
    private ComboBox<Integer> anioBox;

    // Este metodo se llama automáticamente cuando se carga el FXML
    @FXML
    public void initialize() {
        // Llenar los ComboBox con datos
        for (int i = 1; i <= 31; i++) {
            diaBox.getItems().add(i);
        }
        mesBox.getItems().addAll("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
        for (int i = 2024; i >= 1950; i--) {
            anioBox.getItems().add(i);
        }
    }

    // Este metodo se ejecuta cuando se presiona el botón de "finalizar registro" y despues te manda a otra ventana
    @FXML
    protected void finalizarRegistro() {
        String nombre = nombreField.getText();

        try {
            // Cargar la nueva ventana con los botones
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("botones-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);

            // Obtener el controlador de la nueva ventana para pasarle datos
            BotonesController controller = fxmlLoader.getController();
            controller.setBienvenida("¡Hola, " + nombre + "!");

            // Obtener la ventana actual y cambia la escena
            Stage stage = (Stage) nombreField.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Ventana de Botones");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
