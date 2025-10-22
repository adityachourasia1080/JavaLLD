package DSA.Stack.Max_of_min_for_every_window_size;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    class pair{
        int no;
        int index;
        pair(int no,int index){
            this.no=no;
            this.index=index;
        }
    }
    public ArrayList<Integer> maxOfMins(int[] arr) {

        int n= arr.length;
        ArrayList<Integer>lis = new ArrayList<>(Collections.nCopies(n,0));
        int left[] = new int[n];
        int right[]= new int[n];
        ArrayDeque<pair> st= new ArrayDeque<>();
        st.offerLast(new pair(Integer.MIN_VALUE,-1));

        //nsl index
        for (int i=0;i<n;i++){
            while(!st.isEmpty() && st.peekLast().no>=arr[i]) st.pollLast();
            left[i]=st.peekLast().index;
            st.offerLast(new pair(arr[i],i));
        }

        st.clear();
        st.offerLast(new pair(Integer.MIN_VALUE,n));
        //nsr index
        for (int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peekLast().no>=arr[i]) st.pollLast();
            right[i]= st.peekLast().index;
            st.offerLast(new pair(arr[i],i));

        }

        // Range which an be out option
        for (int i=0;i<n;i++){
            int range = right[i]-left[i]-2;
            lis.set(range,Math.max(lis.get(range),arr[i]));
        }

        for (int i=n-2;i>=0;i--){
            lis.set(i,Math.max(lis.get(i),lis.get(i+1)));
        }

        return lis;
    }
}