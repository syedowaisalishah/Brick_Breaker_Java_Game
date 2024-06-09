import java.awt.Image;
import java.awt.geom.Rectangle2D;

public class Sprite {

    // Instance variables for position, image dimensions, and the image itself
    double x; // X-coordinate of the sprite
    double y; // Y-coordinate of the sprite
    int imageWidth; // Width of the sprite's image
    int imageHeight; // Height of the sprite's image
    Image image; // Image representing the sprite
    Rectangle2D rectangle2D = new Rectangle2D.Double(); // Rectangle representing the sprite's bounds

    // Setter method for x-coordinate
    protected void setX(double x) {
        this.x = x;
    }

    // Getter method for x-coordinate
    double getX() {
        return x;
    }

    // Setter method for y-coordinate
    protected void setY(double y) {
        this.y = y;
    }

    // Getter method for y-coordinate
    double getY() {
        return y;
    }

    // Getter method for image width
    int getImageWidth() {
        return imageWidth;
    }

    // Getter method for image height
    int getImageHeight() {
        return imageHeight;
    }

    // Getter method for the image
    Image getImage() {
        return image;
    }

    // Method to get the rectangular bounds of the sprite
    Rectangle2D getRect() {
        // Set the rectangle bounds to the current position and image dimensions
        rectangle2D.setRect(x, y, image.getWidth(null), image.getHeight(null));
        return rectangle2D;
    }

    // Method to retrieve the dimensions of the image
    void getImageDimensions() {
        imageWidth = image.getWidth(null); // Get the width of the image
        imageHeight = image.getHeight(null); // Get the height of the image
    }
}
