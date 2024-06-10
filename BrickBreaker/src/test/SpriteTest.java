import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.geom.Rectangle2D;

public class SpriteTest {

    @Test
    public void testSpritePosition() {
        Sprite sprite = new Sprite();
        
        // Test setting and getting x coordinate
        sprite.setX(50);
        assertEquals(50, sprite.getX(), 0.01);

        // Test setting and getting y coordinate
        sprite.setY(100);
        assertEquals(100, sprite.getY(), 0.01);
    }

    @Test
    public void testImageDimensions() {
        Sprite sprite = new Sprite();
        ImageIcon ii = new ImageIcon(getClass().getResource("/images/paddle.png"));
        Image image = ii.getImage();
        sprite.image = image;

        // Retrieve image dimensions
        sprite.getImageDimensions();
        assertEquals(image.getWidth(null), sprite.getImageWidth());
        assertEquals(image.getHeight(null), sprite.getImageHeight());
    }

    @Test
    public void testGetRect() {
        Sprite sprite = new Sprite();
        ImageIcon ii = new ImageIcon(getClass().getResource("/images/paddle.png"));
        Image image = ii.getImage();
        sprite.image = image;

        // Set sprite position
        sprite.setX(50);
        sprite.setY(100);

        // Retrieve image dimensions
        sprite.getImageDimensions();
        
        // Get rectangle bounds
        Rectangle2D rect = sprite.getRect();

        assertEquals(50, rect.getX(), 0.01);
        assertEquals(100, rect.getY(), 0.01);
        assertEquals(image.getWidth(null), rect.getWidth(), 0.01);
        assertEquals(image.getHeight(null), rect.getHeight(), 0.01);
    }
}
