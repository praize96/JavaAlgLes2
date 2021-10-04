package ru.geekbrains.javaalg.lesson3;

import java.util.Scanner;

public class ReflectionString {
    public static void reflection(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фразу");
        String stringIn = scanner.next();
        String stringOut = "";
        MyStack<Character> stack = new MyStack<>(stringIn.length());
        for (int i = 0; i < stringIn.length(); i++) {
            char ch = stringIn.charAt(i);
            stack.push(ch);
        }
        for (int i = 0; i < stringIn.length(); i++) {
            char ch2 = stack.pop();
            stringOut = stringOut + ch2;
        }
        System.out.println("Обратная строка: " + stringOut);
    }
}
