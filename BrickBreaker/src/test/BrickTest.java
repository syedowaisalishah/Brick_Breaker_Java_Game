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

    @Test
    public void testBrickContainsItem() throws IOException {
        // We need to run this test multiple times due to randomness
        boolean itemFound = false;
        
        // Run the test 1000 times to account for randomness
        for (int i = 0; i < 1000; i++) {
            // Create a brick
            Brick brick = new Brick(100, 150);
            
            // Check if the brick contains an item
            if (brick.hasItem()) {
                itemFound = true;
                break;
            }
        }
        
        // Assert that at least one brick out of 1000 contains an item
        assertTrue("Item should be found in at least one of the 1000 bricks", itemFound);
    }
}
