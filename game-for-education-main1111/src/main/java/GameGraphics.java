
import logic.Wall;

import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JFrame {
    Draw draw;
    GameLogic logic;
    public GameGraphics(GameLogic logic) throws HeadlessException {

        this.draw = new Draw();
        this.logic = logic;

        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Game");
        setBackground(Color.BLACK);

        add(draw);
    }

    public void render(GameLogic logic) {
        this.logic = logic;
        repaint();
    }

    public class Draw extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            if (logic.getBall().isRendered()) {
                g.setColor(logic.getBall().getColor());
                g.fillOval(logic.getBall().getX(), logic.getBall().getY(), logic.getBall().getWidth(), logic.getBall().getHeight());
            }
            if (logic.getBallEnemy().isRendered()) {
                g.setColor(logic.getBallEnemy().getColor());
                g.fillOval(logic.getBallEnemy().getX(), logic.getBallEnemy().getY(), logic.getBallEnemy().getWidth(), logic.getBallEnemy().getHeight());
            }
            for (Wall wall: logic.getWalls()){
                g.setColor(wall.getColor());
                g.drawLine(wall.getStart().x, wall.getStart().y, wall.getStop().x, wall.getStop().y);
            }
        }
    }
}
