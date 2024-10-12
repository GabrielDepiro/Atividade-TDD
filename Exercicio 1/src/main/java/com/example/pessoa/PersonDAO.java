package com.example.pessoa;

import java.util.ArrayList; // Importa a classe ArrayList para manipular listas
import java.util.List; // Importa a interface List

public class PersonDAO {
    // Lista para armazenar as pessoas
    private List<Person> persons = new ArrayList<>();
    
    // Método para salvar uma pessoa
    public void save(Person p) {
            //Adiciona a pessoa á lista
            persons.add(p);
            System.out.println("Pessoa salva: " + p.getName());

    }

    // Método para verificar se a pessoa é válida para inclusão
    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>(); // Lista para armazenar erros de validação

        // Validação do nome
        if (p.getName() == null || p.getName().trim().isEmpty() || !isValidName(p.getName())) {
            // Se o nome for nulo, vazio ou inválido, adiciona uma mensagem de erro
            errors.add("O nome deve ser composto por pelo menos 2 partes e apenas letras.");
        }

        // Validação da idade
        if (p.getAge() < 1 || p.getAge() > 200) {
            // Se a idade estiver fora do intervalo permitido, adiciona uma mensagem de erro
            errors.add("A idade deve estar no intervalo [1, 200].");
        }

        // Validação dos emails
        if (p.getEmails() == null || p.getEmails().isEmpty()) {
            // Se a lista de emails for nula ou vazia, adiciona uma mensagem de erro
            errors.add("O objeto Person deve ter pelo menos um objeto da classe Email associado.");
        } else {
            // Verifica cada email na lista
            for (Email email : p.getEmails()) {
                // Se o email for inválido, adiciona uma mensagem de erro
                if (!isValidEmail(email.getName())) {
                    errors.add("O nome do Email deve estar no formato \"___@___.\", com cada parte contendo pelo menos um caractere.");
                }
            }
        }

        return errors; // Retorna a lista de erros
    }

    // Método para validar se o nome tem pelo menos duas partes e é composto apenas por letras
    private boolean isValidName(String name) {
        String[] parts = name.trim().split("\\s+"); // Divide o nome em partes
        if (parts.length < 2) {
            // Se o nome tiver menos de 2 partes, retorna falso
            return false;
        }
        // Verifica se cada parte do nome contém apenas letras
        for (String part : parts) {
            if (!part.matches("[A-Za-z]+")) {
                return false; // Se alguma parte não for apenas letras, retorna falso
            }
        }
        return true; // Retorna verdadeiro se todas as partes forem válidas
    }

    // Método para validar o formato do email
    private boolean isValidEmail(String email) {
        // Verifica se o email está no formato correto
        return email.matches(".+@.+\\..+");
    }
}
