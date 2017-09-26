
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;


public class Calculate {
    /** calculations on Roman numerals and prints the results **/
    public static void calculate(String leftNumber, String operation, String rightNumber)throws FileNotFoundException {

        boolean numberValid = true;
        boolean operationValid = true;
        int leftRoman, rightRoman;
        int resultRoman = 0;

        leftRoman = RomanNumerals.parse(leftNumber.toUpperCase());
        rightRoman = RomanNumerals.parse(rightNumber.toUpperCase());

        //if input is not a roman numeral
        if (leftRoman == -1) {
        	numberValid = false;
            System.out.println("invalid number: " + leftNumber);
        }
        if (rightRoman == -1) {
        	numberValid = false;
            System.out.println("invalid number: " + rightNumber);
        }
        if (operation.equals("+") || operation.equals("-") || operation.equals("*") ||
                operation.equals("/") || operation.equals("%") || operation.equals("#")) {
        	operationValid = true;
        } else {
        	operationValid = false;
            System.out.println("invalid operation");
        }

        //the operation if input is valid
        if (numberValid == true && operationValid == true) {	
            //Addition
            if (operation.equals("+")) {
                resultRoman = leftRoman + rightRoman;
            }
            //Subtraction
            else if (operation.equals("-")) {
                resultRoman = leftRoman - rightRoman;
            }
            //Multiplication
            else if (operation.equals("*")) {
                resultRoman = leftRoman * rightRoman;
            }
            //Division
            else if (operation.equals("/")) {
                resultRoman = leftRoman / rightRoman;
            }
            //Modulo
            else if (operation.equals("%")) {
                resultRoman = leftRoman % rightRoman;
            }
            //Average
            else if (operation.equals("#")) {
                resultRoman = (leftRoman + rightRoman)/2;
            }
           
            if(numberValid && operationValid) {
                // If result is in range.
                if (resultRoman <= 0 || resultRoman >= 4000) {
                    System.out.println("result out of range");
                } else {
                    System.out.println(RomanNumerals.format(resultRoman));
                }
            }
        }
    }
    
    /**Read input from textfile **/
    public static void main(String[] args) throws IOException {
    	
    	String operation, leftNumber, rightNumber;	
    	File text = new File("example.txt");
    	
        try {
            Scanner scanner = new Scanner(text);
            
            while (scanner.hasNextLine()) {
            	// Formats and displays the result
            	System.out.print("> ");
            	leftNumber = scanner.next();
                operation = scanner.next();
                rightNumber = scanner.next();

                calculate(leftNumber, operation, rightNumber);
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
