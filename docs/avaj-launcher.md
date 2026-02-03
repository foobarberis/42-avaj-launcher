# General instructions

*   You are allowed to use language features up to the latest Java LTS version.
*   You are not allowed to use any external libraries, build tools or code generators.
*   Do not use the default package.
*   Create your own relevant packages following the Java package naming conventions.
*   Java is compiled into an intermediate language. This will generate some .class files. Do not commit them on your repository!
*   Make sure you have javac and java available as commands in your terminal.
*   Compile the project running the commands bellow in the root of your project folder.

```bash
$find * -name "*.java" > sources.txt
$javac @sources.txt
```

# Chapter IV
# Mandatory part

You need to implement an aircraft simulation program based on the class diagram provided to you. All classes are required to be implemented respecting every detail provided in the diagram. Feel free to add more classes or include additional attributes if you think it is necessary, but do not change access modifiers or the class hierarchy for the classes provided in the diagram.

## IV.1 Program behaviour

Your program will take one and only one argument from the command line. This argument represents the name of a text file that will contain the scenario that needs to be simulated. You can find an example file provided with the subject.

Executing the program will generate a file `simulation.txt` that describes the outcome of the simulation.

Example:

```text
$java fr._42lyon.avaj.simulator.Simulator scenario.txt
$cat -e simulation.txt
Tower says: Balloon#B1(1) registered to weather tower.
Tower says: JetPlane#J1(2) registered to weather tower.
Tower says: Helicopter#H1(3) registered to weather tower.
Tower says: Helicopter#H4(4) registered to weather tower.
Balloon#B1(1): Let's enjoy the good weather and take some pics.
JetPlane#J1(2): It's raining. Better watch out for lightings.
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!
Balloon#B1(1): Damn you rain! You messed up my balloon.
JetPlane#J1(2): OMG! Winter is coming!
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!
Balloon#B1(1): It's snowing. We're gonna crash.
JetPlane#J1(2): It's raining. Better watch out for lightings.
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!
Balloon#B1(1): Damn you rain! You messed up my balloon.
Balloon#B1(1) landing.
Tower says: Balloon#B1(1) unregistered from weather tower.
JetPlane#J1(2): OMG! Winter is coming!
Helicopter#H1(3): This is hot.
Helicopter#H4(4): My rotor is going to freeze!
```

## IV.2 Scenario file

The first line of the file contains a positive integer number. This number represents the number of times the simulation is run. In our case, this will be the number of times a weather change is triggered.

Each following line describes an aircraft that will be part of the simulation, with this format: `TYPE NAME LONGITUDE LATITUDE HEIGHT`.

## IV.3 Weather generation

There are 4 types of weather:
*   RAIN
*   FOG
*   SUN
*   SNOW

Each 3 dimensional point has its own weather. Feel free to use whatever generation algorithm you want, as long as it takes into account the point's coordinates.

## IV.4 Aircrafts

*   **JetPlane:**
    *   SUN - Latitude increases with 10, Height increases with 2
    *   RAIN - Latitude increases with 5
    *   FOG - Latitude increases with 1
    *   SNOW - Height decreases with 7
*   **Helicopter:**
    *   SUN - Longitude increases with 10, Height increases with 2
    *   RAIN - Longitude increases with 5
    *   FOG - Longitude increases with 1
    *   SNOW - Height decreases with 12
*   **Balloon:**
    *   SUN - Longitude increases with 2, Height increases with 4
    *   RAIN - Height decreases with 5
    *   FOG - Height decreases with 3
    *   SNOW - Height decreases with 15

## IV.5 Simulation

*   Coordinates are positive numbers.
*   The height is in the 0-100 range.
*   If an aircraft needs to pass the upper limit height it remains at 100.
*   Each time an aircraft is created, it receives a unique ID. There can't be 2 aircrafts with the same ID.
*   If an aircraft reaches height 0 or needs to go below it, the aircraft lands, unregisters from the weather tower and logs a message.
*   When a weather change occurs, each aircraft type needs to log a message, as seen in the example. The message format is: `TYPE#NAME(UNIQUE_ID): SPECIFIC_MESSAGE`. A funny message will be appreciated during the correction.
*   Each time an aircraft registers or unregisters to/from the weather tower, a message will be logged.

## IV.6 Validation

The input file needs to be validated. Any abnormal behaviour due to invalid input data is not acceptable. If the input file data is not correct the program stops execution. Any error messages will be printed to the standard output.

# Chapter V
# Bonus part

Bonus points will be given if:
*   You create your own custom exceptions for treating abnormal behaviour.

> [!CAUTION]
> The bonus part will only be assessed if the mandatory part is PERFECT. Perfect means the mandatory part has been integrally done and works without malfunctioning. If you have not passed ALL the mandatory requirements, your bonus part will not be evaluated at all.

# Chapter VI
# Submission and peer-evaluation

Turn in your assignment in your Git repository as usual. Only the work inside your repository will be evaluated during the defense. Don't hesitate to double check the names of your folders and files to ensure they are correct.
