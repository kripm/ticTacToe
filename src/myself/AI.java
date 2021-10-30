package myself;

import java.util.Random;

class AI {
    static Random rn = new Random();
    private Difficulty d;
    private char mark;

    AI (Difficulty d) {
        this.d = d;
    }

    void move() {
        boolean moveComplete = false;
        switch (this.d) {
            case EASY:
                do {
                    int X = rn.nextInt(3);
                    int Y = rn.nextInt(3);
                    if (Board.checkPossibleMove(X, Y)) {
                        Board.place(X, Y, mark);
                        moveComplete = true;
                    }
                } while (!moveComplete);
        }
    }
    
    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {
        this.mark = mark;
    }
}
