package br.com.calculadora_java.mvc.maven;


import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class CalculadoraView extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            String[] btnStringNumbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String[] btnStringOperators = {"+", "-", "*", "/", "x^2", "x^y"};
            String[] btnStringMedia = {"Mc", "Mr", "M+", "M-"};
            String[] btnStringOthers = {"CE", "=", ".", "C"};
            Button[] btnNumbers = new Button[10];
            Button[] btnOperators = new Button[6];
            Button[] btnMedia = new Button[4];
            Button[] btnOthers = new Button[4];

            GridPane gridPane = new GridPane();
            
            CalculadoraController.textField.setFill(javafx.scene.paint.Color.BLACK);
            CalculadoraController.textField.setFont(javafx.scene.text.Font.font("System", 20));
            //Creating a buttons for numbers and Operators
            createGridButtonNumbers(10, btnStringNumbers, btnNumbers);
            createGridButtonOthersOperation(4, btnStringOthers, btnOthers);
            createGridButtonOperation(6, btnStringOperators, btnOperators);
            createGridButtonMedia(4, btnStringMedia, btnMedia);

            //Creating a text field
            BorderPane pane = createBorderPaneCalculadora(btnMedia);
            createGridPaneCalculadora(btnNumbers, btnOperators, btnOthers, gridPane);
            pane.setCenter(gridPane);

            Scene scene = new Scene(pane, 300, 275);
            stage.setTitle("Calculadora");
            stage.setScene(scene);
            stage.show();
        }


        private static BorderPane createBorderPaneCalculadora(Button[] btnMedia) {
            BorderPane borderPane = new BorderPane();
            BorderPane borderPaneTopBottom = new BorderPane();
            borderPane.setPadding(new Insets(8, 8, 8, 8));
            HBox hbox = new HBox();
            hbox.getChildren().addAll(btnMedia[0], btnMedia[1], btnMedia[2], btnMedia[3]);
            borderPaneTopBottom.setRight(CalculadoraController.textField);
            borderPaneTopBottom.setBottom(hbox);
            borderPane.setTop(borderPaneTopBottom);
            return borderPane;
        }

        private static GridPane createGridPaneCalculadora(Button[] btnNumbers, Button[] btnOperators, Button[] btnOthers, GridPane gridPane) {
            int i = 0;
            int j = 0;
            int count = 0;

            gridPane.add(btnOthers[0], 0, 1);
            gridPane.add(btnOthers[1], 1, 1);
            gridPane.add(btnOthers[2], 2, 1);
            gridPane.add(btnOthers[3], 0, 5);

            for(i = 0; i < 4; i++) {
                gridPane.add(btnOperators[i], 3, i+ 1);
            }

            for(i = 2, count = 7; i < 5; i++, count = count - 3) {
                for(j = 0; j < 3; j++){
                    gridPane.add(btnNumbers[count + j], j, i);
                }
            }

            gridPane.add(btnNumbers[0], 1, 5);
            gridPane.add(btnOperators[4], 2, 5);
            gridPane.add(btnOperators[5], 3, 5);
            

            return gridPane;
        }

        private static Button[] createGridButtonMedia(int size, String[] btnStringMedia, Button[] btnMedia) {
            for(int i = 0; i < size; i++) {
                btnMedia[i] = new Button(btnStringMedia[i]);
                btnMedia[i].setPrefSize(80, 50);
                btnMedia[i].setStyle(STYLESHEET_CASPIAN);
                String j = btnStringMedia[i];
                btnMedia[i].setOnAction(
                    (ActionEvent event) -> CalculadoraController.computar(j)
                );
            }
            return btnMedia;
        }
        
        private static Button[] createGridButtonNumbers(int length, String[] btnString, Button[] btn){
            for (int i = 0; i < length; i++) {
                btn[i] = new Button(btnString[i]);
                btn[i].setPrefSize(80, 50);
                btn[i].setStyle(STYLESHEET_CASPIAN);
                String j = btnString[i];
                btn[i].setOnAction(
                    (ActionEvent event) -> CalculadoraController.computar(j)
                );
            }

            return btn;
        }


        private static Button[] createGridButtonOperation(int length, String[] btnString, Button[] btn){
            for (int i = 0; i < length; i++) {
                btn[i] = new Button(btnString[i]);
                btn[i].setPrefSize(80, 50);
                btn[i].setStyle("-fx-base:white");
                String j = btnString[i];

                if(j.equals("x^2") || j.equals("x^y")) {
                    btn[i].setOnAction(
                        (ActionEvent event) -> CalculadoraController.computar("^")
                    );
                } else {
                    btn[i].setOnAction(
                        (ActionEvent event) -> CalculadoraController.computar(j)
                    );
                }
            }
            return btn;
        }

        private static Button[] createGridButtonOthersOperation(int length, String[] btnStringOthers, Button[] btnOthers){
            int i = 0;
            for (i = 0; i < length; i++) {
                btnOthers[i] = new Button(btnStringOthers[i]);
                btnOthers[i].setPrefSize(80, 50);
                String j = btnStringOthers[i];
                btnOthers[i].setOnAction(
                    (ActionEvent e) -> CalculadoraController.computar(j)
                );
            }
            return btnOthers;
        }

    
        public static void main(String[] args) {
            launch(args);
        }

    
}