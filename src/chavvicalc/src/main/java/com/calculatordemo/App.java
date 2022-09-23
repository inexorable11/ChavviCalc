package com.calculatordemo;

import java.util.*;

import javax.lang.model.util.ElementScanner14;

/*
 * chavvi calc calculator
 */
public class App {

  public static void additionFunction(double x, double y){
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter value for A: ");
    double num1 = myObj.nextDouble();
    System.out.println("Enter value for B: ");
    double num2 = myObj.nextDouble();
    myObj.close();
  };



  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Character command = '_';

    // loop until user quits
    while (command != 'q') {
      printMenu();
      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);

      executeCommand(scan, command);
    }

    scan.close();
  }

  //
  // menu functions
  //
  private static void printMenuLine() {
    System.out.println(
      "----------------------------------------------------------"
    );
    
  }

  private static void printMenuCommand(Character command, String desc) {
    System.out.printf("%s\t%s\n", command, desc);
  }   
  // prints the menu
  public static void printMenu() {
    printMenuLine();
    System.out.println("Chavvi Calc");
    printMenuLine();
    long A = 0;
    System.out.println("A = "+ A);
    printMenuCommand('A', "Enter a value for A");
    printMenuCommand('B', "Enter a value for B");
    printMenuCommand('+',"Addition");
    printMenuCommand('-',"Subtraction");
    printMenuCommand('*', "Multiply");
    printMenuCommand('/',"Divide");
    printMenuCommand('c',"Clear");
    printMenuCommand('q', "Quit");
    printMenuLine();

  }

  // get first character from input
  private static Character menuGetCommand(Scanner scan) {
    Character command = '_';

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      command = rawInput.charAt(0);
    }

    return command;
  }

  // calculator functions
  private static Boolean executeCommand(Scanner scan, Character command) {
    Boolean success = true;

    switch (command) {
      case 'q':
        System.out.println("Thank you for using Chavvi Calc");
        break;
      case '+':
        System.out.printf("%.3f + %.3f = %.3f", num1, num2,(num1+num2));
      break;
      case '-':
        System.out.printf("%.3f - %.3f = %.3f", num1, num2,(num1-num2));
        break;
      case '*':
        System.out.printf("%.3f * %.3f - %.3f",num1, num2,(num1*num2));
      case '/':
        if(num2 != 0)
          System.out.printf("%.3f / %.3f = %.3f", num1, num2,(num1/num2));
        else
          System.out.println("Cannot divide by zero");
      default:
        System.out.println("ERROR: Unknown commmand");
        success = false;
    }

    return success;
  }

}
