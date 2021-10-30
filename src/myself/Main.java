package myself;

public class Main {

    public static void main(String[] args) {
        Difficulty d = Difficulty.EASY;
        AI easyAI = new AI(Difficulty.EASY);

        Board.start();
        while (Board.gameState == GameState.UNFINISHED) {
            switch (d) {
                case EASY:
                    Player.move();
                    easyAI.move();
            }
        }
    }
}
