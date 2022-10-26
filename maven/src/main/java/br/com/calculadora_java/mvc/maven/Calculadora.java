package br.com.calculadora_java.mvc.maven;


import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private Double output;
    private List<Character> expressao;
    private List<Double> numeros;
    private List<Double> memoria;

    public Calculadora() {
        this.expressao = new ArrayList<>();
        this.numeros = new ArrayList<>();
        this.memoria = new ArrayList<>();
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

    public boolean addMemoria(Double memoria) {
        try {
            this.memoria.add(memoria);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }

    public boolean removeMemoria() {
        try {
            this.memoria.remove(this.memoria.size() - 1);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }

    public boolean cleanMemoria() {
        try {
            this.memoria.clear();
            return true;
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

    public List<Double> getMemoria() {
        return this.memoria;
    }

    public Double getOutput() {
        return this.output; 
    }
}