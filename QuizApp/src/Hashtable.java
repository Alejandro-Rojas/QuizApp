/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg 04 - HashNode class
 * Author:
 */

import java.util.Iterator;

public class Hashtable<K,V> implements Iterable<V> {

    private static final int SIZE = 17;
    private HashNode<K, V> table[];

    public Hashtable() {
        table = new HashNode[SIZE];
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % SIZE;
        HashNode<K, V> newHashNode = new HashNode(key, value);
        if (table[index] == null)
            table[index] = newHashNode;
        else {
            HashNode<K, V> current = table[index];
            while (!current.getKey().equals(key) &&
                    current.getNext() != null)
                current = current.getNext();
            if (current.getKey().equals(key))
                current.setValue(value);
            else
                current.setNext(newHashNode);
        }
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        HashNode<K, V> current = table[index];
        while (current != null)
            if (current.getKey().equals(key))
                return current.getValue();
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < SIZE; i++) {
            if (table[i] != null) {
                str += "[" + i + "]: ";
                HashNode<K, V> current = table[i];
                while (current != null) {
                    str += current.toString() + " ";
                    current = current.getNext();
                }
                str += "\n";
            }
        }
        return str;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {

            int index = 0;
            HashNode<K, V> current = table[index];

            @Override
            public boolean hasNext() {
                while (true) {
                    if (index == SIZE)
                        break;
                    if (current == null) {
                        index++;
                        if (index < SIZE)
                            current = table[index];
                    }
                    else
                        return true;
                }
                return false;
            }

            @Override
            public V next() {
                if (hasNext()) {
                    V v = current.getValue();
                    current = current.getNext();
                    while (true) {
                        if (index == SIZE)
                            break;
                        if (current == null) {
                            index++;
                            if (index < SIZE)
                                current = table[index];
                        }
                        else
                            break;
                    }
                    return v;
                }
                return null;
            }
        };
    }
}