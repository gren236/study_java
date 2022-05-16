package robotexception;

public class Main {
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);

                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2) throw e;
            } catch (Throwable e){
                throw e;
            }
        }
    }

    public static void main(String[] args) {

    }
}
