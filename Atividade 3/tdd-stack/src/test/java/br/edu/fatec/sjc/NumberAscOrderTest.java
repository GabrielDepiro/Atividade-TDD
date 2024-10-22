package br.edu.fatec.sjc;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class NumberAscOrderTest {

    @Test
    public void testSortNumbersInCustomStack() throws StackEmptyException {
        // Cria o mock para a pilha
        CustomStack<Integer> mockStack = mock(CustomStack.class);

        // Define o comportamento do mock
        when(mockStack.isEmpty()).thenReturn(false, false, false, false, false, false, true);
        when(mockStack.pop()).thenReturn(150, 140, 130, 70, 50, 30); // Números em ordem inversa

        // Instancia a classe NumberAscOrder com o tipo Integer
        NumberAscOrder<Integer> numberSorter = new NumberAscOrder<>(mockStack);

        // Executa o método que ordena os números
        List<Integer> sortedList = numberSorter.sort();

        // Verifica se o tamanho da lista está correto
        assertEquals(6, sortedList.size());

        // Verifica se os números foram ordenados corretamente
        assertEquals(30, sortedList.get(0));
        assertEquals(50, sortedList.get(1));
        assertEquals(70, sortedList.get(2));
        assertEquals(130, sortedList.get(3));
        assertEquals(140, sortedList.get(4));
    }

    @Test
    public void testSortWithNoElementsInStack() throws StackEmptyException {
        // Mock da pilha
        CustomStack<Integer> mockStack = mock(CustomStack.class);

        // Define que a pilha estará vazia
        when(mockStack.isEmpty()).thenReturn(true);

        // Instancia a classe NumberAscOrder com o tipo Integer
        NumberAscOrder<Integer> numberSorter = new NumberAscOrder<>(mockStack);

        // Chama o método de ordenação
        List<Integer> sortedList = numberSorter.sort();

        // Verifica se a lista está vazia
        assertTrue(sortedList.isEmpty());
    }
}
