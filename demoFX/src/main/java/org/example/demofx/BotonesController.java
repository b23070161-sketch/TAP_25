package org.example.demofx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

public class BotonesController {
    @FXML
    private Label mensajeBienvenida;
    @FXML
    private Button boton1;
    @FXML
    private Button boton2;
    @FXML
    private Button boton3;
    @FXML
    private Label infoLabel;

    // este metodo recibe datos desde la otra ventana
    public void setBienvenida(String mensaje) {
        mensajeBienvenida.setText(mensaje);
    }

    @FXML
    public void initialize() {
        // VENTANA CON LOS BOTONES===============================================================================
        /*
        este tooltip lo que hace es sacar un mensaje para cada vez que se pasa el raton por encima de un objeto por ejemplo en este
        es para el boton de tramites y abajo da una descripcion.
         */
        Tooltip.install(boton1, new Tooltip("Pasa el mouse sobre un boton para saber mas informacion"));

        // Aqui se cambia el texto de una label

        boton1.setOnMouseEntered(event -> infoLabel.setText("agenda citas para realizar tus tramites"));
        boton1.setOnMouseExited(event -> infoLabel.setText("Pasa el mouse sobre un boton para saber mas informacion"));

        boton2.setOnMouseEntered(event -> infoLabel.setText("Revisa tus documentos capturados en el sistema"));
        boton2.setOnMouseExited(event -> infoLabel.setText("Pasa el mouse sobre un boton para saber mas informacion"));

        boton3.setOnMouseEntered(event -> infoLabel.setText("Salir del sistema"));
        boton3.setOnMouseExited(event -> infoLabel.setText("Pasa el mouse sobre un boton para saber mas informacion"));
    }
}

