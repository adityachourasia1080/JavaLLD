package DSA.Graph.KruskalsAlgo.WithoutPathCompression;

import java.util.Arrays;

//gfg practise
// User function Template for Java
class Solution {
    static int find(int node,int []ps){
        while(ps[node]>=0){
            node=ps[node];}
        return node;}

    static void union(int u,int v,int []ps){
        int pu= find(u,ps);
        int pv= find(v,ps);

        if (pu==pv) return;
        if (ps[pu]> ps[pv]){
            ps[pv]+=ps[pu];
            ps[pu]=pv;
        }
        else{
            ps[pu]+=ps[pv];
            ps[pv]=pu;
        }
    }
    static int kruskalsMST(int V, int[][] edges) {

        int n= edges.length;
        int []ps = new int[V];
        for (int i=0;i<V;i++) ps[i]=-1;

        int ans=0;
        //sort edges asc
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        for (int i=0;i<n;i++){
            int [] temp= edges[i];

            int u= temp[0];
            int v= temp[1];

            //not to form cycle
            if (find(u,ps)!=find(v,ps)){
                ans+=temp[2];
                union(u,v,ps);
            }
        }

        return ans;


    }
}