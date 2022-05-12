package players;
import monsters.Monster;
import gameplay.*;
/**
 * This abstract class is meant to force implementation of the abstract methods
 * we want any player to have in the game, no matter what person 
 * type they choose to play the game as. It also saves us time from having
 * to recode the same methods for each subclass of Player that should behave
 * the exact same way (non-abstract methods).
 * 
 * @author Dr Russell Campbell
 *
 */
public abstract class Player {
	// Package-protected means it can be used by other classes in the same package.
	String name;
	final static int MAX_HIT_POINTS = 50;
	static StoryLine stry;
	int hitPoints;
	int strength;
	int wisdom;
	
	/**
	 * This superclass constructor should take care of basic setup for 
	 * creating instances of any kind of person the player chooses. 
	 * So calling super() for any subclass constructors saves you from 
	 * writing this code again.
	 * 
	 * @param name
	 *   The name of the player.
	 *   
	 * @param hitPoints
	 *   The number of points a player has to stay alive.
	 *   
	 * @param strength
	 *   A basic measure of the amount of strength a player has. This could
	 *   be used to help calculate attack damage to hit points of monsters.
	 *   
	 * @param wisdom
	 *   A basic measure of the amount of wisdom a player has. This could be
	 *   used to help calculate the amount of spell effects.
	 */
	public Player(String name, int hitPoints, int strength, int wisdom) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.wisdom = wisdom;
	}
	
	/**
	 * A method to return the name of the player.
	 * 
	 * @return
	 *   A string that the user entered for their name at the 
	 *   start of the game.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A method to get the maximum possible hit points for the player. 
	 * You could use this value to help you calculate results for 
	 * situations you design.
	 * 
	 * @return
	 *   An integer for the largest possible hit points of the player.
	 */
	public int getMaxHitPoints() {
		return MAX_HIT_POINTS;
	}
	
	/**
	 * To find out the current hit points status of the player.
	 * 
	 * @return
	 *   An integer for the current hit point value.
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * To find out the strength of the player.
	 * 
	 * @return
	 *   An integer for the strength of the player.
	 */
	public int getStrength() {
		return strength;
	}
	
	/**
	 * To find out the wisdom of the player.
	 * 
	 * @return
	 *   An integer for the wisdom of the player.
	 */
	public int getWisdom() {
		return wisdom;
	}
	
	/**
	 * To change the value of the player's current hit points.
	 * 
	 * @param hitPoints
	 *   The value to save as the current hit points.
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	/**
	 * To change the value of the player's strength.
	 * 
	 * @param strength
	 *   The value to save as the player's strength.
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	/**
	 * To change the value of the player's wisdom.
	 * 
	 * @param wisdom
	 *   The value to save as the player's wisdom.
	 */
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}
	
	/**
	 * Every kind of player should implement their own version 
	 * of an attack.
	 * 
	 * @param monsters
	 *   The attack should affect one, some, or all of the monsters. 
	 *   You decide how this should be implemented in subclasses.
	 */
	public abstract void attack(Monster... monsters);
	
	/**
	 * Every kind of player should implement their own version 
	 * of a spell to cast.
	 * @param monster 
	 * 
	 * @param monsters
	 *   The spell should affect one, some, or all of the monsters. 
	 *   You decide how this should be implemented in subclasses.
	 */
	public abstract void castSpell(Monster monster);
}