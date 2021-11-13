package myself.game;

public class Player {
    private char mark;

    public boolean move(int tile) {
        if (Board.getMarkAt(tile - 1) == ' ') {
            Board.place(tile - 1, mark);
            return true;
        }
        return false;
    }

    public void isX(boolean answer) {
        if (answer) {
            this.mark = 'X';
        } else {
            this.mark = 'O';
        }
    }
}
