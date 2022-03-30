package gameWar;

	import java.util.LinkedList;
	import java.util.List;

	public class Player {
	  private String name;
	  private List<Card> hand = new LinkedList<>();
	  private int score;

		/*
		 * name The player name.
		 */	  
	  public Player(String name) {
	    this.name = name;
	  }

		/*
		 * The player name.
		 */	  
	  public String getName() {
	    return name;
	  }

		/*
		 * Remove the "top" card from the deck and add it to the player's hand.
		 */	  
	  public void draw(Deck deck) {
	    getHand().add(deck.draw());
	  }

		/*
		 * The player's current hand.
		 */	  
	  public List<Card> getHand() {
	    return hand;
	  }

		/*
		 * describe method for each player's hand.
		 */		  
	  public void describe() {
			for (Card card : hand) {
			    card.describe(); }
	   }			
	  
	    /*
		 * Remove and return the "top" card from the player's hand.
		 */	  
	  public Card flip() {
	    return hand.remove(0);
	  }

		/*
		 * Increment the player's score by 1.
		 */	  
	  public void incrementScore() {
	    score = getScore() + 1;
	  }

		/*
		 * The player's current score.
		 */	  
	  public int getScore() {
	    return score;
	  }
	}


