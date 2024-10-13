package com.example.funcionario;

// A classe CalculadoraDeSalario faz o cálculo do salário líquido do funcionário com base no cargo e salário-base
public class CalculadoraSalario {

    // Método que calcula o salário líquido de um funcionário
    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salario = funcionario.getSalario(); // Obtém o salário-base do funcionário
        Cargo cargo = funcionario.getCargo(); // Obtém o cargo do funcionário

        // Verifica o cargo do funcionário e aplica as regras de desconto de acordo com o cargo
        switch (cargo) {
            case DESENVOLVEDOR:
                if (salario >= 3000) {
                    return salario * 0.8; // Aplica desconto de 20% se o salário for maior ou igual a 3000
                } else {
                    return salario * 0.9; // Aplica desconto de 10% se o salário for menor que 3000
                }
            case DBA:
            case TESTADOR:
                if (salario >= 2000) {
                    return salario * 0.75; // Aplica desconto de 25% se o salário for maior ou igual a 2000
                } else {
                    return salario * 0.85; // Aplica desconto de 15% se o salário for menor que 2000
                }
            case GERENTE:
                if (salario >= 5000) {
                    return salario * 0.7; // Aplica desconto de 30% se o salário for maior ou igual a 5000
                } else {
                    return salario * 0.8; // Aplica desconto de 20% se o salário for menor que 5000
                }
            default:
                return salario; // Retorna o salário-base se o cargo não for reconhecido
        }
    }
}

