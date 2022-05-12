package monsters;
/**
 * This class is a subclass of Monster class. Charizard is a Pokemon type.
 * 
 * @author tusharmahendra
 *
 */


public class Charizard extends Monster{
	 public Charizard(String name, int hitPoints, int strength) {
		super(name, hitPoints, strength);
		
	}

	public void attack() {
		System.out.println("Charizard uses flamethrower!!! " + strength);
	}
	
	
	
}

