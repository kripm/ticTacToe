package myself;

import java.util.Random;

class AI {
    static Random rn = new Random();
    private Difficulty d;

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
                        Board.place(X, Y);
                        moveComplete = true;
                    }
                } while (!moveComplete);
        }
    }
}
