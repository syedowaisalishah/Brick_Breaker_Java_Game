import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;


public class RacketTest {

    @Test
    public void testRacketInitialization() throws IOException {
        Racket racket = new Racket(0);

        // Verify initial position
        assertEquals(Configurations.INIT_PADDLE_X, racket.getX(), 0.01);
        assertEquals(Configurations.INIT_PADDLE_Y, racket.getY(), 0.01);

        // Verify image dimensions
        assertNotNull(racket.getImage());
        assertEquals(racket.getImage().getWidth(null), racket.getImageWidth());
        assertEquals(racket.getImage().getHeight(null), racket.getImageHeight());
    }
}
