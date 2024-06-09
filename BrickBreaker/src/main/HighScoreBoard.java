import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class HighScoreBoard extends JPanel {
    private BrickBreaker mainApp; // Reference to the main application
    JButton rtnMenuButton = new JButton("Return");

    public HighScoreBoard(BrickBreaker mainApp) throws FileNotFoundException {
        this.mainApp = mainApp;
        initBoard();
    }

    private void initBoard() {
        setFocusable(true);
        setPreferredSize(new Dimension(Configurations.WIDTH, Configurations.HEIGHT));
        setLayout(null);

        rtnMenuButton.setBounds(10, 10, 75, 20);
        add(rtnMenuButton);

        ReturnHandler rtnHandler = new ReturnHandler();
        rtnMenuButton.addActionListener(rtnHandler);
    }

    private class ReturnHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainApp.showMenuScreen();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;

        try {
            drawScores(g2d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawScores(Graphics2D g2d) throws IOException {
        FileReader in = new FileReader("ScoreList.txt");
        BufferedReader br = new BufferedReader(in);

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.RED);
        g2d.setFont(font);
        g2d.drawString("Top 5 scores",
                (Configurations.WIDTH - fontMetrics.stringWidth("Top 5 scores")) / 2,
                50);

        TreeSet<Integer> scores = new TreeSet<>(Collections.reverseOrder());
        String line = br.readLine();
        int y = 100;

        if (line == null) {
            var font3 = new Font("Verdana", Font.BOLD, 15);
            g2d.setColor(Color.BLACK);
            g2d.setFont(font3);
            g2d.drawString("No Scores yet!", 40, y);
        } else {
            while (line != null) {
                scores.add(Integer.parseInt(line));
                line = br.readLine();
            }

            var font2 = new Font("Verdana", Font.BOLD, 15);
            g2d.setColor(Color.BLACK);
            g2d.setFont(font2);

            int i = 0;
            for (int score : scores) {
                if (i >= 5) break;
                g2d.drawString("#" + (i + 1) + ": " + score, 40, y);
                y += 30;
                i++;
            }
            br.close();
            in.close();
        }
    }
}
