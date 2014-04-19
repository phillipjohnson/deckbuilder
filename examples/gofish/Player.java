package gofish;

import com.letstalkdata.deckbuilder.Card;
import com.letstalkdata.deckbuilder.CardRank;
import com.letstalkdata.deckbuilder.Hand;

import java.util.*;

/**
 * Author: Phillip Johnson
 * Date: 4/16/14
 */
public class Player {

    //Every player starts with an empty hand
    private Hand hand = new Hand();
    private final Random random = new Random();

    public Player(){

    }

    public void draw(Card c){
        hand.add(c);
    }

    protected Hand getHand(){
        return new Hand(hand);
    }

    public CardRank determineRankToAskFor(){
        Map<CardRank,Integer> ranks = new HashMap<>();
        for(Card c: hand){
            Integer rankCount = ranks.get(c.getRank());
            if(rankCount == null){
                ranks.put(c.getRank(),1);
            } else {
                ranks.put(c.getRank(),rankCount + 1);
            }
        }

        int max = 0;
        for(Integer i : ranks.values()){
            if(i > max){
                max = i;
            }
        }

        List<CardRank> bestRanks = new ArrayList<>();

        for(Map.Entry<CardRank,Integer> entry : ranks.entrySet()){
            if(entry.getValue() == max){
                bestRanks.add(entry.getKey());
            }
        }

        //Picks a random best suit if there is more than one
        return bestRanks.get(random.nextInt(bestRanks.size()));
    }

    public Optional<Card> ask(CardRank rank){
        for(Card c: new Hand(hand)){
            if(c.getRank().equals(rank)){
                hand.remove(c);
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

    public boolean removeMatchesAndCheckAllCardsMatched(){
        Map<CardRank,Integer> pairs = new HashMap<>();
        for(Card c: hand){
            Integer rankCount = pairs.get(c.getRank());
            if(rankCount == null){
                pairs.put(c.getRank(),1);
            } else {
                pairs.put(c.getRank(),rankCount + 1);
            }
        }

        for (Map.Entry<CardRank, Integer> entry : pairs.entrySet()) {
            if(entry.getValue() == 4){
                removeRank(entry.getKey());
            }
        }

        return hand.isEmpty();
    }

    private void removeRank(CardRank r){
        for(Card c : new Hand(hand)){
            if(c.getRank().equals(r)){
                hand.remove(c);
            }
        }
    }
}
