# Qpros Automation Framework
A testing automation framework That is developed to test the following features for https://www.demoblaze.com/ site
* Register and login
* Check the listed Categories has Items
* Add random item to the cart
* Remove item from cart
* Complete successful checkout with random item

**Technology stack:**
* Selenium
* Java 8
* TestNG Framework

**System properties:**

System properties data can be changed directly : 
* Baseurl for different env URLs.
* Headless to run browser in headless mode "Change value to true"
<br>property file can be found inside: `src/main/resources/system.properties` change then save and run<br>

**Reporting:**

* Reports are generated in html format using maven Surefire reports containing  status of run, Passed and Failed TCs.
<br>Reports file can be found inside: `target/surefire-reports`<br>
* For viewing HTML reports you can open `target/surefire-reports/TestRunner/emailable-report.html`

**Running testing Suit using maven from cmd:**

* Install Java Env on machine --> Run in cmd `java -version` for confirmation
* Install maven Env on machine --> Run in cmd `mvn -version` for confirmation
<br>Open cmd from project's file then run command: `mvn clean test`<br>

