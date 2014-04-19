package gofish;

import com.letstalkdata.deckbuilder.AceBehavior;
import com.letstalkdata.deckbuilder.Card;
import com.letstalkdata.deckbuilder.Deck;
import com.letstalkdata.deckbuilder.DeckStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Author: Phillip Johnson
 * Date: 4/16/14
 */
public class Game {

    private final List<Player> players = new ArrayList<>();
    //This game uses a standard deck so I'm using the STANDARD_52 enum
    //The ace behavior doesn't really matter, so I could use
    //either ACES_LOW or ACES_HIGH
    private final Deck deck = new Deck(DeckStyle.STANDARD_52, AceBehavior.ACES_HIGH);
    private final Random random = new Random();

    public Game(int numberOfPlayers){
        if(numberOfPlayers < 2 || numberOfPlayers > 10){
            throw new IllegalArgumentException("Players must be between 2 and 10, inclusive.");
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
        }

        //In almost all circumstances you'll want to call shuffle()
        //before using a deck
        deck.shuffle();
        int cardsPerPlayer;
        if(players.size() <= 4){
            cardsPerPlayer = 7;
        } else {
            cardsPerPlayer = 5;
        }

        for (Player player : players) {
            for (int i = 0; i < cardsPerPlayer; i++) {
                //The poll method is a quick way of getting the next card
                player.draw(deck.poll());
            }
        }
    }

    public void play(){
        boolean victory = false;
        while(!victory){
            printGameStatus();
            for (Player player : players) {
                takeTurn(player);
                victory = checkVictory();
            }
        }
    }

    private void takeTurn(Player player){
        List<Player> others = new ArrayList<>(players);
        others.remove(player);

        boolean gotCardAskedFor = true;
        //Always check for victory before taking turn
        while(!player.removeMatchesAndCheckAllCardsMatched() && gotCardAskedFor){
            //Pick a random player to ask
            Player playerToAsk = others.get(random.nextInt(others.size()));
            Optional<Card> cardOptional = playerToAsk.ask(player.determineRankToAskFor());
            if(cardOptional.isPresent()){
                //Keep going
                gotCardAskedFor = true;
                player.draw(cardOptional.get());
            } else {
                //Turn is over
                gotCardAskedFor = false;
                if(!deck.isEmpty()) {
                    //GO FISH.
                    player.draw(deck.poll());
                }
            }
        }
    }

    private boolean checkVictory(){
        for (Player player : players) {
            if(player.removeMatchesAndCheckAllCardsMatched()){
                return true;
            }
        }

        return false;
    }

    private void printGameStatus(){
        System.out.println("Deck size " + deck.size());
        for(Player p : players){
            System.out.println(p.getHand());
        }
    }

}
