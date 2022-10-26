package br.com.calculadora_java.mvc.maven;

import javafx.scene.text.Text;


public class CalculadoraController {
    public static final Text textField = new Text("");
    private static final Calculadora calc = new Calculadora();

    private CalculadoraController() {
    }
    public static void computar(String expressao) {
        String searchCaracter = "";
        switch (expressao) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
               processarOperadoresApertados(expressao);
               break;
            case "=":
                calcular();
                processarSaida();
                textField.setText(processarSaida());
                break;
            case "CE":
                calc.getNumeros().clear();
                calc.getExpressao().clear();
                textField.setText("");
                break;
            case "C":
                searchCaracter =  textField.getText().split(" ")[textField.getText().split(" ").length - 1];
                if (searchCaracter.equals("+") || searchCaracter.equals("-") || searchCaracter.equals("*") || searchCaracter.equals("/")) {
                    calc.getExpressao().remove(calc.getExpressao().size() - 1);
                } else if (searchCaracter.matches("\\d+")) {
                    calc.getNumeros().remove(calc.getNumeros().size() - 1);
                }
                break;
            case "M+":
                Double memo = calc.getNumeros().get(calc.getNumeros().size() - 1);
                calc.addMemoria(memo);
                break;
            case "M-":
                calc.removeMemoria();
                break;
            case "MR":
                calc.getMemoria().stream().reduce((a, b) -> a + b).ifPresent(calc::setOuput);
                break;
            case "MC":
                calc.getMemoria().clear();
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
        String newExpressao = textField.getText() + expressao;
        textField.setText(newExpressao);
        calc.addNumero(expressao);
        return true;
    }

    public static boolean processarOperadoresApertados(String expressao) {
        String newExpressao = textField.getText() + " " + expressao + " ";
        textField.setText(newExpressao);
        calc.addExpressao((Character.valueOf(expressao.charAt(0))));
        return true;
    }

    public static void calcular() {
        int i = 0;
        int j = 0;
        Double resultado = 0.0;
        
        for (i = 0 ; i < calc.getNumeros().size() - 1; i++) {
            if (resultado == 0) {
                Double x = calc.getNumeros().get(i);
                Double y  = calc.getNumeros().get(i + 1);
                resultado = executarOperacao(x, y, calc.getExpressao().get(i));
            } else {                
                Double y = calc.getNumeros().get(i);
                resultado = executarOperacao(resultado, y, calc.getExpressao().get(j));
                j++;
            }
        }
        calc.setOuput(resultado);
    }

    private static Double executarOperacao(Double x, Double y, Character operador) {
        switch (operador) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '^':
                return Math.pow(x, y);
            default:
                return 0.0;
        }
    }
}