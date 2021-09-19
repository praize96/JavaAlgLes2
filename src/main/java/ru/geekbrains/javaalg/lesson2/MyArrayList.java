package ru.geekbrains.javaalg.lesson2;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        checkSize();
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        checkSize();
        checkIndex(index);
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    private int index(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i] != null && list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOf(T item) {
        return index(item);
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
    }

    public boolean remove(T item) {
        int i = index(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        checkIndex(index);
        return list[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }

    public void bubbleSortOptimized() {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }

    private void checkSize() {
        if (size == list.length) {
            T[] temp = list.clone();
            list = (T[]) new Comparable[(int) (size * 1.5 + 1)];
            size = 0;
            for (int i = 0; i < temp.length; i++) {
                this.add(temp[i]);
            }
        }
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", list size: " + size);
        }
    }

    public int capacity(){
        return list.length;
    }

}
