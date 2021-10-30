package myself;

public class Main {

    public static void main(String[] args) {
        Difficulty d = Difficulty.EASY;
        AI easyAI = new AI(Difficulty.EASY);
        AI easyAI = new AI(Difficulty.EASY, 'X');
        Player playerOne = new Player('O');

        Board.start();
        while (Board.gameState == GameState.UNFINISHED) {
            Board.play(playerOne, easyAI);
        }
    }
}
