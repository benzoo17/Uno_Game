package org.example.Special;
import org.example.*;



public class draw4 extends Special_Card {
    public void Effect(Player player, deck Deck) {

        if (getEffect()) {
            Choose_A_color(player);
            for (int i = 0; i < 4; i++) {
                Deck.Drawing(player);
            }
            System.out.println("player number  "+player.getId()+" drew these cards");
            int n =player.getHand().size();
            System.out.println(player.getHand().get(n-1));
            System.out.println(player.getHand().get(n-2));
            System.out.println(player.getHand().get(n-3));
            System.out.println(player.getHand().get(n-4));
            setEffect(false);
        }
    }
}
