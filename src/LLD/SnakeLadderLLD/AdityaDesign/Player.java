package LLD.SnakeLadderLLD.AdityaDesign;

import java.util.UUID;

public class Player {
    static int idCounter = 1;
    public int playerId;
    public int position;

    public Player() {
        this.playerId = idCounter++;
        this.position = 0; // start before 1
    }

    public void updatePosition(int pos) {
        this.position = pos;
    }
}

