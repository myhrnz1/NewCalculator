import java.util.Scanner;
import java.util.InputMismatchException;

public class NewCalculator {
  private static double firstNumber = 0;
  private static double secondNumber = 0;
  private static double answer = 0;
  private static String operator = "-1";

  static Scanner scan = new Scanner(System.in);

  public NewCalculator() {
    firstNumber = 0;
    secondNumber = 0;
    answer = 0;
    operator = "-1";
  }

  public static void add(){
   answer = firstNumber + secondNumber;
  }
  
  public static void sub(){
    answer = firstNumber - secondNumber;
  }

  public static void mult(){
    answer = firstNumber * secondNumber;
  }

  public static void div(){
    answer = firstNumber / secondNumber;
  }

  private static double enterDouble(){
    double input = 0;
    boolean error = true;
    System.out.print("Enter number: ");
    while(error) {
      try {
        input = scan.nextDouble();
        error = false;
      }
      catch (InputMismatchException e) {
        System.out.println("Input is not a double");
        scan.next(); // clear scanner
      }
    }
  return input;
  }

  private static void enterOperator(){
    while(!(operator.equals("+") || operator.equals("-") || 
             operator.equals("*") || operator.equals("/"))) {
      System.out.print("Enter operator: ");
      operator = scan.next();
    }
  }

  private static void printResult(){
    System.out.println("The answer is: " + answer);
  }

  private static void printInstructions(){
    System.out.println("Step 1: Enter a number.");
    System.out.println("Step 2: Enter an operator.");
    System.out.println("Step 3: Enter a number.");
  }

  public static double getFirstNumber() {
    return firstNumber;
  }

  public static void setFirstNumber(double input) {
    firstNumber = input;
  }
  
  public static double getSecondNumber() {
    return secondNumber;
  }

  public static void setSecondNumber(double input) {
    secondNumber = input;
  }

  public static double getAnswer() {
    return answer;
  }

  public static void setAnswer(double input) {
    answer = input;
  }

  public static String getOperator() {
    return operator;
  }

  public static void setOperator(String input) {
    operator = input;
  }

  public static void main(String[] args) {
    printInstructions();
    
    String quit = "n";
    
    while(!quit.equals("y")) {
      firstNumber = enterDouble();
      enterOperator();
      secondNumber = enterDouble();
      if ( !(operator.equals("/") && secondNumber == 0) ){
        if ( operator.equals("+") ) {
          add(); 
        } else if ( operator.equals("-") ) {
          sub();
        } else if ( operator.equals("*") ) {
          mult();
        } else if ( operator.equals("/") ) {
          div();
        }
        printResult();
      } else {
        System.out.println("You are dividing by zero! Try again!");
      }
      System.out.println("Quit? 'y' for yes");
      quit = scan.next();
      operator = "-1";
    }
  }
}