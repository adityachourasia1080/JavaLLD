package Microsoft;

import java.util.Scanner;

public class PathToAGoal {

    static final int MOD = 1_000_000_007;

    public static int distinctMoves(String s, int n, int x, int y) {
        int len = s.length();
        long dp[][] = new long[len + 1][n + 1];
        dp[0][x] = 1;

        long cumL[] = new long[n + 1];
        long cumR[] = new long[n + 1];

        for (int i = 1; i <= len; i++) {
            char ch = s.charAt(i - 1);
            int move = (ch == 'l') ? -1 : 1;

            for (int pos = 0; pos <= n; pos++) {
                dp[i][pos] = dp[i - 1][pos]; // skip

                int prevPos = pos - move;
                if (prevPos >= 0 && prevPos <= n) {
                    long add = dp[i - 1][prevPos];
                    long sub = (ch == 'l') ? cumL[pos] : cumR[pos];
                    dp[i][pos] = (dp[i][pos] + add - sub + MOD) % MOD;
                }
            }

            // accumulate running sum for duplicate removal
            for (int pos = 0; pos <= n; pos++) {
                int prevPos = pos - move;
                if (prevPos >= 0 && prevPos <= n) {
                    if (ch == 'l') cumL[pos] = (cumL[pos] + dp[i - 1][prevPos]) % MOD;
                    else           cumR[pos] = (cumR[pos] + dp[i - 1][prevPos]) % MOD;
                }
            }
        }

        return (int) dp[len][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        int n = Integer.parseInt(sc.nextLine().trim());
        int x = Integer.parseInt(sc.nextLine().trim());
        int y = Integer.parseInt(sc.nextLine().trim());
        System.out.println(distinctMoves(s, n, x, y));
        sc.close();
    }
}