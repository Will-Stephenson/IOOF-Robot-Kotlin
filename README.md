# IOOF-Robot Project (Kotlin version)
## Overview
This repo contains a Kotlin version of my submission for the IOOF Coding Challenge.

The application allows the user to place and move a robot around a 5x5 grid.

## Set Up
The application can be run manually or with input defined in a .txt file.
The location of the text file can be passed as an argument.


To run the application:
1. Clone this repository
2. Open a terminal
3. Navigate to the root directory of your local copy of the repository
4. Ensure Java 11 is in your $PATH
5. Execute `java -jar out/artifacts/Robot_Kotlin_jar/Robot-Kotlin.jar input.txt`

## How to Use
Place the robot to begin. The robot can move and turn on the 5x5 unit table.
Any movements which would cause the robot to fall will be ignored for its safety.
### Commands
`PLACE [xPos],[yPos],[Direction]`
Places the robot on the table. All other commands will be ignored until the robot has been placed.

`REPORT`
Shows the current position and direction of the robot.

`MOVE`
Moves the robot one unit in the direction it is facing.

`LEFT`
Turns the robot 90 degrees to the left.

`RIGHT`
Turns the robot 90 degrees to the right.

## Requirements
Built and tested on OpenJDK 11.0.9


