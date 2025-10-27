package LLD.TicTacToeLLD.Gaurav;

//Gaurav Sen Interview ready
public class TicTacToeO1 {

      int[] rowCount;
      int[] colCount;
      int diaCount;
      int revDiaCount;
      int[][] mat;
      int moves;
      int n;

      TicTacToeO1(int n){
          rowCount = new int[n];
          colCount= new int[n];
          diaCount= 0;
          revDiaCount= 0;
          mat = new int[n][n];
          moves=0;
          this.n=n;
          for (int i=0;i<n;i++){
              for (int j=0;j<n;j++) mat[i][j]=0;
          }
      }

      public int move(int player,int row,int col){
          if (row<0 || row>=n || col<0 || col>=n){
              throw new IllegalArgumentException("Moves out of Bound");
          }
          else if (player!=-1 && player!=1){
              throw new IllegalArgumentException("Not a valid player");
          }
          else if (mat[row][col]!=0){
              throw new IllegalArgumentException("Place is already filled");
          }

          mat[row][col]=player;
          rowCount[row]+=player;
          colCount[col]+=player;
          if (row==col) diaCount+=player;
          if (row+col == n-1)  revDiaCount+=player;

          if (Math.abs(rowCount[row]) == n ||
                  Math.abs(colCount[col]) == n ||
                  Math.abs(diaCount) == n ||
                  Math.abs(revDiaCount) == n) {
              return player;
          }

          moves++;
          if (moves== (n*n))  return 2; // match drawn

          return 0;
      }


}
