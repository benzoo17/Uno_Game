package org.example.Special;

import org.example.Player;
import org.example.Special_Card;
import org.example.deck;

public class draw2 extends Special_Card {
    public void Effect(Player player, deck Deck) {
        if (getEffect()) {
            for (int i = 0; i < 2; i++) {
                Deck.Drawing(player);

            }
            System.out.println("this player drew these cards");
                int n =player.getHand().size();
                System.out.println(player.getHand().get(n-1));
                System.out.println(player.getHand().get(n-2));
            setEffect(false);
        }
    }
}
