package ru.geekbrains.javaalg.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    int capacity;
    private List<Item> bestSet;
    private int maxValue;

    public Backpack(int capacity) {
        if (capacity < 5){
            throw new NumberFormatException("вместимость рюкзака должна быть не меньше 5 единиц");
        }
        this.capacity = capacity;
    }

    private void bestVariant(List<Item> items) {
        if (items.size() > 0) {
            checkBest(items);
        }
        for (int i = 0; i < items.size(); i++) {
            List<Item> tempList = new ArrayList<>(items);
            tempList.remove(i);
            bestVariant(tempList);
        }
    }

    private void checkBest(List<Item> items) {
        if (bestSet == null) {
            if (sumOfWeight(items) <= capacity) {
                bestSet = items;
                maxValue = sumOfValue(items);
            }
        } else {
            if (sumOfWeight(items) <= capacity && sumOfValue(items) > maxValue) {
                bestSet = items;
                maxValue = sumOfValue(items);
            }

        }
    }

    private int sumOfWeight(List<Item> items) {
        int sum = 0;
        for (Item i : items) {
            sum += i.weight;
        }
        return sum;
    }

    private int sumOfValue(List<Item> items) {
        int sum = 0;
        for (Item i : items) {
            sum += i.value;
        }
        return sum;
    }

    public void getResult(List<Item> items) {
        bestVariant(items);
        System.out.print("Для рюкзака вместимостью " + capacity + " единиц лучшей упаковкой является: ");
        for (int i = 0; i < bestSet.size(); i++) {
            System.out.print(bestSet.get(i).name);
            if (i != bestSet.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(". Ценность этой сборки " + maxValue + " единиц.");

    }

}
