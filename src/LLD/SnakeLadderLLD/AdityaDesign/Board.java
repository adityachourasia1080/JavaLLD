package LLD.SnakeLadderLLD.AdityaDesign;

import java.util.ArrayDeque;
import java.util.Deque;

public class Board {

    int n;
    int totalSteps;
    Snake snake;
    Ladder ladder;
    Dice dice;
    Deque<Player> dq;

    public Board(int n) {
        this.n = n;
        this.totalSteps = n * n;
        this.snake = new Snake();
        this.ladder = new Ladder();
        this.dice = new Dice();
        this.dq = new ArrayDeque<>();
    }

    public void startGame() {
        // Two players
        Player p1 = new Player();
        Player p2 = new Player();
        dq.offerLast(p1);
        dq.offerLast(p2);

        while (true) {
            Player current = dq.pollFirst();

            System.out.println("Player " + current.playerId + " turn...");
            int diceValue = dice.roll();
            System.out.println("Dice: " + diceValue);

            int newPos = current.position + diceValue;

            if (newPos > totalSteps) {
                System.out.println("Cannot move. Need exact roll.");
                dq.offerLast(current);
                continue;
            }

            // Win condition
            if (newPos == totalSteps) {
                System.out.println("Player " + current.playerId + " WINS!");
                return; // END GAME
            }

            // Check ladder
            if (ladder.mp.containsKey(newPos)) {
                System.out.println("Ladder from " + newPos + " to " + ladder.mp.get(newPos));
                newPos = ladder.mp.get(newPos);
            }

            // Check snake
            if (snake.mp.containsKey(newPos)) {
                System.out.println("Snake from " + newPos + " to " + snake.mp.get(newPos));
                newPos = snake.mp.get(newPos);
            }

            current.updatePosition(newPos);
            System.out.println("Player " + current.playerId + " at position " + newPos);

            dq.offerLast(current);
        }
    }

    public void addLadder(int start, int end) throws Exception {
        if (start <= 0 || end <= 0 || start > totalSteps || end > totalSteps || start >= end) {
            throw new Exception("Invalid ladder range");
        }
        ladder.addLadder(start, end);
    }

    public void addSnake(int start, int end) throws Exception {
        if (start <= 0 || end <= 0 || start > totalSteps || end > totalSteps || end >= start) {
            throw new Exception("Invalid snake range");
        }
        snake.addSnake(start, end);
    }
}
