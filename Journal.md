# Journal

### Week 1 - Spring 2024
**1/16/24 4-12pm** 
* Initial Setup and Testing of environment.
* Install and configure IntelliJ IDEA (Apache, Tomcat, Maven).
* Connect to Database (MAMP).
* Determine Project Idea.
* Started looking at what API's are and how they are used.
* Weekly Classwork

Key learning points/takeaways:

-   If you're running another instance of tomcat, it will prevent some updates from
    happening when you build using another tomcat instance.

What challenged me:

-   Getting an account setup with JetBraings(IntelliJ IDEA).
-   Using an incompatible version of Java.


### Week 2 - Spring 2024
**1/23/24 4-10pm**
**1/24/24 6pm-12am**
**1/25/24 6pm - 12am**
* Create initial project repository on GitHub.
* Started documenting the project plan.
* Began listing technologies and how they fit in this project
* Weekly Classwork

Key learning points/takeaways:

-   I am a more confident and competent debugger and problem solver.

What challenged me:

-   Determining the new file structure for this project as compared to what I've learned in the past.
-   Determining the best way to calculate a donations age.


### Week 3 - Spring 2024
**1/29/24 8pm-12am**
**1/30/24 6pm - 1am**
**1/31/24 12pm - 2:30, 3:30 - 10pm**

* Signed up for Professional Development Opportuity
* https://nofluffjuststuff.com/webinar/91/continuous_learning
* Started working on requirements for Checkpoint #1.
* Created userStories.md
* Created Project Plan.md
* Created Journal.md
* Weekly Classwork

Key learning points/takeaways:

-   When you create a project on IntelliJ and re use index.jsp from another project, it will carry over the
    configuration from that file into your new one. Create a new file and set up the configuration before hand.

What challenged me:

-   IntelliJ auto imported an SQL script for my logger, that was not the script that I was intending to use. Double check
    that the scripts you want to use are correct and haven't been changed.


### Week 4 - Spring 2024
**2/5/24 6pm - 12am**
**2/6/24 7pm - 12am**
**2/7/24 7pm - 12am**
**2/8/24 8pm - 2:45am**
**2/9/24 9am - 8pm**

* Double-checked project specifications.
* Went through my donation stories and MVP's.
* Updated my project plan.
* Completed wire frames.
* Created WeeklyReflection.md
* Weekly Classwork
* Started working on Project in leu of Exercise. Implementing CRUD, DAO, Hibernate.

* Different API's for emailing Donation Reports:

-   Java Mail: https://javaee.github.io/javamail/
-   Apache Commons EMail: https://commons.apache.org/proper/commons-email/
-   Email Verifier: https://rapidapi.com/mr_admin/api/email-verifier
-   Adobe Create PDF: https://developer.adobe.com/document-services/docs/overview/pdf-services-api/howtos/create-pdf/

Things I would like to explore further:

-   The best way to take a html table, with results from the database, and turn it into a pdf file.
-   The best way to take that pdf file and automatically insert it as an attachment in a blank email.
-   The best way to print only the html table with results from the database, not the whole webpage.
-   Seeing my results from the request in my modify and delete JSP's.

Key learning points/takeaways:

-   PDF images will not load in a md file.
-   Create a test database before even starting anything.

When working on Using the DAO, and implementing getByPropertyEqual, I kept getting null pointer exceptions. I found 
that I wasnt putting Submit into the request, I thought that i was putting searchUser there but I wasn't. I had to put 
the name i was putting into the request with the submit button.

I was then getting an error that it couldn't resolve the attribute first_name. I wondered why it wasn't able to find it 
and then started looking, and I didn't see anywhere I called it first_name, everywhere else it was called firstName. So 
in my form where I was naming the searchType's to first_name, last_name etc. I changed them to firstName, lastName and 
my errors went away.

When working on the exercise, I was able to implement modify and delete pretty easily after having gone through the
weekly activities. There are still things I am having issues with in regards to those, but they are functioning and
passing right now. I want my values to pre-fill my text boxes when I modify and delete, but everything I have tried so
far hasn't worked. I will come back to that. If you put in the donation id # of the one you chose to modify or delete
it functions as expected. And my values are visible in the request, I'm not sure why I cant fill the text boxes.

After that I started testing and my @before setup(), when I ran my tests it had reset my database to values I didn't 
want in there and everything stopped working. I was able to figure that out with the log error saying that that value
wasn't in my database. Always make sure to create the test database first, not just before you start testing.

