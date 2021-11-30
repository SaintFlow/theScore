# NFL Rushing Stat Application

![Image](/screenshot.png "Screenshot")

This small application displays the stats of NFL players provided in rushing.json. The user has the ability to filter the list by name, and sort the columns based on 
Total Rushing Yards, Longest Rush and Total Rushing Touchdowns. The user can also download the filtered list as a .csv file.

This application is powered by:
- Java Spring Boot
- React

## Preresequites
Java and npm must be installed on your local machine, with JAVA_PATH environment variable set to your local JRE folder. There are two methods for running the application.

## Installation: Method 1 - Java Jar and NPM
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

## Installation: Method 2 - Docker
First ensure Docker (Docker Desktop) is installed on your local machine such that commands can be run on the terminal.
1. **Clone the application**
  
```bash
git clone https://github.com/SaintFlow/theScore
cd theScore/nflRushing
```
2. **Ensure nflRushing/mvnw is executable**

This can be done in Windows by opening the file in Notepad++, and selecting Edit -> EOL Conversion -> Unix, then saving the file.

This can also be done by making the file (or root folder) executing using chmod in Linux/MAC. Move to the root folder theScore in terminal and run

```bash
sudo chmod -r 777
```

3. **Run Docker-Compose Build**

In theScore/nflRushing folder, run the below command to build the application.

```bash
docker-compose build
```

4. **Run Docker-Compose up**
```bash
docker-compose up
```

The application can be accessed by visiting http://localhost:9090
