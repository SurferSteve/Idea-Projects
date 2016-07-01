package dz;

import java.util.Collection;
import java.util.List;

/**
 * Created by Steve on 23.05.2016.
 */
public class GenericStack<E extends List<E>> implements Stack<E> {
    E elements;

    @Override
    public void push(E element) throws StackException {
        if (isFull()) {
            throw new StackException("Stack is Full!");
        } else {
            elements.add(element);
        }
    }

    @Override
    public E pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is Empty!");
        } else {
            int lastNumber = elements.size() - 1;
            E element = elements.get(lastNumber);
            elements.remove(lastNumber);
            return element;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        } else {
            int lastNumber = elements.size() - 1;
            E element = elements.get(lastNumber);
            return element;
        }
    }

    @Override
    public int getSize() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        if (elements.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if (elements.size() == 10) {
            return true;
        }
        return false;
    }

    @Override
    public void pushAll(Collection<? extends E> src) throws StackException {
//        elements.add(src); // impossible
        for (E e : src) {
            push(e);
        }
    }

    @Override
    public void popAll(Collection<? super E> dst) throws StackException {
        while(!isEmpty()) {
            dst.add(pop());
        }
    }
}
