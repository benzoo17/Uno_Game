package UNO.Logic;
import java.util.Collections;
import java.util.Stack;
import java.util.Random;

import UNO.Logic.Special.*;


public class deck {
    Stack<Card> Draw;
    Stack<Card> Discard;

    void initdeck() {
        Draw = new Stack<>();
        Discard = new Stack<>();
        int cpt = 0;
        for (int i = 0; i < 108; i++) {
            Card gen;
            if (cpt < 40) {
                gen = generate_special_Card();
                cpt++;
            } else {
                gen = new Normal_Card();
            }
            Draw.push(gen);
        }
        Collections.shuffle(Draw);
    }

    deck() {
        initdeck();
    }

    public void restart() {
        if (Draw.empty()) {
            Card card = null;
            while (!Discard.empty()) {
                card = Discard.pop();
                if (card instanceof Special_Card){
                    ((Special_Card) card).setEffect(true);
                }
                Draw.push(Discard.pop());
            }
            Collections.shuffle(Draw);
            Discard.push(card);
        }
    }
    Card generate_special_Card(){
        Random rand = new Random();
        int x=rand.nextInt(5);
        Card card;
        switch (x) {
            case 0 : card =new draw2();
            break;
            case 1 : card =new draw4();
            card.setColor(Card.Color.black);
            break;
            case 2 : card = new reverse();
            break;
            case 3 : card = new skip();
            break;
            case 4 : card = new wild();
            card.setColor(Card.Color.black);
            break;
            default : card = new Normal_Card();
        }
             return card;
    }
    public void Drawing(Player player) {
        if (!Draw.empty()) {
            Card card = Draw.pop();
            player.getHand().add(card);

        } else {
            restart();
        }
    }
    public void Discarding(Player player, Card card) {

        Discard.push(card);
        player.getHand().remove(card);
    }
    public Card getTopCard() {
        return Discard.peek();

    }
}