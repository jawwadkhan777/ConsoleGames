package Projects;

import java.util.Arrays;
import java.util.Scanner;

class GameProcedure{
    char [][] gameSheet;
    char boxMark;
    GameProcedure(){
        gameSheet = new char[3][3];
        instructions();
        initializeGameSheet();
        displayGameSheet();
    }
    void instructions(){
        System.out.println("--------------Tic Tac Toe Game--------------");
        System.out.print("Objective: The objective of Tic Tac Toe is to be the first player to form a line of three of your own\n" +
                "(X for first player and O for second player) horizontally, vertically, or diagonally on the game sheet.\n" +
                "Note: The game continues until one player wins or the sheet is filled. You input the box number\n(box numbers from 1 to 9 according to row wise) where you want to put your mark.\n" +
                "Winning: A player wins when they have three of their symbols in a row (horizontally, vertically, or diagonally)\nor when all the boxes are filled, resulting in a draw.\n" +
                "Press enter to start the game: ");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("-------Game Sheet-------");
    }
    void initializeGameSheet(){
        for (char[] chars : gameSheet) {
            Arrays.fill(chars, ' ');
        }
    }
    void displayGameSheet(){
        System.out.println("_____________");
        for (char[] chars : gameSheet) {
            System.out.print("| ");
            for (char Char : chars) {
                System.out.print(Char + " | ");
            }
            System.out.println();
        }
        System.out.println("_____________");
    }
    void placeMark(int boxNo){
        switch (boxNo){
            case 1:
                if (gameSheet[0][0]==' ') {
                    gameSheet[0][0] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
            case 2:
                if (gameSheet[0][1]==' '){
                    gameSheet[0][1] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
            case 3:
                if (gameSheet[0][2]==' '){
                    gameSheet[0][2] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
            case 4:
                if (gameSheet[1][0]==' '){
                    gameSheet[1][0] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
            case 5:
                if (gameSheet[1][1]==' '){
                    gameSheet[1][1] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
            case 6:
                if (gameSheet[1][2]==' '){
                    gameSheet[1][2] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
            case 7:
                if (gameSheet[2][0]==' '){
                    gameSheet[2][0] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
            case 8:
                if (gameSheet[2][1]==' '){
                    gameSheet[2][1] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
            case 9:
                if (gameSheet[2][2]==' '){
                    gameSheet[2][2] = boxMark;
                }
                else {
                    System.out.print("Already fill, again ");
                    playersDecision();
                }
                break;
        }
    }
    void playersDecision (){
        int boxNo;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("box no for mark: ");
            boxNo = sc.nextInt();
        } while (!isValidBox(boxNo));
        placeMark(boxNo);
        displayGameSheet();
    }
    boolean isValidBox(int boxNo){
        if (boxNo<1 || boxNo>9){
            System.out.print("Invalid box, again ");
            return false;
        }
        return true;
    }
     boolean winConditions(){
        //column wise checking
        for(int j=0; j<gameSheet.length; j++){
            if (gameSheet[0][j]!=' ' && gameSheet[0][j]==gameSheet[1][j] && gameSheet[1][j]==gameSheet[2][j]){
                return true;
            }
        }
        //row wise checking
         for (char[] chars : gameSheet) {
             if (chars[0] != ' ' && chars[0] == chars[1] && chars[1] == chars[2]) {
                 return true;
             }
         }
        //diagonal wise checking
         return gameSheet[0][0] != ' ' && gameSheet[0][0] == gameSheet[1][1] && gameSheet[1][1] == gameSheet[2][2] || gameSheet[0][2] != ' ' && gameSheet[0][2] == gameSheet[1][1] && gameSheet[1][1] == gameSheet[2][0];
     }
}
class Object extends GameProcedure {
    String player1;
    String player2;
    Object(){
        playerName();
        playerTurns();
    }
    GameProcedure p1; //object of player 1
    GameProcedure p2; //object of player 2
    GameProcedure currentPlayer; //object of player turn
    void playerName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("First player name: ");
        player1 = sc.next();
        System.out.print("Second player name: ");
        player2 = sc.next();
    }
    void playerTurns(){
        currentPlayer = p1;
        while (true) {
            currentPlayer = p1;
            System.out.println(player1 + " turn");
            boxMark = 'X';
            playersDecision();
            if (gameSheet[0][0]!=' ' && gameSheet[0][1]!=' ' && gameSheet[0][2]!=' ' && gameSheet[1][0]!=' ' && gameSheet[1][1]!=' ' && gameSheet[1][2]!=' ' && gameSheet[2][0]!=' ' && gameSheet[2][1]!=' ' && gameSheet[2][2]!=' ') {
                System.out.println("Game Tie, nobody win. Try Again!!!");
                System.out.println("-------Thanks-------");
                break;
            }
            if (winConditions()){
                System.out.println(player1 + " won!!!");
                System.out.println("-------Thanks-------");
                break;
            }
            currentPlayer = p2;
            System.out.println(player2 + " turn");
            boxMark = 'O';
            playersDecision();
            if (winConditions()){
                System.out.println(player2 + " won!!!");
                System.out.println("-------Thanks-------");
                break;
            }
        }
    }
}
public class TicTacToeGame {
    public static void main(String[] args) {
        new Object();
    }
}
