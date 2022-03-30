package gameWar;

public class Card {
	 
	  private String name;
	  private String suit;
	  private int value;
	  
	
	  public Card(String name, String suit, int value) {
	    this.name = name;
	    this.suit = suit;
	    this.value = value;   
	    
	  }

	  @Override
	  public String toString() {
	    return name + " of " + suit;
	  }
	  
	 public void describe() {
		 System.out.println(name + "= " + value);
	 }

	  public int getRank() {
	    return value;
	    
	  }   
  }



