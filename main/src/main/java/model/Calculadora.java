package model;

import java.lang.Double;
import java.lang.Character;
import java.util.List;
import java.util.ArrayList;

public class Calculadora {
    private Double output;
    private List<Character> expressao;
    private List<Double> numeros;

    public Calculadora() {
        this.expressao = new ArrayList<Character>();
        this.numeros = new ArrayList<Double>();
        this.output = 0.0;
    }

    public boolean setOuput(Double output) {
        try {
                this.output = output;
                return true;
        } catch (Exception e) {
            return false;
        }        
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
            if (numero.matches("[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)")) {
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
        try {
            return this.expressao;
        } catch (Exception e) {
            return null;
        } 
    }

    public List<Double> getNumeros() {
        try {
            return this.numeros;
        } catch (Exception e) {
            return null;
        } 
    }

    public Double getOutput() {
        try {
            return this.output;
        } catch (Exception e) {
            return 0.0;
        } 
    }
}