I started with this-weeks activities. I created a new database for my donation log and then changed the things in the 
weekly activity to reference and work with that database. then I just started personalizing things and changing class
variable names. I had modify and delete buttons from an earlier week and implemented those. The JSP's and java classes
were all mostly the same, so I was able to just use the ones for adding a donation to create the modify and delete
functions. I would like the delete function to show the information for the user you selected to delete instead of
using the from from adding a donation, but I wasn't able to see the results from the request for that either. 


### Week 5 - Spring 2024

**2/15/24 7:30pm - 1:45am**
**2/16/24 10am - 5:00pm**  

* Modified user stories and project plan
* Updated Screens.md
* Cleaned up time logs / entries and put them all into Journal.md
* Worked on remove donation functionality
* Worked on add donation functionality
* Added calendar to sidebar
* Added new links to sidebar
* Weekly Classwork - Modified indie project in lue of weekly exercise.
* Added full CRUD for creating, reading, updating and deleting Users.
* Added a new Users table in the Donation Log Database.
* Created tests for Users DAO.

Things I would like to explore further:

-   The best way to take a html table, with results from the database, and turn it into a pdf file.
-   The best way to take that pdf file and automatically insert it as an attachment in a blank email.
-   The best way to print only the html table with results from the database, not the whole webpage.
-   Seeing my results from the request in my modify JSP.

Key learning points/takeaways:

-   Don't be so quick to be doing things with a Database. Be extra sure what you want to do is going to have the results you want.

What challenged me:
It was challenging getting the user data to go from my results.jsp to the donationDelete.jsp. I was trying to access a value that wasn't there and when I thought about doing it how I already was when searching for a user, it worked how I wanted and went smoothly. 

It was challenging figuring out the one-to-many relationship at first, because I had created a foreign key on a new user_id instead of using the exising id. My program was searching and seemed to be working fine, but when I would try to display information about a user I had selected to delete I ran into issues. I was trying to remove a user with a user_id that didnt match the id of the user. The ID auto increments, but the user_id would not. I tried to auto increment the user_id but got an error that said only one column in a table is allowed to auto increment. I thought about how to do it for a while and though that I should be able to make one column the primary and the foreign key. 

I set the ID in the user table to be the foreign key in the relationship and removed the user_id column, and changed the references I was using for that. It was working and I started testing. I ran my tests and the @before setup got me again. It removed my foreign key relationship, and wouldn't let me create a new donations table. I was able to take the foreign key definitions out of the sql dump file and create it without the old ones to a not existing column, and then re-created them and made a new sql dump file. After that things were working as expected.

Everything else this week seemed to go smoothly. I was able to re-create the functionality I already had made for the donations CRUD to use with the Users, and that worked pretty smoothly. I had used Project 4 in the previous semester as guide for how to structure my file directory, and had created two files that I have thought that I didnt need. I was able to confirm that and remove them to clean up my controller directory.


### Week 6 - Spring 2024

Resources Used:

Format date without time:
https://stackoverflow.com/questions/22824190/how-to-use-format-date-as-yyyy-mm-dd-with-jstl

**2/20/24 7:30pm - 12:00am**

* Initial deployment to AWS
* Initial setup of AWS Database

**2/22/24 7:30pm - 11:45pm** 
* Peer Code Review 1 Meeting
* Peer Code Review Checklist completed

**2/25/24 12:00pm - 1:00pm**
* Remove empty time from date being displayed
* Created Report an Issue JSP page
* Moved search for a user link to only be visible from add new user page
* Moved show all users to only be visible from search for users page
* Prepare for and turn in Checkpoint 2


### Week 7 - Spring 2024

**2/29/2024 6:00pm - 12:00pm**
* Weekly classwork
* Start working on AWS Cognito implementation

**3/01/2024 10:00am - 2:30pm**
* Start AWS Cognito implementation

**3/02/2024 9:00am - 3:00pm**
* Troubleshooting AWS charges and sign in issues

**3/03/2024 4:00pm - 10:00pm**
* Troubleshooting AWS charges and sign in issues

**3/04/2024 4:00pm - 10:00pm**
* Troubleshooting AWS charges and sign in issues

Things I would like to explore further:
Different web hosting services or ways to do it yourself.

Key learning points/takeaways:
It has to be super expensive to host a popular website on the internet using AWS.

What challenged me:
Trying to connect to AWS using HTTPS, I am still trying to figure it out.

