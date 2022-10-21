package br.com.calculadora_java.mvc.maven;

import javafx.scene.text.Text;


public class CalculadoraController {
    public static final Text textField = new Text("");
    private static final Calculadora calc = new Calculadora();

    private CalculadoraController() {
    }
    public static void computar(String expressao) {
        String search_caracter = "";
        switch (expressao) {
            case "+":
            case "-":
            case "*":
            case "/":
                processarOperadoresApertados(expressao);
                break;
            case "=":
               processarSaida();
               break;
            case "CE":
                calc.getNumeros().clear();
                calc.getExpressao().clear();
                break;
            case "DEL":
                search_caracter =  textField.getText().split(" ")[textField.getText().split(" ").length - 1];
                if (search_caracter.equals("+") || search_caracter.equals("-") || search_caracter.equals("*") || search_caracter.equals("/")) {
                    calc.getExpressao().remove(calc.getExpressao().size() - 1);
                } else if (search_caracter.matches("[0-9]+")) {
                    calc.getNumeros().remove(calc.getNumeros().size() - 1);
                }
                break;
            default:
                processarNumerosApertados(expressao);
                break;
        }
    }


    public static String processarSaida() {
        return String.valueOf(calc.getOutput());
    }

    public static boolean processarNumerosApertados(String expressao) {
        String new_expressao = textField.getText() + expressao;
        textField.setText(new_expressao);
        calc.addNumero(expressao);
        return true;
    }

    public static boolean processarOperadoresApertados(String expressao) {
        String new_expressao = textField.getText() + " " + expressao + "";
        textField.setText(new_expressao);
        calc.addExpressao((Character.valueOf(expressao.charAt(0))));
        return true;
    }

    public static void computar() {
        int i = 0;
        Double resultado = calc.getNumeros().get(i);
        for (i = 1; i <= calc.getNumeros().size(); i++) {
            if (calc.getExpressao().get(i - 1).equals("+")) {
                resultado = calc.getNumeros().get(i) + calc.getNumeros().get(i + 1);
            } else if (calc.getExpressao().get(i - 1).equals("-")) {
                resultado = calc.getNumeros().get(i) - calc.getNumeros().get(i + 1);
            } else if (calc.getExpressao().get(i - 1).equals("*")) {
                resultado = calc.getNumeros().get(i) * calc.getNumeros().get(i + 1);
            } else if (calc.getExpressao().get(i - 1).equals("/")) {
                resultado = calc.getNumeros().get(i) / calc.getNumeros().get(i + 1);
            }
        }
        calc.setOuput(resultado);
    }
}