package com.example;

import com.example.pessoa.PersonDAO;
import com.example.pessoa.Email;
import com.example.pessoa.Person;

// Importa as classes necessárias para os testes
import static org.junit.jupiter.api.Assertions.*; // Importa métodos de asserção do JUnit
import org.junit.jupiter.api.Test; // Importa a anotação @Test para definir métodos de teste
import java.util.Arrays; // Importa a classe Arrays para trabalhar com arrays

public class PersonDAOTest {

    private PersonDAO personDAO = new PersonDAO(); // Cria uma instância do PersonDAO para os testes

    // Teste para nome válido
    @Test
    public void testValidarNome() {
        Person person = new Person(1, "Joao Vitor", 22, Arrays.asList(new Email(1, "joaovitor@email.com")));
        // Verifica se não há erros para uma pessoa com nome válido
        assertTrue(personDAO.isValidToInclude(person).isEmpty());
    }

    // Teste para nome inválido (menos de 2 partes)
    @Test
    public void testNomeInvalidoUmaParte() {
        Person person = new Person(2, "Gabriel", 25, Arrays.asList(new Email(2, "gabriel@gmail.com")));
        // Verifica se há erro para um nome que tem apenas uma parte
        assertEquals("O nome deve ser composto por pelo menos 2 partes e apenas letras.", personDAO.isValidToInclude(person).get(0));
    }

    // Teste Nome com números
    @Test
    public void testNomeInvalidoNumeros() {
        Person person = new Person(2, "Gabriel8", 25, Arrays.asList(new Email(2, "gabriel@yahoo.com")));
        // Verifica se há erro para um nome que tem apenas uma parte
        assertEquals("O nome deve ser composto por pelo menos 2 partes e apenas letras.", personDAO.isValidToInclude(person).get(0));
    }

    // Teste sem nome
    @Test
    public void testSemNome() {
        Person person = new Person(2, null, 25, Arrays.asList(new Email(2, "gabriel@yahoo.com")));
        // Verifica se há erro para um nome que tem apenas uma parte
        assertEquals("O nome deve ser composto por pelo menos 2 partes e apenas letras.", personDAO.isValidToInclude(person).get(0));
    }

    // Teste nome vazio
    @Test
    public void testSemNome2() {
        Person person = new Person(2, "", 25, Arrays.asList(new Email(2, "gabriel@yahoo.com")));
        // Verifica se há erro para um nome que tem apenas uma parte
        assertEquals("O nome deve ser composto por pelo menos 2 partes e apenas letras.", personDAO.isValidToInclude(person).get(0));
    }

    // Teste para idade inválida (menor que 1)
    @Test
    public void testIdadeInvalidaBaixa() {
        Person person = new Person(3, "Maria Silva", 0, Arrays.asList(new Email(3, "maria@outlook.com")));
        // Verifica se há erro para uma idade que é menor que 1
        assertEquals("A idade deve estar no intervalo [1, 200].", personDAO.isValidToInclude(person).get(0));
    }

    // Teste para idade inválida (maior que 200)
    @Test
    public void testIdadeInvalidaMaior() {
        Person person = new Person(4, "Gabriel Silva", 201, Arrays.asList(new Email(4, "carlos@email.com")));
        // Verifica se há erro para uma idade que é maior que 200
        assertEquals("A idade deve estar no intervalo [1, 200].", personDAO.isValidToInclude(person).get(0));
    }

    // Teste para email inválido
    @Test
    public void testEmialInvalido() {
        Person person = new Person(5, "Emanuella Pinheiro", 30, Arrays.asList(new Email(5, "ana.gmail.com.br"))); // Email inválido
        // Verifica se há erro para um email inválido
        assertEquals("O nome do Email deve estar no formato \"___@___.\", com cada parte contendo pelo menos um caractere.", personDAO.isValidToInclude(person).get(0));
    }

    // Teste sem emails
    @Test
    public void testSemEmail() {
        Person person = new Person(6, "Joao Eduardo", 40, null); // Sem email
        // Verifica se há erro para uma pessoa sem emails
        assertEquals("O objeto Person deve ter pelo menos um objeto da classe Email associado.", personDAO.isValidToInclude(person).get(0));
    }

    // Teste email vazio
    @Test
    public void testEmailvazio() {
        Person person = new Person(5, "Ana Costa", 30, Arrays.asList(new Email(5, ""))); // Email vazio
        // Verifica se há erro para um email vazio
        assertEquals("O nome do Email deve estar no formato \"___@___.\", com cada parte contendo pelo menos um caractere.", personDAO.isValidToInclude(person).get(0));
    }
}
