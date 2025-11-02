package DSA.Graph.FindNoOfIslands;

import java.util.LinkedList;
import java.util.Queue;

//Islands are form in vertical, horizontal and in diagonal direction
class Solution {
    class pair{
        public int x;
        public int y;

        public pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    int r[]={1,0,-1,0,-1,1,1,-1};
    int c[]={0,1,0,-1,1,1,-1,-1};

    private void dfs(int x,int y, char[][]grid){
        grid[x][y]='#';
        int n= grid.length;
        int m= grid[0].length;

        for (int i=0;i<8;i++){
            int nx= x+r[i];
            int ny= y+c[i];

            if (nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]=='L'){
                dfs(nx,ny,grid);
            }

        }

    }
    public int countIslands(char[][] grid) {

        // Code here
        Queue<pair> q= new LinkedList<>();
        int n=grid.length;
        int m= grid[0].length;

        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]=='L') q.offer(new pair(i,j));
            }
        }

        int count=0;

        while(!q.isEmpty()){
            pair curr= q.poll();
            int x= curr.x;
            int y= curr.y;

            if (grid[x][y]=='L'){
                dfs(x,y,grid);
                count++;
            }
        }

        return count;


    }
}