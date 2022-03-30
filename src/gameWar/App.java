package gameWar;


	import java.util.LinkedList;
	import java.util.List;
	import java.util.Random;

	public class App {
		

	  /*
	   * This is the list of player names. 
	   */
	  private final List<String> members = List.of("Austin", "Chelsea", "Dalton", "Daniel Teh",
	      "Daniel Tondra", "Darrin", "Dustin", "Henry", "James", "Jordan", "Khou", "Kolby",
	      "Logan", "Matt", "Michaeline", "Misty", "Pierce", "Stephanie");

	  /* This allows the game to generate two random player names. */
	  private Random random = new Random();

		/*
		 * main method:
		 */		  
	  public static void main(String[] args) {
	    new App().run();
	   
	  }

		/*
		 * Creates the players, creates and shuffles the deck, and plays the game.
		 */	  
	  private void run() {
	    /*
	     * Create a new list of member names. This list is modified by removing names 
	     * of player members.
	     */
	    List<String> names = new LinkedList<>(members);
	    Player player1 = selectPlayer(names);
	    Player player2 = selectPlayer(names);

	    System.out.println(player1.getName() + " is playing " + player2.getName() + ".");

	    /* Create and shuffle the deck. */
	    Deck deck = new Deck();
	    deck.shuffle();

	    /* Deal the cards evenly to each player. */
	    deal(deck, player1, player2);

	    /* Play the game. */
	    play(player1, player2);

	    /* Announce the winner. If there is no winner, announce a tie. */
	    declareWinner(player1, player2);
	  }

		/*
		 * Figure out which player has the highest score and announce the winner.
		 */	  
	  private void declareWinner(Player player1, Player player2) {
	    if (player1.getScore() > player2.getScore()) {
	      printWinner(player1);
	      printLoser(player2);
	    } else if (player2.getScore() > player1.getScore()) {
	      printWinner(player2);
	      printLoser(player1);
	    } else {
	      printTie(player1, player2);
	    }
	  }

		/*
		 * Announce the loser.
		 */	  
	  private void printLoser(Player loser) {
	    System.out.println(loser.getName() + " is the loser with a score of "
	        + loser.getScore() + ".");
	  }

		/*
		 * Announce the winner.
		 */
	  private void printWinner(Player winner) {
	    System.out.println(
	        winner.getName() + " is the winner with a score of " + winner.getScore() + ".");
	  }

		/*
		 * Announce a tie, in which both players have the same score.
		 */	  
	  private void printTie(Player player1, Player player2) {
	    System.out.println(player1.getName() + " and " + player2.getName() + 
	    		" tied with a score of " + player1.getScore() + ".");
	  }

		/*
		 * Plays the game and stores each player's score
		 */	  
	  private void play(Player player1, Player player2) {
	   
	    int numTurns = player1.getHand().size();

	    for (int turn = 0; turn < numTurns; turn++) {
	      Card card1 = player1.flip();
	      Card card2 = player2.flip();

	      if (card1.getRank() > card2.getRank()) {
	        player1.incrementScore();
	      } else if (card2.getRank() > card1.getRank()) {
	        player2.incrementScore();
	      }
	    }
	  }

		/*
		 * Deal the deck evenly to each player. The cards in the deck go into the
		 * players' hands.
		 */	  
	  private void deal(Deck deck, Player player1, Player player2) {
	    int size = deck.size();

	    for (int index = 0; index < size; index++) {
	      
	      if (index % 2 == 0) {
	        player1.draw(deck);
	      } else {
	        player2.draw(deck);
	      }

	    }
	  }
	  
		/*
		 * Randomly select a player name from the given list. The player name is removed
		 * from the list so that the same player is not selected twice.
		 */
	  
	  private Player selectPlayer(List<String> names) {
	    int pos = random.nextInt(names.size());
	    String playerName = names.remove(pos);
	    return new Player(playerName);
	  }
	}


