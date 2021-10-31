package myself;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean playing = true;

    public static void main(String[] args) {
        Difficulty d = Difficulty.EASY;
        EasyAI easyAI = new EasyAI();
        final Player playerOne = new Player();

        while (playing) {
            switch (start()) {
                case ("PVE"):
                    Board.start();
                    playerOne.setMark('X');
                    easyAI.setMark('O');
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(playerOne, easyAI);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    break;

                case ("EVP"):
                    Board.start();
                    easyAI.setMark('X');
                    playerOne.setMark('O');
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(playerOne, easyAI);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    break;

                case ("PVP"):
                    Player playerTwo = new Player();
                    Board.start();
                    playerOne.setMark('X');
                    playerTwo.setMark('O');
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(playerOne, playerTwo);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    break;

                case ("EVE"):
                    EasyAI easyAII = new EasyAI();
                    Board.start();
                    easyAI.setMark('X');
                    easyAII.setMark('O');
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(easyAI, easyAII);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    break;

                case ("EXIT"):
                    playing = false;
            }
        }

        System.exit(0);
    }

    public static String start() {
        String gameMode = "stillHateNull";

        String[] args = takeInput();
        if (args[0].equalsIgnoreCase("exit")) {
            gameMode = "EXIT";
        } else if (args[1].equalsIgnoreCase("user")
                && args[2].equalsIgnoreCase("easy")) {
            gameMode = "PVE";
        } else if (args[2].equalsIgnoreCase("user")
                && args[1].equalsIgnoreCase("easy")) {
            gameMode = "EVP";
        } else if (args[1].equalsIgnoreCase("user")
                && args[2].equalsIgnoreCase("user")) {
            gameMode = "PVP";
        } else if (args[1].equalsIgnoreCase("easy")
                && args[2].equalsIgnoreCase("easy")) {
            gameMode = "EVE";
        }
        return gameMode;
    }

    public static String[] takeInput() {
        boolean gotInput = false;
        String[] params = null;
       do {
            try {
                System.out.print("Input command: ");
                String input = sc.nextLine();
                params = input.split(" ");
                if (params[0].equals("exit")) {
                    gotInput = true;
                } else if (params[0].equalsIgnoreCase("start") & (params.length > 3 | params.length < 3)) {
                    throw new Exception();
                } else if (params[0].equals("start") & params[1].equals("user")
                        | params[1].equals("easy") | params[2].equals("user") | params[2].equals("easy")) {
                    gotInput = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Bad parameters!");
            }
        } while (!gotInput);
        return params;
    }
}
