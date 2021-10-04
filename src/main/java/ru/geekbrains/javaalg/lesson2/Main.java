package ru.geekbrains.javaalg.lesson2;

import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        MyArrayList myArrayListForBubbleSort = new MyArrayList(100000);
        for (int i = 0; i < myArrayListForBubbleSort.capacity(); i++) {
            myArrayListForBubbleSort.add(random.nextInt());
        }
        long startTime1 = System.currentTimeMillis();
        myArrayListForBubbleSort.bubbleSortOptimized();
        long finishTime1 = System.currentTimeMillis();
        System.out.println("Время выполнения пузырьковой сортировки: " + (finishTime1 - startTime1) + " мс");

        MyArrayList myArrayListForSelectionSort = new MyArrayList(100000);
        for (int i = 0; i < myArrayListForSelectionSort.capacity(); i++) {
            myArrayListForSelectionSort.add(random.nextInt());
        }
        long startTime2 = System.currentTimeMillis();
        myArrayListForSelectionSort.selectionSort();
        long finishTime2 = System.currentTimeMillis();
        System.out.println("Время выполнения сортировки выбором: " + (finishTime2 - startTime2) + " мс");

        MyArrayList myArrayListForInsertionSort = new MyArrayList(100000);
        for (int i = 0; i < myArrayListForInsertionSort.capacity(); i++) {
            myArrayListForInsertionSort.add(random.nextInt());
        }
        long startTime3 = System.currentTimeMillis();
        myArrayListForInsertionSort.insertionSort();
        long finishTime3 = System.currentTimeMillis();
        System.out.println("Время выполнения сортировки вставкой: " + (finishTime3 - startTime3) + " мс");
    }
}
