package org.example;

import java.util.concurrent.Callable;

class FactorialTask implements Callable<Long> {
    private final Integer number;

    public FactorialTask(Integer number) {
        this.number = number;
    }

    @Override
    public Long call() {
        long result = calculateFactorial(number);
        System.out.println("Факториал числа " + number + ": " + result);
        return result;
    }

    private long calculateFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}