package DSA.Graph.KruskalsAlgo.PathCompression;

import java.util.Arrays;

//gfg practise
// User function Template for Java
class Solution {
    static int find(int node,int []parent){

        //Path Compresssion to hve O(1)
        if (parent[node]==node)  return node;
        return parent[node]= find(parent[node],parent);

    }

    static void union(int u,int v,int []parent,int[]size){
        int pu= find(u,parent);
        int pv= find(v,parent);

        if (pu==pv) return;
        if (size[pu] < size[pv]){
            size[pv]+=size[pu];
            parent[pu]=pv;
        }
        else{
            size[pu]+=size[pv];
            parent[pv]=pu;
        }
    }

    static int kruskalsMST(int V, int[][] edges) {

        int n= edges.length;

        int []parent = new int[V];
        int []size = new int[V];

        for (int i=0;i<V;i++) {
            parent[i]=i;
            size[i]=1;
        }

        int ans=0;
        //sort edges asc
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        for (int i=0;i<n;i++){
            int [] temp= edges[i];

            int u= temp[0];
            int v= temp[1];

            //not to form cycle
            if (find(u,parent)!=find(v,parent)){
                ans+=temp[2];
                union(u,v,parent,size);
            }
        }

        return ans;


    }
}