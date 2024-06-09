import javax.swing.*; // Import for Swing components
import java.awt.*; // Import for AWT components
import java.awt.event.ActionEvent; // Import for handling action events
import java.awt.event.ActionListener; // Import for handling action listeners

public class LevelSelectionScreen extends JPanel {
    private BrickBreaker mainApp; // Reference to the main application
    JButton easyButton = new JButton("Easy"); // Button to select easy level
    JButton mediumButton = new JButton("Medium"); // Button to select medium level
    JButton hardButton = new JButton("Hard"); // Button to select hard level

    // Constructor that accepts a reference to the main application
    public LevelSelectionScreen(BrickBreaker mainApp) {
        this.mainApp = mainApp; // Assign the mainApp reference
        initLevelSelection(); // Initialize the level selection screen
    }

    // Method to initialize the level selection screen
    private void initLevelSelection() {
        setFocusable(true); // Set the panel to be focusable
        setPreferredSize(new Dimension(Configurations.WIDTH, Configurations.HEIGHT)); // Set panel dimensions
        setLayout(null); // Use null layout for manual positioning of components

        // Set bounds for the level selection buttons
        easyButton.setBounds((Configurations.WIDTH - 120) / 2, 100, 120, 40);
        mediumButton.setBounds((Configurations.WIDTH - 120) / 2, 150, 120, 40);
        hardButton.setBounds((Configurations.WIDTH - 120) / 2, 200, 120, 40);

        // Add the level selection buttons to the panel
        add(easyButton);
        add(mediumButton);
        add(hardButton);

        // Add action listener to the easy button
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.setBallSpeed(GameBoard.EASY); // Set ball speed to easy level
                mainApp.showGameBoard(); // Show the game board
            }
        });

        // Add action listener to the medium button
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.setBallSpeed(GameBoard.MEDIUM); // Set ball speed to medium level
                mainApp.showGameBoard(); // Show the game board
            }
        });

        // Add action listener to the hard button
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.setBallSpeed(GameBoard.HARD); // Set ball speed to hard level
                mainApp.showGameBoard(); // Show the game board
            }
        });
    }
}
