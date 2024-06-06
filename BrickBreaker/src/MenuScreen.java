import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuScreen extends JPanel {
    private BrickBreaker mainApp; // Reference to the main application
    JButton startButton = new JButton("Start Game");
    JButton hsButton = new JButton("High Scores");
    JButton levelButton = new JButton("Select Level");

    public MenuScreen(BrickBreaker mainApp) {
        this.mainApp = mainApp;
        initMenu();
    }

    private void initMenu() {
        setFocusable(true);
        setPreferredSize(new Dimension(Configurations.WIDTH, Configurations.HEIGHT));
        setLayout(null);

        startButton.setBounds((Configurations.WIDTH - 120) / 2, 100, 120, 40);
        hsButton.setBounds((Configurations.WIDTH - 120) / 2, 150, 120, 40);
        levelButton.setBounds((Configurations.WIDTH - 120) / 2, 200, 120, 40);

        add(startButton);
        add(hsButton);
        add(levelButton);

        StartHandler stHandler = new StartHandler();
        startButton.addActionListener(stHandler);

        HSHandler hsHandler = new HSHandler();
        hsButton.addActionListener(hsHandler);

        LevelHandler lvlHandler = new LevelHandler();
        levelButton.addActionListener(lvlHandler);
    }

    private class StartHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainApp.showGameBoard();
        }
    }

    private class HSHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainApp.showHighScoreBoard();
        }
    }

    private class LevelHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainApp.showLevelSelectionScreen();
        }
    }
}
