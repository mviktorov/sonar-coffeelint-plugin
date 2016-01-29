# README #

### What is this repository for? ###

* Building a sonar plugin to analyse coffee script files via http://coffeelint.org

### How do I get set up? ###

* Clone repo
* run **mvn clean package**
* plugin can be found under *sonar-coffeelint-plugin/target* 
* http://coffeelint.org must be installed
* install plugin in sonarqube

### Modules ###
* sonar-coffeelint2java: Converts .coffee rule files (from http://coffeelint.org) into sonarqube checks
* sonar-coffeelint-checks: Contains all generated rules from the sonar-coffeelint2java
* sonar-coffeelint-plugin: Sonarqube plugin
