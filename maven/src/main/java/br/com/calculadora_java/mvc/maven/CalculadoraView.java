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
            String btnStringNumbers[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String btnStringOperators[] = {"+", "-", "*", "/"};
            String btnStringOthers[] = {"CE", "=", ".", "DEL"};
            Button[] btnNumbers = new Button[10];
            Button[] btnOperators = new Button[5];
            Button[] btnOthers = new Button[5];

            GridPane gridPane = new GridPane();
            BorderPane pane = new BorderPane();
            
            CalculadoraController.textField.setFill(javafx.scene.paint.Color.WHITE);
            CalculadoraController.textField.setFont(javafx.scene.text.Font.font("System", 20));
            //Creating a buttons for numbers and Operators
            btnNumbers = createGridButtonNumbers(10, btnStringNumbers, btnNumbers);
            btnOthers = createGridButtonOthersOperation(5, btnStringOthers, btnOthers);
            btnOperators = createGridButtonOperation(5, btnStringOperators, btnOperators);
            
            //Creating a text field
            pane = createBorderPaneCalculadora();
            gridPane = createGridPaneCalculadora(btnNumbers, btnOperators, btnOthers, gridPane);

            pane.setCenter(gridPane);
            

            Scene scene = new Scene(pane, 300, 275);
            stage.setTitle("Calculadora");
            stage.setScene(scene);
            stage.show();
        }


        private static BorderPane createBorderPaneCalculadora() {
            BorderPane borderPane = new BorderPane();
            BorderPane borderPaneTopBottom = new BorderPane();

            borderPane.setPadding(new Insets(20, 0, 20, 20));
            
            HBox hbox = new HBox();
            hbox.getChildren().addAll();

            borderPaneTopBottom.setRight(CalculadoraController.textField);
            borderPaneTopBottom.setBottom(hbox);
            borderPane.setTop(borderPaneTopBottom);
            return borderPane;
        }

        private static GridPane createGridPaneCalculadora(Button[] btnNumbers, Button[] btnOperators, Button[] btnOthers, GridPane gridPane) {
            int i = 0;
            int j = 0;
            int count = 0;

            gridPane.add(btnOthers[0], 0, 0);
            gridPane.add(btnOthers[1], 1, 0);
            
            for(i = 0; i < 5; i++) {
                gridPane.add(btnOperators[i], 3, i + 1   );
            }
            
            for(i = 0, count = 7; i < 10; i++, count = count - 3) {
                for(j = 0; j < 3; j++){
                    gridPane.add(btnNumbers[i], 4, i + 1);
                }
            }
            
            gridPane.add(btnOthers[2], 0, 5);
            gridPane.add(btnOthers[3], 2, 5);

            return gridPane;
        }
        
        private static Button[] createGridButtonNumbers(int length, String[] btnString, Button[] btn){
            for (int i = 0; i < length; i++) {
                btn[i] = new Button(btnString[i]);
                btn[i].setPrefSize(50, 50);
                btn[i].setStyle("-fx-background-color: #A9A9A9; -fx-text-fill: #FFFFFF;");
            }

            return btn;
        }

        private static Button[] createGridButtonOperation(int length, String[] btnString, Button[] btn){
            for (int i = 0; i < length; i++) {
                btn[i] = new Button(btnString[i]);
                btn[i].setPrefSize(50, 50);
                btn[i].setStyle("-fx-background-color: #A9A9A9; -fx-text-fill: #FFFFFF;");
            }
            return btn;
        }

        private static Button[] createGridButtonOthersOperation(int length, String[] btnStringOthers, Button[] btnOthers){
            int i = 0;
            for (i = 0; i < length; i++) {
                btnOthers[i] = new Button(btnStringOthers[i]);
                btnOthers[i].setPrefSize(50, 50);
                String j = btnStringOthers[i];
                btnOthers[i].setOnAction(
                    (ActionEvent e) -> {
                        CalculadoraController.computar(j);
                    }
                );
            }
            return btnOthers;
        }

        
    
        public static void main(String[] args) {
            launch(args);
        }

    
}