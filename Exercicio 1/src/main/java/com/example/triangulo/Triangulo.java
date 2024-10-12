package com.example.triangulo;

public class Triangulo {
    private int lado1;
    private int lado2;
    private int lado3;

    public Triangulo(int lado1, int lado2, int lado3){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public String tipoTriangulo(){
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            return "Valor inválido";
        }

        if ((lado1 + lado2 <= lado3) || (lado1 + lado3 <= lado2) || (lado2 + lado3 <= lado1)){
            return "Não é um triângulo";
        } else if (lado1 == lado2 && lado2 == lado3){
            return "Equilátero";
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3){
            return "Isósceles";
        } else{
            return "Escaleno";
        }
    }
}
