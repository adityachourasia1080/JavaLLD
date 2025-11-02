package DSA.Graph.Dijkstra.Normal;


import java.util.ArrayList;

//Will give TLE
class Solution {
    class pair{
        public int v;
        public int wt;
        public pair(int v,int wt){
            this.v=v;
            this.wt=wt;
        }
    }

    //Does not work for negative weight
    public int[] dijkstra(int V, int[][] edges, int src) {
        int n= edges.length;

        //Distance array
        int []dis = new int[V];
        for (int i=0;i<V;i++)  dis[i]=Integer.MAX_VALUE;
        dis[src]=0;

        //whether Key has been finalised or not
        boolean []fin = new boolean[V];
        for (int i=0;i<V;i++)  fin[i]=false;


        //Create adj list for better TC
        ArrayList<ArrayList<pair>>adj= new ArrayList<>();
        for (int i=0;i<n;i++)  adj.add(new ArrayList<pair>());
        for (int i=0;i<n;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            int wt= edges[i][2];
            adj.get(u).add(new pair(v,wt));
            adj.get(v).add(new pair(u,wt));
        }

        //iterate for exactly v-1 times and
        for (int i=0;i<V;i++){
            int u=-1;

            //Choose minimum distnce not yet finalised
            for (int j=0;j<V;j++){
                if (!fin[j]  && (u==-1 || dis[u]>dis[j]))  u=j;
            }

            //Finalise it
            fin[u]=true;

            //relax neighbours not yet finalised
            for (pair p : adj.get(u)){
                int v= p.v;
                int wt= p.wt;

                if (fin[v]==false && dis[u]+wt <dis[v]){
                    dis[v]= dis[u]+wt;
                }
            }
        }

        return dis;


    }
}
