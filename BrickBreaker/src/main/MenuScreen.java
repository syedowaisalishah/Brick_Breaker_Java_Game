import javax.swing.*; // Import for Swing components
import java.awt.*; // Import for AWT components
import java.awt.event.ActionEvent; // Import for handling action events
import java.awt.event.ActionListener; // Import for handling action listeners

public class MenuScreen extends JPanel {
    private BrickBreaker mainApp; // Reference to the main application
    JButton startButton = new JButton("Start Game"); // Button to start the game
    JButton hsButton = new JButton("High Scores"); // Button to view high scores
    JButton levelButton = new JButton("Select Level"); // Button to select difficulty level

    // Constructor that accepts a reference to the main application
  // Constructor that accepts a reference to the main application
public MenuScreen(BrickBreaker mainApp) {
    this.mainApp = mainApp; // Assign the mainApp reference
    initMenu(); // Initialize the menu screen
}

// Method to initialize the menu screen
private void initMenu() {
    setFocusable(true); // Set the panel to be focusable
    setPreferredSize(new Dimension(Configurations.WIDTH, Configurations.HEIGHT)); // Set panel dimensions
    setLayout(null); // Use null layout for manual positioning of components

    // Set bounds for the menu buttons
    startButton.setBounds((Configurations.WIDTH - 120) / 2, 100, 120, 40);
    hsButton.setBounds((Configurations.WIDTH - 120) / 2, 150, 120, 40);
    levelButton.setBounds((Configurations.WIDTH - 120) / 2, 200, 120, 40);

    // Add the menu buttons to the panel
    add(startButton);
    add(hsButton);
    add(levelButton);

    // Add action listener to the start button
    StartHandler stHandler = new StartHandler();
    startButton.addActionListener(stHandler);

    // Add action listener to the high scores button
    HSHandler hsHandler = new HSHandler();
    hsButton.addActionListener(hsHandler);

    // Add action listener to the level selection button
    LevelHandler lvlHandler = new LevelHandler();
    levelButton.addActionListener(lvlHandler);
}


    // Getter for the start button
    public JButton getStartButton() {
        return startButton;
    }

    // Getter for the high scores button
    public JButton getHsButton() {
        return hsButton;
    }

    // Getter for the level selection button
    public JButton getLevelButton() {
        return levelButton;
    }

    // Inner class to handle start button actions
    private class StartHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainApp.showGameBoard(); // Show the game board
        }

    
    }

    // Inner class to handle high scores button actions
    private class HSHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainApp.showHighScoreBoard(); // Show the high scores board
        }
    }

    // Inner class to handle level selection button actions
    private class LevelHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainApp.showLevelSelectionScreen(); // Show the level selection screen
        }
    }


}
