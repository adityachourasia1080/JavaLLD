package Microsoft;

import java.util.Scanner;

public class EbookProvider {


    public class Main {

        private static int solve(int[] iv, int[] articles, int p,int index,int dp[][]){
            if (index==0 || p==0)  return 0;
            if (dp[index][p]!=-1)  return dp[index][p];

            int ans=Integer.MIN_VALUE;
            if (p>=articles[index-1]){
                ans=Math.max(ans,solve(iv,articles,p-articles[index-1],index-1,dp)+iv[index-1]);
            }
            ans=Math.max(ans,solve(iv,articles,p,index-1,dp));
            return dp[index][p]=ans;
        }

        //METHOD 2 O(P)
//        public static int solve(List<Integer> iv, List<Integer> articles, int p) {
//            int n = iv.size();
//            int[] dp = new int[p + 1];
//
//            for (int i = 0; i < n; i++) {
//                int value = iv.get(i);
//                int weight = 2 * articles.get(i);  // Must read TWICE!
//
//                // Traverse from right to left for 0/1 knapsack
//                for (int j = p; j >= weight; j--) {
//                    dp[j] = Math.max(dp[j], dp[j - weight] + value);
//                }
//            }
//
//            return dp[p];
//        }

        public static int maximumLearning(int[] iv, int[] articles, int p) {

            int n= iv.length;
            int dp[][]= new int[n+1][p+1];
            for (int i=0;i<=n;i++){

                if(i<n) articles[i]=articles[i]*2;
                for(int j=0;j<=p;j++) dp[i][j]=-1;
            }

            return solve(iv,articles,p,iv.length,dp);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = Integer.parseInt(sc.nextLine().trim());
            int[] iv = new int[n];
            int[] articles = new int[n];

            for (int i = 0; i < n; i++) iv[i] = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) articles[i] = sc.nextInt();
            sc.nextLine();

            int p = Integer.parseInt(sc.nextLine().trim());

            System.out.println(maximumLearning(iv, articles, p));

            sc.close();
        }
    }
}
