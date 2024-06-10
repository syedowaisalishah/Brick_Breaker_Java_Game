
import javax.swing.*; // Import for Swing components
import java.awt.*; // Import for AWT components
import java.awt.event.ActionEvent; // Import for handling action events
import java.awt.event.ActionListener; // Import for handling action listeners
import java.io.*; // Import for handling IO exceptions
import java.util.*; // Import for collections

public class HighScoreBoard extends JPanel {
    private BrickBreaker mainApp; // Reference to the main application
    JButton rtnMenuButton = new JButton("Return"); // Button to return to the main menu

    // Constructor that accepts a reference to the main application
    public HighScoreBoard(BrickBreaker mainApp) throws FileNotFoundException {
        this.mainApp = mainApp; // Assign the mainApp reference
        initBoard(); // Initialize the game board
    }
    public JButton getRtnMenuButton() {
        return rtnMenuButton;
    }
    

    // Method to initialize the game board
    private void initBoard() {
        setFocusable(true); // Set the panel to be focusable
        setPreferredSize(new Dimension(Configurations.WIDTH, Configurations.HEIGHT)); // Set panel dimensions
        setLayout(null); // Use null layout for manual positioning of components

        rtnMenuButton.setBounds(10, 10, 75, 20); // Set bounds for the return button
        add(rtnMenuButton); // Add the return button to the panel

        ReturnHandler rtnHandler = new ReturnHandler(); // Create a handler for the return button
        rtnMenuButton.addActionListener(rtnHandler); // Add action listener to the return button
    }

    // Inner class to handle return button actions
    private class ReturnHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainApp.showMenuScreen(); // Show the main menu screen when the return button is pressed
        }
    }

    // Override paintComponent method to draw on the panel
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call superclass method to ensure proper rendering

        var g2d = (Graphics2D) g; // Cast Graphics object to Graphics2D

        try {
            drawScores(g2d); // Draw the high scores
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }
    }

    // Method to draw the high scores on the panel
    private void drawScores(Graphics2D g2d) throws IOException {
        FileReader in = new FileReader("ScoreList.txt"); // Open file reader to read scores file
        BufferedReader br = new BufferedReader(in); // Create buffered reader for efficient reading

        var font = new Font("Verdana", Font.BOLD, 18); // Define font for high scores title
        FontMetrics fontMetrics = this.getFontMetrics(font); // Get font metrics for positioning

        g2d.setColor(Color.RED); // Set color for high scores title
        g2d.setFont(font); // Set font for high scores title
        g2d.drawString("Top 5 scores",
                (Configurations.WIDTH - fontMetrics.stringWidth("Top 5 scores")) / 2,
                50); // Draw title for high scores centered at the top

        TreeSet<Integer> scores = new TreeSet<>(Collections.reverseOrder()); // Create TreeSet to store scores in descending order
        String line = br.readLine(); // Read the first line from the scores file
        int y = 100; // Initial Y-coordinate for drawing scores

        if (line == null) { // Check if the file is empty
            var font3 = new Font("Verdana", Font.BOLD, 15); // Define font for "No Scores yet!" message
            g2d.setColor(Color.BLACK); // Set color for the message
            g2d.setFont(font3); // Set font for the message
            g2d.drawString("No Scores yet!", 40, y); // Draw message indicating no scores
        } else {
            while (line != null) { // Loop to read all scores from the file
                scores.add(Integer.parseInt(line)); // Parse score from the line and add to TreeSet
                line = br.readLine(); // Read the next line
            }

            var font2 = new Font("Verdana", Font.BOLD, 15); // Define font for individual scores
            g2d.setColor(Color.BLACK); // Set color for individual scores
            g2d.setFont(font2); // Set font for individual scores

            int i = 0; // Counter for top 5 scores
            for (int score : scores) {
                if (i >= 5) break; // Break loop if top 5 scores are drawn
                g2d.drawString("#" + (i + 1) + ": " + score, 40, y); // Draw each score with rank
                y += 30; // Increment Y-coordinate for next score
                i++; // Increment counter
            }
            br.close(); // Close buffered reader
            in.close(); // Close file reader
        }
    }
   
}
