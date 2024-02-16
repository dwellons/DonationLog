## Problem Statement

Smaller, non-profit organizations like food pantries and re-sale stores rely on donations
to make up the majority of their inventory. Pantries might be getting food donations from multiple
businesses each day, and the volunteers or workers there have to record them all in a
notebook. Not just food donations, but things like clothes, household items, toys, etc. from community
members, and there is no reasonable way many of them are able to track any of these. The kind, weight, and who donated them are all information that the organization needs to have at
the end of the year.

Often times volunteers are tracking and managing those donations by hand in a notebook or in
a spreadsheet. This is time-consuming and in efficient. This is an application that will let volunteers or workers record
donations as they come, and then let managers be able to search through the recordings
using different search options. It will return a summary that the manager can use for
finances or other reasons, or to share with donors. It is designed for initial use and testing by the Edgerton Community Outreach, is open-source and in the future will be free to use for any non-profit
organization. 

If you want to help support the project, you can here: (future link)


### Project Technologies/Techniques Used.

* Security/Authentication
    * AWS Cognito
* Database
    * MySQL 8.x
    * MAMP
* ORM Framework
    * Hibernate Version TBD
* Dependency Management
    * Maven
* Web Services consumed using Java
    * TBD
* CSS
    * Bootstrap or Materialize
* Data Validation
    * Bootstrap Validator for front end
    * Explore Hibernate Validator?
* Logging
    * Log4J2
* Hosting
    * AWS
* Tech I'd like to explore as part of this work
    * CI tools in AWS
    * Materialize
    * Hibernate Validator
    * Hibernate Search
* Unit Testing
    * JUnit tests to cover all testable logic
* Editors
    * IDE: IntelliJ IDEA
    * Editor: VSCodium
    * Screen Layout Design: Figma

* Different API's for emailing Donation Reports:
    * Java Mail: https://javaee.github.io/javamail/
    * Apache Commons EMail: https://commons.apache.org/proper/commons-email/
    * Email Verifier: https://rapidapi.com/mr_admin/api/email-verifier
    * Adobe Create PDF: https://developer.adobe.

### Design Documents.

* [User Stories](DesignDocuments/UserStories.md)
* [Screen Design](DesignDocuments/Screens.md)
* [Project Plan](ProjectPlan.md)

### Documentation of progress, reflections, and time spent on this class.

* [Journal](Journal.md)