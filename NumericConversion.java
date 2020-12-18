import java.util.Scanner;
public class NumericConversion {
    //Displays menu to screen for user to see.
    public static void displayMenu() {
        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.println();
    }
    public static int userOption(Scanner scanner) {
        int menuSelection;
        System.out.print("Please enter an option: ");
        menuSelection = scanner.nextInt();
        return menuSelection;
    }
    public static String convertNumericString(Scanner myScanner) {
        String numericInput;
        System.out.print("Please enter the numeric string to convert: ");
        numericInput = myScanner.next();
        return numericInput;
    }
    //Decodes hexadecimal value inputted by user to decimal value.
    public static short hexCharDecode(char digit) {
        short output = 0;
        if (digit - '0' <= 9) {
            output = (short) (digit - '0');
        } else if (digit == 'a') {
            output = 10;
        } else if (digit == 'b') {
            output = 11;
        } else if (digit == 'c') {
            output = 12;
        } else if (digit == 'd') {
            output = 13;
        } else if (digit == 'e') {
            output = 14;
        } else if (digit == 'f') {
            output = 15;
        }
        return output;
    }
    //Methods convert hexadecimal value to decimal value.
    public static long hexStringDecode(String hex) {
        long output = 0;
        short charSequence;
        int exponent = 0;
        String hexDecode = hex.toLowerCase();
        char[] hexString = hexDecode.toCharArray();
        for (int i = hexString.length - 1; i >= 0; i--) {
            charSequence = hexCharDecode(hexString[i]);
            output += Math.pow(16, exponent) * charSequence;
            exponent++;
        }
        return output;
    }
    //Binary input from user is converted to decimal value.
    public static short binaryStringDecode(String binary) {
        short output = 0;
        int exponent = 0;
        boolean preRun = true;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (preRun) {
                if (binary.substring(i).compareTo("1") == 0) {
                    output += Math.pow(2, exponent);
                }
                preRun = false;
            } else {
                if (binary.substring(i, i + 1).compareTo("1") == 0) {
                    output += Math.pow(2, exponent);
                }
            }
            exponent++;
        }
        return output;
    }
    //Converts binary input by user to hexadecimal value.
    public static String binaryToHex(String binary) {
        String output = "";
        short binaryDecimal;
        char[] hexLetters = {'F', 'E', 'D', 'C', 'B', 'A'};
        int decimalRemainder;
        binaryDecimal = binaryStringDecode(binary);
        while (binaryDecimal > 0) {
            decimalRemainder = binaryDecimal % 16;
            //Checks to see if hex value should be a number or letter.
            if (decimalRemainder > 9) {
                output = hexLetters[15 - decimalRemainder] + output;
            } else {
                output =decimalRemainder + output;
            }
            binaryDecimal /= 16;
        }
        return output;
    }
    public static void main (String[] args){
        //Method declaration for calling other methods.
        int menuChoice;
        String numericStringInput;
        short outputBinary;
        long outputHex;
        String outputBinaryHex;
        Scanner myScanner = new Scanner(System.in);
        displayMenu();
        menuChoice = userOption(myScanner);
        //While loop used to keep program running until user chooses to quit.
        while (menuChoice != 0) {
            //Switch statements for deciding which method to access based on user input.
            switch (menuChoice) {
                case 1:
                    numericStringInput = convertNumericString(myScanner);
                    outputHex = hexStringDecode(numericStringInput);
                    System.out.println("Result: "+outputHex);
                    System.out.println();
                    break;
                case 2:
                    numericStringInput = convertNumericString(myScanner);
                    outputBinary = binaryStringDecode(numericStringInput);
                    System.out.println("Result: "+outputBinary);
                    System.out.println();
                    break;
                case 3:
                    numericStringInput = convertNumericString(myScanner);
                    outputBinaryHex= binaryToHex(numericStringInput);
                    System.out.println("Result: "+outputBinaryHex);
                    System.out.println();
                    break;
                case 4:
                    menuChoice = 0;
                    System.out.println("Goodbye!");
                    break;
                default:
            }
            if (menuChoice != 0) {
                displayMenu();
                menuChoice = userOption(myScanner);
            }
        }
    }
}










