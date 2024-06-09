import javax.swing.*; // Import for Swing components
import java.awt.*; // Import for AWT components
import java.io.IOException; // Import for handling IO exceptions

public class BrickBreaker extends JFrame {
    private CardLayout cardLayout; // Layout manager for switching between screens
    private JPanel mainPanel; // Main panel to hold different screens
    private MenuScreen menuScreen; // Menu screen
    private GameBoard gameBoard; // Game board screen
    private HighScoreBoard highScoreBoard; // High score board screen
    private LevelSelectionScreen levelSelectionScreen; // Level selection screen
    private int ballSpeed; // Speed of the ball

    // Constructor for BrickBreaker class that throws IOException
    public BrickBreaker() throws IOException {
        initUI(); // Initialize the UI components
    }

    // Method to initialize the UI
    private void initUI() throws IOException {
        cardLayout = new CardLayout(); // Initialize the CardLayout
        mainPanel = new JPanel(cardLayout); // Create a main panel with CardLayout

        // Initialize screens
        menuScreen = new MenuScreen(this); // Menu screen
        gameBoard = new GameBoard(this); // Game board screen
        highScoreBoard = new HighScoreBoard(this); // High score board screen
        levelSelectionScreen = new LevelSelectionScreen(this); // Level selection screen

        // Add screens to the main panel
        mainPanel.add(menuScreen, "MenuScreen"); // Add menu screen with name "MenuScreen"
        mainPanel.add(gameBoard, "GameBoard"); // Add game board screen with name "GameBoard"
        mainPanel.add(highScoreBoard, "HighScoreBoard"); // Add high score board screen with name "HighScoreBoard"
        mainPanel.add(levelSelectionScreen, "LevelSelectionScreen"); // Add level selection screen with name "LevelSelectionScreen"

        // Set up the frame
        add(mainPanel); // Add main panel to the frame
        setTitle("Brick Breaker"); // Set title of the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Set default close operation
        setLocationRelativeTo(null); // Center the frame on the screen
        setResizable(false); // Disable frame resizing
        pack(); // Pack the components
    }

    // Method to switch to GameBoard screen
    public void showGameBoard() {
        gameBoard.setBallSpeed(ballSpeed); // Set ball speed
        cardLayout.show(mainPanel, "GameBoard"); // Switch to GameBoard screen
        gameBoard.requestFocusInWindow(); // Request focus for GameBoard
    }

    // Method to switch to MenuScreen
    public void showMenuScreen() {
        cardLayout.show(mainPanel, "MenuScreen"); // Switch to MenuScreen
        menuScreen.requestFocusInWindow(); // Request focus for MenuScreen
    }

    // Method to switch to HighScoreBoard
    public void showHighScoreBoard() {
        cardLayout.show(mainPanel, "HighScoreBoard"); // Switch to HighScoreBoard
        highScoreBoard.requestFocusInWindow(); // Request focus for HighScoreBoard
    }

    // Method to switch to LevelSelectionScreen
    public void showLevelSelectionScreen() {
        cardLayout.show(mainPanel, "LevelSelectionScreen"); // Switch to LevelSelectionScreen
    }

    // Getter for the main panel
    public JPanel getMainPanel() {
        return mainPanel;
    }

    // Method to set ball speed
    public void setBallSpeed(int ballSpeed) {
        this.ballSpeed = ballSpeed; // Set ball speed
    }

    // Main method to start the application
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            BrickBreaker game = null; // Initialize BrickBreaker object
            try {
                game = new BrickBreaker(); // Create new BrickBreaker instance
            } catch (IOException e) { // Catch IOException
                e.printStackTrace(); // Print stack trace if exception occurs
            }
            game.setVisible(true); // Set the frame visible
        });
    }
}
