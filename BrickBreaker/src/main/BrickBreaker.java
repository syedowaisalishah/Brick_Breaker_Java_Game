import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        menuScreen = new MenuScreen(this);
        gameBoard = new GameBoard(this);
        highScoreBoard = new HighScoreBoard(this);
        levelSelectionScreen = new LevelSelectionScreen(this);

        mainPanel.add(menuScreen, "MenuScreen");
        mainPanel.add(gameBoard, "GameBoard");
        mainPanel.add(highScoreBoard, "HighScoreBoard");
        mainPanel.add(levelSelectionScreen, "LevelSelectionScreen");

        add(mainPanel);
        setTitle("Brick Breaker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(800, 600);
    
        applyFadeEffect(mainPanel);
    }

    private void applyFadeEffect(JPanel panel) {
        Timer timer = new Timer(10, new ActionListener() {
            float alpha = 0f;
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                if (alpha >= 1f) {
                    ((Timer) e.getSource()).stop();
                }
                panel.repaint();
            }
        });
        timer.start();
    }

    public void showGameBoard() {
        gameBoard.setBallSpeed(ballSpeed);
        cardLayout.show(mainPanel, "GameBoard");
        gameBoard.requestFocusInWindow();
    }

    public void showMenuScreen() {
        cardLayout.show(mainPanel, "MenuScreen");
        menuScreen.requestFocusInWindow();
    }

    public void showHighScoreBoard() {
        cardLayout.show(mainPanel, "HighScoreBoard");
        highScoreBoard.requestFocusInWindow();
    }

    public void showLevelSelectionScreen() {
        cardLayout.show(mainPanel, "LevelSelectionScreen");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setBallSpeed(int ballSpeed) {
        this.ballSpeed = ballSpeed;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BrickBreaker game = new BrickBreaker();
                game.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
