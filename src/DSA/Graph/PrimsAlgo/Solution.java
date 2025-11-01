package DSA.Graph.PrimsAlgo;

import java.util.ArrayList;
import java.util.PriorityQueue;

//GFG practise
//Minium spanning tree
//remember u need visited array in pq
class Solution {
    class pair{
        public int var1;
        public int var2;

        public pair(int var1,int var2){
            this.var1= var1;
            this.var2= var2;
        }
    }

    public int spanningTree(int V, int[][] edges) {
        //Dist array creation
        int [] dis= new int[V];
        dis[0]=0;
        for (int i=1;i<V;i++) dis[i]=Integer.MAX_VALUE;

        //Visited array
        boolean[] visited = new boolean[V];

        //Pq creation
        PriorityQueue<pair>pq= new PriorityQueue<>((pair a, pair b)-> Integer.compare(a.var1,b.var1));
        pq.offer(new pair(0,0));

        //adj list creation
        int n= edges.length;

        @SuppressWarnings("unchecked")
        ArrayList<pair> adj[]= new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i=0;i<n;i++){
            int u= edges[i][0],v=edges[i][1];
            adj[u].add(new pair(v,edges[i][2]));
            adj[v].add(new pair(u,edges[i][2]));
        }

        int ans=0;

        while(!pq.isEmpty()){
            pair temp= pq.poll();
            int u= temp.var2;

            if (visited[u]) continue;
            visited[u] = true;

            ans+=temp.var1;

            for (pair p : adj[u]){
                int v= p.var1;
                int weight= p.var2;

                if (!visited[v] && dis[v] > weight){
                    dis[v]=weight;
                    pq.offer(new pair(weight,v));
                }
            }
        }

        return ans;
    }
}
