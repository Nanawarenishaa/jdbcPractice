package jdbcPractice;
import java.applet.Applet;
import java.awt.*;

public class flagApplet extends Applet implements Runnable {
    boolean saffron = false, white = false, green = false;

    public void init() {
        new Thread(this).start();
    }

    public void run() {
        try {
            saffron = true; repaint(); Thread.sleep(500);
            white = true;   repaint(); Thread.sleep(500);
            green = true;   repaint();
        } catch (InterruptedException e) {}
    }

    public void paint(Graphics g) {
        if (saffron) {
            g.setColor(Color.ORANGE);
            g.fillRect(100, 50, 200, 20);
        }
        if (white) {
            g.setColor(Color.WHITE);
            g.fillRect(100, 70, 200, 20);
            g.setColor(Color.BLUE);
            g.drawOval(190, 72, 20, 20); 
        }
        if (green) {
            g.setColor(Color.GREEN);
            g.fillRect(100, 90, 200, 20);
        }

        // Flag pole
        g.setColor(Color.BLACK);
        g.fillRect(95, 50, 5, 200);
    }
}

