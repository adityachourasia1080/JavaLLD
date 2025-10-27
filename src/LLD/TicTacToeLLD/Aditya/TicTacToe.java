package LLD.TicTacToeLLD.Aditya;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class TicTacToe {
    int size;
    Board b;
    Player p1;
    Player p2;
    Deque<Player>dq;

    public TicTacToe(int size){
        PlayingPiece pi= new PlayingPieceX();
        PlayingPiece pii= new PlayingPieceO();

        this.size=size;

        p1= new Player("Player1",pi.getSymbol());
        p2= new Player("Player2",pii.getSymbol());

        dq= new ArrayDeque<>(){};
        dq.offerLast(p1);
        dq.offerLast(p2);

        b= new Board(size);

        startGame();
    }

    private void startGame(){

        boolean win=false;
        while(!win){
            b.printBoard();
            Player temp = dq.pollFirst();
            System.out.print("Player : "+ temp.userName+ " Enter i,j: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            String[] parts = input.split(",");

            int i = Integer.parseInt(parts[0].trim());
            int j = Integer.parseInt(parts[1].trim());
            int ans=b.makeMove(temp,i,j);
            if (ans==1)  {
                System.out.println("Player win : "+ temp.userName);
                win=true;
            }
            else if (ans==2)
            {
                System.out.println("Match draw");
                win=true;
            }
            else if(ans==-1){
                dq.offerFirst(temp);
            }
            else{
                dq.offerLast(temp);
            }


        }


    }
}
