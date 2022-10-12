# End of Line

A 54 cards abstract game where you will have a single objective: end your opponents line before they end yours.



## Running end-of-line locally
end-of-line is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:
```shell
git clone https://github.com/gii-is-DP1/dp1-2022-2023-ling-2.git
cd dp1-2022-2023-ling-2
./mvnw package
java -jar target/*.jar
```
You can then access end-of-line here: http://localhost:8080/

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):
```shell
./mvnw spring-boot:run
```



## Database configuration
In its default configuration, end-of-line uses an in-memory database (H2) which gets populated at startup with data.



## Working with Petclinic in your IDE
### Prerequisites
The following items should be installed in your system:
* Java 17 or newer.
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE
    * Eclipse with the m2e plugin. Note: when m2e is available, there is a m2 icon in `Help -> About` dialog. If m2e is
      not there, just follow the install process here: https://www.eclipse.org/m2e/
    * [Spring Tools Suite](https://spring.io/tools) (STS)
    * IntelliJ IDEA
    * [VS Code](https://code.visualstudio.com)

### Steps:
1) On the command line

```shell
git clone https://github.com/gii-is-DP1/dp1-2022-2023-ling-2.git
```

2) Inside Eclipse or STS

```
File -> Import -> Maven -> Existing Maven project
```
Then either build on the command line `./mvnw generate-resources` or using the Eclipse launcher (right click on project and `Run As -> Maven install`) to generate the css. Run the application main method by right-clicking on it and choosing `Run As -> Java Application`.

3) Inside IntelliJ IDEA

In the main menu, choose `File -> Open` and select the End of Line [pom.xml](pom.xml). Click on the `Open` button.

CSS files are generated from the Maven build. You can either build them on the command line `./mvnw generate-resources`
or right-click on the `end-of-line` project then `Maven -> Generates sources and Update Folders`.

A run configuration named `EndOfLineApplication` should have been created for you if you're using a recent Ultimate
version. Otherwise, run the application by right-clicking on the `EndOfLineApplication` main class and choosing
`Run 'EndOfLineApplication'`.

4) Navigate to End Of Line

Visit [http://localhost:8080](http://localhost:8080) in your browser.



## Documentation
All documentation, including the requirements document, the conceptual diagrams, rules of the game, etc. can be found in the [documentation folder](docs)



## License
The Spring EndOfLine application is released under version 2.0 of the [Apache License](LICENSE).
