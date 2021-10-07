package ru.geekbrains.javaalg.lesson4;

public class LinkedQueue<T> {
    private MyLinkedList<T> list;

    public LinkedQueue() {
        list = new MyLinkedList<>();
    }

    public void insert(T item) {
        list.insertFirst(item);
    }

    public T remove() {
        return list.removeLast();
    }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
