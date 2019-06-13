import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents an arithmetic problem based on two operands.
 * 
 * @author Howard
 * @version January 22, 2018
 */


abstract class Arithmetic{
    Scanner input = new Scanner( System.in );
    /**
     * The left operand
     */
    private int leftOperand;
    /**
     * The right operand
     */    
    private int rightOperand;
    /**
     * The user input
     */
    private int user;

    /**
     * The number of attempts made
     */
    public static int attempts = 0;
    
    /**
     * The number of attempts made
     */
    public static int question = 0;
    
    
    /**
     * Defaults the two operands to a random number
     * between 1-9
     */
    public Arithmetic(){
        setLeftOperand ((int)(Math.random() * (10 -1) + 1));
        setRightOperand((int)(Math.random() * (10 -1) + 1));

        question++;
    }
    
    /**
     *Sets the value of the left operand based on the
     * input of the user and makes sure its within the 
     * range of 1-9
     *
     * @param  operand the desired value of the operand sent by the user or constructor
     */
    public void setLeftOperand(int operand){
        if (operand > 0 && operand <10)
            leftOperand = operand;
        else{
            System.out.println("Invalid number. Defaulting left operand to 1");
            leftOperand = 1;
        }
        
    }
    
    /**
     *Sets the value of the right operand based on the
     * input of the user and makes sure its within the 
     * range of 1-9
     *
     * @param  operand the desired value of the operand sent by the user or constructor
     */
    public void setRightOperand(int operand){
        if (operand > 0 && operand <10)
            rightOperand = operand;
        else{
            System.out.println("Invalid number. Defaulting right operand to 1");
            rightOperand = 1;
        }
    }
    /**
     * Returns the value of the left operand
     * 
     *  @return      the value of the left operand
     */   
    public int getLeftOperand(){
        return leftOperand;
    }
    
    /**
     * Returns the value of the right operand
     * 
     *  @return      the value of the right operand
     */  
    public int getRightOperand(){
        return rightOperand;
    }
    
    
    /**
     * Returns the question in a readable format
     * 
     *  @return      the addition problem between the operands
     */ 
    public abstract String getQuestion();
    
    
    /**
     * Allows the user to attempt to keep answering the 
     * question until they get the answer right and keeps
     * track of how many attempts they use
     * 
     * 
     *  @return the answer to the question
     */ 
    public int getAnswer(){
        

            try{
                
                System.out.print("Q" + question+ ": " +getQuestion());
                user = input.nextInt();
                input.nextLine();
                attempts++;

            }
            catch(InputMismatchException error){
                System.err.println("PLEASE ONLY ENTER NUMBERS!");
                input.nextLine();
            }
            
        return user;
        
    }
    
    
    /**
     * Checks if the answer that is passed through is correct
     * 
     *  @param answer the answer that will be checked
     *  @return if the answer is correct or not
     */ 
    public abstract boolean checkAnswer(int answer);

    
    
    /**
     * Returns the number of attempts total
     * 
     * 
     *  @return the number of attempts total
     */  
    public static int attempts(){
        return attempts;
    }
    
        /**
     * Returns the number of the current questiion
     * 
     *  @return the number of the current question
     */ 
    public static int questionNum(){
        return question;
        
    }
    

    
    
    
    
}