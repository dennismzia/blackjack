import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Blackjack{
    public static int card1;
    public static int card2;
    public static int[] cards = {0,0};
    public static int Total;
    public static ArrayList<Integer> Newtotal = new ArrayList<Integer>();
    public static Scanner sc = new Scanner ( System.in );
    public static void main(String[] args) {
        card1 = firstCards()[0];
        card2 = firstCards()[1];
        System.out.println("First cards: "+card1+","+card2);
        Total = card1 + card2;
        Newtotal.add(Total);
        System.out.println("Total: "+Total);
        System.out.println();


        while(true){
            System.out.println("Do you want another card?[y/n]:");
            String nx = sc.next();
            if (nx.equals("n")){
                System.out.println(" you've selected 'n' exiting in peace...");
                break;
            }else if(nx.equals("y")){
                System.out.println("Card: ");
                int n = sc.nextInt();
                if (deal() > 21){
                    System.out.println("Busted...");
                    break;
                }else{
                    Newtotal.add(n);
                    // int selected = n + deal();
                    if(deal() > 21){
                        System.out.println("Busted...");
                        break;
                    }
                    System.out.println("Tot: " + deal());
                }


            }else{
                System.out.println();
                System.out.println("unrecognized arguments - (strictly[y/n])");
                System.out.println();
                continue;
            }

        }
        
        
    }

    public static int[] firstCards(){
        Random rand = new Random();
        int max = 11; // generate values from 0 - 10
        int min = 1;
        cards[0] = rand.nextInt(max - min) + min;
        cards[1] = rand.nextInt(max - min) + min;
        return cards;
    }

    public static int sum(){
        int sum = 0; // initialize sum
        int i;
 
        // Iterate through all elements and add them to sum
        for (i = 0; i < cards.length; i++)
            sum += cards[i];
 
        return sum;
    }

    public static int deal(){
        // returns the new total everytime the player deals a card
        int d = 0;
        for (int i = 0; i < Newtotal.size(); i++) {
            d += Newtotal.get(i);
        }
        return d;
    }

}