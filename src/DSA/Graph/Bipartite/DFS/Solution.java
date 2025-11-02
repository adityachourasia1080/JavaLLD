package DSA.Graph.Bipartite.DFS;

import java.util.ArrayList;

class Solution {
    private boolean dfs(int u ,ArrayList<ArrayList<Integer>>adj,int []color,int c){
        color[u]=c;
        for (int v: adj.get(u)){
            if (color[v]==-1 ){
                if (!dfs(v,adj,color,1-c)) return false;
            }
            else if (color[v]==c)  return false;
        }

        return true;

    }
    public boolean isBipartite(int V, int[][] edges) {
        int n= edges.length;

        ///Building adj matrix
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
        for (int i=0;i<V;i++) adj.add(new ArrayList<>());
        for (int i=0;i<n;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int color[]= new int[V];
        for (int i=0;i<V;i++) color[i]=-1;

        for (int i=0;i<V;i++){
            if (color[i]==-1 && !dfs(i,adj,color,0)) return false;
        }

        return true;

    }
}