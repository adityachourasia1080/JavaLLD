package JavaLearning.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Intermediate {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(16, 20, 3, 47, 5, 65, 70, 8, 9,9);
        List<String> strings = Arrays.asList("Aditya", "Atharva", "Aditya", "bad", "Timber","Timber");


        //sorting in reverse order
//        List<Integer> ans= numbers.stream().sorted((Integer a,Integer b)-> Integer.compare(b,a))
//                .collect(Collectors.toList());
//        ans.forEach((Integer temp)->System.out.println(temp));


        //find min
//        Optional<Integer>minh= numbers.stream().min((Integer a ,Integer b)-> Integer.compare(a,b));
//        System.out.println(minh.get());

        //findMax
//        Optional<Integer>maxh= numbers.stream().min((Integer a ,Integer b)-> Integer.compare(b,a));
//        System.out.println(maxh.get());

        //removes duplicate
//        List<Integer> temp= numbers.stream().distinct().collect(Collectors.toList());
//        temp.forEach((Integer t)-> System.out.println(t));

        //find second highest no
//        Optional<Integer> temp=numbers.stream().distinct().sorted((Integer a, Integer b)->Integer.compare(b,a)).limit(2)
//                .min((Integer a,Integer b)-> Integer.compare(a,b));
//        System.out.println(temp.get());


        //convert int[] to ArrayList<Integer>
//        int [] arr= new int []{12,13,14,56,78};
//        //m1
//        Stream<Integer> ins= Arrays.stream(arr).boxed();
//        List<Integer> ans= ins.collect(Collectors.toList());
//        ans.forEach((Integer a)-> System.out.println(a));

//        //m2;
//        IntStream ints = Arrays.stream(arr);
//        ints.boxed().collect(Collectors.toList()).forEach((Integer a)-> System.out.println(a));



        //find 4th highest no
//        Optional<Integer> temp = numbers.stream()
//                .distinct()
//                .sorted((Integer a, Integer b) -> Integer.compare(b, a))
//                .skip(3)
//                .findFirst();



    }

}
