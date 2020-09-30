/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg 04 - LinkedList class
 * Author:
 */

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    // add tail
    public void append(T data) {
        Node<T> newNode = new Node(data);
        if (isEmpty())
            head = newNode;
        else {
            Node<T> current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(newNode);
        }
    }

    @Override
    public String toString() {
        String out = "";
        Node<T> current = head;
        while (current != null) {
            out += current.toString() + " ";
            current = current.getNext();
        }
        return out;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    public T get(int index) {
        if (index < 0 || index >= size())
            return null;
        int i = 0;
        Node<T> current = head;
        while (i < index) {
            i++;
            current = current.getNext();
        }
        return current.getData();
    }

    // TODO: finish the implementation of the method
    @Override
    public Iterator<T> iterator() {
            return new Iterator<T>() {

                Node<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    if (current != null) {
                        T data = current.getData();
                        current = current.getNext();
                        return data;
                    }
                    return null;
                }
            };
        }
 }
