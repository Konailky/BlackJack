
/**
 * The Main Game
 * 
 * @author (Kong) 
 * @version (9.26.17)
 */
import java.util.Scanner;
import java.lang.Math;
public class Game
{
    public static void main(){
        Scanner scanner = new Scanner (System.in);
        int money = 15;//I tried to incorporate a game like how lucky 7's was....Each game may take a while to complete long...
        while (money > 0){
            Hand player = new Hand();
            Hand dealer = new Hand();
            int playerTotal = (player.getCard1() + player.getCard2());
            int dealerTotal = (dealer.getCard1() + dealer.getCard2());
            int check = 1;
            boolean bust = false;

            System.out.println("");
            System.out.println("NEW ROUND!");
            System.out.println("You drew a total of " + (playerTotal) + ".");
            System.out.println("Deal has drawn a " + dealer.getCard1() + " and a hidden card.");

            while (check == 1){
                System.out.println("Would you like to 'hit' or 'stay'? ");
                String answer = scanner.next();
                if (answer.equals("hit")){
                    player.Hit();
                    playerTotal += player.getNew();
                    System.out.println("Your new total is " + (playerTotal) + "."); 
                    if (playerTotal > 21) {
                        System.out.println("You have busted :P");
                        check -= 1;
                        money -=3;
                    }

                }

                else if (answer.equals("stay")){
                    System.out.println("Your total will now be compared to the dealer.");
                    System.out.println("Dealer's cards were " + dealer.getCard1() + " and " + dealer.getCard2() +".");
                    
                    while (dealerTotal < 17){
                        System.out.println("Dealer will draw until they have at least 17");
                        dealer.Hit();
                        dealerTotal += dealer.getNew();
                        System.out.println("Dealer's new total is " + dealerTotal + ".");
                        if (dealerTotal >= 17) {
                            if (dealerTotal > 21){
                                System.out.println(" ");
                                System.out.println("Dealer has busted and you win :D");
                                money += 5;
                            }
                            else if( playerTotal > dealerTotal){
                                System.out.println(" ");
                                System.out.println("Your total was " + playerTotal + " and dealer's total was " + dealerTotal +".");
                                System.out.println("You have won :D");
                                money +=5;
                            }
                            else if (playerTotal < dealerTotal) {
                                System.out.println(" ");
                                System.out.println("Your total was " + playerTotal + " and dealer's total was " + dealerTotal +".");
                                System.out.println("You have lost :P");
                                money -=3;
                            }
                        }
                    }
                    check -= 1;

                }

            }
        }
        if (money <=0){
            System.out.println(" ");
            System.out.println("You have wasted plenty of time and money. Go home.");
        }
    }
}