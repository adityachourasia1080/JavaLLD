package JavaLearning.Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Advanced {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(16, 20, 3, 47, 5, 65, 70, 8, 9, 9,70);
        List<String> strings = Arrays.asList("Aditya", "Atharva", "Aditya", "bad", "Timber", "Timber");

        //Top 3 Highest Numbers
//        numbers.stream()
//                .sorted(Collections.reverseOrder())
//                .limit(3).forEach((Integer a)->System.out.println(a));

        //Given a list of strings, count how many times each string appears.
//        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
//        Map<String, Long> frequencyMap = words.stream()
//                .collect(Collectors.groupingBy(
//                        word -> word,
//                        Collectors.counting()
//                ));
//
//        System.out.println(frequencyMap);


        //find most frequent
//        Map<Integer, Long> freqMap = numbers.stream()
//                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
//
//        Optional<Map.Entry<Integer, Long>> mostFrequent = freqMap.entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue());
//
//        if (mostFrequent.isPresent()) {
//            System.out.println("Most frequent element: " + mostFrequent.get().getKey());
//            System.out.println("Frequency: " + mostFrequent.get().getValue());
//        } else {
//            System.out.println("List is empty");
//        }

        //Group Strings by Length
//        Map<Integer,List<String>> mp= strings.stream()
//                .collect(Collectors.groupingBy(temp -> temp.length(),Collectors.toList()));
//        System.out.println(mp);

        //find avg of even no
//        OptionalDouble avg = numbers.stream()
//                .filter(n -> n % 2 == 0)
//                .mapToInt(Integer::intValue)
//                .average();
//
//        if (avg.isPresent()) {
//            System.out.println(avg.getAsDouble());
//        } else {
//            System.out.println("No even numbers found");
//        }

    }

}
