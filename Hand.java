
/**
 * The Hands
 * 
 * @author (Kong) 
 * @version (9.26.17)
 */
import java.lang.Math;
public class Hand
{
    //Fields
    private int card1;
    private int card2;
    private int newCard;
    private int total;
    private int numInHand;

    //Constructor
    public Hand(){
        card1 = getRam();
        card2 = getRam();
        newCard = getRam();
    }

    //Accessor Methods
    public int getCard1(){
        return card1;
    }
    public int getCard2(){
        return card2;
    }
    public int getNew(){
        return newCard;
    }
    public int getRam(){
        double num = Math.random();
        int ram = (int) (num * 10);
        return ram;
    }
    
    // Mutator Methods 
    public void Hit(){
        double num = Math.random();
        newCard = (int) (num *10);
    }
    

}

 
