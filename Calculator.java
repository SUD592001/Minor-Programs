import java.util.Scanner;
public class Calculator {
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    double firstOperand = 0; //Declare variables for operands inputted by user.
    double secondOperand = 0;
    int response=0;
    double sum = 0;
    System.out.print("Enter first operand: ");
    firstOperand = in.nextDouble();
    System.out.print("Enter second operand: ");
    secondOperand = in.nextDouble();
System.out.println("Calculator Menu"); //Print options menu to screen.
System.out.println("---------------");
System.out.println("1. Addition");
System.out.println("2. Subtraction");
System.out.println("3. Multiplication");
System.out.println("4. Division");
System.out.println("Which operation do you want to perform?");
response = in.nextInt();
if(response ==1) {
    sum = firstOperand + secondOperand;
    System.out.println("The result of the operation is " + sum + ". Goodbye!");
}
else if(response ==2) {
    sum = firstOperand - secondOperand;
    System.out.println("The result of the operation is " + sum + ". Goodbye!");
}
else if(response ==3) {
    sum = firstOperand * secondOperand;
    System.out.println("The result of the operation is " +sum + ". Goodbye!");
}
else if(response ==4) {
    sum = firstOperand / secondOperand;
    System.out.println("The result of the operation is " + sum + ". Goodbye!");
}
else {
    System.out.println("Error: Invalid selection! Terminating program. "); //Error message printed to screen if user inputs invalid option.
    }



}




}

