# Weekly Reflection #

Document how your week in Ent Java went. You may use whatever format suits you, as long as you share how much time you worked and provide a general overview of how things went: achievements and struggles. 


### Week 1

##### 1/25/2020 - 1.5 hours

Tasks Completed:
 * Evaluate project ideas
 * Download and play around with traveling app:
    * Polarsteps
    * Places Been
    * Countries Been
 
I was pondering on a few project ideas. The two that I'm leaning towards at the moment is a 'treat tracker' that tracks
treats owed by employee. We have this ongoing thing at work where if someone is not at their desk and leave their 
computer unlock, a passing by person can send out an email from the violator's computer to the team about bring in a 
treat. It would be nice to have an application that will track these offensives. The second idea is a traveling
application that tracks a person's movement as they travel and logged the places they've been.

At the moment I'm leaning towards the traveling application since I feel it will be interesting, new, and challenging.
There doesn't seem to be a lot of similar 'traveling' application out there. I've downloaded the three listed above.
Places Been and Countries Been allows a user to select the places that they've been too where as Polarsteps uses a GPS
to track their location.

##### 1/27/2020 - 1.5 hours

Tasks Completed:
 * Decided on Traveling Application for individual project.
 * Create project directory
 * Update project README.md
 * Look into google map API: https://developers.google.com/maps/documentation
 
I was inspire by how a map become visible to a user in a video game. As the user explore an unknown territory, the map 
opens and becomes available to the user. My long term goal is to implement something similar as my users explore the 
world they live in.

The idea for the traveling application is that it'll track a person's movement as they travel. While traveling to new
place that they haven't been to, that area of the map opens and becomes available to the user. Once the map is available
to the user, information about different attractions also becomes available. The areas that the user have not visited
will be block until the user unlock them by traveling there.

At the time I'm still a little confuse about how to use the google map API to achieve this. There seems to be several 
API available depending on what I want to do. I'm not sure at the moment which to choose and what will work best for me.
More research will be needed.

In terms of my overall project, I feel that there will be a huge lift on the UI side which I don't know if I have the 
skill/knowledge make this happen.

### Week 2

##### 1/28/2020 - 1 hours

Tasks Completed:
* Updated project presentation README.md to include a better project name and description.
* Created my project in Intellij
* Add timeLog.md

##### 1/31/2020 - update

This was a busy week at work. With the work needed to bring home, I haven't had much time to think of the project. At 
the moment, I'm debating if I want to use the time log or just go with a weekly reflection and leaning towards the 
reflection.

### Week 3

##### 02/06/2020 - 2 hours

Tasks Completed:
* Complete screen design using Moqups

I'm not overly thrill with the wireframe that I've created. As I was doing this, I feel that rather that this being a 
web application, this should really be a App for phones. I currently don't have the knowledge to build a App yet. Will
Will have to proceed with this for now.

##### 02/10/2020 - 2 hours

Tasks Completed:
* Complete and add user stories
* Add project plan - edit the provided plan to fit my timeframe

My project plan may need revision. I find it hard to plan for things that we will be learning in this class, but have
limited idea of the details it entails. Overall, I feel that if I can plan for the upcoming weeks and re-edit my plan, 
I'll be in a good place.

##### 02/11/2020 - 2 hours

Tasks Completed:
* Add problem statement
* Extract wireframe from  Moqups
* Create screen design and include wireframe
* Push project to GitHub

### Week 4

##### 02/12/2020 - 2 hours

Tasks Completed:
* Create new project in GitHub and project directory for Treat Tracker
* Update pom file, web.xml file, and add .gitignore
* Add README file
* Add user stories
* Update link to student directory
* Push new documents to GitHub

I decided to change my project idea. My current idea is to create a treat tracker for work. Completed and committed
the above files to GitHub.

##### 02/18/2020 - 2 hours

Tasks Completed
* Created wireframe for screen design
* Complete screenDesign.md
* Update project plan
* Push new documents to GitHub

### Week 5

##### 02/24/2020 - 5 hours

