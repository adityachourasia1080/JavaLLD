package JavaLearning.Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practise22Feb {


    public static void main(String[] args) {

//         filter even no from int array
//        int [] lis= new int []{12,13,14,56,78,90,23,45,67,89};
//        Stream<Integer> ins= Arrays.stream(lis).boxed();
//        ins.filter(n-> n%2==0).forEach((Integer a)-> System.out.println(a));


        //segregate no from string
        List<List<String>> douLis= Arrays.asList(
                Arrays.asList("1", "Atharva"),
                Arrays.asList("123d", "2","2345","69"),
                Arrays.asList("456","2345","Timber","Timber")
        );

        HashSet<Integer> ans= douLis.stream()
                .flatMap((List<String>list)-> list.stream().filter((String s)->{
                    try {
                        Integer.parseInt(s);
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }).map((String s)-> Integer.parseInt(s))).collect(Collectors.toCollection(HashSet::new));

        ans.stream().forEach((Integer a)-> System.out.println(a));
    }
}
