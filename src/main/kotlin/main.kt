import java.io.File
import java.io.FileNotFoundException

/**
 * Entry point for the application
 * Determines if the user has provided an input file, then hands control over to the RobotControl class
 * User input must be in a .txt file
 */
fun main(args: Array<String>) {

    if (args.isEmpty()) RobotControl.controlLoop() else {
        val fileName: String = args[0]
        val fileExtension: String = fileName.substring(fileName.indexOf('.'))
        if(fileExtension == ".txt") {
            try {
                val inputFile = File(fileName)
                val inputList: ArrayList<String> = ArrayList()
                inputFile.forEachLine { inputList.add(it) }
                RobotControl.autoLoop(inputList)
            } catch (e: FileNotFoundException) {
                System.out.println("File $fileName not found")
            }

        } else print("Input file must be a .txt file")

    }

}






