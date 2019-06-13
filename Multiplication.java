
/**
 * This class represents an multiplication problem based on two operands.
 * 
 * @author Howard
 * @version January 22, 2018
 */

public class Multiplication extends Arithmetic{
    
    
    /**
     * Defaults the two operands to a random number
     * between 1-9
     */
    public Multiplication(){
        super();
    }
    
    
    /**
     * Returns the question in a readable format
     * 
     *  @return      the addition problem between the operands
     */ 
    @Override
    public String getQuestion(){
        return getLeftOperand() + " x " + getRightOperand() + " = ";
    }
    
    
    
    /**
     * Checks if the answer that is passed through is correct
     * 
     *  @param answer the answer that will be checked
     *  @return if the answer is correct or not
     */ 
    @Override
    public boolean checkAnswer(int answer){
        return (answer == (getLeftOperand() * getRightOperand()));
    }
    
    
    
    
    
}