import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.awt.EventQueue;
import org.junit.Test;

public class BrickBreakerTest {

    @Test
    public void testBrickBreakerConstructor() {
        EventQueue.invokeLater(() -> {
            try {
                BrickBreaker game = new BrickBreaker();
                assertNotNull("BrickBreaker object is not null", game);
                assertNotNull("Main panel is not null", game.getMainPanel());
                assertTrue("Main panel has components", game.getMainPanel().getComponentCount() > 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
