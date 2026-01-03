# FtcUtils

## Description
FtcUtils is a utility library for FTC robotics development.
It provides helper classes and abstractions, including support for Limelight cameras and AprilTag detection, designed to be included as a JAR in your robot projects.
This library **does not depend on the Android SDK at runtime**; the robot provides the necessary FTC dependencies.

## Setup

### Requirements
- Java 17 (matches FTC RobotCore requirements)
- Gradle 9+
- Your robot project with the FTC SDK (RobotCore, Hardware, FtcCommon)
- Compiled FTC SDK jars located in sdk-aar/libs:
    - RobotCore.jar (originally from [RobotCore.aar](https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/RobotCore/RobotCore.aar))
    - FtcCommon.jar (originally from [FtcCommon.aar](https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcCommon/FtcCommon.aar))
    - Hardware.jar (originally from [Hardware.aar](https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/Hardware/Hardware.aar))

These JARs were created by extracting the classes from the corresponding AARs.
```bash
unzip RobotCore-10.3.0.aar RobotCore.jar -d libs/RobotCore)
```

### Build the Library
Clone the repository and build the JAR:
```bash
git clone https://github.com/churkl/FtcUtils.git
cd FtcUtils
./gradlew clean jar
```

The output JAR will be located at:
```
lib/build/libs/ftc-utils-1.0.0.jar
```

### Running Utilities
- If you want to run the main class for testing (UtilRunner):
```bash
./gradlew run
```

## Include in Robot Project
1. Copy the JAR to your robot project, e.g., TeamCode/libs/ftc-utils-1.0.0.jar.
2. Reference it in your robot project’s build.gradle:
```gradle
dependencies {
    implementation files('libs/ftc-utils-1.0.0.jar')
}
````
