package players;

import gameplay.Random;
import monsters.Monster;

/**
 * Warrior class is a subclass of Player class. 
 * 
 * @author Tushar Mahendra
 *
 */
public class Warrior extends Player {
	
	public Warrior(String name) {
		super(
			name,
			MAX_HIT_POINTS,  // hitPoints start with the max
			Random.rand(1, 100), // strength is at most 100
			Random.rand(2, 20)   // wisdom is at most 20
		);
	}
	
	@Override
	public void attack(Monster... monsters) {
		// Recall that Monster... is called "variable arguments" (textbook, pg 93)
		// Basically, you can use monsters like an array of strings.
		
		System.out.println("Warrior attack! " + strength);
	}

	
	public void castSpell(Monster monster) {
		System.out.println("Wizard spell!" + stry.getStrength());
	}

}
