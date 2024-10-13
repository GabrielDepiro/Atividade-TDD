package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.funcionario.CalculadoraSalario;
import com.example.funcionario.Cargo;
import com.example.funcionario.Funcionario;

// A classe de teste verifica se a calculadora de salários está funcionando corretamente
public class CalculadoraSalarioTest {
    
    // Teste salário líquido de um desenvolvedor com salário maior que 3000
    @Test
    public void testDesenvolvedorSalarioAcimaDe3000() {
        Funcionario desenvolvedor = new Funcionario("João", "joao@example.com", 3500.0, Cargo.DESENVOLVEDOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
        assertEquals(2800.0, salarioLiquido, 2850.0); // Verifica se o resultado é 2800 (desconto de 20%)
    }

    // Teste salário líquido de um desenvolvedor com salário igual a 3000
    @Test
    public void testDesenvolvedorSalarioIgual3000() {
        Funcionario desenvolvedor = new Funcionario("João", "joao@example.com", 3000.0, Cargo.DESENVOLVEDOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
        assertEquals(2400.0, salarioLiquido); // Verifica se o resultado é 2400 (desconto de 20%)
    }
    

    // Teste salário líquido de um desenvolvedor com salário abaixo de 3000
    @Test
    public void testDesenvolvedorSalarioAbaixoDe3000() {
        Funcionario desenvolvedor = new Funcionario("Maria", "maria@example.com", 2500.0, Cargo.DESENVOLVEDOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
        assertEquals(2250.0, salarioLiquido); // Verifica se o resultado é 2250 (desconto de 10%)
    }

    // Teste salário líquido de um DBA com salário acima de 2000
    @Test
    public void testDBASalarioAcimaDe2000() {
        Funcionario dba = new Funcionario("Pedro", "pedro@example.com", 2500.0, Cargo.DBA);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
        assertEquals(1875.0, salarioLiquido); // Verifica se o resultado é 1875 (desconto de 25%)
    }

    // Teste salário líquido de um DBA com salário igual a 2000
    @Test
    public void testDBASalarioIgual2000() {
        Funcionario dba = new Funcionario("Pedro", "pedro@example.com", 2000.0, Cargo.DBA);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
        assertEquals(1500.0, salarioLiquido); // Verifica se o resultado é 1500 (desconto de 25%)
    }

    // Teste salário líquido de um Testador com salário igual a 2000
    @Test
    public void testTestadorSalarioIgual2000() {
        Funcionario testador = new Funcionario("Pedro", "pedro@example.com", 2000.0, Cargo.DBA);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(testador);
        assertEquals(1500.0, salarioLiquido); // Verifica se o resultado é 1500 (desconto de 25%)
    }

    // Teste salário líquido de um DBA com salário abaixo de 2000
    @Test
    public void testDBASalarioAbaixoDe2000() {
        Funcionario dba = new Funcionario("Ana", "ana@example.com", 1800.0, Cargo.DBA);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
        assertEquals(1530.0, salarioLiquido); // Verifica se o resultado é 1530 (desconto de 15%)
    }

    // Teste salário líquido de um testador com salário abaixo de 2000
    @Test
    public void testTestadorSalarioAbaixoDe2000() {
        Funcionario testador = new Funcionario("Ana", "ana@example.com", 1800.0, Cargo.TESTADOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(testador);
        assertEquals(1530.0, salarioLiquido); // Verifica se o resultado é 1530 (desconto de 15%)
    }

    // Teste salário líquido de um gerente com salário acima de 5000
    @Test
    public void testGerenteSalarioAcimaDe5000() {
        Funcionario gerente = new Funcionario("Carlos", "carlos@example.com", 6000.0, Cargo.GERENTE);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
        assertEquals(4200.0, salarioLiquido); // Verifica se o resultado é 4200 (desconto de 30%)
    }

    // Teste salário líquido de um gerente com salário igual a 5000
    @Test
    public void testGerenteSalarioigual5000() {
        Funcionario gerente = new Funcionario("Carlos", "carlos@example.com", 5000.0, Cargo.GERENTE);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
        assertEquals(3500.0, salarioLiquido); // Verifica se o resultado é 3500 (desconto de 30%)
    }

    // Teste salário líquido de um gerente com salário abaixo de 5000
    @Test
    public void testGerenteSalarioAbaixoDe5000() {
        Funcionario gerente = new Funcionario("Julia", "julia@example.com", 4500.0, Cargo.GERENTE);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
        assertEquals(3600.0, salarioLiquido); // Verifica se o resultado é 3600 (desconto de 20%)
    }
}
