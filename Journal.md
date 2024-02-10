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
* Started working on Project in leu of Exercise. Implementing CRUD, DAO, Hibernate
  Different API's for emailing Donation Reports:

-   Java Mail: https://javaee.github.io/javamail/
-   Apache Commons EMail: https://commons.apache.org/proper/commons-email/
-   Email Verifier: https://rapidapi.com/mr_admin/api/email-verifier
-   Adobe Create PDF: https://developer.adobe.com/document-services/docs/overview/pdf-services-api/howtos/create-pdf/

Thins I would like to explore further:

-   The best way to take a html table, with results from the database, and turn it into a pdf file.
-   The best way to take that pdf file and automatically insert it as an attachment in a blank email.
-   The best way to print only the html table with results from the database, not the whole webpage.
-   Seeing my results from the request in my modify and delete JSP's.

Key learning points/takeaways:

-   PDF images will not load in a md file.
-   Create a test database before even starting anything.

What challenged me:
When working on Using the DAO, and implementing getByPropertyEqual, I kept getting null pointer exceptions. I found 
that I wasnt putting Submit into the request, I thought that i was putting searchUser there but I wasn't. I had to put 
the name i was putting into the request with the submit button.

I was then getting an error that it couldnt resolve the attribute first_name. I wondered why it wasnt able to find it 
and then started looking, and I didnt see anywhere I called it first_name, everywhere else it was called firstName. So 
in my form where I was naming the searchType's to first_name, last_name etc, I changed them to firstName, lastName and 
my errors went away.

When working on the exercise, I was able to implement modify and delete pretty easily after having gone through the
weekly activities. There are still things I am having issues with in regards to those, but they are functioning and
passing right now. I want my values to pre fill my text boxes when I modify and delete, but everything I have tried so
far hasn't worked. I will come back to that. If you put in the donation id # of the one you chose to modify or delete
it functions as expected. And my values are visible in the request, I'm not sure why I cant fill the text boxes.

After that I started testing and my @before setup(), when I ran my tests it had reset my database to values I didn't 
want in there and everything stopped working. I was able to figure that out with the log error saying that that value
wasn't in my database. Always make sure to create the test database first, not just before you start testing.

I started with this weeks activiites, I created a new database for my donation log and then changed the things in the 
weekly activity to reference and work with that database. then I just started personalizing things and changing class
variable names. I had modify and delete buttons from an earlier week and implemented those. The jsp's and java classes
were all mostly the same so I was able to just use the ones for adding a donation to create the modify and delete
functions. I would like the delete function to show the information for the user you selected to delete instead of
using the from from adding a donation, but I wasn't able to see the results from the request for that either. 

### Week 5 - Spring 2024

** ** 