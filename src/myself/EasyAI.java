package myself;

import java.util.Random;

public class EasyAI extends AI {
    private char mark;

    void move() {
        Random rn = new Random();
        boolean moveComplete = false;
        do {
            int X = rn.nextInt(3);
            int Y = rn.nextInt(3);
            if (Board.checkPossibleMove(X, Y)) {
                Board.place(X, Y, mark);
                moveComplete = true;
            }
        } while (!moveComplete);
    }

    void isX(boolean answer) {
         if (answer) {
             this.mark = 'X';
             Board.setTurn(0);
         } else {
             this.mark = 'O';
         }
    }
}
