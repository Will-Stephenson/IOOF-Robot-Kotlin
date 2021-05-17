import CardinalDirection.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RobotIntegrationTest {

    private lateinit var testRobot: Robot

    @BeforeEach
    internal fun createRobot(){
        testRobot = Robot(1,2,NORTH)
    }

    @Test
    fun moveRobot() {
        testRobot = Robot(1, 2, EAST)
        testRobot.move()
        testRobot.move()
        testRobot.move()
        Assertions.assertEquals(4, testRobot.xPos)
        Assertions.assertEquals(2, testRobot.yPos)
    }

    @Test
    fun moveAndRotateRobot() {
        testRobot = Robot(2, 1, NORTH)
        testRobot.move()
        testRobot.rotate(Direction.RIGHT)
        testRobot.move()
        testRobot.rotate(Direction.LEFT)
        testRobot.move()
        Assertions.assertEquals(3, testRobot.xPos)
        Assertions.assertEquals(3, testRobot.yPos)
        Assertions.assertEquals(NORTH, testRobot.direction)
    }

    @Test
    fun moveRobotOverEdge() {
        testRobot = Robot(1, 1, NORTH)
        testRobot.move()
        testRobot.move()
        testRobot.move()
        testRobot.move()
        testRobot.move()
        testRobot.move()
        Assertions.assertEquals(1, testRobot.xPos)
        Assertions.assertEquals(5, testRobot.yPos)
    }

    @Test
    fun placeRobot() {
        testRobot = Robot()
        val placeArgs:List<String> = listOf("1","3","WEST")
        val placeCommand = Command(CommandType.PLACE,placeArgs)
        RobotControl.executeCommand(placeCommand, testRobot)
        Assertions.assertEquals(1, testRobot.xPos)
        Assertions.assertEquals(3, testRobot.yPos)
        Assertions.assertEquals(WEST, testRobot.direction)
    }

    @Test
    fun placeAndMoveRobot() {
        testRobot = Robot()
        val placeArgs:List<String> = listOf("4","2","SOUTH")
        val placeCommand = Command(CommandType.PLACE,placeArgs)
        RobotControl.executeCommand(placeCommand, testRobot)
        val moveCommand = Command(CommandType.MOVE)
        RobotControl.executeCommand(moveCommand, testRobot)
        Assertions.assertEquals(4, testRobot.xPos)
        Assertions.assertEquals(1, testRobot.yPos)
        Assertions.assertEquals(SOUTH, testRobot.direction)
    }

    @Test
    fun placeAndRotateRobot() {
        testRobot = Robot()
        val placeArgs:List<String> = listOf("4","2","EAST")
        val placeCommand = Command(CommandType.PLACE,placeArgs)
        RobotControl.executeCommand(placeCommand, testRobot)
        val rotateCommand = Command(CommandType.RIGHT)
        RobotControl.executeCommand(rotateCommand, testRobot)
        Assertions.assertEquals(4, testRobot.xPos)
        Assertions.assertEquals(2, testRobot.yPos)
        Assertions.assertEquals(SOUTH, testRobot.direction)
    }

    @Test
    fun parseInput() {
        val command = RobotControl.parseInput("PLACE 4,3,EAST")
        Assertions.assertEquals(CommandType.PLACE, command.commandType)
        Assertions.assertEquals(4, command.args!![0].toInt())
        Assertions.assertEquals(3, command.args!![1].toInt())
        Assertions.assertEquals(EAST, CardinalDirection.valueOf(command.args!![2]))
    }

}