package Projects;

import java.util.Scanner;

class Battle{
    int computerDecision;
    int playerDecision;
    int totalBattles;
    int totalWinnings;
    Battle(){
        this.totalBattles = 0;
        this.totalWinnings = 0;
        rules();
        playerInput();
    }
    void rules(){
        System.out.println("--------------ROCK PAPER SCISSORS GAME--------------");
        System.out.print("Instructions:\n\tIn rock paper scissors game, a rock beats scissors, " +
                "scissors beat paper by cutting it,\n\tand paper beats rock by covering it. " +
                "This game allows the user to battle against the computer.\n\t" +
                "Key symbols for rock is 1, paper is 2, and scissors is 3." +
                "You objective is to choose one symbol\n\tand input its key on your turn. " +
                "For quit the game input 0 in the symbol.\n\tPress enter to start the battle: ");
        startBattle();
    }
    void startBattle(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("\nBattle Start, Good Luck!!!");
        System.out.println("_____________________________________________________________");
    }
    void computerGuess(){
        int min = 1; // Minimum value of range
        int max = 3; // Maximum value of range
        // Generate random int value from min to max
        computerDecision = (int)Math.floor(Math.random() * (max - min + 1) + min);
        switch (computerDecision){
            case 1:
                System.out.println("Computer guess: rock");
                break;
            case 2:
                System.out.println("Computer guess: paper");
                break;
            case 3:
                System.out.println("Computer guess: scissors");
                break;
        }
        checkWinLoose();
    }
    void playerInput(){
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose your symbol: ");
            playerDecision = sc.nextInt();
            switch (playerDecision){
                case 1:
                    System.out.println("You choose: rock");
                    break;
                case 2:
                    System.out.println("You choose: paper");
                    break;
                case 3:
                    System.out.println("You choose: scissors");
                    break;
                case 0:
                    System.out.println("\nGame quit!!!");
                    System.out.println("You won "+ totalWinnings+ " battles out of "+ totalBattles+" battles");
                    System.out.println("-------Thanks For Playing-------");
                    return;
            }
        } while (!isValidInput());
        totalBattles++;
        computerGuess();
        playerInput();
    }
    boolean isValidInput(){
        if(playerDecision<0 || playerDecision>3){
            System.out.print("Invalid Input, again ");
            return false;
        }
        else return true;
    }
    void checkWinLoose(){
        if(playerDecision==computerDecision){
            System.out.println("Nobody win this battle!!!");
        }
        else if (playerDecision==1 && computerDecision==2){
            System.out.println("You loose this battle!!!");
        }
        else if (playerDecision==1 && computerDecision==3){
            System.out.println("You won this battle!!!");
            totalWinnings++;
        }
        else if (playerDecision==2 && computerDecision==1){
            System.out.println("You won this battle!!!");
            totalWinnings++;
        }
        else if (playerDecision==2 && computerDecision==3){
            System.out.println("You loose this battle!!!");
        }
        else if (playerDecision==3 && computerDecision==1){
            System.out.println("You loose this battle!!!");
        }
        else if (playerDecision==3 && computerDecision==2){
            System.out.println("You won this battle!!!");
            totalWinnings++;
        }
    }
}
public class RockPaperScissorsGame {
    public static void main(String[] args) {
        new Battle();
    }
}
