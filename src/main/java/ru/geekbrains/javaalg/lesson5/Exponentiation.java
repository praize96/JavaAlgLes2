package ru.geekbrains.javaalg.lesson5;

import java.util.Scanner;

public class Exponentiation {
    private static int number;
    private static int extent;

    public static void getDecision(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        number = scanner.nextInt();
        System.out.print("Введите степень: ");
        extent = scanner.nextInt();
        System.out.println("Ответ: " + exponentiation(number, extent));
    }

    private static int exponentiation(int number, int extent) {
        if (number == 0 && extent == 0) {
            throw new ArithmeticException("Ноль в нулевой степени не определен, такое выражение не имеет смысла.");
        }
        if (extent == 0) {
            return 1;
        }
        return exponentiation(number, extent - 1) * number;

    }
}


