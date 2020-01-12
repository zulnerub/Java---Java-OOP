package WORKSHOP_TWO.structure.repositories;

import WORKSHOP_TWO.structure.models.cards.interfaces.Card;
import WORKSHOP_TWO.structure.repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl( ) {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void add(Card card) {
        if (card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }

        if (this.getCards().contains(card)){
            throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
        }

        this.cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null){
            throw new IllegalArgumentException("Card cannot be null!");
        }
        if (this.getCards().contains(card)){
            this.cards.remove(card);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Card find(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("card's name cannot be null or an empty string.");
        }
        return this.getCards().stream().filter(card -> card.getName().equals(name)).findFirst().orElse(null);

    }
}
