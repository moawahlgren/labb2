package cardutils;

import java.util.Comparator;
import java.lang.Comparable;
import java.io.*;
/**
 * Represents an immutable playing card, with rank and suit.
 */
public class Card implements Comparable<Card>{

	private final Rank rank;
	private final Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
        //testar
	}
	
	int jaha = 1;

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getRankValue() {
		return rank.getValue();
	}

	public int getSuitValue() {
		return suit.ordinal(); // default values, 0, 1, 2, 3
	}

	public boolean equals(Card other) {
		return this.rank == other.rank && this.suit == other.suit;
	}

	@Override
	public String toString() {
		String info = rank + " of " + suit;
		return info;
	}

	public String toShortString() {
		String info = "";
		switch (rank) {
		case ACE:
			info += 'A';
			break;
		case KING:
			info += 'K';
			break;
		case QUEEN:
			info += 'Q';
			break;
		case JACK:
			info += 'J';
			break;
		default:
			info += getRankValue();
		}
		switch (suit) {
		case SPADES:
			info += '\u2660';
			break;
		case HEARTS:
			info += '\u2764';
			break;
		case CLUBS:
			info += '\u2663';
			break;
		case DIAMONDS:
			info += '\u2666';
			break;
		default:
			;
		}
		return info;
	}

    @Override
    public int compareTo(Card other) {
        //CompareTo returnerar 0 => this = other, returnerar 1 => this > other
        // eller returnerar -1 => this < other
        //Ska sortera korten 
        int res = this.suit.compareTo(other.suit);
        if (res == 0) {
            //Om suit är samma, så sortera på rank
            return this.rank.compareTo(other.rank); 
        }
        else {
            //Om suit ej är samma
            return res; 
        }
    }

}
