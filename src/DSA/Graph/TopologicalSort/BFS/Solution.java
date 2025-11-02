package DSA.Graph.TopologicalSort.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        int n= edges.length;

        // indegree to calculate incoming edges
        int[] ind = new int[V];
        for (int i=0;i<V;i++) ind[i]=0;


        ///Building adj matrix
        ArrayList<ArrayList<Integer>>adj= new ArrayList<>();
        for (int i=0;i<V;i++) adj.add(new ArrayList<>());
        for (int i=0;i<n;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
            ind[v]++;
        }

        ArrayList<Integer> res= new ArrayList<>();

        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<V;i++){
            if (ind[i]==0) q.offer(i);
        }

        //Using topological sorting
        while(!q.isEmpty()){
            int curr= q.poll();
            res.add(curr);
            for (int v: adj.get(curr)){
                ind[v]--;
                if (ind[v]==0) q.offer(v);
            }
        }

        return res;

    }
}