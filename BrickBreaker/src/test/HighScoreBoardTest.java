import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HighScoreBoardTest {
    
    private HighScoreBoard highScoreBoard;
    private BrickBreaker mockBrickBreaker;

    @BeforeEach
    void setUp() throws IOException {
        // Mock the main application
        mockBrickBreaker = new BrickBreaker();
        highScoreBoard = new HighScoreBoard(mockBrickBreaker);
        
        // Create a mock score list file
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ScoreList.txt")))) {
            List<Integer> scores = Arrays.asList(30, 40, 20, 10, 50, 40, 20);
            for (int score : scores) {
                writer.println(score);
            }
        }
    }

    @Test
    void testDrawScores() {
        // Create a BufferedImage to draw on
        BufferedImage image = new BufferedImage(Configurations.WIDTH, Configurations.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        try {
            highScoreBoard.drawScores(g2d);

            // Test assertions here to verify the output
            // For simplicity, we will check that the top score is displayed correctly
            assertTrue(image.getRGB(40, 100) != 0); // Check if the first score position has been drawn
        } catch (IOException e) {
            fail("IOException was thrown");
        }
    }
}
