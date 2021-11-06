package myself;

import java.util.Random;

public class EasyAI extends AI {
    Random rn = new Random();
    private char mark;
    
    void move() {
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
         } else {
             this.mark = 'O';
         }
    }
}
