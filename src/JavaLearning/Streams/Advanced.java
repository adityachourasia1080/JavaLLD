package JavaLearning.Streams;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
//        Optional<Map.Entry<Integer, Long>> mostFrequent =
//                freqMap.entrySet()
//                        .stream()
//                        .max((e1, e2) -> Long.compare(e1.getValue(), e2.getValue()));
//
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


        //Find first non-repeating character in a string
//        String str = "stress";
//
//        LinkedHashMap<Character, Long> freqMap1 =
//                str.chars()
//                        .mapToObj(c -> (char) c)
//                        .collect(Collectors.groupingBy(
//                                c -> c,
//                                LinkedHashMap::new,     // preserves insertion order
//                                Collectors.counting()
//                        ));
//
//        Optional<Character> st =
//                freqMap1.entrySet()
//                        .stream()
//                        .filter(e -> e.getValue() == 1)
//                        .map(e->e.getKey())
//                        .findFirst();
//
//        if (st.isPresent()) System.out.println(st.get());
//         else System.out.println("Not found");


        //Group strings by length
//        List<String> temp= Arrays.asList("Aditya", "Atharva", "Aditya", "bad", "Timber", "Timber");
//        Map<Integer,List<String>> ans= temp.stream().collect(Collectors.groupingBy(
//                s -> s.length(),
//                Collectors.toList()
//        ));





    }

}
