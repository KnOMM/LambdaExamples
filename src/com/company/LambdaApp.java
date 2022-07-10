package com.company;

public class LambdaApp {
    public static void main(String[] args) {
        Operationable operation = ((x, y) -> x + y);
        int result = operation.calculate(10, 20);
        System.out.println(result);
    }
}
