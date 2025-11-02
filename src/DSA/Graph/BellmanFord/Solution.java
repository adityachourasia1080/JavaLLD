package DSA.Graph.BellmanFord;


//GFG practise
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int dis[] = new int[V];
        int max= 100000000;
        for (int i=0;i<V;i++) dis[i]=max;

        dis[src]=0;
        int n= edges.length;

        for (int i=0;i<V-1;i++){
            for (int j=0;j<n;j++){
                int u= edges[j][0],v=edges[j][1],wt=edges[j][2];

                if (dis[u]!=max && dis[v]> dis[u]+wt){
                    dis[v]= dis[u]+wt;
                }
            }

        }

        //TO DETECT NEGATIVE EDGE CYCLE
        for (int j = 0; j < n; j++) {
            int u = edges[j][0], v = edges[j][1], wt = edges[j][2];

            if (dis[u] != max && dis[v] > dis[u] + wt) {
                return new int[]{-1};
            }
        }

        return dis;

    }
}

