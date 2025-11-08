package LLD.TicTacToeLLD.Aditya;

public class  Player {
    String userName;
    Piece Piece;

    public Player(String Username,Piece p){
        this.Piece=p;
        this.userName=Username;
    }

    public String getUserName() {
        return userName;
    }
}
