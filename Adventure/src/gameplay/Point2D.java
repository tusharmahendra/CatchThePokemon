package gameplay;

/**
 * A coordinate point in the 2D plane.
 * 
 * @author Dr Russell Campbell
 */
public class Point2D {
  public int x;
  public int y;
  
  /**
   * You need to provide an x and y value to create a point.
   * 
   * @param x
   *   The horizontal coordinate value.
   * 
   * @param y
   *   The vertical coordinate value.
   *   
   */
  public Point2D(int x, int y) {
	  this.x = x;
	  this.y = y;
  }
  
  /**
   * This method modifies the <code>x</code> and <code>y</code> values.
   * 
   * @param dx
   *   Used to add <code>dx</code> to <code>x</code>.
   * 
   * @param dy
   *   Used to add <code>dy</code> to <code>y</code>.
   */
  public void translate(int dx, int dy) {
	  x += dx;
	  y += dy;
  }
}
