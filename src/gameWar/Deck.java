package gameWar;
	
	import java.util.Collections;
	import java.util.LinkedList;
	import java.util.List;


	@SuppressWarnings("serial")
	public class Deck extends LinkedList<Card> {
	 
	  private final List<String> position = List.of("Two", "Three", "Four", "Five", "Six", 
			  "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace");

	
	  private final List<String> suits =
	      List.of("Hearts", "Clubs", "Spades", "Diamonds");

	 
	  public Deck() {
	    for(int namePos = 0; namePos < position.size(); namePos++) {
	      int value = namePos + 1;
	      String name = position.get(namePos);

	      for(String suit : suits) {
	        add(new Card(name, suit, value));
	      }
	    }
	  }

		/*
		 * Returns a String representation of all the cards currently in the deck.
		 */	  
	  @Override
	  public String toString() {
	    StringBuilder b = new StringBuilder();

	    b.append("List of cards:" + System.lineSeparator());

	    for(Card card : this) {
	      b.append("   ").append(card).append(System.lineSeparator());
	    }

	    return b.toString();
	  }

		/*
		 * Randomly shuffle the cards in the deck.
		 */	  
	  
	  public void shuffle() {	
	    Collections.shuffle(this);
	  }

		/*
		 * Draw and return the "top" card from the deck.
		 */	  
	  public Card draw() {
	    return remove(0);
	    
	  }
	}

