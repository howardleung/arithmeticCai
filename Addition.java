
/**
 * This class represents an addition problem based on two operands.
 * 
 * @author Howard
 * @version January 22, 2018
 */

public class Addition extends Arithmetic{
    
    /**
     * Defaults the two operands to a random number
     * between 1-9
     */
    public Addition(){
        super();
    }
    

    
    /**
     * Returns the question in a readable format
     * 
     *  @return      the addition problem between the operands
     */ 
    @Override
    public String getQuestion(){
        return getLeftOperand() + " + " + getRightOperand() + " = ";
    }
    
    
    
    /**
     * Checks if the answer that is passed through is correct
     * 
     *  @param answer the answer that will be checked
     *  @return if the answer is correct or not
     */ 
    @Override
    public boolean checkAnswer(int answer){
        return (answer == (getLeftOperand() + getRightOperand()));
    }
    


    
    
    
    
}