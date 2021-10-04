package ru.geekbrains.javaalg.lesson6;

import java.util.Random;

public class Forest {
    int capacity;
    int treeHeight;

    public Forest(int capacity, int treeHeight) {
        this.capacity = capacity;
        this.treeHeight = treeHeight;
    }

    public void getforest() {
        int counterOfBalancedTrees = 0;
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            MyTreeMap<Integer, Integer> threeMap = new MyTreeMap<>();
            while (threeMap.height() != treeHeight) {
                threeMap.put((-100 + random.nextInt()), random.nextInt(1000));
            }
            if (threeMap.isBalanced()) {
                counterOfBalancedTrees++;
            }
        }
        analyticsOfBalancedTrees(capacity, counterOfBalancedTrees);
    }

    private void analyticsOfBalancedTrees(int capacity, int counterOfBalancedTrees) {
        double percent = ((double) (capacity - counterOfBalancedTrees) * 100) / capacity;
        System.out.printf("При %d деревьев, процент несбалансированных — %f", capacity, percent);
    }
}
