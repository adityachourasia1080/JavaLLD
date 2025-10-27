package LLD.TicTacToeLLD.Gaurav;

//Gaurav sen Interview ready
//TicTacToe is a 2 player game on n*n matric
//2 player and there moves are represented as 1, -1
public class TicTacToeBruteForce {
    int[][] mat;
    int n;
    int moves;
    TicTacToeBruteForce(int n){
        mat= new int[n][n];
        this.n=n;
        this.moves=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++) mat[i][j]=0;
        }
    }

    public int move(int player,int row,int col) throws IllegalArgumentException{
        if (row<0 || row>=n || col<0 || col>=n){
            throw new IllegalArgumentException("Moves out of Bound");
        }
        else if (player!=-1 && player!=1){
            throw new IllegalArgumentException("Not a valid player");
        }
        else if (moves==(n*n)){
            return 2; // match drawn
        }
        else{
            boolean rowWin=true,colWin=true,diaWin=true,revDiaWin=true;
            if (mat[row][col]!=0)  throw new IllegalArgumentException("Place is already filled up");
            moves++;
            mat[row][col]=player;

            for (int i=0;i<n;i++){
                if (mat[i][col]!=player){
                    colWin=false;
                }
                if (mat[row][i]!=player){
                    rowWin=false;
                }

                if (mat[i][i] != player) {
                    diaWin = false;
                    }

                if (mat[i][n-i-1] != player) {
                    revDiaWin = false;
                    }
                }

            if (rowWin || colWin|| diaWin || revDiaWin) return player;
            return 0;


        }

    }

}
