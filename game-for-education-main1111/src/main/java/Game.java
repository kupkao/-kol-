import logic.Direction;

import javax.swing.*;
import java.awt.event.*;

// Toto je komentář
public class Game {
    GameLogic logic;
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game();
            }
        });
    }

    public Game() {
        logic = new GameLogic();
        GameGraphics graphic = new GameGraphics(logic);
        logic.initialize();
        graphic.render(logic);
        boolean isGameOver = false;

        graphic.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    logic.getBall().move(50, Direction.LEFT);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    logic.getBall().move(50,Direction.RIGHT);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        graphic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int differenceX = e.getX() - logic.getBall().getX();
                int differenceY = e.getY() - logic.getBall().getY() - graphic.getInsets().top;
                if (differenceX > 0 && differenceX < logic.getBall().getWidth() && differenceY > 0 && differenceY < logic.getBall().getHeight()){
                    logic.getBall().move(20,Direction.RIGHT);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.update();
                graphic.render(logic);
            }
        });

        timer.start();
        /*
        ;
        while (!isGameOver){
            logic.update();
            graphic.render();
        }
         */
    }

    public GameLogic getLogic() {
        return logic;
    }
}
