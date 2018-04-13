public class Card
{
    public int value;
    public String suit;
    public String face;
    public Card(int val, String s, String f) {
        value = val;
        suit = s;
        face = f;
    }
    public int getValue() {
        return value;
    }
    public String getSuit() {
        return "The card suit is " + suit;
    }
    public String toString() {
        return value + " of " + suit;
    }
}
