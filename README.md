# Yia's Individual Project

### Problem Statement
Members of the BEPS Systems team are notorious for leaving their computers unlock when they are away from their desk.
This presents a major security concern with the team's security liaison and reflects poorly on a technology team. A 
strategy, developed and enforced by the team, to control the neglectful act is to punish the violator by incurring a 
debt in the form of a treat for entire team. A treat is indebted to the violator when a co-worker witness the offense 
and sends an email from the violator's email to the team informing the team that the violator will bring in a treat.

Current tracking application does not suffice the need of the team and records are manually recorded through an Excel 
sheet. This is error prone since recording a violation may be missed and payments may be long overdue with no 
punishment. The BEPS Systems team is in dire need of a way to assist the enforcement of locking their computer.

### Project Technologies/Techniques
* Security/Authentication
  * Tomcat's JDBC Realm Authentication
* Database
  * MySQL
  * Store users and locations visited
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* CSS 
  * Bootstrap or Materialize
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA

### Design
* [User Stories](designDocuments/userStories.md)
* [Screen Design](designDocuments/screenDesigns.md)

### [Project Plan](ProjectPlan.md)

### [Weekly Reflection](WeeklyReflection.md)
