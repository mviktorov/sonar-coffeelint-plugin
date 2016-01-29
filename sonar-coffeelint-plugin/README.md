# README #

Plugin for http://www.sonarqube.org to analyse coffe script files. Analysis is done by http://coffeelint.org

### Build plugin ###
* Clone repo
* Run **mvn package**

### Generate rule files ###
The checks for sonarqube are automatically generated from the rules defined in coffeelint.

* Clone repo
* Run **coffeelint2java.sh** - Run **coffeelint2java.sh -h** for help

### Integrate plugin in sonarqube ###
* Install http://sonarqube.org
* Install Coffeelint (http://coffeelint.org)
* Copy built plugin into the plugins directory of sonarqube (*extension/plugin*)
* Restart sonarqube
* Analyse project with coffee scripts

### Who do I talk to? ###

* andreas

### Limitations ###
* Coffeelint must be installed on the system

### Future ###
* Analysis purely in the plugin, checks are only retrieved from coffeelint 