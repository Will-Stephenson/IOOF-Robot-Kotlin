import CardinalDirection.*
import Direction.*
import java.io.File

object RobotControl {

    var testRobot = Robot();

    fun controlLoop(){

    }

    fun autoLoop(inputList: ArrayList<String>){
        inputList.forEach{System.out.println(it)}
    }


}