package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // Генерация случайных чисел от 1 до 50
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            randomNumbers.add(random.nextInt(50) + 1);
        }

        // Параллельные вычисления факториалов
        for (Integer number : randomNumbers) {
            Thread thread = new Thread(new FactorialTask(number));
            thread.start();
        }
    }
}

class FactorialTask implements Runnable {
    private final Integer number;

    public FactorialTask(Integer number) {
        this.number = number;
    }

    @Override
    public void run() {
        long result = calculateFactorial(number);
        System.out.println("Факториал числа " + number + ": " + result);
    }

    private long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}