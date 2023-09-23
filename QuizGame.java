package Projects;
import java.util.Scanner;
class Questions{
    String [] que;
    char [] cOpt;
    int qNo;
    int index;
    int score;
    Questions(){
        this.que = new String[10];
        this.cOpt = new char[que.length];
        this.qNo = 1;
        this.index = 0;
        this.score = 0;
        instructions();
        displayQuestions();
        quizEnd();

    }
    void instructions(){
        System.out.print("Note:\n\tTotal 10 MCQs will be shown. First read carefully the questions then pick " +
                "an answer key(i.e. a,b,c or d)\n\tand put in the input as per regarding question." +
                "\n\tPress enter to  continue: ");
        runProgram();
    }
    void runProgram(){
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println();
        System.out.println("       -------Multiple Choice Questions-------       ");
        multipleChoiceQuestions();
        correctOptions();
    }
    void multipleChoiceQuestions(){
        que[0] = "Q1: Which force pulls objects with mass toward each other?\n\ta) Force of friction\t b) Gravitational force\t c) Strong force\t d) none of these";
        que[1] = "Q2: Some months have 31 days. Some have 30. How many have 28?\n\ta) 2\tb) 6\tc) 12\td) none";
        que[2] = "Q3: Who invented Java Programming?\n\ta) Guido van Rossum\tb) James Gosling\tc) Bjarne Stroustrup\td) Dennis Ritchie";
        que[3] = "Q4: If yesterday was Monday then what will be the day after tomorrow?\n\ta) Thursday\tb) Monday\tc) Friday\td) Wednesday";
        que[4] = "Q5: Which component is used to compile, debug and execute the java programs?\n\ta) JRE\tb) JIT\tc) JVM\td) JDK";
        que[5] = "Q6: If 15th of this month is Friday what was the day at 1th of this month?\n\ta) Friday\tb) Saturday\tc) Sunday\td) Tuesday";
        que[6] = "Q7: Which of these cannot be used for a variable name in Java?\n\ta) identifier & keyword\tb) identifier\tc) keyword\td) none of the mentioned";
        que[7] = "Q8: What is the extension of java code files?\n\ta) .js\tb) .java\tc) .class\td) .txt";
        que[8] = "Q9: What will be the output of the following Java code?\n\t" +
                "class increment {\n" +
                "        public static void main(String args[]) \n" +
                "        {        \n" +
                "             int g = 3;\n" +
                "             System.out.print(++g * 8);\n" +
                "        } \n" +
                "    }\n\t" +
                "a) 24\tb) 32\tc) 33\td) 25";
        que[9] = "Q10: Which of the following is not an OOPS concept in Java?\n\ta) Polymorphism\tb) Inheritance\tc) Compilation\td) Encapsulation";
    }
    void correctOptions(){
        cOpt[0] = 'b';
        cOpt[1] = 'c';
        cOpt[2] = 'b';
        cOpt[3] = 'a';
        cOpt[4] = 'd';
        cOpt[5] = 'a';
        cOpt[6] = 'c';
        cOpt[7] = 'b';
        cOpt[8] = 'b';
        cOpt[9] = 'c';
    }
    void displayQuestions(){
        for (String str: que) {
            System.out.println(str);
            userAnswer();
        }
    }
    void userAnswer(){
        if (qNo<=que.length) {
            char ans;
            do {
                Scanner sc = new Scanner(System.in);
                System.out.print("Your answer key for Q" + qNo + ": ");
                ans = sc.next().charAt(0);
            } while (!isAnsValid(ans));
            checkAnswers(ans);
            qNo += 1;
        }
    }
    boolean isAnsValid(char ans){
        if(ans=='a' || ans=='b' || ans=='c' || ans=='d'){
            return true;
        }
        else {
            System.out.println("-------Invalid choose-------");
            System.out.print("Enter again,");
            return false;
        }
    }
    void checkAnswers(char ans){
        if (ans == cOpt[index]) {
            System.out.println("Correct option.");
            score += 1;
        } else {
            System.out.println("Wrong option, correct option is '" + cOpt[index] + "'." );
        }
        index += 1;
    }
    void quizEnd(){
        System.out.println("_________________________________________");
        System.out.println("Quiz End!!!");
        System.out.println("You scored "+score+" marks out of 10.");
        System.out.println("-------Thanks-------");
    }
}
public class QuizGame {
    public static void main(String[] args) {
        new Questions();
    }
}
