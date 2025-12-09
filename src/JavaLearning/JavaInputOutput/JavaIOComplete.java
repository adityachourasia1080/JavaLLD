package JavaLearning.JavaInputOutput;

import java.util.Scanner;
import java.io.*;

public class JavaIOComplete {

    // 1. BASIC SCANNER INPUT
    public static void basicScanner() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println("You entered: " + text);
        sc.close();
    }

    // 2. BUFFERED READER (Faster for large inputs)
    public static void bufferedReaderExample() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter name: ");
        String name = br.readLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(br.readLine());

        System.out.println("Name: " + name + ", Age: " + age);
    }

    // 3. READING ARRAYS
    public static void readArray() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        sc.close();
    }

    // 4. READING SPACE-SEPARATED INPUT
    public static void spaceSeparatedInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers separated by space:");
        String line = sc.nextLine();
        String[] parts = line.split(" ");

        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        System.out.print("Numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        sc.close();
    }

    // 5. OUTPUT METHODS
    public static void outputExamples() {
        // Basic print
        System.out.print("No newline ");
        System.out.println("With newline");

        // Formatted output
        String name = "Alice";
        int age = 25;
        double salary = 50000.5678;

        System.out.printf("Name: %s, Age: %d, Salary: %.2f%n", name, age, salary);

        // Using StringBuilder for efficient string building
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append(i).append(" ");
        }
        System.out.println("StringBuilder: " + sb.toString());
    }

    // 6. FILE INPUT/OUTPUT
    public static void fileIOExample() throws IOException {
        // Writing to file
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("Hello, World!");
        writer.newLine();
        writer.write("Line 2");
        writer.close();

        // Reading from file
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // 7. READING MATRIX
    public static void readMatrix() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    // Main method to run examples
    public static void main(String[] args) throws IOException {
        System.out.println("=== Java I/O Examples ===\n");

        // Uncomment the method you want to test
        // basicScanner();
        // bufferedReaderExample();
        // readArray();
        // spaceSeparatedInput();
        // outputExamples();
        // fileIOExample();
        // readMatrix();
    }
}