package monsters;
/**
 * This class is a subclass of Monster class. Squirtle is a Pokemon type.
 * 
 * @author tusharmahendra
 *
 */


public class Squirtle extends Monster {
	public Squirtle(String name, int hitPoints, int strength) {
		super(name, hitPoints, strength);

	}

	@Override
	public void attack() {
		System.out.println("Squirtle uses water blast!!! " + strength);

	}
}
