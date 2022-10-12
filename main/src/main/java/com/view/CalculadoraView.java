package view;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import com.controller.CalculadoraService;


public class CalculadoraView extends Application {
        private static final CalculadoraService calculadoraService = new CalculadoraService();

        @Override
        public void start(Stage stage) throws IOException {
            String btnStringNumbers[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String btnStringOperators[] = {"+", "-", "*", "/"};
            String btnStringOthers[] = {"C", "=", ".", "del"};
            Button btnNumbers = new Button[10];
            Button btnOperators = new Button[5];
            Button btnOthers = new Button[5];

            GridPane gridPane = new GridPane();
            BorderPane pane = new BorderPane();
            
            //Creating a buttons for numbers and Operators
            btnNumbers = createGridButtonNumbers(10, btnStringNumbers, btnNumbers);
            btnOthers = createGridButtonOthersOperation(5, btnStringOthers, btnOthers);
            btnOperators = createGridButtonOperation(5, btnStringOperators, btnOperators);
            
            //Creating a text field
            pane = createBorderPaneCalculadora();
            gridPane = createGridPaneCalculadora(btnNumbers, btnOperators, btnOthers);

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
            
            Hbox hbox = new HBox();
            hbox.getChildren().addAll();

            borderPaneTopBottom.setRight(textField);
            borderPaneTopBottom.setBotton(hbox);
            borderPane.setTop(borderPaneTopBottom);
            return borderPane;
        }

        private static GridPane createGridPaneCalculadora(Button[] btnNumbers, Button[] btnOperators, Button[] btnOthers) {
            int i = 0;
            int j = 0;
            int count = 0;

            gridPane.add(bntOthers[0], 0, 0);
            gridPane.add(bntOthers[1], 1, 0);
            
            for(i = 0; i < 5; i++) {
                gdpane.add(btnOperators[i], 3, i + 1   );
            }
            
            for(i = 0, count = 7; i < 10; i++, count = count - 3) {
                for(j = 0; j < 3; j++){
                    gdpane.add(btnNumbers[i], 4, i + 1);
                }
            }
            
            gridPane.add(bntOthers[2], 0, 5);
            gridPane.add(bntOthers[3], 2, 5);

            return gridPane;
        }
        
        private static Button[] createGridButtonNumbers(nt length, String[] btnString, Button[] bnt){
            for (int i = 0; i < length; i++) {
                bnt[i] = new Button(btnString[i]);
                bnt[i].setPrefSize(50, 50);
                bnt[i].setStyle("-fx-background-color: #A9A9A9; -fx-text-fill: #FFFFFF;");
            }

            return btn;
        }

        private static Button[] createGridButtonOperation(int length, String[] btnString, Button[] bnt){
            for (int i = 0; i < length; i++) {
                bnt[i] = new Button(btnString[i]);
                bnt[i].setPrefSize(50, 50);
                bnt[i].setStyle("-fx-background-color: #A9A9A9; -fx-text-fill: #FFFFFF;");
            }
            return bnt;
        }

        private static Button[] createGridButtonOthersOperation(int length, String[] btnStringOthers, Button[] bntOthers){
            for (int i = 0; i < length; i++) {
                btnOthers[i] = new Button(btnStringOthers[i]);
                btnOthers[i].setPrefSize(50, 50);
                btnOthers[i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        calculardoraService.processarOutrosApertados(event);
                    }
                });
            }
            return bnt;
        }

        
    
        public static void main(String[] args) {
            launch();
        }

    
}