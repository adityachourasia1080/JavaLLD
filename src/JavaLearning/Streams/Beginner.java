package JavaLearning.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Beginner {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(16, 20, 3, 47, 5, 65, 7, 8, 9);
        List<String> strings = Arrays.asList("Aditya", "Atharva", "a", "bad", "Timber");

        //  Print even numbers
        // numbers.stream()
        //        .filter(num -> num % 2 == 0)
        //        .forEach(System.out::println);

        //  Square each number and collect into a list
        // List<Integer> squared = numbers.stream()
        //                                .map(num -> num * num)
        //                                .collect(Collectors.toList());
        // squared.forEach(System.out::println);

        //  Count strings starting with 'a' (case-insensitive)
        // long count = strings.stream()
        //                     .filter(s -> !s.isEmpty() && s.toLowerCase().charAt(0) == 'a')
        //                     .count();
        // System.out.println("Count: " + count);


        //  Find first number greater than 10
//         Optional<Integer> ans= numbers.stream()
//                .filter(num -> num > 100)
//                .findFirst();
//         System.out.println(ans.get());


        //  Find sum using streams
        // Optional<Integer> sum = numbers.stream()
        //                                .reduce((Integer a, Integer b) -> a + b);
        // sum.ifPresent(System.out::println);
    }
}
