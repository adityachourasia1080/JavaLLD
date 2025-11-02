package DSA.Graph.CycleDetection.Directed.DFS;

import java.util.ArrayList;

class Solution {
    private boolean dfs(int u ,ArrayList<ArrayList<Integer>>adj, boolean []vis,boolean[]recur){
        vis[u]=true;
        recur[u]=true;

        for (int v: adj.get(u)){
            if (vis[v]==false){
                if (dfs(v,adj,vis,recur))  return true;
            }
            else if (recur[v])  return true;
        }

        recur[u]=false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int n= edges.length;

        //Building adj matrix
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
        for (int i=0;i<V;i++) adj.add(new ArrayList<>());
        for (int i=0;i<n;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
        }

        //Visited Array
        boolean vis[]= new boolean[V];
        for (int i=0;i<V;i++) vis[i]=false;

        //recursion stack array
        boolean recur[]= new boolean[V];
        for (int i=0;i<V;i++) recur[i]=false;


        for (int i=0;i<V;i++){
            if (vis[i]==false && dfs(i,adj,vis,recur))  return true;
        }
        return false;

    }
}
