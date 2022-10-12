package controller;

import com.model.Calculadora;

public class CalculadoraController {
    private static final Calculadora model = new Calculadora();

    public static String computar(ActionEvent event) {
        String result = "";
        

        switch (event.getSource().toString()) {
            case "=":
                resultado = model.getOutput();
                break;
            case "C":
                resultado = model.setOuput(0);
                break;
        }

        return resultado;
    }


    public static String processarSaida() {
        return model.getOutput();
    }

    public static boolean procesarNumerosApertados(ActionEvent event) {
        String expressao = event.getSource().toString();
        for (char c : expressao.toCharArray()) {
                model.addNumero(c);
        }

        return true;
    }

    public static boolean procesarOperadoresApertados(ActionEvent event) {
        String expressao = event.getSource().toString();
        for (char c : expressao.toCharArray()) {
                model.addExpressao(c);
        }

        return true;
    }

    public static boolean procesarOutrosApertados(ActionEvent event) {
        String expressao = event.getSource().toString();
        for (char c : expressao.toCharArray()) {
                model.addExpressao(expressao);
        }

        return true;
    }


    public static float computar() {
        int i = 0;
        float resultado = model.getNumeros().get(i);
        for (i = 1; i <= model.getNUmeros().size(); i++) {
            if (model.getExpressao().get(i - 1).equals("+")) {
                resultado = add(
                    model
                    .getNumeros()
                    .get(i), 
                    model
                    .getNumeros()
                    .get(i + 1)
                );
            } else if (model.getExpressao().get(i - 1).equals("-")) {
                resultado = sub(
                    model
                    .getNumeros()
                    .get(i),
                    model
                    .getNumeros()
                    .get(i + 1)
                );
            } else if (model.getExpressao().get(i - 1).equals("*")) {
                resultado = mult(
                    model
                    .getNumeros()
                    .get(i), 
                    model
                    .getNumeros()
                    .get(i + 1)
                );
            } else if (model.getExpressao().get(i - 1).equals("/")) {
                resultado = div(
                    model
                    .getNumeros()
                    .get(i), model
                    .getNumeros()
                    .get(i + 1)
                    );
            }
        }

        model.setOuput(resultado);
    }
}