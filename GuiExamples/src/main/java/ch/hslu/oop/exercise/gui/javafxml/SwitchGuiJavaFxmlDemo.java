/*
 * Copyright 2019 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.oop.exercise.gui.javafxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * SwitchGUI mit Java FX und FXML implementiert.
 */
@SuppressWarnings("restriction")
public final class SwitchGuiJavaFxmlDemo extends Application {

    private static final Logger LOG = LogManager.getLogger(SwitchGuiJavaFxmlDemo.class);

    @Override
    public void start(final Stage stage) {

        stage.setTitle("Switch GUI with JavaFX/FXML");
        Parent pane;
        try {
            final URL fxmlUrl = getClass().getResource("SwitchGuiJavaFxml.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
            fxmlLoader.setController(new SwitchGuiJavaFxmlController());
            pane = fxmlLoader.load();
            stage.setScene(new Scene(pane, 200, 100));
            stage.show();
            LOG.info("GUI-Stage aktiviert und sichtbar.");
        } catch (IOException e) {
            LOG.error("FXML-Datei nicht gefunden/lesbar.", e);
        }
    }

    /**
     * Controller als innere Klasse implementiert.
     */
    public static final class SwitchGuiJavaFxmlController implements Initializable {

        @FXML
        private Button btnOn;

        @FXML
        private Button btnOff;

        @FXML
        private Label label;

        /*
         * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
         */
        @Override
        public void initialize(final URL arg0, final ResourceBundle arg1) {
            btnOn.setOnAction(this::setOnAction);
            btnOff.setOnAction(this::setOffAction);
            LOG.info("Controller als Listener registriert.");
        }

        /**
         * Behandlung des On-Buttons.
         * @param event Event.
         */
        private void setOnAction(final ActionEvent event) {
            label.setText("The switch is ON.");
            label.setStyle("-fx-background-color: lightgreen;");
            LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
        }

        /**
         * Behandlung des Off-Buttons.
         * @param event Event.
         */
        private void setOffAction(final ActionEvent event) {
            label.setText("The switch is OFF.");
            label.setStyle("-fx-background-color: red;");
            LOG.debug("ActionEvent von OFF-Button empfangen und verarbeitet.");
        }
    }

    /**
     * main-Methode startet die JavaFX-Application.
     * @param args nicht verwendet.
     */
    public static void main(final String[] args) {
        LOG.info("Applikation startet...");
        launch(args);
    }
}