package Projects;

import java.util.Scanner;

public class NumberGuessingGame {
    static int randomNumber;
    static int userNumber;
    static int attempt = 1;
    static void gameInstruction(){
        System.out.print("Game instructions:\n\tA random number stored between 1 to 100 and your objective is to guess that number,\n\tif your guess is accurate then you win otherwise there is a hint for you to win.\n\tFor quit the game you enter -1. Press enter to continue: ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("--------------Game Starts Now!!!--------------");
    }
    static void randomNUmberGenerator(){
        int min = 1; // Minimum value of range
        int max = 100; // Maximum value of range
        // Generate random int value from min to max
        randomNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
    static void userInputResult(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Attempt#"+ attempt);
        System.out.print("Guess that number: ");
        userNumber = sc.nextInt();
        if(userNumber==-1){
            System.out.println("Game quit and that random number is " + randomNumber);
            System.out.println("--------------Thanks!!!--------------");
            return;
        }
        else if (userNumber == randomNumber) {
            System.out.println("You won!, your guess is accurate.");
            System.out.println("--------------Thanks!!!--------------");
            return;
        }
        else if (userNumber < randomNumber) {
            System.out.println("Oops, your guess is less than that number.");
        }
        else {
            System.out.println("Oops, your guess is greater than that number.");
        }
        attempt = attempt+1;
        userInputResult();
    }
    public static void main(String[] args) {
        gameInstruction();
        randomNUmberGenerator();
        userInputResult();
    }
}

