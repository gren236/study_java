public class RobotTask {
    public static void main(String[] args) {
        Robot robot = new Robot(3,15, Direction.UP);
        moveRobot(robot, 0, 0);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        // Move origin to robot position
        int targetX = toX - robot.getX();
        int targetY = toY - robot.getY();

        // Determine direction for x move (left or right)
        Direction targetDirection;
        int[] targetVector;
        if (targetX >= 0) {
            targetDirection = Direction.RIGHT;
            targetVector = new int[]{1, 0};
        } else {
            targetDirection = Direction.LEFT;
            targetVector = new int[]{-1, 0};
        }

        // Determine turn direction for x and turn
        int determinant = targetVector[0] * targetY;
        while (robot.getDirection() != targetDirection) {
            if (determinant >= 0) {
                robot.turnLeft();
            } else {
                robot.turnRight();
            }
        }

        // Move along x
        for (int i = 0; i < Math.abs(targetX); i++) {
            robot.stepForward();
        }

        // Determine turn direction for y and turn
        if (((targetDirection == Direction.LEFT) && (targetY >= 0)) || ((targetDirection == Direction.RIGHT) && (targetY <= 0))) {
            robot.turnRight();
        } else {
            robot.turnLeft();
        }

        // Move along y
        for (int i = 0; i < Math.abs(targetY); i++) {
            robot.stepForward();
        }
    }
}