package myself.game;

import java.util.Random;

public class EasyAI implements AI {
    Random rn = new Random();
    private char mark;

    public void move() {
        boolean moveComplete = false;
        do {
            int square = rn.nextInt(9);
            if (Board.checkPossibleMove(square)) {
                Board.place(square, mark);
                moveComplete = true;
            }
        } while (!moveComplete);
    }

    public void isX(boolean answer) {
        if (answer) {
            this.mark = 'X';
        } else {
            this.mark = 'O';
        }
    }
}
