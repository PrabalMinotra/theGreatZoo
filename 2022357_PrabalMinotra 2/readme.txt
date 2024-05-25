AP Assignment 2: Zoo Management System

Assumptions:

1. Discounts and Special Deals have been applied to the ticket prices individually to show the reduced amounts
2. Discounts have been prefilled but can be edited later by the admin
3. Attractions have been assigned IDs as per a counter so that no two attractions have the same id
4. Admin Username: "prabal"
5. Admin Password: "prabal12"
6. Events are attributes of Attractions and serve limited purpose
7. Added a viewBalance Functionality to the visitor Menu to make view balance hassle-free
8. Assumed that animals of a particular type make only one kind of sound (i.e. Mammals only growl, Amphibians only Groak and Reptiles only Hiss)
9. JDK version 19 : properties to be kept in mind to prevent BUILD FAILURE (shown below is an extract from pom.xml)

<properties>
        <maven.compiler.source>19</maven.compiler.source> (19 FOR THE VERSION)
        <maven.compiler.target>19</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>

HOME_FOLDER = 2022357_PrabalMinotra

1. Download the entire assignment and unzip
2. Navigate to the folder generated after unzipping
3. The following commands are to be run inside the folder called "2022357_PrabalMinotra"

1. mvn clean
2. mvn compile
3. mvn package
4. cd target
5. java -jar Main-1.0-SNAPSHOT.jar

----------------------------------
