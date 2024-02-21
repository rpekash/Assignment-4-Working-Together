import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingMachine{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("To use this vending machine, simply select an option, and then enter your money.");

        String[] snacks = { "Chips", "Protein Bar", "Cookies" };
        double[] prices = { 1.5, 2, 1.5 };

        System.out.println("Avaiable Snacks;");
        
        for (int i = 0; i < snacks.length;i++) {
            System.out.println((i + 1) + ": " + snacks[i] + " $" + String.format("%.2f", prices[i]));
        }
        System.out.println("Please select the number of the snack you would like");

        int selection = -1;
        do {
            try {
                int userInput = scanner.nextInt();
                if (userInput > 0 && userInput <= snacks.length) {
                    selection = userInput - 1;

                    System.out.println("Enter the number of dollar bills you would like to insert.");
                    int userInput2 = scanner.nextInt();

                    if(userInput2 > 0 && userInput2 >= prices[selection]) {

                        System.out.println("Please confirm that you would like to make this transaction (y/n)");
                        scanner.nextLine();
                        String input = scanner.nextLine();
                        while (!input.equals("y") && !input.equals("n")) {
                            System.out.println("Unrecognized input -- please try again. Enter y to confirm, n to cancel");
                            input = scanner.nextLine();
                        }
                        if (input.equals("y")) {
                            System.out.println("Here is your snack!");
                            System.out.println("WHIRRRRRRRRRR");
                            float change = (float) (userInput2 - prices[selection]);
                            if (change > 0) {
                                System.out.println("And here is your change of " + String.format("$%.2f", change));
                                System.out.println("CLUNK CLUNK CLUNK");
                            }
                            System.out.println("GREAT snack choice by the way, you have great taste! Goodbye!");
                            System.exit(0);
                        }
                        else {
                            System.out.println("Canceling Transaction...");
                            System.out.println("Returning your money. Have a great day!");
                            System.exit(0);
                        }
                    }
                    else {
                        System.out.println("Not enough money!");
                    }  

                }

                else {
                    System.out.println("Error: That number does not correspond with a snack item, please try again.");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("Error: That is not a valid number, please try again.");
                scanner.nextLine();
            }
        } while (selection < 0);


    }
}
