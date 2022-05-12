package gameplay;

/**
 * 
 * This class receives gets the values of pokemons from Game class's switch that passes values using polymorphism. Polymorphism is a great way to access methods of multiple classes.
 * 
 * @author Tushar Mahendra
 *
 */


public class StoryLine {
	String name;
	int hitPoints;
	int strength;
	static int numberOfPokemonsDefeated = 0;
	int bandages = 3;
	
	public StoryLine(String name, int hitPoints, int strength) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
	}
	/**
	 * 
	 * 
	 * @param hitPoints It is used to change the value of hitPoints of pokemons
	 */
	public void setHitPoints(int hitPoints) {
		hitPoints = this.hitPoints;
	}
	/**
	 * 
	 * @return Returns the HitPoints of pokemons
	 */
	public int getHitPoints() {
		return hitPoints;
	}
	
	/**
	 * 
	 * 
	 * @param strength To set the changed strength of Pokemon
	 */
	public void setStrength(int strength) {
		strength = this.strength;
	}
/**
 * 
 * 
 * @return It returns the strength of pokemon
 */
	
	public int getStrength() {
		return strength;
	}
	/**
	 * This method gets the values of pokemons from Game class through the constructor. Middle has all the essential variables and uses methods from Player 
	 * class to set and get values. There are nested while loops used to attack the pokemon that appears. This structure of code is an idea from https://codecourse.com
	 * The nested loop runs till the hitPoints of pokemon stays positive. The concept of bandages to heal up is an idea of https://www.epicgames.com/fortnite/en-US/buy-now/battle-royale
	 */

	public void middle() {
		
		int bandages = 4;	// Number of bandages a player has to heal like in FORTNITE
		int health = 10;	// Amount of health a bandage recovers
		
		boolean play = true;
		SEARCH:
		while(play) {
			Game.pause();
			Game.narrator.print(
					name + " has appeared!!!"
					);
			
			
			while(hitPoints > 0) {
				Game.pause();
				
				Game.narrator.print(
						"Your health is: " + Game.plyr.getHitPoints(),
						name + "'s health is: " + hitPoints,
						"Press 1 to Attack",
						"Press 2 to Use Bandages",
						"Press 3 to Caste Spell"
						);
				
				int input = Game.input.nextInt();
				
				if(input == 1) {
					
					Game.plyr.setHitPoints(Game.plyr.getHitPoints() - strength);	//Player's health left after attack
					hitPoints = hitPoints - Game.plyr.getStrength();	//Monster's health left after attack
					
					Game.plyr.attack(Game.monsters.get(0));
					
					Game.narrator.print( 
							"Your health after the attack: " + Game.plyr.getHitPoints(),
							name + "'s health: " + hitPoints
							);
					Game.pause();
					
					if (Game.plyr.getHitPoints() <= 0 ) {
						Game.narrator.print(
								"You got wounded critically!!!",
								"You can't fight with " + Game.plyr.getHitPoints() + " health",
								"Play again"
								);
						Game.pause();
						break SEARCH;
					}
				}
				
				else if (input == 2) {
					
					if (bandages > 0) {
						Game.plyr.setHitPoints(Game.plyr.getHitPoints() + health);
						bandages--;
						Game.narrator.print(
								"Your health is " + Game.plyr.getHitPoints() + " after healing yourself",
								"You have " + bandages + " bandages left."
								);
						Game.pause();
						}
					
					else {
							Game.narrator.print("You have used all the bandages!!!");
							Game.pause();
						}
					}
				
				else if (input == 3) {
					strength = strength - Random.rand(0, 10);
					Game.narrator.print("You lowered " + name + "'s attack with spell!!!");
					Game.pause();
				}
				
				
				else {
					System.out.println("Please enter a valid input");
					
				}
			}	
			
			if(Game.plyr.getHitPoints() <= 0) {
				Game.narrator.print("You can't fight no more!!!");
				Game.pause();
				break;
				
			}
			
			else {
				numberOfPokemonsDefeated++;
				Game.narrator.print(
						"You captutred " + name + "!!!",
						"You have " + Game.plyr.getHitPoints() + " health left",
						"Lets find another Pokemon!!!"
						);
				break;
			}
		}
			
	}
}
