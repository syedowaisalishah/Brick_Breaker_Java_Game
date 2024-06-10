
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;

public class Brick extends Sprite {
    private boolean destroyed;
    // private boolean containsItem;

    public Brick(int x, int y) throws IOException {
        initBrick(x, y);
    }

    private void initBrick(int x, int y) throws IOException {
        this.x = x;
        this.y = y;
        this.destroyed = false;
        // this.containsItem = false;

        loadImage(0);
        getImageDimensions();

        // 10% chance the brick contains an item
        int random = (int) (Math.random() * 100) + 1;
        if (random < 10) {
            // containsItem = true;
            loadImage(1);
        }
    }

    private void loadImage(int index) throws IOException {
        if (index == 0) {
            var ii = new ImageIcon(ImageIO.read(Brick.class.getResource("/images/brick.png")));
            image = ii.getImage();
        } else {
            System.out.println("Bad index passed to Brick loadImage");
        }
    }

    void doDamage() {
        destroyed = true;
    }

    boolean isDestroyed() {
        return destroyed;
    }

    // boolean hasItem() {
    //     return containsItem;
    // }
}