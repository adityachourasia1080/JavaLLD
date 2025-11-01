package DSA.Graph.KosarajuAlgo;
import java.util.ArrayList;


//Refer GFG practise for actual problem

class Solution {

    private void findFinishTime(int u,ArrayList<ArrayList<Integer>> adj,boolean vis[],ArrayList<Integer>dq){
        vis[u]=true;
        for (int v: adj.get(u)){
            if (!vis[v]){  findFinishTime(v,adj,vis,dq); }
        }
        dq.add(u);
    }

    private void dfs(int u ,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[u]=true;
        for (int v: adj.get(u)){
            if (!vis[v]){
                dfs(v,adj,vis);
            }
        }
    }


    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {

        // ordering index based on decreasing order of finish time
        //Most Impt step
        int V= adj.size();
        boolean pro[] = new boolean[V];
        for (int i=0;i<V;i++) pro[i]=false;
        ArrayList<Integer>dq= new ArrayList<>();
        for (int i=0;i<V;i++){
            if(pro[i]==false){
                findFinishTime(i,adj,pro,dq);
            }
        }



        //reverse the edges
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        int n = adj.size();
        for (int i=0;i<n;i++) rev.add(new ArrayList<Integer>());
        for (int i=0;i<n;i++){
            for (int v : adj.get(i)){
                rev.get(v).add(i);
            }
        }

        // Do dfs
        boolean vis[]=new boolean[n];
        for (int i=0;i<n;i++) vis[i]=false;
        int count=0;
        int index=dq.size()-1;
        while(index>=0){
            int u= dq.get(index);
            index--;
            if (!vis[u]){
                dfs(u,rev,vis);
                count++;
            }
        }

        return count;

    }
}