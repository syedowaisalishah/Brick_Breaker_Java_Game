import javax.imageio.ImageIO; // Import for reading image files
import javax.swing.ImageIcon; // Import for handling image icons
import java.io.IOException; // Import for handling IO exceptions

// Ball class extends Sprite class
public class Ball extends Sprite {

    // Variables for the direction of the ball's movement
    private double xdir;
    private double ydir;

    // Constructor for Ball class that throws an IOException
    public Ball() throws IOException {
        initBall(); // Initialize the ball
    }

    // Method to initialize the ball
    private void initBall() throws IOException {
        xdir = 1; // Set initial x direction
        ydir = -1; // Set initial y direction

        loadImage(); // Load the ball image
        getImageDimensions(); // Get the dimensions of the image
        resetState(); // Reset the ball's position
    }

    // Method to load the ball image
    private void loadImage() throws IOException {
        // Load the image from the specified path and set it to the image variable
        var ii = new ImageIcon(ImageIO.read(Ball.class.getResource("/images/ball.png")));
        image = ii.getImage();
    }

    // Method to move the ball
    void move() {
        x += xdir; // Update x position by adding x direction
        y += ydir; // Update y position by adding y direction

        // Check if the ball hits the right edge of the screen
        if (x + 2 >= (Configurations.WIDTH)) {
            xdir *= -1; // Reverse x direction
            setXDir(xdir); // Update x direction
        }
        // Check if the ball hits the left edge of the screen
        else if (x <= 0) {
            xdir *= -1; // Reverse x direction
            x = xdir; // Update x position
        }
        // Check if the ball hits the top edge of the screen
        else if (y <= 0) {
            ydir *= -1; // Reverse y direction
            y = ydir; // Update y position
        }
    }

    // Method to reset the ball's position to its initial state
    private void resetState() {
        x = Configurations.INIT_BALL_X; // Set initial x position
        y = Configurations.INIT_BALL_Y; // Set initial y position
    }

    // Setter for x direction
    void setXDir(double x) {
        xdir = x;
    }

    // Setter for y direction
    void setYDir(double y) {
        ydir = y;
    }

    // Getter for y direction
    double getYDir() {
        return ydir;
    }
}
