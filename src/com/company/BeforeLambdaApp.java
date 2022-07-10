package com.company;

public class BeforeLambdaApp {
    public static void main(String[] args) {
        Operationable op = new Operationable() {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        };

        int z = op.calculate(20, 20);
        System.out.println(z);
    }
}
