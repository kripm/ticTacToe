package myself;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Player playerOne = new Player();
    static Player playerTwo = new Player();
    static EasyAI easyAI = new EasyAI();
    static EasyAI easyAII = new EasyAI();
    static MediumAI mediumAI = new MediumAI();
    static MediumAI mediumAII = new MediumAI();
    static private boolean playing = true;

    public static void main(String[] args) {
        while (playing) {
            reset();
            switch (start()) {
                case ("PVE"):
                    Board.start();
                    playerOne.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(playerOne, easyAI);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;

                case ("EVP"):
                    Board.start();
                    easyAI.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(playerOne, easyAI);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;

                case ("PVM"):
                    Board.start();
                    playerOne.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(playerOne, mediumAI);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;

                case ("MVP"):
                    Board.start();
                    mediumAI.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(playerOne, mediumAI);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;

                case ("PVP"):
                    Board.start();
                    playerOne.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(playerOne, playerTwo);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;

                case ("EVE"):
                    Board.start();
                    easyAI.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(easyAI, easyAII);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;
                case ("EVM"):
                    Board.start();
                    easyAI.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(easyAI, mediumAI);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;

                case ("MVE"):
                    Board.start();
                    mediumAI.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(easyAI, mediumAI);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;

                case ("MVM"):
                    Board.start();
                    mediumAI.isX(true);
                    while (Board.gameState == GameState.UNFINISHED) {
                        Board.play(mediumAI, mediumAII);
                    }
                    Board.gameState = GameState.UNFINISHED;
                    reset();
                    break;

                case ("EXIT"):
                    playing = false;
            }
        }

        System.exit(0);
    }

    static String start() {
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
                && args[2].equalsIgnoreCase("medium")) {
            gameMode = "PVM";
        } else if (args[2].equalsIgnoreCase("user")
                && args[1].equalsIgnoreCase("medium")) {
            gameMode = "MVP";
        } else if (args[1].equalsIgnoreCase("user")
                && args[2].equalsIgnoreCase("user")) {
            gameMode = "PVP";
        } else if (args[1].equalsIgnoreCase("easy")
                && args[2].equalsIgnoreCase("easy")) {
            gameMode = "EVE";
        }  else if (args[1].equalsIgnoreCase("easy")
                && args[2].equalsIgnoreCase("medium")) {
            gameMode = "EVM";
        }  else if (args[2].equalsIgnoreCase("easy")
                && args[1].equalsIgnoreCase("medium")) {
            gameMode = "MVE";
        } else if (args[1].equalsIgnoreCase("medium")
                && args[2].equalsIgnoreCase("medium")) {
            gameMode = "MVM";
        }
        return gameMode;
    }

    static void reset() {
        playerOne.isX(false);
        playerTwo.isX(false);
        easyAI.isX(false);
        easyAII.isX(false);
        mediumAI.isX(false);
        mediumAII.isX(false);
    }

    static String[] takeInput() {
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
                } else {
                    gotInput = true;
                }
            } catch (Exception e) {
                System.out.println("Bad parameters!");
            }
        } while (!gotInput);
        return params;
    }
}
