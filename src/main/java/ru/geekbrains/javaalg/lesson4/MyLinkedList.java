package ru.geekbrains.javaalg.lesson4;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private class Node {
        MyLinkedList.Node prev;
        T value;
        MyLinkedList.Node next;

        public Node(T value, MyLinkedList.Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(MyLinkedList.Node prev, T value, MyLinkedList.Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public MyLinkedList.Node getNext() {
            return next;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(MyLinkedList.Node next) {
            this.next = next;
        }

        public MyLinkedList.Node getPrev() {
            return prev;
        }

        public void setPrev(MyLinkedList.Node prev) {
            this.prev = prev;
        }
    }

    private MyLinkedList.Node first;
    private MyLinkedList.Node last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedList.Iter();
    }

    private class Iter implements Iterator<T>{
        MyLinkedList.Node current = new MyLinkedList.Node(null, first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.getNext();
            return current.getValue();
        }
    }

    public void insertFirst(T item) {
        MyLinkedList.Node newNode = new MyLinkedList.Node(item, first);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void insertLast(T item) {
        MyLinkedList.Node newNode = new MyLinkedList.Node(last, item, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T removeFirst() {
        T temp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    public T removeLast() {
        T temp = getLast();
        if (last.getPrev() != null) {
            last.getPrev().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrev();
        size--;
        return temp;
    }


    public final T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        return first.getValue();
    }

    public final T getLast() {
        if (isEmpty()) {
            throw new RuntimeException("list is empty");
        }
        return last.getValue();
    }

    public void insert(int index, T item) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index: " + index);
        }
        if (index == 0) {
            insertFirst(item);
            return;
        }
        if (index == size ) {
            insertLast(item);
            return;
        }

        MyLinkedList.Node current = first;
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        MyLinkedList.Node newNode = new MyLinkedList.Node(current, item, current.getNext());
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        size++;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (getFirst().equals(item)) {
            removeFirst();
            return true;
        }

        MyLinkedList.Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        size--;
        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        MyLinkedList.Node current = first;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(current.getValue()).append(", ");
            current = current.getNext();
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T item){
        if (isEmpty()){
            return -1;
        }
        MyLinkedList.Node current = first;
        int ind = 0;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
            ind++;
        }
        if (current == null){
            return -1;
        }
        return ind;
    }
}