package org.example;

public class SumCalculator {
    public int sum(int number) {
        if(number == 0){
            throw new IllegalArgumentException();
        }
        if(number == 1){
            return number;
        }
        return number + sum(number-1);
    }
}