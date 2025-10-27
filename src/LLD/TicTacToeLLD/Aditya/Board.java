package LLD.TicTacToeLLD.Aditya;

public class Board {
    public Piece [][] mat;
    public int len;
    int movesMade;
    int row[];
    int col[] ;
    int dia;
    int revDia;

    public Board(int len){
        mat = new Piece[len][len];
        row = new int[len];
        col = new int[len];
        dia=0;
        revDia=0;
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                mat[i][j]=null;
                mat[i][j]=null;
            }
        }
        this.len=len;
        movesMade=0;
    }

    public int makeMove(Player p,int row,int col){
        if (col<0 || col>=len || row<0 || row>=len || mat[row][col]!=null){
            return -1; // invalid move
        }
        else if (movesMade==len*len){
            return 2; // draw
        }

        mat[row][col]=p.Piece;
        movesMade++;
        if (winplayer(p,row,col)){
            return 1;
        }
        return 0;
    }

    public boolean winplayer(Player p,int r,int c){
        int move=0;
        if (Piece.X == p.Piece) move=-1;
        else move=1;

        col[c]+=move;
        row[r]+=move;
        if (r==c) dia+=move;
        if (r+c == len-1) revDia+=move;

        if (Math.abs(col[c]) == len ||
                Math.abs(row[r]) == len ||
                Math.abs(dia) == len ||
                Math.abs(revDia) == len)  return true;
        return false;


    }

    public void printBoard(){
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                 if (mat[i][j]!=null ) System.out.print(mat[i][j].toString()+" ");
                 else System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
