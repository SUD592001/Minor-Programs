import java.util.Scanner;

public class SciCalculator {
    public static void main(String[] args) {
        //Main method that displays menu and does calculations
        Scanner myScanner = new Scanner(System.in);
        double answer = 0;
        int response = 0;
        double Sum = Double.sum(answer, answer);
        int numberOfCalculations = 0;
        Sum += answer;
        System.out.println("Current Result: " + answer);
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("0. Exit Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Display Average");
        System.out.print("Enter Menu Selection: ");
        response = myScanner.nextInt();
        double result1 = 0;
        if (response == 0) {
            System.out.println("Thanks for using this calculator. Goodbye!");
        }
        //Displays appropriate messages when user chooses invalid selections or displays data when user chooses option 7.
        if (response != 0) {
            while (response != 0) {
                if (response > 7 || response < 0) {
                    System.out.println("Error: Invalid selection!");
                    System.out.print("Enter Menu Selection: ");
                    response = myScanner.nextInt();
                } else if (response == 7 && numberOfCalculations == 0) {
                    System.out.println("Error: No calculations yet to average!");
                    System.out.print("Enter Menu Selection: ");
                    response = myScanner.nextInt();
                } else if (response == 7 && numberOfCalculations != 0) {
                    double avg = (Sum / numberOfCalculations);
                    System.out.println("Sum of calculations: " + Sum);
                    System.out.println("Number of calculations: " + numberOfCalculations);
                    System.out.printf("Average of calculations: %.2f", avg);
                    System.out.println();
                    System.out.print("Enter Menu Selection: ");
                    response = myScanner.nextInt();
                }
                //If-else statements used for program to carry out mathematical operations base on user's choice.
                if (response != 7 && response != 0 && response < 7 && response > 0) {
                    //String declaration allows for user to input RESULT instead of a number to use the current result in calculation.
                    String firstRESULT = "";
                    double first = 0.0;
                    System.out.print("Enter first operand: ");
                    if (myScanner.hasNextDouble()) {
                        first = myScanner.nextDouble();
                    } else {
                        firstRESULT = myScanner.next();
                        first= Sum;
                    }
                    String secondRESULT = "";
                    double second = 0.0;
                    System.out.print("Enter second operand: ");
                    if (myScanner.hasNextDouble()) {
                        second= myScanner.nextDouble();
                    } else {
                        secondRESULT = myScanner.next();
                        second = Sum;
                    }
                    if (response == 1) {
                        double answer1 = (first + second);
                        System.out.println("Current Result: " + answer1);
                        Sum += answer1;
                        numberOfCalculations++;
                        result1 = answer1;
                    } else if (response == 2) {
                        double answer2 = (first - second);
                        System.out.println("Current Result: " + answer2);
                        Sum += answer2;
                        numberOfCalculations++;
                        result1 = answer2;
                    } else if (response == 3) {
                        double answer3 = (first * second);
                        System.out.println("Current Result: " + answer3);
                        Sum += answer3;
                        numberOfCalculations++;
                        result1 = answer3;
                    } else if (response == 4) {
                        double answer4 = (first / second);
                        System.out.println("Current Result: " + answer4);
                        Sum += answer4;
                        numberOfCalculations++;
                        result1 = answer4;
                    }
                    else if (response == 5) {
                        double answer5 = Math.pow(first, second);
                        System.out.println("Current Result: " + answer5);
                        Sum += answer5;
                        numberOfCalculations++;
                        result1 = answer5;
                    } else if (response == 6) {
                        double answer6 = Math.log(second) / Math.log(first);
                        System.out.println("Current Result: " + answer6);
                        Sum += answer6;
                        numberOfCalculations++;
                        result1 = answer6;
                    }
                    System.out.println("Calculator Menu");
                    System.out.println("---------------");
                    System.out.println("0. Exit Program");
                    System.out.println("1. Addition");
                    System.out.println("2. Subtraction");
                    System.out.println("3. Multiplication");
                    System.out.println("4. Division");
                    System.out.println("5. Exponentiation");
                    System.out.println("6. Logarithm");
                    System.out.println("7. Display Average");
                    System.out.print("Enter Menu Selection: ");
                    response = myScanner.nextInt();

                }


            }
            //If user chooses option 0 the program stops and thanks user for using calculator.
            if (response == 0)
                System.out.println("Thanks for using this calculator. Goodbye!");
        }
    }
}
