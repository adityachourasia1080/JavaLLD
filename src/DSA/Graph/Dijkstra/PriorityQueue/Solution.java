package DSA.Graph.Dijkstra.PriorityQueue;


import java.util.ArrayList;
import java.util.PriorityQueue;

//GFG Practice
class Solution {
    class pair{
        public int var1;
        public int var2;
        public pair(int var1,int var2){
            this.var1=var1;
            this.var2=var2;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        int n = edges.length;

        //Building adj list
        ArrayList<ArrayList<pair>> adj= new ArrayList<>();
        for (int i=0;i<V;i++){ adj.add(new ArrayList<pair>());}

        for (int i=0;i<n;i++){
            int u = edges[i][0],v=edges[i][1],wt=edges[i][2];
            adj.get(u).add(new pair(v,wt));
            adj.get(v).add(new pair(u,wt));
        }

        //distance array
        int dis[]= new int[V];
        for (int i=0;i<V;i++) dis[i]=Integer.MAX_VALUE;
        dis[src]=0;

        //Visited array to not re reprocress same node
        boolean vis[]= new boolean[V];
        for (int i=0;i<V;i++) vis[i]=false;


        //Priority queue to pop out the smallest distance edges that has to be processed
        PriorityQueue<pair> pq= new PriorityQueue<>((pair a , pair b) -> Integer.compare(a.var1,b.var1));


        pq.offer(new pair(0,src));


        while(!pq.isEmpty()){
            pair curr= pq.poll();

            int u= curr.var2;
            if (vis[u]) continue;
            vis[u]=true;

            //relaxed all the neighbours
            for (pair p : adj.get(u)){

                int v= p.var1;
                int wt= p.var2;

                if(!vis[v] && dis[u]!=Integer.MAX_VALUE && dis[v]> dis[u]+wt){
                    dis[v]= dis[u]+wt;
                    pq.offer(new pair(dis[v],v));
                }
            }
        }

        return dis;




    }
}