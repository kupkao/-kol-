import logic.Ball;
import logic.Direction;
import logic.Wall;

import java.awt.*;
import java.util.ArrayList;

public class GameLogic {
    private Ball ball;
    private Ball ballEnemy;
    private ArrayList<Wall> walls;
    private Wall line;

    public GameLogic() {
        this.ball = null;
        this.ballEnemy = null;
        this.walls = new ArrayList<>();
    }

    public void initialize() {
        ball = new Ball(20, 20, 50, 50, Color.BLUE);
        ballEnemy = new Ball(250, 20, 70, 70, Color.RED);
        Wall wall1 = new Wall(300, 430, 400,430, Color.MAGENTA);
        Wall wall2 = new Wall(400, 20, 400, 100, Color.ORANGE);
        Wall wall3 = new Wall(350,300,600,300, Color.GREEN);
        Wall wall4 = new Wall(150,100,200,150,Color.CYAN);
        walls.add(wall1);
        walls.add(wall2);
        walls.add(wall3);
        walls.add(wall4);
        line = new Wall(400, 20, 400, 100,Color.BLACK);


    }

    public void update() {
        if (ball.isCollided(ballEnemy.getBallRectangle())) {
            ballEnemy.inactive();
        }
        ball.move(2, Direction.RIGHT);
        if (logic.Wall.nevim(ball.getBallRectangle())) {
            System.out.println("Zed a Koule se potkali");
        }

    }


    public Ball getBall() {
        return ball;
    }

    public Ball getBallEnemy() {
        return ballEnemy;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }
}
