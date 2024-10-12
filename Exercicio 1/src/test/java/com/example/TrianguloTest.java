package com.example;

// Importa as classes necessárias para os testes
import static org.junit.jupiter.api.Assertions.*; // Importa métodos de asserção do JUnit
import org.junit.jupiter.api.Test; // Importa a anotação @Test para definir métodos de teste

import com.example.triangulo.Triangulo;

public class TrianguloTest {
    /* Na classe TrianguloTest, cut é uma instância da classe Triangulo que você está testando.
     O termo "cut" geralmente é uma abreviação de "class under test" (classe sob teste),
     usada em testes unitários para indicar qual classe ou objeto está sendo testado em um determinado método de teste.*/
    // Declara uma instância da classe Triangulo que será testada
    private Triangulo cut;
    
    // 1. Teste para um triângulo escaleno válido
    @Test
    public void testEscaleno() {
        // Cria uma nova instância de Triangulo com lados 10, 11 e 12
        cut = new Triangulo(10, 11, 12);
        // Verifica se o método tipoTriangulo() retorna "Escaleno"
        assertEquals("Escaleno", cut.tipoTriangulo());
    }

    // 2. Teste para um triângulo isósceles válido
    @Test
    public void testIsosceles() {
        // Cria uma nova instância de Triangulo com lados 4, 4 e 5
        cut = new Triangulo(4, 4, 5);
        // Verifica se o método tipoTriangulo() retorna "Isósceles"
        assertEquals("Isósceles", cut.tipoTriangulo());
    }

    // 3. Teste para um triângulo equilátero válido
    @Test
    public void testEquilatero() {
        // Cria uma nova instância de Triangulo com lados 3, 3 e 3
        cut = new Triangulo(3, 3, 3);
        // Verifica se o método tipoTriangulo() retorna "Equilátero"
        assertEquals("Equilátero", cut.tipoTriangulo());
    }
    
    // 4. Teste para um triângulo isósceles válido com permutações dos mesmos valores
    @Test
    public void testIsosceles2() {
        // Cria três instâncias diferentes de Triangulo com lados 5, 5 e 3 em diferentes ordens
        cut = new Triangulo(5, 5, 3);
        cut = new Triangulo(5, 3, 5);
        cut = new Triangulo(3, 5, 5);
        
        // Verifica se o método tipoTriangulo() retorna "Isósceles" para cada permutação
        assertEquals("Isósceles", cut.tipoTriangulo());
        assertEquals("Isósceles", cut.tipoTriangulo());
        assertEquals("Isósceles", cut.tipoTriangulo());
    }

    // 5. Teste com um valor zero
    @Test
    public void testValorZero() {
        // Cria três instâncias diferentes de Triangulo com um lado igual a 0
        cut = new Triangulo(0, 4, 5);
        cut = new Triangulo(4, 0, 5);
        cut = new Triangulo(5, 4, 0);

        // Verifica se o método tipoTriangulo() retorna "Valor inválido" para cada caso
        assertEquals("Valor inválido", cut.tipoTriangulo());
        assertEquals("Valor inválido", cut.tipoTriangulo());
        assertEquals("Valor inválido", cut.tipoTriangulo());
    }

    // 6. Teste com um valor negativo
    @Test
    public void testValorNegativo() {
        // Cria uma instância de Triangulo com um lado negativo
        cut = new Triangulo(-1, 4, 5);
        // Verifica se o método tipoTriangulo() retorna "Valor inválido"
        assertEquals("Valor inválido", cut.tipoTriangulo());
    }

    // Teste com um valor negativo em outra posição
    @Test
    public void testValorNegativo2() {
        cut = new Triangulo(4, -1, 5);
        assertEquals("Valor inválido", cut.tipoTriangulo());
    }

    // Teste com um valor negativo em outra posição
    @Test
    public void testValorNegativo3() {
        cut = new Triangulo(5, 4, -1);
        assertEquals("Valor inválido", cut.tipoTriangulo());
    }

    // 7. Teste em que a soma de dois lados é igual ao terceiro lado
    @Test
    public void testSomaDoisLadosIgualAoTerceiro() {
        cut = new Triangulo(2, 3, 5);
        // Verifica se o método tipoTriangulo() retorna "Não é um triângulo"
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
    }

    // 8. Teste para cada permutação do caso acima
    @Test
    public void testSomaDoisLadosIgualAoTerceiroPermutacoes() {
        // Cria três instâncias de Triangulo com as permutações dos lados
        cut = new Triangulo(5, 2, 3);
        cut = new Triangulo(3, 5, 2);
        cut = new Triangulo(2, 3, 5);
        // Verifica se o método tipoTriangulo() retorna "Não é um triângulo" para cada permutação
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
    }

    // 9. Teste em que a soma de dois lados é menor que o terceiro lado
    @Test
    public void testTrianguloInvalido() {
        // Cria três instâncias de Triangulo com a soma de dois lados menor que o terceiro
        cut= new Triangulo(1, 2, 4);
        cut= new Triangulo(1, 4, 2);
        cut= new Triangulo(4, 1, 2);
        // Verifica se o método tipoTriangulo() retorna "Não é um triângulo" para cada caso
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
    }

    // 10. Teste para cada permutação do caso acima
    @Test
    public void testSomaDoisLadosMenorQueTerceiroPermutacoes() {
        // Cria duas instâncias de Triangulo com a soma de dois lados menor que o terceiro
        cut = new Triangulo(4, 1, 2);
        cut = new Triangulo(2, 4, 1);
        // Verifica se o método tipoTriangulo() retorna "Não é um triângulo" para cada permutação
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
        assertEquals("Não é um triângulo", cut.tipoTriangulo());
    }

    // 11. Teste em que todos os lados são iguais a zero
    @Test
    public void testValoresIguaisAZero() {
        // Cria uma instância de Triangulo com todos os lados iguais a 0
        cut = new Triangulo(0, 0, 0);
        // Verifica se o método tipoTriangulo() retorna "Valor inválido"
        assertEquals("Valor inválido", cut.tipoTriangulo());
    }
}
