package DSA.Graph.CycleDetection.Undirected.DisjointSets.PathCompression;


// Cycle detection through union-find only works for undirected graph
class Solution {

    private int find(int node, int[]parent){
        if (parent[node]==node)  return node;
        return parent[node]=find(parent[node],parent);
    }

    private void union(int u,int v,int []size,int []parent){
        int pv= find(v,parent);
        int pu= find(u,parent);

        if (pu==pv)  return ;
        if (size[pv]<size[pu]){
            size[pu]+=size[pv];
            parent[pv]=pu;
        }
        else{
            size[pv]+=size[pu];
            parent[pu]=pv;
        }
    }

    public boolean isCycle(int V, int[][] edges) {
        int n= edges.length;

        //to maintain size of disjoint size
        int size[]= new int[V];
        for (int i=0;i<V;i++) size[i]=1;

        //to maintain ultimate parent of the node
        int parent[]= new int[V];
        for (int i=0;i<V;i++) parent[i]=i;

        //Considering edges as a dynamic graph
        for (int i=0;i<n;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            if(find(u,parent)==find(v,parent)) return true;
            else{
                union(u,v,size,parent);
            }
        }

        return false;

    }
}
