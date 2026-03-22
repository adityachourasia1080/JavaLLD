package PayPalQuestions;


import java.util.Scanner;

//question link: https://prepinsta.com/paypal-coding-questions-and-answers/
//Given a string s consisting of stars “*” and bars  “|” ,an array of starting indices  starIndex,and an array of ending indices endIndex,determine the number of stars between any two bars within the substrings between the two indices inclusive . NOTE that in this problem indexing starts at 1.
//
//        A Star is represented as an asterisk [*=ascii decimal 42]
//        A Bar is represented as a Pipe [“|”=ascii decimal 124]
//        Example
//        s=’|**|*|’
//        startIndex=[1,1]
//        endIndex=[5,6]
//
//        For the first pair of indices (1,5) the substrings is “|**|*”  . There are 2 stars between a pair of bars
//        For the second pair of indices (1,6) the substring is  “|**|*|” and there are 2+1=3 stars in between the bars.
//        Both of the answers are returned to the array [2,3].

public class StarAndPipe {
    public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        int start[]={1,2,0,7};
        int end[] = {2,4,7,13};
        findStarBetweenPipe(str,start,end);
    }

    private static void findStarBetweenPipe(String str, int start[], int end[]){
        int n= str.length();
        int star=0;
        int totalStar[]= new int[n];
        int last=-1;
        int lastPipe[]= new int[n];
        int next=n;
        int nextPipe[]= new int[n];

        for (int i=0;i<n;i++){
            if (str.charAt(i)=='*') star++;
            else last=i;
            totalStar[i]=star;
            lastPipe[i]=last;
        }

        for (int i=n-1;i>=0;i--){
            if (str.charAt(i)=='|'){
                next=i;
            }
            nextPipe[i]=next;

        }

        for (int i=0;i<start.length;i++){
            int l= start[i];
            int h= end[i];
            int nextInd= nextPipe[l];
            int lastInd= lastPipe[h];
            if (nextInd == n || lastInd == -1 || nextInd >= lastInd
                    || lastInd < l || nextInd > h) {  // ← ADD THIS
                System.out.println(0);
                continue;
            }

            int starts= totalStar[lastInd]-totalStar[nextInd];
            System.out.println(starts);

        }




    }
}
