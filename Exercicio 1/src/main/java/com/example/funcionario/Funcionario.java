package com.example.funcionario;

// A classe Funcionario representa um funcionário da empresa
public class Funcionario {
    // Atributos do funcionário: nome, email, salário e cargo
    private String nome;
    private String email;
    private double salario;
    private Cargo cargo;
    
    // Construtor da classe Funcionario
    public Funcionario(String nome, String email, double salario, Cargo cargo) {
        this.nome = nome; // Define o nome do funcionário
        this.email = email; // Define o email do funcionário
        this.salario = salario; // Define o salário-base do funcionário
        this.cargo = cargo; // Define o cargo do funcionário
    }
    // Método para obter o nome do funcionário
    public String getNome() {
        return nome;
    }

    // Método para obter o email do funcionário
    public String getEmail() {
        return email;
    }

    // Método para obter o salário-base do funcionário
    public double getSalario() {
        return salario;
    }

    // Método para obter o cargo do funcionário
    public Cargo getCargo() {
        return cargo;
    }
}
