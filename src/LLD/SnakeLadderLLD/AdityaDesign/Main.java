package LLD.SnakeLadderLLD.AdityaDesign;



public class Main {
    public static void main(String[] args) throws Exception {

        Board board = new Board(10); // 10x10 = 100 cells

        board.addLadder(4, 25);
        board.addLadder(13, 46);
        board.addSnake(50, 6);
        board.addSnake(97, 65);

        board.startGame();
    }
}

