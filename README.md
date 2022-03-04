# Biscuit-Sharma

Command line tool for software project management.

## Configure and Setup

 - Checkout code from GitHub

```bash
git clone -b main https://github.com/ksharm53/Biscuits-Sharma.git
```

 - Install maven and configure environment paths

### [Download Apache Maven](https://maven.apache.org/install.html)

 - Building Biscuit JAR

Execute below command in the root of the project
```bash
mvn clean install -DskipTests
```

Start application (jar will be in target folder)
```bash
java -jar Biscuits-Sharma-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```


## New Functionalities Introduced

 - Adding Happiness to the tasks.

   CMD Command example: 
    ```bash
     Dashboard>Test>kanav~$ add task
     title: testTask

     happiness value:
    (hit Tab to see an example)

     confused   happy      mad        sad

    happiness value:
    (hit Tab to see an example)
    confused

    Task "testTask" has been added!
     Dashboard>Test>kanav~$

     ```
 - Slack Integration.

   fetch Authentication token required to connect Taiga
   ### [Get Slack Authentication Token](https://api.slack.com/)

   CMD Command example: 
   ```bash
     Dashboard~$ add project
     project name: Test

     Do you want to connect with Slack channel? [Y] Yes       [N] No:Y
     Slack channel name (add '#' also):#project_information_channel
     Slack token:xxxxx

    ```

 - Taiga Integration Adding Project to Taiga.

      fetch Auth token required to connect Taiga
      ### [Get Taiga Authentication Token](https://docs.taiga.io/api.html)

     CMD Command example: 
    ```bash
     Dashboard~$ add project
     project name: Test

     Do you want to add this Project to Taiga? [Y] Yes        [N] No:Y

     Please add authorization token: XXXXXXX


     Project added successfully to Taiga. Please log in to https://taiga.io/ to 
     access this project.

     Project "Test" has been added!

   ```
 - GUI for Biscuit Sharma.
 - Add Team members.

    CMD Command example: 
    ```bash
     Dashboard~$ add project
     project name: Test

     Do you want to add team members? [Y/n] Y

     Type names:
     (\q to end writing)
     Kanav
     Please add the role for Kanav: Team Member

   ```

 - Adding GitHub URL to project.

    CMD Command example: 
    ```bash
     Dashboard~$ add project
     project name: Test     
    github url: test.github.com
     ```
 - Introducing validation for business points to be input.

    CMD Command example: 
    ```bash
     Dashboard>Test~$ add user_story
     title: test US
     points:
     (hit Tab to see an example)

     0    1    13   2    21   3    5    8

    points:
    (hit Tab to see an example)
    76876
    invalid value. Please use tab to check valid values
     ```

 - Adding roles for team members.

    CMD Command example: 
    ```bash
     Dashboard~$ add project
     project name: Test

     Do you want to add team members? [Y/n] Y

     Type names:
     (\q to end writing)
     Kanav
     Please add the role for Kanav: Team Member

     ```
 - Mapping numeric values to autocomplete texts.
 - Adding business value to tasks.

    CMD Command example: 
    ```bash
     Dashboard>Test>kanav~$ add task
     title: testTask

     business value for the task:
     (hit tab to see the values)

     Large      Medium     Small      X-Large    X-Small    XX-Large

     business value for the task:
     (hit tab to see the values)
     Small

     ```
 - Rectify Misspellings of the commands.



## Team
Kanav Sharma
Ashik
Manish
Santosh
