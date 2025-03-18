
import java.awt.AWTException;
import java.awt.Robot;
 
public class Test {
	public static void main(String[] args) {
		try {
			Robot robot = new Robot();
 
			while (true) {
				moveCursor(robot);
				Thread.sleep(30000); // Sleep for 30 seconds
			}
 
		} catch (AWTException | InterruptedException e) {
			e.printStackTrace();
		}
	}
 
	private static void moveCursor(Robot robot) {
		// Get the current position of the cursor
		int x = (int) (Math.random() * 800); // Set x-coordinate to a random value (adjust as needed)
		int y = (int) (Math.random() * 600); // Set y-coordinate to a random value (adjust as needed)
 
		// Move the cursor to the new position
		robot.mouseMove(x, y);
 
		// Optionally, simulate a mouse click to interact with the screen
		// robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		// robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	} 
}

