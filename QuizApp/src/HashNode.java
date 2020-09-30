/*
 * CS 2050 - Computer Science II - Spring 2020
 * Instructor: Thyago Mota
 * Description: Prg 04 - HashNode class
 * Author:
 */

public class HashNode<K, V> {

    private K  key;
    private V  value;
    private HashNode<K, V> next;

    public HashNode() {
        key = null;
        value = null;
        next = null;
    }

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public HashNode<K, V> getNext() {
        return next;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "(" + key.toString() + ", " + value.toString() + ")";
    }
}