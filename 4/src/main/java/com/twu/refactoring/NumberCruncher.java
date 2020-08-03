package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }


    public int countEven() {
        countEveryType("even");
    }

    public int countOdd() {
        countEveryType("odd");
    }

    public int countPositive() {
        countEveryType("positive");
    }

    public int countNegative() {
        countEveryType("negative");
    }

    public void countEveryType(String type){
        int count = 0;
        for (int number : numbers) {
            if(number % 2 == 0 && type.equals("even")){
                count++;
            }else if (number % 2 == 1 && type.equals("odd")){
                count++;
            }else if(number >= 0 && type.equals("positive")){
                count++;
            }else if(number < 0 && type.equals("negative")){
                count++;
            }
        }
    }
}