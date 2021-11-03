package myself;

import java.util.Random;

public class EasyAI extends AI {
    private char mark;

    void move() {
        Random rn = new Random();
        boolean moveComplete = false;
        do {
            int square = rn.nextInt(9);
            if (Board.checkPossibleMove(square)) {
                Board.place(square, mark);
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
