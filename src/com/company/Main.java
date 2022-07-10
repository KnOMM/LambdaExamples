package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Printable printer = System.out::println;
        printer.print("Hello, this is lambda example");

        Predicate<Integer> prediction = integer -> integer > 0;
        System.out.printf("5 > 0 is %b\n", prediction.test(5));
        System.out.printf("-5 > 0 is %b\n", prediction.test(-5));

        System.out.println("=".repeat(50));

        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        BinaryOperator<Integer> add = (x, y) -> x + y;
        BinaryOperator<Integer> subtract = (x, y) -> x - y;
        System.out.println("10 * 20 = " + multiply.apply(10, 20));
        System.out.println("10 + 20 = " + add.apply(10, 20));
        System.out.println("10 - 20 = " + subtract.apply(10, 20));

        System.out.println("=".repeat(50));

        UnaryOperator<Integer> square = x -> x * x;
        System.out.println("Square of 5 is " + square.apply(5));

        System.out.println("=".repeat(50));

        Function<Integer, String> convert = x -> String.valueOf(x) + " bananas";
        System.out.println(convert.apply(5));

        System.out.println("=".repeat(50));

        Consumer<Integer> moneyPrinter = x -> System.out.printf("%d$\n", x);
        moneyPrinter.accept(5);

        System.out.println("=".repeat(50));

        Supplier<User> userFactory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the name: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();
        System.out.println("User1 name - " + user1.getName());
        System.out.println("User2 name - " + user2.getName());

        System.out.println("=".repeat(50));

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        Stream<String> streamFromCollection = collection.stream();
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        String[] array = {"a1", "a2", "a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);

        List<String> out = collection.stream().map(String::toUpperCase).peek((e) ->
                System.out.print("," + e)).toList();
        System.out.println(out);

        System.out.println("=".repeat(50));

        long count = streamFromCollection.filter("a1"::equals).count();
        System.out.println("a1: " + count + " times");
        String firstValue = streamFromArrays.findFirst().orElse("0");
        System.out.println(firstValue );
        String a3 = streamFromValues.filter("a3"::equals).findFirst().get();
        System.out.println(a3);
        Stream<String> streamFromValues2 = Stream.of("a1", "a2", "a3");
        String thirdElement = streamFromValues2.skip(2).findFirst().get();
        System.out.println("Third element is " + thirdElement);
        Stream<String> streamFromValues3 = Stream.of("a1", "a2", "a3", "a4");
        List<String> twoElements = streamFromValues3.skip(1).limit(2).toList();
        System.out.println(twoElements);
        System.out.println(Arrays.toString(collection.stream().skip(1).limit(2).toArray()));
        Stream<String> streamFromValues4 = Stream.of("a1", "a2", "a1", "a1");
        List<String> contains1 = streamFromValues4.filter((s) ->
                s.contains("1")).collect(Collectors.toList());
        System.out.println(contains1);
    }
}
