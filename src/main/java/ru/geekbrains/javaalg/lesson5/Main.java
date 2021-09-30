package ru.geekbrains.javaalg.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Exponentiation.getDecision();

        List<Item> items = new ArrayList<>();
        Item item = new Item("Book1", 4, 2);
        Item item2 = new Item("Gold", 7, 12);
        Item item3 = new Item("Book2", 5, 2);
        Item item4 = new Item("Box1", 5, 3);
        Item item5 = new Item("Box2", 6, 7);

        items.add(item);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);

        Backpack backpack = new Backpack(14);
        backpack.getResult(items);
    }
}
