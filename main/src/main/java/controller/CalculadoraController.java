package controller;

import javafx.scene.text.Text;
import model.Calculadora;

public class CalculadoraController {
    public static final Text textField = new Text("");
    private static final Calculadora model = new Calculadora();

    public static void computar(String expressao) {
        String output = "";
        String search_caracter = "";
        switch (expressao) {
            case "+":
            case "-":
            case "*":
            case "/":
                processarOperadoresApertados(expressao);
                break;
            case "=":
               output = processarSaida();
               break;
            case "CE":
                output = "";
                model.getNumeros().clear();
                model.getExpressao().clear();
                break;
            case "DEL":
                output = textField.getText().substring(0, textField.getText().length() - 1);
                search_caracter =  textField.getText().split(" ")[textField.getText().split(" ").length - 1];
                if (search_caracter.equals("+") || search_caracter.equals("-") || search_caracter.equals("*") || search_caracter.equals("/")) {
                    model.getExpressao().remove(model.getExpressao().size() - 1);
                } else if (search_caracter.matches("[0-9]+")) {
                    model.getNumeros().remove(model.getNumeros().size() - 1);
                }
                break;
            default:
                processarNumerosApertados(expressao);
                break;
        }
    }


    public static String processarSaida() {
        return String.valueOf(model.getOutput());
    }

    public static boolean processarNumerosApertados(String expressao) {
        String new_expressao = textField.getText() + expressao;
        textField.setText(new_expressao);
        model.addNumero(expressao);
        return true;
    }

    public static boolean processarOperadoresApertados(String expressao) {
        String new_expressao = textField.getText() + " " + expressao + "";
        textField.setText(new_expressao);
        model.addExpressao((Character.valueOf(expressao.charAt(0))));
        return true;
    }

    public static void computar() {
        int i = 0;
        Double resultado = model.getNumeros().get(i);
        for (i = 1; i <= model.getNumeros().size(); i++) {
            if (model.getExpressao().get(i - 1).equals("+")) {
                resultado = model.getNumeros().get(i) + model.getNumeros().get(i + 1);
            } else if (model.getExpressao().get(i - 1).equals("-")) {
                resultado = model.getNumeros().get(i) - model.getNumeros().get(i + 1);
            } else if (model.getExpressao().get(i - 1).equals("*")) {
                resultado = model.getNumeros().get(i) * model.getNumeros().get(i + 1);
            } else if (model.getExpressao().get(i - 1).equals("/")) {
                resultado = model.getNumeros().get(i) / model.getNumeros().get(i + 1);
            }
        }
        model.setOuput(resultado);
    }
}