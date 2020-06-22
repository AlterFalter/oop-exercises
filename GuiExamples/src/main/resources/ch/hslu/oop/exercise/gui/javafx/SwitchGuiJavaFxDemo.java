/*
 * Copyright 2020 Hochschule Luzern Informatik.
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
package ch.hslu.oop.exercise.gui.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Einfaches SwitchGUI mit Java FX implementiert.
 */
@SuppressWarnings("restriction")
public final class SwitchGuiJavaFxDemo extends Application {

    private static final Logger LOG = LogManager.getLogger(SwitchGuiJavaFxDemo.class);

    @Override
    public void start(final Stage primaryStage) {

        primaryStage.setTitle("Switch GUI with JavaFX");

        final Label label = new Label("The switch is OFF.");

        final Button btnOn = new Button("On");
        btnOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                label.setText("The switch is ON.");
                label.setStyle("-fx-background-color: lightgreen;");
                LOG.info("ActionEvent von ON-Button empfangen und verarbeitet.");
            }
        });
        final Button btnOff = new Button("Off");
        btnOff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                label.setText("The switch is OFF.");
                label.setStyle("-fx-background-color: red;");
                LOG.info("ActionEvent von OFF-Button empfangen und verarbeitet.");
            }
        });

        final BorderPane borderPane = new BorderPane();
        borderPane.setTop(btnOn);
        borderPane.setCenter(label);
        borderPane.setBottom(btnOff);
        primaryStage.setScene(new Scene(borderPane, 200, 100));
        primaryStage.show();
        LOG.info("GUI-Stage aktiviert und sichtbar.");
    }

    /**
     * main-Methode startet die JavaFX-Application.
     * @param args nicht verwendet.
     */
    public static void main(final String[] args) {
        LOG.info("Applikation startet...");
        launch(SwitchGuiJavaFxDemo.class, args);
    }
}