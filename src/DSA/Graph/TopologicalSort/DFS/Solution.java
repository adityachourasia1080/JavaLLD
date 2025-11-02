package DSA.Graph.TopologicalSort.DFS;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private void dfs(int u,boolean vis[],ArrayList<ArrayList<Integer>>adj,ArrayList<Integer> res){
        vis[u]=true;

        //process all the dependencies first
        for (int v: adj.get(u)){
            if (vis[v]==false){
                dfs(v,vis,adj,res);
            }
        }

        //once all are processed now process curr;
        res.add(u);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        int n= edges.length;

        ///Building adj matrix
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
        for (int i=0;i<V;i++) adj.add(new ArrayList<>());
        for (int i=0;i<n;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
        }

        ArrayList<Integer> res= new ArrayList<>();


        //find index in increasing offer of it finish time
        boolean vis[]= new boolean[V];
        for (int i=0;i<V;i++) vis[i]=false;


        for (int i=0;i<V;i++){
            if(vis[i]==false){
                dfs(i,vis,adj,res);
            }
        }

        Collections.reverse(res);
        return res;

    }
}
