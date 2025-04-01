package jdbcPractice;

import javax.swing.*;
import java.awt.*;

public class SrollText extends JFrame {
    private int x = 10, direction = 2;

    public SrollText() {
        setTitle("Scrolling Text"); setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE); setLocationRelativeTo(null);
        JLabel label = new JLabel("Scrolling Text");
        label.setFont(new Font("Arial", Font.BOLD, 20)); add(label);
        Timer timer = new Timer(20, e -> {
            x += direction;
            if (x <= 0 || x + label.getPreferredSize().width >= getWidth()) direction *= -1;
            label.setLocation(x, getHeight() / 2);
        }); timer.start();
        setLayout(null); label.setSize(label.getPreferredSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ScrollingText().setVisible(true));
    }
}
