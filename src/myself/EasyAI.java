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

    public char getMark() {
        return mark;
    }

    void isX(boolean answer) {
         if (answer) {
             this.mark = 'X';
         } else {
             this.mark = 'O';
         }
    }
}
