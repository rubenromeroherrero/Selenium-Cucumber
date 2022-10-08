# Selenium + Cucumber + Gradle


The purpose of this repository is to be able to start with test automation through Selenium + Java. 

I am managing all the necessary dependencies through Gradle: 
 - Gradle 7.5
 - Cucumber to cover the most critical aspects of the app documented: 
 - 
    // https://mvnrepository.com/artifact/info.cukes/cucumber-junit
    testImplementation 'io.cucumber:cucumber-java:7.5.0'
    testImplementation 'io.cucumber:cucumber-junit:7.5.0'
 - Selenium in order to automate the tests performed in web browsers.
    //https://mavenlibs.com/maven/dependency/org.seleniumhq.selenium/selenium-java
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.5.0'
 - Junit
    testImplementation 'org.junit.jupiter:junit-jupiter:5.7.2'
 - Java / JDK 
    java version "18.0.2.1" 2022-08-18

On the other hand, I have implemented the use of cucumber, in order to unify in an understandable way documentation, automated acceptance tests and information requirements. 

We have a runner file that will allow us to execute the features to know if the tests are successful or not.
