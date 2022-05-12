package gameplay;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import monsters.*;
import players.*;
/*
 * This game is a concept of an amazing cartoon Pokemon!
 *  
 * https://www.pokemon.com/us/
 */

/*
* University of the Fraser Valley
* COMP 155 AB2
* Name:  Tushar Mahendra
* Student Number:  300156940	
* Assignment 3:  Pokemon game to capture all the pokemons you find!!!
*/

/**
 * This is the class that will execute our game.
 * Add yourself as author in Javadoc for the extra methods you write.
 * You are expected to write many of your own methods. In general, it is
 * good to keep methods short so that you can read the entire method 
 * code in one screen.
 * 
 * @author Dr Russell Campbell
 *
 */
public class Game {
	static Scanner input = new Scanner(System.in);
	static TextPanel narrator = new TextPanel();
	public static Player plyr;
	static final int N_MONTSERS = 3;
	static ArrayList<Monster> monsters = new ArrayList<Monster>(); 
	
	/**
	 * This is where our game program starts execution.
	 * 
	 * @param args The usual command line arguments array.
	 */
	public static void main(String[] args) {
		// Take special note of the small size of each method.
		// Small methods are easier to understand and debug.
		
		// must handle any Scanner input errors during interaction
		try {
			gameLoop(); // execute the game code
		} catch (InputMismatchException e) {
			System.out.println(e);
		} finally {
			input.close();
		}
		
	}
	
	/**
	 * A prompt for the player so they have some time to read output.
	 */
	public static void pause() {
		// Use this when you want to pause output so the 
		// player can read it before printing more output.
		getUserInput("(okay, press Enter)");
		System.out.println();
	}
	
	/**
	 * Prints a prompt to the user for some String input, 
	 * and then waits for the user to enter one line of text.
	 * 
	 * @param msg 
	 *   The prompt for the user to read, so the player
	 *   knows what kind of input to type.
	 *   
	 * @return 
	 *   The line of text the user entered.
	 */
	public static String getUserInput(String msg) {
		System.out.print(msg);
		return input.nextLine();
	}
	
	/**
	 * Prints a prompt to the user for an integer input, 
	 * and then waits for the user to enter an integer.
	 * 
	 * @param msg 
	 *   The prompt for the user to read, so the player
	 *   knows what integer values they can choose.
	 *   
	 * @return 
	 *   The integer the user entered.
	 */
	public static int getUserChoice(String msg) {
		System.out.print(msg);
		int choice = input.nextInt();
		// Calling nextInt does not process the end-of-line ENTER key-press.
		input.nextLine();
		// Without this nextLine, the user would not be able to
		// enter their next line of input.
		return choice;
	}
	
	/**
	 * The basic program flow-of-control for our game.
	 * Most of your code here should be calling the other methods
	 * that you write.
	 * You are expected to write many of your own methods to
	 * keep your code organized.
	 */
	public static void gameLoop() {
		welcome();
		
	
		
		boolean notDone = true;
		while (notDone) {
			notDone = play();
		}
		
		finish();
	}
	
	/**
	 * This prints the prompt for the first choice the player has
	 * in the game: which kind of person will they play?
	 */
	public static void promptForPlayerChoice() {
		String[] playerTypes = PlayerType.getValues();
		int n = playerTypes.length;
		String[] playerTypeMessage = new String[n+1];
		playerTypeMessage[0] = "The possible people you can play:";
		for (int i = 0; i < n; i++) {
			playerTypeMessage[i+1] = 
				" - "
				+ playerTypes[i]
				+ " (enter " + i + ")";
		}
		
		narrator.print(playerTypeMessage);
		System.out.println();
	}
	
	/**
	 * This validates the player's choice for which type of person they want
	 * to play as. The user could have entered an invalid choice, so we have
	 * to check that it is one of the available choices that are programmed in 
	 * our game.
	 * 
	 * @param choice
	 *   The input integer the user entered.
	 *   
	 * @param name
	 *   The player's name for inside the game.
	 *   
	 * @return
	 *   Will return <code>true</code> if the user's choice is valid, and
	 *   <code>false</code> otherwise.
	 */
	public static boolean checkUserChoice(int choice, String name) {
		int n = PlayerType.size();
		if (choice >= n) {
			System.out.println("You need to choose among the given options.");
			pause();
			return false; // we should not continue and try to access PlayerType
		}
		
		// which valid choice did they choose?
		switch (PlayerType.values()[choice]) {
			case WARRIOR:
				narrator.print("You chose a warrior!");
				plyr = new Warrior(name);
				break;
			case WIZARD:
				narrator.print("You chose a wizard!");
				plyr = new Wizard(name);
				break;
		}
		return true;
	}
	
