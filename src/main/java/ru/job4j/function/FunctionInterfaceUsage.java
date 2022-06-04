package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        Consumer<String> consumer = System.out::println;
        consumer.accept(sup.get());
        BiConsumer<String, String> secondConsumer = (s, s1) -> System.out.println(s + s1);
        secondConsumer.accept(sup.get(), " and Second String");

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> supplier = () -> new HashSet<>(list);
        BiConsumer<Integer, String> thirdConsumer = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = supplier.get();
        int i = 1;
        for (String s : strings) {
            thirdConsumer.accept(i++, " is " + s);
        }

        Predicate<String> pred = String::isEmpty;
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));

        BiPredicate<String, Integer> cond = (s, secondI) -> s.contains(secondI.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));

        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));

        BiFunction<String, Integer, String> biFunc = (s, thirdI) -> s.concat(" ").concat(thirdI.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));

        UnaryOperator<StringBuilder> builder = StringBuilder::reverse;
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));

        BinaryOperator<StringBuilder> secondBuilder = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + secondBuilder.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
