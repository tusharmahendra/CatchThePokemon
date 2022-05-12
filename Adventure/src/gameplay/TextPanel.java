package gameplay;

/**
 * This class makes printing fancy story output a bit easier.
 * 
 * @author Dr Russell Campbell
 *
 */
public class TextPanel {
	private final static int MAX_WIDTH = 90;
	private final static int MAX_HEIGHT = 40;
	private static Screen2D heading = new Screen2D(MAX_WIDTH, MAX_HEIGHT);
	private int width;
	private int height;
	
	/**
	 * This method centres the given strings inside a rectangular design
	 * for nicer output to read.
	 * 
	 * @param message
	 *   An array of strings that will be printed, 
	 *   one string on each line.
	 * 
	 * @throws IllegalArgumentException
	 *   If any string in the message array is longer than 82 chars,
	 *   then this exception will be thrown. This obviously isn't the 
	 *   best way to deal with output messages, but it gives you an 
	 *   example of one strict (and simple) way you could deal with 
	 *   this issue. You can read *much* more about line breaking at
	 *   <a href="https://xxyxyz.org/line-breaking/">XXYXYZ</a> site.
	 */
	public void print(String... message) throws IllegalArgumentException {
		width = 50;
		for (String str : message) {
			if (str.length() + 8 > MAX_WIDTH) {
				throw new IllegalArgumentException(
					"Part of the message is too wide for the TextPanel"
					+ " (more than 82 chars):\n\""
					+ str + "\""
				);
			} else if (str.length() + 8 > width){
				width = str.length() + 8;
			}
		}
		
		height = message.length + 8; // includes padding and border
		if (height > MAX_HEIGHT) {
			throw new IllegalArgumentException(
				"Too many lines in the message for the TextPanel"
				+ " (more than 36 lines)."
			);
		}
		
		Box border = new Box(0, height-1, width-1, 0, '*');
		border.setParent(heading);
		border.draw();
		border.shiftCorners(2, -2, -2, 2);
		border.draw();
		// unfortunately, the y value in a 2D plane decreases
		// in the direction humans read down...
		int y = height - 5;
		for (String str : message) {
			centrePlace(heading, str, y--);
		}
		heading.display(width, height); // print the message
		heading.clear(); // so old output is gone for next time
	}
	
	// A private helper method should not be part of the documentation.
	// You are free to read the code to help yourself study.
	private void centrePlace(Screen2D heading, String str, int y) {
		int n = str.length();
		int x = (width - n) / 2;
		for (int i = 0; i < n; i++) {
			heading.set(x + i, y, str.charAt(i));
		}
	}
}
