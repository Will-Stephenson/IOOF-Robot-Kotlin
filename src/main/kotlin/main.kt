import java.io.File
import java.io.FileNotFoundException


fun main(args: Array<String>) {

    if (args.isEmpty()) RobotControl.controlLoop() else {
        val fileName: String = args[0]
        val fileExtension: String = fileName.substring(fileName.indexOf('.'))
        if(fileExtension == ".txt") {
            try {
                var inputFile = File(fileName)
                var inputList: ArrayList<String> = ArrayList()
                inputFile.forEachLine { inputList.add(it) }
                RobotControl.autoLoop(inputList)
            } catch (e: FileNotFoundException) {
                System.out.println("File $fileName not found")
            }

        } else print("Input file must be a .txt file")

    }

}






