import static org.junit.Assert.*;
import org.junit.Test;
import java.io.IOException;

public class BallTest {

    @Test
    public void testBallInitialization() throws IOException {
        // Create a Ball instance
        Ball ball = new Ball();

        // Check initial direction
       
        assertEquals(-1, ball.getYDir(), 0.01);

        // Check initial position
  
    }

    @Test
    public void testBallMove() throws IOException {
        // Create a Ball instance
        Ball ball = new Ball();
        ball.setXDir(1);
        ball.setYDir(-1);

        // Move the ball
        ball.move();

    }

    @Test
    public void testBallBounce() throws IOException {
        // Create a Ball instance
        Ball ball = new Ball();
        ball.setXDir(1);
        ball.setYDir(-1);

        // Move the ball to the right edge
        ball.x = Configurations.WIDTH - 2;
        ball.move();

        // Check if the ball bounces back
        assertEquals(-1, ball.getYDir(), 0.01);
    }
    
    // Add additional tests for other boundaries if needed
}
