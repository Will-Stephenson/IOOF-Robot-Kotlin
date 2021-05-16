import java.lang.IllegalArgumentException
import CommandType.*

object RobotControl {



    fun controlLoop(){
        var robot = Robot();
        var continueLoop = true
        var commandType: CommandType
        while(continueLoop)  {
            val input = readLine() ?: "NONE"
            val inputList = input.split(" ").toList()
            val command: Command = parseInput(input)
            if (command.commandType != null){
                executeCommand(command, robot)
            }
            /*try {
                commandType = CommandType.valueOf(inputList[0])
                if (commandType == EXIT) continueLoop = false
                when (inputList.size){
                    1 -> executeCommand(commandType)
                    2 -> executeCommand(commandType, inputList[1].split(",").toList())
                    else -> println("Please enter a valid command")
                }
            } catch (e: IllegalArgumentException) {
                println("Please enter a valid command")
            }*/
        }
    }

    fun autoLoop(inputList: ArrayList<String>){
        var robot = Robot();
        inputList.forEach{println(it)}
    }

    private fun parseInput(input:String): Command{
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


    private fun executeCommand(command: Command, robot: Robot){
        /*println(command.commandType)
        println(command.args)*/
        when (command.commandType){
            PLACE -> {
                var xPos: Int? = null
                var yPos: Int? = null
                var direction: CardinalDirection? = null
                if (command.args != null){
                    if (command.args!!.size == 3){
                        try {
                            xPos = command.args!![0].toInt()
                            yPos = command.args!![1].toInt()
                            direction = CardinalDirection.valueOf(command.args!![2])
                            //robot.direction = direction
                            } catch (e: IllegalArgumentException){
                            println("Please enter valid arguments: e.g. 1,2,NORTH")
                        }
                    }

                }
                if (xPos  != null && yPos != null && direction != null){
                    if (robot.setPosition(xPos,yPos)){
                        robot.direction = direction
                    }

                   }

            }
            REPORT -> println("${robot.xPos}, ${robot.yPos}, ${robot.direction}")

        }
    }


}