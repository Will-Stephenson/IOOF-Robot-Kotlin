import CardinalDirection.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RobotUnitTest {

    private lateinit var testRobot: Robot //= Robot()

    @BeforeEach
    internal fun createRobot(){
        testRobot = Robot(1,2,NORTH)
    }

    @Test
    internal fun setPosition() {
        testRobot.setPosition(2,4)
        Assertions.assertEquals(2,testRobot.xPos)
        Assertions.assertEquals(4,testRobot.yPos)
    }

    @Test
    internal fun move() {
        testRobot.move()
        Assertions.assertEquals(1,testRobot.xPos)
        Assertions.assertEquals(3,testRobot.yPos)
    }

    @Test
    internal fun rotateLeft() {
        testRobot.rotate(Direction.LEFT)
        Assertions.assertEquals(WEST, testRobot.direction)
    }

    @Test
    fun rotateRight() {
        testRobot.rotate(Direction.RIGHT)
        Assertions.assertEquals(EAST, testRobot.direction)
    }

}