import java.util.Scanner;
public class ConnectFour {
    //Method that prints board to screen.
    public static void printBoard(char[][] array) {
for(int row = array.length -1; row>=0; row--) {
    for(int col =0; col <array[0].length;col++) {
        System.out.println(array[row][col]+ " ");
    }
}
    }

    public static void initializeBoard(char[][] array) {
    for(int row =0; row< array.length; row++) {
        for(int col=0; col<array[0].length; col++) {
            array[row][col] = '-';

        }

    }
    }
//Method that inserts chip into board.
    public static int insertChip(char[][] array, int col, char chipType) {
        for (int row = 0; row < array.length; row++) {
            if (array[row][col] == '-') {
                array[row][col] = chipType;
                return row;

            }
        }
        return -1;
    }

    //Method checks if there's a winner after a game.
    public static boolean checkIfWinner(char[][] array, int column, int row, char chipType) {
        int tracker = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][column] == chipType) {
                tracker++;
                if (tracker == 4) {
                    return true;
                }
            } else {
                tracker = 0;
            }
        }
        //For loop created to see if there are four pieces in a row to declare a winner.
        tracker = 0;
        for (int i = 0; i < array[0].length; i++) {
            if (array[row][i] == chipType) {
                tracker++;
                if (tracker == 4) {
                    return true;
                }
            } else {
                tracker = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int row;
        int col;
        //While loop created to allow for program to ask user height and length of board while user inputs are at least 4.
        while (true) {
            System.out.print("What would you like the height of the board to be? ");
            row = myScanner.nextInt();
            if (row >= 4) {
                break;
            } else {
                System.out.println("Height should be at least 4. Please try again!");
            }
        }
        while (true) {
            System.out.print("What would you like the length of the board to be? ");
            col = myScanner.nextInt();
            if (col >= 4) {
                break;
            } else {
                System.out.println("Length should be at least 4. Please try again!");
            }
        }
        //2-D array is created to allow for pieces to be stored and used in game along with prompts for user to input x and o.
        char connectFourBoard[][] = new char[row][col];
        initializeBoard(connectFourBoard);
        printBoard(connectFourBoard);
        System.out.println("Player 1 : x ");
        System.out.println("Player 2 : o ");
        int playerColumn = 0;
        char connectFourPlayers = 0;
        int tie = 0;
        int outcome = 0;
        boolean player1 = true;
        boolean winner = false;
        while (true) {
            if (player1) {
                System.out.print("Player 1:");
                connectFourPlayers = 'x';
            } else {
                System.out.print("Player 2:");
                connectFourPlayers = 'o';
            }
            System.out.print("Which column would you like to choose? ");
            playerColumn = myScanner.nextInt();

            if (playerColumn >= col ||playerColumn < 0) {
                System.out.println("Invalid option. Choose between 0 and " + (col - 1));

            } else {
                outcome = insertChip(connectFourBoard, playerColumn, connectFourPlayers);
                if (outcome == -1) {
                    System.out.println("Invalid choice. Try again.");
                } else {
                    printBoard(connectFourBoard);
                    winner = checkIfWinner(connectFourBoard, playerColumn, outcome, connectFourPlayers);
                    if (winner) {
                        if (player1) {
                            System.out.print("Player 1 won the game!");
                        } else {
                            System.out.print("Player 2 won the game!");
                        }
                        break;
                    }
                    player1 = !player1;
                    tie++;
                }
            }
            //Checks if there is a winner depending on how many pieces are in rows and columns.
            if (tie == row * col) {
                System.out.println("Draw. Nobody wins.");
                break; 
            }
        }
    }
}



