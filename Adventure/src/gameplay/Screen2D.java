package gameplay;

import java.util.Arrays;

/**
 * Note the changes to this class for use with the other code in this project.
 * This class encapsulates (hides) the confusion of working with the 2D char array
 * directly elsewhere in our program.
 * 
 * @author Dr Russell Campbell
 *
 */
public class Screen2D {
	// Note that we only need to share one instance of a StringBuilder for
	// actually printing output.
	private static StringBuilder output = new StringBuilder();
	// private instance variables
	private int width;
	private int height;
	private char fill = '`';
	private char[][] panel;
	
	/**
	 * A good default size is somewhere close to videographic aspect ratios.
	 * Keep in mind that each text character is NOT square. Default width is set
	 * to 80 chars, and default height is set to 30 chars.
	 */
	public Screen2D() {
		this(80, 30);
	}
	
	/**
	 * You may want to have more than one output screen to do some of your own
	 * graphics as part of your game (for example, maps, or effects).
	 * 
	 * @param width
	 *   The number of chars in the horizontal axis of the 2D char array.
	 * 
	 * @param height
	 *   The number of chars in the vertical axis of the 2D char array.
	 */
	public Screen2D(int width, int height) {
		this.width = width;
		this.height = height;
		panel = new char[height][width];
		clear();
	}
	
	/**
	 * This will fill the 2D char array with backtick <code>`</code> characters
	 * (usually under the tilde ~ in the top-left corner of a keyboard).
	 */
	public void clear() {
		// every character in the screen is set to a default char
		for (int i = 0; i < panel.length; i++) {
			Arrays.fill(panel[i], fill);
		}
	}

	/**
	 * This method swaps the order of the <code>x</code> and <code>y</code>
	 * values for us (so we don't have to swap them everywhere else in our code). 
	 * 
	 * @param x 
	 *   The horizontal position inside the 2D char array.
	 *   
	 * @param y 
	 *   The vertical position inside the 2D char array.
	 *   
	 * @return
	 *   The char value stored in the 2D char array at column 
	 *   <code>x</code> and row <code>y</code>.
	 */
	public char get(int x, int y) {
		return panel[y][x];
	}

	/**
	 * Similar to the <code>get</code> method, but assign a char 
	 * value to an <code>x</code> and <code>y</code> position in 
	 * the 2D char array.
	 * 
	 * @param x
	 *   The column position in the 2D char array.
	 * 
	 * @param y
	 *   The row position in the 2D char array.
	 * 
	 * @param c
	 *   The char value to store in the 2D char array.
	 * 
	 */
	public void set(int x, int y, char c) {
		// check if the point is outside the screen boundaries
		if (0 <= x && x < width && 0 <= y && y < height)
			panel[y][x] = c;
	}
	
	/**
	 * Actually print the 2D char array to output.
	 * 
	 * @param width
	 *   The characters in the 2D char array that will be displayed,
	 *   along the horizontal axis interval <code>[0, width)</code>.
	 *   
	 * @param height
	 *   The characters in the 2D char array that will be displayed,
	 *   along the vertical axis interval <code>[0, height)</code>.
	 */
	public void display(int width, int height) {
		for (int y = height - 1; y >= 0; y--) {
			for (int x = 0; x < width; x++) {
				output.append(get(x, y));
			}
			output.append('\n');
		}
		System.out.print(output);
		// Clear the StringBuilder so it is ready for
		// the next call to display.
		output.delete(0, output.length());
	}
	
	/**
	 * Avoids using floating-point arithmetic for a faster drawing
	 * of a line. Feel free to ask me about the math and why it works.
	 * 
	 * @param first 
	 *   The start position of the straight line.
	 *   
	 * @param second 
	 *   The end position of the straight line.
	 *   
	 * @param stroke 
	 *   The character used to draw the line.
	 */
	public void drawLine(Point2D first, Point2D second, char stroke) {

		// Bresenham's Line Algorithm
		int x1 = first.x;
		int y1 = first.y;
		int x2 = second.x;
		int y2 = second.y;
		byte stepx, stepy;

		int dx = x2 - x1;
		int dy = y2 - y1;

		// Simplify keeping track of distance by removing direction (sign)
		// from the amount of changes in position for each step.
		// Let the direction be taken care of with step variables.
		if (dy < 0) { dy = -dy; stepy = -1; } else { stepy = 1; }
		if (dx < 0) { dx = -dx; stepx = -1; } else { stepx = 1; }
		dy <<= 1; // dy is now 2*dy
		dx <<= 1; // dx is now 2*dx
		set(x1, y1, stroke);

		// the algorithm is simplified by ensuring slope m is always -1 < m < 1
		if (dx > dy) {
			int error = dy - (dx >> 1);
			while (x1 != x2) {
				x1 += stepx;
				error += dy;
				if (error >= 0) {
					y1 += stepy;
					error -= dx;
				}
				set(x1, y1, stroke);
			}
		} else { // but this means we may have to swap roles for dy and dx
			int error = dx - (dy >> 1);
			while (y1 != y2) {
				y1 += stepy;
				error += dx;
				if (error >= 0) {
					x1 += stepx;
					error -= dy;
				}
				set(x1, y1, stroke);
			}
		}
	} // end of drawLine method
}
