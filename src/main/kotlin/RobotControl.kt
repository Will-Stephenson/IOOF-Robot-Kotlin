import java.lang.IllegalArgumentException
import CommandType.*

/**
 * Object which allows the user to interact with the program
 * This can be done either directly or through a .txt input file which holds commands
 */
object RobotControl {


    /**
     * Loop which continues to receive direct user inputs until the EXIT command is issued
     */
    fun controlLoop(){
        val robot = Robot()
        var continueLoop = true
        while(continueLoop) {
            val input = readLine() ?: "NONE"
            val command: Command = parseInput(input)
            if (command.commandType != null) {
                executeCommand(command, robot)
            }
            if (command.commandType == EXIT) continueLoop = false // Break the loop if the command is 'EXIT'
        }
    }

    /**
     * Loop which parses and executes each command in pre-generated list
     */
    fun autoLoop(inputList: ArrayList<String>){
        val robot = Robot()
        for(i in inputList){
            val command: Command = parseInput(i)
            if (command.commandType != null) {
                executeCommand(command, robot)
            }
            if (command.commandType == EXIT) break
        }
    }

    /**
     * Parse one line of input and return it as a valid Command object
     * Will return a null Command if the command is not valid
     * @param input a string containing a single user input
     * @return a Command object which can be null if the input is not valid
     */
    fun parseInput(input:String): Command{
        val inputList = input.split(" ").toList()
        try {
            val commandType = CommandType.valueOf(inputList[0])
            when (inputList.size){
                1 -> {
                    return Command(commandType)
                }
                2 -> {
                    //executeCommand(command, inputList[1].split(",").toList())
                    val args = inputList[1].split(",").toList()
                    return Command(commandType,args)
                }
                else -> println("Please enter a valid command")
            }
        } catch (e: IllegalArgumentException){
            println("Please enter a valid command")
        }
        return Command()
    }

    /**
     * Execute a Command on a Robot
     * @param command a valid, non null command
     * @param robot an initialised robot object
     */
    fun executeCommand(command: Command, robot: Robot){
        when (command.commandType){
            PLACE -> {
                var xPos: Int? = null
                var yPos: Int? = null
                var direction: CardinalDirection? = null
                // Parse command arguments if they exist and are the right format, if not print error message
                if (command.args != null){
                    if (command.args!!.size == 3){
                        // Try to set the variables needed to place the robot if all types are correct
                        try {
                            xPos = command.args!![0].toInt()
                            yPos = command.args!![1].toInt()
                            direction = CardinalDirection.valueOf(command.args!![2])
                            //robot.direction = direction
                        } catch (e: IllegalArgumentException){
                            println("Please enter valid arguments: e.g. 1,2,NORTH")
                        }
                    }
                } else {
                    println("Please enter valid arguments: e.g. 1,2,NORTH")
                }
                // Execute the placement if all arguments are correct
                if (xPos  != null && yPos != null && direction != null){
                    // Only set the direction if the position is valid
                    if (robot.setPosition(xPos,yPos)){
                        robot.direction = direction
                    }
                }
            }
            REPORT -> println("${robot.xPos}, ${robot.yPos}, ${robot.direction}")
            MOVE -> robot.move()
            LEFT -> robot.rotate(Direction.LEFT)
            RIGHT -> robot.rotate(Direction.RIGHT)
            EXIT -> println("Closing program")
        }
    }


}