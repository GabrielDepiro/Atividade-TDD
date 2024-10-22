package br.edu.fatec.sjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberAscOrder<T extends Number & Comparable<T>> {

    private CustomStack<T> stack;

    public NumberAscOrder(CustomStack<T> stack) {
        this.stack = stack;
    }

    public List<T> sort() throws StackEmptyException {
        List<T> sortedList = new ArrayList<>();

        // Certifique-se de que há elementos na pilha antes de chamar pop()
        while (!stack.isEmpty()) {
            sortedList.add(stack.pop());
        }

        // Ordena a lista em ordem ascendente
        Collections.sort(sortedList);

        return sortedList;
    }
}
