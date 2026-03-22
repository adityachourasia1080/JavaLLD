package Microsoft;

import java.util.Scanner;

public class RollDice {

    public class Main {

        public static String rollTheString(String s, int[] roll) {
            int prefix[] = new int[26];
            for (int i = 0; i < roll.length; i++) {
                prefix[roll[i] - 1]++;
            }

            for (int i=24;i>=0;i--){
                prefix[i]=prefix[i+1]+prefix[i];
            }

            String ans="";
            for(int i=0;i<s.length();i++){
                char c= s.charAt(i);
                int temp= c-'a';
                temp+=prefix[i];
                temp=temp%26;
                ans+=(char)(temp+'a');
            }

            return ans;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String s = sc.nextLine().trim();
            int n = Integer.parseInt(sc.nextLine().trim());

            int[] roll = new int[n];
            for (int i = 0; i < n; i++) {
                roll[i] = sc.nextInt();
            }

            System.out.println(rollTheString(s, roll));

            sc.close();
        }
    }
}
