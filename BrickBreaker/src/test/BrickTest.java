import static org.junit.Assert.*;
import org.junit.Test;

import java.io.IOException;

public class BrickTest {


    @Test
    public void testBrickDestroyed() throws IOException {
        // Create a brick
        Brick brick = new Brick(100, 150);
        
        // Check if the brick is not destroyed initially
        assertFalse(brick.isDestroyed());
        
        // Call doDamage() to destroy the brick
        brick.doDamage();
        
        // Check if the brick is now destroyed
        assertTrue(brick.isDestroyed());
    }

        
        
}
