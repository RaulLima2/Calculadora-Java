package br.com.calculadora_java.mvc.maven;


import java.util.List;
import java.util.ArrayList;

public class Calculadora {
    private Double output;
    private List<Character> expressao;
    private List<Double> numeros;

    public Calculadora() {
        this.expressao = new ArrayList<>();
        this.numeros = new ArrayList<>();
        this.output = 0.0;
    }

    public boolean setOuput(Double output) {
            this.output = output;
            return true;
    }

    public boolean addExpressao(Character expressao) {
        try {
            if (expressao == '+' || expressao == '-' || expressao == '*' || expressao == '/') {
                this.expressao.add(expressao);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } 
    }

    public boolean addNumero(String numero) {
        try {
            if (numero.matches("[+-]?(\\d+([.]\\d*)?|[.]\\d+)")) {
                this.numeros.add(Double.parseDouble(numero));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } 
    }

    public boolean removeExpressao() {
        try {
            this.expressao.remove(this.expressao.size() - 1);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }

    public boolean removeNumero() {
        try {
            this.numeros.remove(this.numeros.size() - 1);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }

    public List<Character> getExpressao() {
        return this.expressao;
    }

    public List<Double> getNumeros() {
        return this.numeros; 
    }

    public Double getOutput() {
        return this.output; 
    }
}