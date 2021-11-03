package myself;

import java.util.Scanner;

public class Player {
    private char mark;
    static Scanner sc = new Scanner(System.in);

    void move() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter the square number: ");
                int square = sc.nextInt();
                if (!Board.checkPossibleMove(square)) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    Board.place(square, mark);
                    validInput = true;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }


    void isX(boolean answer) {
        if (answer) {
            this.mark = 'X';
        } else {
            this.mark = 'O';
        }
    }
}

