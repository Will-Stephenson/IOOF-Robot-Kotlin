import CardinalDirection.*
import Direction.*

const val TABLE_SIZE = 5

/**
 * Class which holds the constructor and functions for a robot entity
 * A robot has a position (made of x and y coordinates) and a direction (North, EAST, SOUTH, or WEST)
 */
class Robot (_xPos: Int = 0, _yPos: Int = 0, _direction: CardinalDirection = NORTH) {

    var direction: CardinalDirection = _direction

    var xPos: Int = _xPos
        set(value) {
            field = if(value in 1..TABLE_SIZE) value else 0
            if(field == 0) println("yPos must be between 1 - 5")
        }

    var yPos: Int = _yPos
        set(value) {
            field = if(value in 1..TABLE_SIZE) value else 0
            if(field == 0) println("yPos must be between 1 - 5")
        }

    /**
     * Set the position of the robot
     * Validates user input to ensure a valid position is selected
     * @return a boolean value which is true for a valid position or false for an invalid one
     */
    fun setPosition(xPos: Int, yPos: Int): Boolean{
        var validPosition = true
        if (xPos in 1..TABLE_SIZE && yPos in 1..TABLE_SIZE){
            this.xPos = xPos
            this.yPos = yPos
        } else {
            println("xPos and yPos must be between 1 - $TABLE_SIZE")
            validPosition = false
        }
        return validPosition
    }

    /**
     * Print the current position and cardinal direction of the robot
     */
    fun report(){
        println("${this.xPos},${this.yPos},${this.direction}")
    }

    /**
     * Rotate the robot 90 degrees
     * @param turnDirection the direction (LEFT or RIGHT) the robot should rotate toward
     */
    fun rotate(turnDirection: Direction){
        if (turnDirection == LEFT){
            when (this.direction){
                NORTH -> this.direction = WEST
                EAST -> this.direction = NORTH
                SOUTH -> this.direction = EAST
                WEST -> this.direction = SOUTH
            }
        } else if(turnDirection == RIGHT) {
            when (this.direction){
                NORTH -> this.direction = EAST
                EAST -> this.direction = SOUTH
                SOUTH -> this.direction = WEST
                WEST -> this.direction = NORTH
            }
        }
    }

    /**
     * Move the robot 1 unit in the direction it is currently facing
     */
    fun move(){
        when(this.direction){
            NORTH -> if (this.yPos < TABLE_SIZE) this.yPos++
            EAST -> if (this.xPos < TABLE_SIZE) this.xPos++
            SOUTH -> if (this.yPos > 1) this.yPos--
            WEST -> if (this.yPos > 1) this.yPos--
        }
    }

}