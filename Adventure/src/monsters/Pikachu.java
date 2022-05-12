package monsters;
/**
 * This class is a subclass of Monster class. Pikachu is a Pokemon type.
 * 
 * @author tusharmahendra
 *
 */

public class Pikachu extends Monster{
	  public Pikachu(String name, int hitPoints, int strength) {
			super(name, hitPoints, strength);
			
		}

	@Override
	public void attack() {
		System.out.println("Pikachu uses thunderbolt!!! " + strength);
		}
	}