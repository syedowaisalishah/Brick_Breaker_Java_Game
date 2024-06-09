import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelSelectionScreen extends JPanel {
    private BrickBreaker mainApp; // Reference to the main application
    JButton easyButton = new JButton("Easy");
    JButton mediumButton = new JButton("Medium");
    JButton hardButton = new JButton("Hard");

    public LevelSelectionScreen(BrickBreaker mainApp) {
        this.mainApp = mainApp;
        initLevelSelection();
    }

    private void initLevelSelection() {
        setFocusable(true);
        setPreferredSize(new Dimension(Configurations.WIDTH, Configurations.HEIGHT));
        setLayout(null);

        easyButton.setBounds((Configurations.WIDTH - 120) / 2, 100, 120, 40);
        mediumButton.setBounds((Configurations.WIDTH - 120) / 2, 150, 120, 40);
        hardButton.setBounds((Configurations.WIDTH - 120) / 2, 200, 120, 40);

        add(easyButton);
        add(mediumButton);
        add(hardButton);

        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.setBallSpeed(GameBoard.EASY);
                mainApp.showGameBoard();
            }
        });

        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.setBallSpeed(GameBoard.MEDIUM);
                mainApp.showGameBoard();
            }
        });

        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.setBallSpeed(GameBoard.HARD);
                mainApp.showGameBoard();
            }
        });
    }
}
