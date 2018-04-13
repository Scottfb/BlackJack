public class Game
{
    public void play() {
        //Make players
        Player d = new Player("Dealer", 0);
        Player g = new Player("Gambler", 1000);
        //Let player know holdings
        System.out.println(g.toString());
        System.out.println("You know have " + g.bet());
        //Make a deck
        Deck cards = new Deck();
        cards.createDeck();
        //Deal a card from the deck 
        Card temp = cards.deal();
        Card temp1 = cards.deal();
        Card temp2 = cards.deal();
        Card temp3 = cards.deal();
        //Add that card to player...
        g.addCard(temp);
        g.addCard(temp1);
        d.addCard(temp2);
        d.addCard(temp3);
        //Players handtotal
        System.out.println("The Dealer's card is a " + d.DealerHand());
        System.out.println("Your cards combine to " + g.handTotal());
        if (g.handTotal() > 21) {
                    System.out.println("The dealer wins, sorry");
                    System.out.println("The dealer now has " + d.updateWinningsDealer());
                }
        //Player turn  
        while (g.stay() == true) {
            if (g.handTotal() < 21) {
                Card temp4 = cards.deal();
                g.hit(temp4);
                if (g.handTotal() > 21) {
                    System.out.println("The dealer wins, sorry");
                }
                System.out.println("Your cards are now worth " + g.handTotal());
            }
        }
        if (g.stay() == false) {
            if (g.handTotal() < 21 && g.handTotal() > d.handTotal()) {
                if (d.handTotal() <= 17) {
                    Card temp5 = cards.deal();
                    d.hit(temp5);
                    System.out.println("The Dealer's cards are now worth " + d.handTotal());
                }
            }
        }
        //Determine winner
        if (g.handTotal() == 21) {
            System.out.println("Jackpot!");
            System.out.println("You now have " + g.updateWinnings());
        } else if (g.handTotal() > d.handTotal() && g.handTotal() < 21) {
            System.out.println("The Dealer's cards are worth " + d.handTotal());
            System.out.println("The player wins!");
            System.out.println("You now have " + g.updateWinnings());
        } else {
            System.out.println("Your cards are worth " + g.handTotal());
            System.out.println("The dealer wins, sorry");
            System.out.println("The dealer now has " + d.updateWinningsDealer());
        }
        //End Game
        System.out.println("Game Over!");
    }
}
