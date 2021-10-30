package myself;

import java.util.Scanner;

public class Player {
    static Scanner sc = new Scanner(System.in);

    public static void move() {

        boolean validInput = false;
        while (!validInput) {
            try {
                int count = 0;
                System.out.println("Enter the coordinates: ");
                String cords = sc.nextLine().strip();
                String[] splitNumber = cords.split(" ");
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
                if (!Board.checkPossibleMove(numberCord[0], numberCord[1])) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    Board.place(numberCord[0], numberCord[1]);
                    validInput = true;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}

