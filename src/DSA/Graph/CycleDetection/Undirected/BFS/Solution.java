package DSA.Graph.CycleDetection.Undirected.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public boolean isCycle(int V, int[][] edges) {

        int n= edges.length;

        //Building adj matrix
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
        for (int i=0;i<V;i++) adj.add(new ArrayList<>());
        for (int i=0;i<n;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //Visited Array
        boolean vis[]= new boolean[V];
        for (int i=0;i<V;i++) vis[i]=false;

        //Parent array
        int parent[]= new int[V];
        for (int i=0;i<V;i++) parent[i]=-1;


        for (int i=0;i<V;i++){
            if (vis[i]==false){
                Queue<Integer> q= new LinkedList<>();
                q.offer(i);
                vis[i]=true;
                while(!q.isEmpty()){
                    int curr= q.poll();

                    for (int v: adj.get(curr)){
                        if (vis[v]==false){
                            vis[v]=true;
                            parent[v]=curr;
                            q.offer(v);
                        }
                        else if (parent[curr]!=v)  return true;
                    }
                }
            }
        }

        return false;


    }
}
