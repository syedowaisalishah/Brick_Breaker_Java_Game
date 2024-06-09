import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BrickBreaker extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private MenuScreen menuScreen;
    private GameBoard gameBoard;
    private HighScoreBoard highScoreBoard;
    private LevelSelectionScreen levelSelectionScreen;
    private int ballSpeed;

    public BrickBreaker() throws IOException {
        initUI();
    }

    private void initUI() throws IOException {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Initialize screens
        menuScreen = new MenuScreen(this);
        gameBoard = new GameBoard(this);
        highScoreBoard = new HighScoreBoard(this);
        levelSelectionScreen = new LevelSelectionScreen(this);

        // Add screens to the main panel
        mainPanel.add(menuScreen, "MenuScreen");
        mainPanel.add(gameBoard, "GameBoard");
        mainPanel.add(highScoreBoard, "HighScoreBoard");
        mainPanel.add(levelSelectionScreen, "LevelSelectionScreen");

        // Set up the frame
        add(mainPanel);
        setTitle("Brick Breaker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }

    // Method to switch to GameBoard
    public void showGameBoard() {
        gameBoard.setBallSpeed(ballSpeed);
        cardLayout.show(mainPanel, "GameBoard");
        gameBoard.requestFocusInWindow();
    }

    // Method to switch to MenuScreen
    public void showMenuScreen() {
        cardLayout.show(mainPanel, "MenuScreen");
        menuScreen.requestFocusInWindow();
    }

    // Method to switch to HighScoreBoard
    public void showHighScoreBoard() {
        cardLayout.show(mainPanel, "HighScoreBoard");
        highScoreBoard.requestFocusInWindow();
    }

    // Method to switch to LevelSelectionScreen
    public void showLevelSelectionScreen() {
        cardLayout.show(mainPanel, "LevelSelectionScreen");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    // Method to set ball speed
    public void setBallSpeed(int ballSpeed) {
        this.ballSpeed = ballSpeed;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            BrickBreaker game = null;
            try {
                game = new BrickBreaker();
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.setVisible(true);
        });
    }
}
