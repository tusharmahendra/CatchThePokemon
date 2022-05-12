package monsters;

/**
 * 
 * 
 * @author Tushar Mahendra
 * 
 */
public abstract class Monster {
	// Package-protected so other classes in the same package can access.
	int hitPoints;
	int strength;
	String name;
	
	Monster(String name, int hitPoints, int strength){
		name = this.name;
		hitPoints = this.hitPoints;
		strength = this.strength;
	}
	
	public abstract void attack();
	  
}

/**
 * @param num 
 * Stores total number of monsters in the game generated randomly.
 * 
 * @param statement
 * Boolean to see if the input to move is correct or not. If not, it asks user to put the input again.
 * 
 * @param  choice
 * Stores the user input to move in various directions
 * 
 * @author Tushar Mahendra
 *
 */
 
 


 

  