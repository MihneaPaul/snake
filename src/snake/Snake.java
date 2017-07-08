package snake;

import javafx.scene.effect.Light;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.Point;
import java.util.Random;

/**
 * Created by dan on 04.07.2017.
 */
public class Snake implements ActionListener {
    public JFrame jframe;

    public Toolkit toolkit;

    public static Snake snake;

    public RenderPanel renderPanel;

    public Timer timer = new Timer(20, this);

    public ArrayList<Point> snakeParts = new ArrayList<Point>();
    public int ticks = 0, direction = DOWN, score;
    public Point head, cherry;
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGT = 3, SCALE = 10;
    public Random random;
    public Dimension dim;
    public boolean over = false;

    public Snake() {

        dim = Toolkit.getDefaultToolkit().getScreenSize();
        toolkit = Toolkit.getDefaultToolkit();
        jframe = new JFrame("Snake");
        jframe.setVisible(true);
        jframe.setSize(800, 800);
        jframe.setLocation(dim.width / 2 * jframe.getWidth() / 2, dim.height / 2 * jframe.getHeight() / 2);
        jframe.add(renderPanel = new RenderPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
        random = new Random();
        cherry = new Point(dim.width / SCALE, dim.height / SCALE);
        head = new Point(0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        renderPanel.repaint();
        ticks++;
        if (ticks % 10 == 0 && head != null && over != true) ;
        if (direction == UP){
            if (head.y -1 > 0)
                snakeParts.add(new Point(head.x, head.y - 1));
            else
                over = true;
        }


        if (direction == DOWN)
            snakeParts.add(new Point(head.x, head.y + 1));
        if (direction == LEFT)
            snakeParts.add(new Point(head.x - 1, head.y));
        if (direction == RIGT)
            snakeParts.add(new Point(head.x + 1, head.y));
        if (cherry != null) {
            if (head.equals(cherry))
            {
                score++;
                cherry.setLocation(dim.width / SCALE, dim.height/SCALE);
            }

        }

    }


    public static void main(String[] args) {
        snake = new Snake();

    }


}

