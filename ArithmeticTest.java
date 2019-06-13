import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class is a CAI test program thats asks the user arithmetic questions.
 * 
 * @author Howard
 * @version January 22, 2018
 */

public class ArithmeticTest{
    public static void main(String[] args) { 
        int numberOfQuestions;
        int type = 0;
        boolean keepRandom =false;
        
        
        System.out.print("How many questions would you like? (1-10)");
        numberOfQuestions = checkValid(10);
        
        do{
            
            System.out.println("What would you like to practice?");
            System.out.println("1. Addition only");
            System.out.println("2. Subtraction only");
            System.out.println("3. Multiplication only");
            System.out.println("4. Random mix (all 3 types)\nChoice: ");
            
            
            type = checkValid(4);
            
            
        }while( type == 0);
        
        
        
        
        
        for (int x = 0; x < numberOfQuestions; x++){
            
            if (type==4){
                type = (int)(Math.random() * (4 -1) + 1);
                keepRandom = true;
            }
            
            switch (type){
                case 1:
                    askQuestion(new Addition());
                    break;
                case 2:
                    askQuestion(new Subtraction());
                    break;
                case 3:     
                    askQuestion(new Multiplication());
                    break;                                      
            }
            if (keepRandom)           
                type=4;
            
            
        }
        System.out.printf("It took you " + Arithmetic.attempts() + " tries to answer " + numberOfQuestions + " questions. You got %.2f%%!",numberOfQuestions*100.0/Arithmetic.attempts() );
    }
    /**
     * Randomly returns one of 5 positive strings
     * 
     * 
     *  @return a positive string
     */
    private static String positive(){
        switch(1 + (int)(Math.random() * ((5 - 1) + 1))){
            case 1:
                return "Correct!";
            case 2:
                return "Good work!";
            case 3:
                return "Nice job!";
            case 4:
                return "Keep up the good work!";
            case 5:
                return "Brilliant!";
            default:
                return "Correct!";
        }
    }
    
    
    /**
     * Randomly returns one of 5 negative strings
     * 
     * 
     *  @return a negative string
     */
    private static String negative(){
        switch(1 + (int)(Math.random() * ((5 - 1) + 1))){
            case 1:
                return "Incorrect!";
            case 2:
                return "You can do better!";
            case 3:
                return "Sorry, try again.";
            case 4:
                return "Um.. no.";
            case 5:
                return "Not even close!";
            default:
                return "Correct!";
        }
    }
    
    
    /**
     *  Checks the unput of the user to see if the value they inputted is 
     *  of the correct type and within the given range
     * 
     *  @param max maximum number accepted for the value
     */  
    private static int checkValid (int max){
        Scanner input = new Scanner( System.in );
        int user = 0;
        do{
            try{
                user = input.nextInt();
                input.nextLine();
                if (user > 0 && user <= max)
                    return user;
                else{
                    System.err.println("Invalid input. Please enter a number between 1-" + max + ".");
                    user = 0;
                }
                
            }
            catch(InputMismatchException error){
                System.err.println("PLEASE ONLY ENTER NUMBERS!");
                input.nextLine();
                user = 0;
            }
        }while (user == 0);
        return user;
    }
    
    
    /**
     *  Prompts the user to answer the question and then checks if their answer
     *  is correct or not, and displays a message accordingly
     * 
     *  @param problem the object instantiated that contains the current problem
     */ 
    private static void askQuestion(Arithmetic problem){
        int user=0;
        do{
            user = problem.getAnswer();
            if (problem.checkAnswer(user))
                System.out.println(positive());
            else
                System.err.println(negative());
        }while(problem.checkAnswer(user)==false);
    }
    
}

