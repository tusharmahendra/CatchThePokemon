package players;
import gameplay.Random;
import monsters.Monster;

/**
 * Wizard class is a subclass of Player class.
 * 
 * 
 * 
 * @author Tushar Mahendra
 *
 */
public class Wizard extends Player {
	
	public Wizard(String name) {
		super(
			name,
			Random.rand(3, 50),  // hitPoints
			Random.rand(4, 20), // strength
			Random.rand(5, 100)   // wisdom
		);
	}
	
	@Override
	public void attack(Monster... monsters) {
		
		System.out.println("Wizard attack!" + strength);
	}

	@Override
	public void castSpell(Monster monster) {
	
		System.out.println("Wizard spell!" + stry.getStrength());
	}

}
