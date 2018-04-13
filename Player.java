import java.util.ArrayList;
import java.util.Scanner;
public class Player
{
    private double money;
    private double mon;
    private String name;
    private ArrayList<Card> pcard;
    public Player(String nm, double m) {
        name = nm;
        money = m;
        pcard = new ArrayList<Card>();
    }
    public double bet() {
        Scanner cash = new Scanner(System.in);
        System.out.println("How much would you like to bet?");
        double mon = cash.nextDouble();
        if (mon > money || mon < 0) {
            System.out.println("You don't have that much money");
        } else {
            money -= mon;
        }
        return money;
    }
    public Card hit(Card c) {
        pcard.add(c);
        return c;
    }
    public Card addCard(Card c) {
        pcard.add(c);
        return c;
    }
    public boolean stay() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Stay? Y/N");
        boolean temp = false;
        if(scan.next().equals("N")) {
            temp = true;
        }
        return temp;
    }
    public double updateWinnings() {
        double winnings = 0.0;
        double temp = 0.0;
        temp = (1000 - money);
        winnings = 2 * (temp) + money;
        return winnings;
    }
    public double updateWinningsDealer() {
        double winning = 0.0;
        double tem = 0.0;
        tem = (1000 - money);
        return tem;
    }
    public int handTotal() {
        int value = 0;
        for (Card c : pcard) {
            if (c.getValue() == 1) {
                if (value <= 10) {
                    value += 11;
                }
                value += 1;
            }
            value += c.getValue();
        }
        return value;
    }
    public Card DealerHand() {
        return pcard.get(1);
    }
    public String toString() {
        return name + " has " + money + " dollars";
    }
}
