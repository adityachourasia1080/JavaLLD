package Microsoft;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DaulInternTask {


    public class Main {

        public static long getMaximumRewardPoints(int[] reward_1, int[] reward_2, int k) {

            //first i will allocate all task to intern 2

            int sum= Arrays.stream(reward_2).sum();

            //now i will calculate the diff of reward 1 and reward 2 and sort it in decreasing order
            PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);
            for (int i=0;i<reward_1.length;i++){
                pq.add(reward_1[i]-reward_2[i]);
            }

           for (int i=0;i<k;i++) {
               int temp = pq.poll();
               sum += temp;
           }

            return sum;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = Integer.parseInt(sc.nextLine().trim());
            int[] reward_1 = new int[n];
            int[] reward_2 = new int[n];

            for (int i = 0; i < n; i++) reward_1[i] = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) reward_2[i] = sc.nextInt();
            sc.nextLine();

            int k = Integer.parseInt(sc.nextLine().trim());

            System.out.println(getMaximumRewardPoints(reward_1, reward_2, k));

            sc.close();
        }
    }
}
