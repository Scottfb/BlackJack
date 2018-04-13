import java.util.ArrayList;
import java.util.Random;
public class Deck
{
    private Card temp;
    private ArrayList<Card> deck;
    public Deck() {
         deck = new ArrayList<Card>();
    }
    public Card deal() {
        //deal random card and you don't need to shuffle
        int val = 0;
        Random rand = new Random();
        int index = rand.nextInt(51 - val);
        Card temp =  deck.get(index);
        deck.remove(index);
        val++;
        return temp;
    }
    public void createDeck() {
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", 
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        for(String s : suits) {
            int value = 1;
            for(String r : ranks) {
                Card temp = new Card(value , s, r);
                value++;
                if(value > 10) {
                    value = 10;
                }
                deck.add(temp);
            }
        }
    }
    
}
