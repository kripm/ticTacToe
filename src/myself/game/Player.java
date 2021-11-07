package myself.game;

import java.util.InputMismatchException;
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
                } else if (square < 0 || square > 8) {
                    throw new IndexOutOfBoundsException();
                } else {
                    Board.place(square, mark);
                    validInput = true;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 0 to 8!");
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                sc.next(); // thank you stack overflow.
            } catch (Exception e) {
                System.out.println("Unknown error.");
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
