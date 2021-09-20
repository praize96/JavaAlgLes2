package ru.geekbrains.javaalg.lesson3;

public class MyDequeue<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyDequeue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDequeue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int previousIndex(int index) {
        return (index + list.length - 1) % list.length;
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Dequeue isEmpty");
        }

        return list[begin];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("Dequeue isEmpty");
        }

        return list[end];
    }

    public void insertRight(T item) {
        if (isFull()) {
            int extendedCapacity = (int) (list.length * 1.5 + 1);
            T[] tempList = (T[]) new Object[extendedCapacity];
            list = tempList;
            if (begin > end){
                System.arraycopy(list, begin, tempList, 0, list.length - begin);
                System.arraycopy(list, 0, tempList, list.length - begin + 1, end);
            } else {
                System.arraycopy(list, begin, tempList, 0, end);
            }
            list = tempList;
            begin = 0;
            end = list.length;
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertLeft(T item) {
        if (isFull()) {
            int extendedCapacity = (int) (list.length * 1.5 + 1);
            T[] tempList = (T[]) new Object[extendedCapacity];
            list = tempList;
            if (begin > end){
                System.arraycopy(list, begin, tempList, 0, list.length - begin);
                System.arraycopy(list, 0, tempList, list.length - begin + 1, end);
            } else {
                System.arraycopy(list, begin, tempList, 0, end);
            }
            list = tempList;
            begin = 0;
            end = list.length;
        }
        size++;
        list[begin] = item;
        begin = previousIndex(begin);
    }

    public T removeLeft() {
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeRight() {
        T temp = peekRight();
        size--;
        list[end] = null;
        begin = previousIndex(end);
        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }
}
