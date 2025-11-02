package DSA.Graph.CycleDetection.Undirected.DisjointSets.WithoutPathCompression;

// Cycle detection through union-find only works for undirected graph
class Solution {

    private int find(int node, int[]size){
        while(size[node]>=0){
            node=size[node];
        }
        return node;
    }

    private void union(int u,int v,int []size){
        int pv= find(v,size);
        int pu= find(u,size);

        if (pu==pv)  return ;
        if (size[pv]>size[pu]){
            size[pu]+=size[pv];
            size[pv]=pu;
        }
        else{
            size[pv]+=size[pu];
            size[pu]=pv;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        int n= edges.length;

        int size[]= new int[V];
        for (int i=0;i<V;i++) size[i]=-1;

        //Considering edges as a dynamic graph
        for (int i=0;i<n;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            if(find(u,size)==find(v,size)) return true;
            else{
                union(u,v,size);
            }
        }

        return false;

    }
}