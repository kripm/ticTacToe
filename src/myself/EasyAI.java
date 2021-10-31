package myself;

import java.util.Random;

public class EasyAI extends AI {
    static Random rn = new Random();
    private char mark;

    void move() {
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

    public void setMark(char mark) {
        this.mark = mark;
    }
}
