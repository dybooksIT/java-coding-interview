package coding.challenge.deck;

import coding.challenge.card.Card;
import coding.challenge.card.Pack;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Deck<T extends Card> implements Iterable<T> {
    private final List<T> cards; // 모든 카드

    public Deck(Pack pack) {
        this.cards = pack.getCards();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<T> dealHand(int numberOfCards) {
        // 손을 다루는 코드
        return null;
    }

    public T dealCard() {
        // 카드 1장을 다루는 코드
        return null;
    }

    public int remainingCards() {
        return cards.size();
    }

    public void removeCards(List<T> cards) {
        // 카드를 제거하는 코드
    }

    @Override
    public Iterator<T> iterator() {
        // Card 반복자 구현
        return null;
    }
}