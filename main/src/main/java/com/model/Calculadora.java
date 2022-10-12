package model;

import java.util.List;
import java.util.ArrayList;

public class Calculadora {
    private double output;
    private List<?> expressao;
    private List<?> numeros;

    Calculadora() {
        this.expressao = new ArrayList<Integer>();
        this.numeros = new ArrayList<Integer>();
    }

    public boolean setOuput(double output) {
        try {
            if(output != null) {
                this.output = output;
                return true;
            }
        } catch (Exception e) {
            return false;
        }        
    }

    public boolean addExpressao(char expressao) {
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
            if (numero.matches("[0-9]+")) {
                this.numeros.add(Integer.parseInt(numero));
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } 
    }

    public List<?> getExpressao() {
        try {
            return this.expressao;
        } catch (Exception e) {
            return null;
        } 
    }

    public List<?> getNumeros() {
        try {
            return this.numeros;
        } catch (Exception e) {
            return null;
        } 
    }

    public double getOutput() {
        try {
            return this.output;
        } catch (Exception e) {
            return null;
        } 
    }

}