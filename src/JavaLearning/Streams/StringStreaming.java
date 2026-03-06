package JavaLearning.Streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStreaming {

    public static void main(String[] args) {

        String asn = "aditya";

        // ─────────────────────────────────────────────────────────────
        // METHOD 1: .chars() → IntStream
        // Returns raw integer (ASCII) values of each character.
        // 'a'=97, 'd'=100, 'i'=105, 't'=116, 'y'=121
        // ─────────────────────────────────────────────────────────────
        System.out.println("=== Method 1: IntStream (raw integers) ===");
        asn.chars()
                .forEach(c -> System.out.print(c + " "));
        // Output: 97 100 105 116 121 97

        System.out.println();

        // ─────────────────────────────────────────────────────────────
        // METHOD 2: .chars() → IntStream → cast to char
        // Cast each int back to char so it prints as a letter.
        // This is the most common and efficient approach.
        // ─────────────────────────────────────────────────────────────
        System.out.println("=== Method 2: IntStream cast to char ===");
        asn.chars()
                .forEach(c -> System.out.print((char) c + " "));
        // Output: a d i t y a

        System.out.println();

        // ─────────────────────────────────────────────────────────────
        // METHOD 3: .chars() → mapToObj → Stream<Character>
        // Converts int to Character object — gives you a proper Stream<Character>.
        // Useful when you need Character-specific methods or generics.
        // ─────────────────────────────────────────────────────────────
        System.out.println("=== Method 3: Stream<Character> ===");
        Stream<Character> charStream = asn.chars()
                .mapToObj(c -> (char) c);
        charStream.forEach(c -> System.out.print(c + " "));
        // Output: a d i t y a

        System.out.println();

        // ─────────────────────────────────────────────────────────────
        // METHOD 4: split("") → Stream<String>
        // Splits each character into a single-character String.
        // Useful when you need each character as a String (not char/int).
        // ─────────────────────────────────────────────────────────────
        System.out.println("=== Method 4: Stream<String> via split ===");
        Arrays.stream(asn.split(""))
                .forEach(c -> System.out.print(c + " "));
        // Output: a d i t y a

        System.out.println();

        // ─────────────────────────────────────────────────────────────
        // METHOD 5: codePoints() → Java 9+
        // Similar to .chars() but handles Unicode better (emojis, special chars).
        // Prefer this over .chars() when working with non-ASCII characters.
        // ─────────────────────────────────────────────────────────────
        System.out.println("=== Method 5: codePoints() — Java 9+ ===");
        asn.codePoints()
                .mapToObj(Character::toString)
                .forEach(c -> System.out.print(c + " "));
        // Output: a d i t y a

        System.out.println();
    }
}