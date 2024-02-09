# Weekly Reflections

### Week 1

1/16/2024 - 8 hours

Tasks Completed:

-   Initial Setup and Testing of environment.
-   Install and configure IntelliJ IDEA (Apache, Tomcat, Maven).
-   Connect to Database (MAMP).
-   Determine Project Idea.
-   Weekly Classwork

Key learning points/takeaways:

-   If you're running another instance of tomcat, it will prevent some updates from
    happening when you build using another tomcat instance.

What challenged me:

-   Getting an account setup with JetBraings(IntelliJ IDEA).
-   Using an incompatible version of Java.

### Week 2

1/23/2024 - 18 Hours

Tasks Completed:

-   Create initial project repository on GitHub.
-   Started documenting the project plan.
-   Began listing technologies and how they fit in this project
-   Started looking at what API's are and how they are used.
-   Weekly Classwork

Key learning points/takeaways:

-   I am a more confident and competent debugger and problem solver.

What challenged me:

-   Determining the new file structure for this project as compared to what I've learned in the past.
-   Determining the best way to calculate a donations age.

### Week 3

1/29/2024 - 20 Hours

Tasks Completed:

-   Signed up for Professional Development Opportuity
-   https://nofluffjuststuff.com/webinar/91/continuous_learning
-   Started working on requirements for Checkpoint #1.
-   Created userStories.md
-   Created Project Plan.md
-   Created Journal.md
-   Weekly Classwork

Key learning points/takeaways:

-   When you create a project on IntelliJ and re use index.jsp from another project, it will carry over the
    configuration from that file into your new one. Create a new file and set up the configuration before hand.

What challenged me:

-   IntelliJ auto imported an SQL script for my logger, that was not the script that I was intending to use. Double check
    that the scripts you want to use are correct and haven't been changed.

### Week 4

2/5/2024 - 10 Hours

Tasks Completed:

-   Double-checked project specifications.
-   Went through my donation stories and MVP's.
-   Updated my project plan.
-   Completed wire frames.
-   Created WeeklyReflection.md
-   Weekly Classwork

Different API's for emailing Donation Reports:

-   Java Mail: https://javaee.github.io/javamail/
-   Apache Commons EMail: https://commons.apache.org/proper/commons-email/
-   Email Verifier: https://rapidapi.com/mr_admin/api/email-verifier
-   Adobe Create PDF: https://developer.adobe.com/document-services/docs/overview/pdf-services-api/howtos/create-pdf/

Thins I would like to explore further:

-   The best way to take a html table, with results from the database, and turn it into a pdf file.
-   The best way to take that pdf file and automatically insert it as an attachment in a blank email.
-   The best way to print only the html table with results from the database, not the whole webpage.

Key learning points/takeaways:

-   PDF images will not load in a md file.

What challenged me:
When working on Using the DAO, and implementing getByPropertyEqual, I kept getting null pointer exceptions. I found that I wasnt putting Submit into the request, I thought that i was putting searchUser there but I wasn't. I had to put the name i was putting into the request with the submit button.

I was then getting an error that it couldnt resolve the attribute first_name. I wondered why it wasnt able to find it and then started looking, and I didnt see anywhere I called it first_name, everywhere else it was called firstName. So in my form where I was naming the searchType's to first_name, last_name etc, I changed them to firstName, lastName and my errors went away.
