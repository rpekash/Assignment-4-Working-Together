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

                    if(userInput2 > 0 && userInput2 >= prices[userInput]){

                            float change = (float) (userInput2 - prices[userInput]);
                            System.out.println("Here's your change: "+ change);
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