Task Completed
* Started jsp for index, about, contentType, head, and navbar
* Created a 'logo' for website
* Add CSS file
* Add three entity; User, Incident, & Resolve
* Add three DAO for User, Incident, & Resolve

I completed the above tasks but have not test to see if there are any issues. I still need to create my database so I 
can run some test to ensure my DAO/entities are working as I'm expecting it. I'm currently having issue with my JSP not
getting what I want to display. This is likely a bootstrap issue and will need to bush up on bootstrap.

### Week 6

##### 02/26/2020 - 2 hours

Task Completed
* Added a register and login modal to navigation menu

Finally got the login and register modal working correctly. Next step is to send each submit to a controller and send to 
the appropriate jsp when logging in or logging out.

##### 02/27/2020 - 2 hours

Task Completed
* Made some tweak to the navigation bar and head file.
* Added a js file and added form field validations.
* Started on a home page for a register user.

The home page for the register user is still a working progress. After the user login, the login information will be
validated from a servlet. If the user is valid, it should forward the user to this home page.

##### 03/02/2020 - 3 hours

Task Completed
* Update instance variables in all three entities
* Added generic dao
* Add sql table
* Added databaseDiagram image

There's some additional work to do. I'm still trying to update my database to show a one to many relationship between
the user and incident tables.

### Week 7 & 8

Read a little into Gmail API but did not accomplished much these too weeks.

### Week 9

##### 03/30/2020 - 3 hours

Task Completed
* Restructured database
* Update Hibernate annotation in entities

I was having a lot of trouble with some of my test failing. I had to re-build my database and try to learn how hibernate works
so I can apply the correct relationship. I was unable to get some of the test to pass and was pretty frustrated with 
hibernate.

### Week 10 & 11

These weeks were dedicated for the team project. 

### Week 12

##### 04/15/2020 - 4 hours

Continue my database issued. I got a little closer with most of my test passing. however, there were issue with my
incident test since it holds two reference key to other tables. I cannot figure out the hibernate relationship.

### Week 13

##### 04/21/2020 - 5 hours

Task Completed
* Complete database restructure
* Complete dao test
* Implement Lombok to most of my entities
* Started working on Gmail API call

It was pretty frustrated with Hibernate but I think I finally figure it out to make most of my test pass. I was able to 
implement lombok with other entities. I also started trying to implement an gmail API and was having a lot of trouble. 
I was unable to authenticate my call to Google using localhost.

### Week 14

##### 04/28/2020 - 3 hours

Task Completed
* Implemented login servlet
* Started working on Gmail API

Logging in was frustrating too. I initially created a modal for logging in. I was unable to implement form base auth with 
the modal. I eventually scrap the modal and just implement the login using a jsp. This worked better and I was able to login.


### Week 15

##### 05/06/2020 - 30 hours

Task Completed
* Implemented a register form and a servlet
* User allowed to be added to DB from login

##### 05/07/2020 - 4 hours

Task Completed
* Added styling to web page
* Add form validation to login and register pages
* Update test for incident to test for searching for a user by the user id
* Add failed login page
* Create navigation menu

For the most part, today was a must stress free in terms of making progress. The last few time I've worked on the project
I find myself stuck and unable to make progress. Today was as success.

##### 05/08/2020 - 6 hours

Task Completed
* Add admin features such as getting/editing users
* Add additional style to user home page
* Add admin menu

##### 05/09/2020 - 6 hours

Task Completed
* Allow user to add a resolution
* Allow user to retrieve a list of incidents to be resolved
* Add controllers and JSP
* Able to implement a web service call to Gmail

##### 05/10/2020 - 8 hours

Task Completed
* Add sending an email feature when resolving incident

##### 05/10/2020 - 6 hours

Task Completed
* Add ability to retrieve email to be added by user
* Deploy to AWS

Overall, this week has been a lot of work. I don't feel that I've met all the requirement for the project, however, I
accomplished a lot in terms of having a usable project. I'll continue working and enhancing the project after the semester.

