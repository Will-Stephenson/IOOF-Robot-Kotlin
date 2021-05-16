import CardinalDirection.*
import Direction.*

const val TABLE_SIZE = 5

class Robot (_xPos: Int = 0, _yPos: Int = 0, _direction: CardinalDirection = NORTH) {

    var direction: CardinalDirection = _direction

    var xPos: Int = _xPos
        set(value) {
            field = if(value in 1..5) value else 0
            if(field == 0) println("yPos must be between 1 - 5")
        }

    var yPos: Int = _yPos
        set(value) {
            field = if(value in 1..5) value else 0
            if(field == 0) println("yPos must be between 1 - 5")
        }

    fun setPosition(xPos: Int, yPos: Int): Boolean{
        var validPosition: Boolean = true
        if (xPos in 1..TABLE_SIZE && yPos in 1..TABLE_SIZE){
            this.xPos = xPos
            this.yPos = yPos
        } else {
            println("xPos and yPos must be between 1 - $TABLE_SIZE")
            validPosition = false
        }
        return validPosition
    }

    fun report(){
        println("${this.xPos},${this.yPos},${this.direction}")
    }

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

    fun move(){
        when(this.direction){
            NORTH -> if (this.yPos < TABLE_SIZE) this.yPos++
            EAST -> if (this.xPos < TABLE_SIZE) this.xPos++
            SOUTH -> if (this.yPos > 1) this.yPos--
            WEST -> if (this.yPos > 1) this.yPos--
        }
    }

}