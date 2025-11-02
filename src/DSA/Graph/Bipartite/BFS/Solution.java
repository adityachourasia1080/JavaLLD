package DSA.Graph.Bipartite.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
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
            if (color[i]==-1)
            {
                Queue<Integer> q= new LinkedList<>();
                q.offer(i);
                color[i]=0;

                while(!q.isEmpty()){
                    int u= q.poll();
                    for (int v: adj.get(u)){
                        if (color[v]==-1){
                            q.offer(v);
                            color[v]=1-color[u];
                        }
                        else if (color[v]==color[u])  return false;
                    }
                }
            }
        }

        return true;

    }
}