	/**
	 * The start of the game. Any part of the game that should 
	 * be set up before the play loop.
	 */
	public static void welcome() {
		String name = 
			getUserInput("Please enter your name: ");
		
		narrator.print(
			"Hello, " + name + "!",
			"---GET READY TO CAPTURE POKEMONS---",
			"",
			"You are in the City of Champions!",
			"Capture all the Pokemons to be the MASTER!!!"
		);
		pause();
		
		boolean validChoice = false;
		while (!validChoice) {
			promptForPlayerChoice();
			
			int choice;
			choice = getUserChoice("Choose a person: ");
			System.out.println();
			
			validChoice = checkUserChoice(choice, name);
		}
		
		
		
		// generate a bunch of random monsters the player must defeat
		for (int i = 0; i < N_MONTSERS; i++) {
			
			
			
			StoryLine story = null;	//story is an object to pass the values through constructor and call the method of StoryLine. Seems easier way than using arraylist :)
			int monsterType = Random.rand(i, 2);
			
			switch (monsterType) {
				case 0:
					monsters.add(new Pikachu("Pikachu", Random.rand(15, 30), Random.rand(8, 20)));	//Used the monster list anyways
					story = new StoryLine("Pikachu", Random.rand(15, 30), Random.rand(8, 20)); 	// passing the values of each pokemon to the constructor of StoryLine
					story.middle();
					break;
					
				case 1:
					monsters.add(new Squirtle("Squirtle", Random.rand(13, 40), Random.rand(5, 25)));
					story = new StoryLine("Squirtle", Random.rand(13, 40), Random.rand(5, 25));
					story.middle();
					break;
						
					
				case 2:
					monsters.add(new Charizard("Charizard", Random.rand(15, 50), Random.rand(10, 30)));
					story = new StoryLine("Charizard", Random.rand(15, 50), Random.rand(10, 30));
					story.middle();
					break;
					
			}
			
		}
	
		
}
	 
	

	
	/**
	 * This method is the part of the game that can be repeated. The basic
	 * idea is to give the player a choice, and then process that choice
	 * towards some kind of goal. Attacking monsters is a <b>very</b> common 
	 * theme in many games.
	 * 
	 * @return
	 *   Should return <code>true</code> to continue play, and 
	 *   <code>false</code> to end the game.
	 */
	public static boolean play() {
		
		// ~~~~~~ USED A STORYLINE INSTEAD ~~~~~~~~
		
		// Some test code for you.
		// Using polymorphism, it does not matter which type of Player is chosen,
		// you will be able to call (abstract) methods declared in the Player class.
		
		/*
		int choice = Random.rand(0,1);
		Monster dude = null;
		if(choice == 0) {
			dude = new Pikachu("Pika",40,50);
		}
		else {
			dude = new Squirtle("Squirtle",30,50);
		}
		dude.attack();
		*/
		
		
		// Each kind of subclass will call its own implementation of the method.
		// But you will not be able to call new methods specific to the subclasses.
		// This is because the plyr object is currently recognized as a Player instance.
		
		
		// Replace the above test code.
		// You should make a switch, and each case should call a different method.
		// Each method should present a unique situation to the player with choices.
		// Create your own Enum to make your code easier to read.
		// Use PlayerType as an example of how to do this effectively.
		
		// Return false when you want your game to end.
		
		// A few ways you could end the game is to defeat all
		// the Monster instances in the monsters collection,
		// OR the monsters attack the player to reach zero hitPoints.
		
		// You should change the final return to true when you are done testing
		// and you want your game to loop.
		return false;
	}
	
	/**
	 * You should put any code here you want to be the last thing to execute.
	 */
	public static void finish() {
		// You could have different endings, using if-statements to check certain things.
		
		narrator.print(
				"Thanks for playing the game!!!",
				"You've captured " + StoryLine.numberOfPokemonsDefeated + " pokemons"
				);
	}
}