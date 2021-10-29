package myself;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[][] board = new String[3][3];
    static GameState gameState = GameState.UNFINISHED;
    static String turnMarker;

    public static void main(String[] args) {
        System.out.print("Enter the cells: ");
        createBoard(sc.nextLine().strip());
        printBoard();
        boolean possibleCords = false;
        do {
            int count = 0;
            System.out.println("Enter the coordinates: ");
            String cords = sc.nextLine().strip();
            String[] splitNumber = cords.split(" ");
            try {
                int[] numberCord = new int[splitNumber.length];
                for (String a : splitNumber) {
                    int parsedInteger = Integer.parseInt(a);
                    if (parsedInteger > 3 | parsedInteger < 1) {
                        throw new IndexOutOfBoundsException();
                    } else {
                        numberCord[count] = parsedInteger - 1;
                        count++;
                    }
                }
                if (board[numberCord[0]][numberCord[1]].equals("X") | board[numberCord[0]][numberCord[1]].equals("O")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else if (board[numberCord[0]][numberCord[1]].equals("IHATENULL")) {
                    checkTurn();
                    board[numberCord[0]][numberCord[1]] = turnMarker;
                    possibleCords = true;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        } while (!possibleCords);

        printBoard();
        gameState.check(checkWinOrDraw());
    }

    public static void createBoard(String input) {
        String[] split = input.split("");
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (split[counter].equals("_")) {
                    board[i][j] = ("IHATENULL");
                } else {
                    board[i][j] = split[counter];
                }
                counter++;
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("IHATENULL")) {
                    System.out.print("  ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void checkTurn() {
        int XCount = 0;
        int OCount = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("X")) {
                    XCount++;
                } else if (board[i][j].equals("O")) {
                    OCount++;
                }
            }
        }

        if (XCount == OCount) {
            turnMarker = "X";
        } else {
            turnMarker = "O";
        }
    }

    public static GameState checkWinOrDraw() {
        boolean isNotFull = false;

        for (String[] strings : board) {
            for (String strings1 : strings) {
                if (strings1.equals("IHATENULL")) {
                    isNotFull = true;
                    break;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            int j = 0;
            if (board[i][j].equals("X") & board[i][j + 1].equals("X") & board[i][j + 2].equals("X")) {
                return GameState.X_WIN;
            } else if (board[j][i].equals("X") & board[j + 1][i].equals("X") & board[j + 2][i].equals("X")) {
                return GameState.X_WIN;
            } else if (board[i][j].equals("O") & board[i][j + 1].equals("O") & board[i][j + 2].equals("O")) {
                return GameState.O_WIN;
            } else if (board[j][i].equals("O") & board[j + 1][i].equals("O") & board[j + 2][i].equals("O")) {
                return GameState.O_WIN;
            }
        }
        if (board[0][0].equals("X") & board[1][1].equals("X") & board[2][2].equals("X")) {
            return GameState.X_WIN;
        } else if (board[0][2].equals("X") & board[1][1].equals("X") & board[2][0].equals("X")) {
            return GameState.X_WIN;
        } else if (board[0][0].equals("O") & board[1][1].equals("O") & board[2][2].equals("O")) {
            return GameState.O_WIN;
        } else if (board[0][2].equals("O") & board[1][1].equals("O") & board[2][0].equals("O")) {
            return GameState.O_WIN;
        } else if (isNotFull){
            return GameState.UNFINISHED;
        }
        return GameState.DRAW;
    }
}

enum GameState {
    UNFINISHED,
    DRAW,
    O_WIN,
    X_WIN;

    void check (GameState gameState) {
        switch (gameState) {
            case X_WIN:
                System.out.println("X wins");
                break;
            case O_WIN:
                System.out.println("O wins");
                break;
            case DRAW:
                System.out.println("Draw");
                break;
            case UNFINISHED:
                System.out.println("Game not finished");
        }
    }
}