### Week 8 - Spring 2024
**3/08/2024 6:00pm - 12:00am**
* Weekly Classwork
* Implemented Weather API

**3/10/2024 11:00am - 5:00pm**
* Peer Review Corrections Made
* Updating DAO's
* Checkpoint Suggestions
* Updating Project Plan
* Updating Journal

Things I would like to explore further:
Brainstorming different API's that might be cool to use in my project.

Key learning points/takeaways:
Its cool that there is so much information available on the internet to use in your projects for free.

What challenged me:
It was tricky trying to figure out how to use javascript and java together to automatically load the js when the homepage loads, I'm still exploring that. 

### Week 9 - Spring 2024
**3/19/2024 6:00pm - 12:00am**
* Working on Cognito implementation
* Getting ready for checkpoint 3

**3/20/2024 4:00pm - 12am**
* Worked on displaying weather on sidebar on page load
* Start cleaning up CSS
* Tried to figure out Cognito issue

**3/24/2024 7:00pm - 8:30pm**
* Meet with Team for Group Project

### Week 10 - Spring 2024
**3/25/2024 6:00pm - 10:00pm**
* Working on Cognito issue

**3/26/2024 5:00pm - 1:00am**
* Week 9 classwork
* Project Revision prior to completing weekly exercise

**3/27/2024 9:00pm - 10:30pm**
* Weekly Classwork

**3/28/2024 7:00pm - 8:30pm**
* Work on Group Project - entity and hibernate files

### Week 11 - Spring 2024
**4/03/2024 7:00pm - 8:00pm**
* Group Project Team Meeting

**4/05/2024 11:00am - 1:30pm**
* Work on styling for group project

**4/05/2024 9:00pm - 12:00am**
* Working on Logging issues


### Week 12 - Spring 2024
**4/10/2024 5:30pm - 7:00 pm**
* Record Team Project Presentation

### Week 13 - Spring 2024
* Finish up and Record Professional Development PowerPoint and presentation.

Key learning points/takeaways - Week 12 and 13
Stay committed to the things that you have the chance to take part in. 

What challenged me:
Trying to stay on track and motivated, there was a lot going on the past couple weeks but I was there for the team project and to get my professional development presentation done on time.

### Week 14 - Spring 2024
**4/22/2024 8pm - 11pm**
* Determined Database Relation Issue

**4/24/2024 7:00pm - 9:00pm**
* Work on learning tracker
* Plan meeting for Peer Review

**4/26/2024 12:00pm - 2:30pm, 4:00pm - 11:45pm**
* Application Startup created
* Weather is being loaded through startup
* Modify donation entries now displaying
* 5 donations now displaying on homepage
* User/admin functionality started
* Edited cleandb file
* Report issue is now linked to send an email
* Dates issue in donations resolved
* Peer Review Meeting
* Typed Query Reference, for limiting amount of results:
* https://docs.oracle.com/javaee%2F6%2Fapi%2F%2F/javax/persistence/TypedQuery.html#setMaxResults(int)

Key learning points/takeaways - Week 14
Don't overthink things just let the work do itself.

What challenged me:
Trying to get the most recent 5 donations. I am still trying to figure out how to get them descending, but I have
been able to limit it to 5 so far.
It was a little tricky creating the Application Startup, I couldn't remember exactly how to do it but I just went back
to last semesters project and it was easy from there. It was not easy at first getting the weather to load using the application start up though, but once I stopped thinking about it so much I figured out how to do what i wanted. I was trying to access the WeatherDAO, but it was in another package. I thought I would have to move my weather info to my DAO, but I took a break doing other work and when I came back I just specified it more directly.

### Week 15 - Spring 2024
**5/1/2024 6:00pm - 11pm**
* Begin finalizing project for demonstration and end of semester.
* Added print button to print search results
* Print specific part of page:
* https://stackoverflow.com/questions/12997123/print-specific-part-of-webpage
* Created sign out servlet
* Updated styling, added image
* Closed out open issues
* Remove unused files
* Modify user now displaying user information

**5/3/2024 4:00pm - 11pm**
* Removed print references in project
* Updated comments and javadoc
* Update date formatting and some styling
* QA plug initial scan
* Implementing String Builder
* Removed unused import statements
* Resolved issue modifying users and donations
* Created Version2.md
* Fixed multiple QA plug issues
* Temp is rounding
* Went through indie project tips and code best practices
* Implemented peer code review tips
* Went through past checkpoints
* Ready for presentation