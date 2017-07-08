package snake;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Created by dan on 04.07.2017.
 */
@SuppressWarnings("Serial")
public class RenderPanel extends JPanel {
    public static Color green = new Color(1666073);

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(green);
        g.fillRect(0, 0, 800, 800);



    }
}
