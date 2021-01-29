package tictactoe;


import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static String input;
    static String[] splitCoordinates;
    static String[][] grid = new String[3][3];
    static boolean oThreeInRow;
    static boolean xThreeInRow;
    static boolean isGameFinished;
    static boolean loopFlag;
    static String currentSign = "X";

    public static void main(String[] args) {
        createEmptyGrid();
        printGrid();

        do {

            do {
                System.out.println("Enter the coordinates:");
                input = scanner.nextLine().replaceAll(" ", "");
                splitCoordinates = input.split("");

                try {
                    loopFlag = isCellEmpty();
                    if (!isCellEmpty()) {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    loopFlag = false;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    loopFlag = false;
                }

            } while (!loopFlag);

            grid[Integer.parseInt(splitCoordinates[0]) - 1][Integer.parseInt(splitCoordinates[1]) - 1] = currentSign;
            changeSign();
            printGrid();


            if ((grid[0][0].equals("O") && grid[0][1].equals("O") && grid[0][2].equals("O")) ||
                    (grid[1][0].equals("O") && grid[1][1].equals("O") && grid[1][2].equals("O")) ||
                    (grid[2][0].equals("O") && grid[2][1].equals("O") && grid[2][2].equals("O")) ||
                    (grid[0][0].equals("O") && grid[1][0].equals("O") && grid[2][0].equals("O")) ||
                    (grid[0][1].equals("O") && grid[1][1].equals("O") && grid[2][1].equals("O")) ||
                    (grid[0][2].equals("O") && grid[1][2].equals("O") && grid[2][2].equals("O")) ||
                    (grid[0][0].equals("O") && grid[1][1].equals("O") && grid[2][2].equals("O")) ||
                    (grid[0][2].equals("O") && grid[1][1].equals("O") && grid[2][0].equals("O"))) {
                oThreeInRow = true;
            } else {
                oThreeInRow = false;
            }

            if ((grid[0][0].equals("X") && grid[0][1].equals("X") && grid[0][2].equals("X")) ||
                    (grid[1][0].equals("X") && grid[1][1].equals("X") && grid[1][2].equals("X")) ||
                    (grid[2][0].equals("X") && grid[2][1].equals("X") && grid[2][2].equals("X")) ||
                    (grid[0][0].equals("X") && grid[1][0].equals("X") && grid[2][0].equals("X")) ||
                    (grid[0][1].equals("X") && grid[1][1].equals("X") && grid[2][1].equals("X")) ||
                    (grid[0][2].equals("X") && grid[1][2].equals("X") && grid[2][2].equals("X")) ||
                    (grid[0][0].equals("X") && grid[1][1].equals("X") && grid[2][2].equals("X")) ||
                    (grid[0][2].equals("X") && grid[1][1].equals("X") && grid[2][0].equals("X"))) {
                xThreeInRow = true;
            } else {
                xThreeInRow = false;
            }

            if (grid[0][0].equals(" ") ||
                    grid[0][1].equals(" ") ||
                    grid[0][2].equals(" ") ||
                    grid[1][0].equals(" ") ||
                    grid[1][1].equals(" ") ||
                    grid[1][2].equals(" ") ||
                    grid[2][0].equals(" ") ||
                    grid[2][1].equals(" ") ||
                    grid[2][2].equals(" ") ) {
                isGameFinished = false;
            } else {
                isGameFinished = true;
            }

            if (!oThreeInRow && !xThreeInRow && isGameFinished) {
                System.out.println("Draw");
            } else if (oThreeInRow) {
                System.out.println("O wins");
            } else if (xThreeInRow) {
                System.out.println("X wins");
            }

        }while (!(isGameFinished || oThreeInRow || xThreeInRow));
    }
    public static void changeSign() {
        if (currentSign.equals("X")){
            currentSign = "O";
        }else currentSign = "X";
    }
    public static void createEmptyGrid() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = " ";
            }
        }
    }

    public static void printGrid(){
        System.out.println("---------");

        for (int i = 0; i <3; i++) {
            System.out.print("| ");
            for (int j = 0; j <3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    public static boolean isCellEmpty() throws NumberFormatException, ArrayIndexOutOfBoundsException{
        return grid[Integer.parseInt(splitCoordinates[0]) - 1][Integer.parseInt(splitCoordinates[1])-1].equals(" ");
        }

}
