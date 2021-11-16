# NFL Rushing Stat Application

![Image](/screenshot.png "Screenshot")

This small application displays the stats of NFL players provided in rushing.json. The user has the ability to filter the list by name, and sort the columns based on 
Total Rushing Yards, Longest Rush and Total Rushing Touchdowns. The user can also download the filtered list as a .csv file.

This application is powered by:
- Java Spring Boot
- React

## Preresequites
Java and npm must be installed on your local machine, with JAVA_PATH environment variable set to your local JRE folder. This installation has only been
tested on Windows.

## Installation
### Creating the Spring Boot background
1. **Clone the application**
  
```bash
git clone https://github.com/SaintFlow/theScore
cd theScore/nflRushing
```
2. **Create the jar file using the file mvn.cmd. This should create a new target directory containing the jar file**

```bash
.\mvnw.cmd install
```

3. **Run the jar file**

```bash
java -jar target/nflRushing-0.0.1-SNAPSHOT.jar
```
The backend server is now running. This can be tested by visiting http://localhost:8080/players

### Creating the Front End
1. **Move to src\main\app and build the front end using npm**
```bash
npm build
```
2. **Start the front end**
```bash
npm start
```

When successful, the cmd will prompt you with the URL for accessing the application. The front end can now be visited using http:/localhost:3000
