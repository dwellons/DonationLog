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

### Project Technologies/Techniques Used.

* Security/Authentication
    * AWS Cognito
* Database
    * MySQL 5.7.39
* ORM Framework
    * Hibernate Version 6.4.3.Final
* Dependency Management
    * Maven 11
* Web Services consumed using Java
    * GeoNames for Weather Information
* CSS
    * HTML5 UP - https://html5up.net/
* Data Validation
    * Bootstrap Validator
    * Hibernate Validator
* Logging
    * Log4J2
    * Hibernate
* Hosting
    * AWS
* Tech I'd like to explore as part of this work
    * Email API's
    * Codenameone for Mobile deployment
* Unit Testing
    * JUnit
* Software Used
    * IntelliJ IDEA
    * Figma
    * MAMP Pro
    * SoapUI
    * MySQLWorkbench
    * GitHub Desktop
    * Postman
* Different future API's for emailing Donation Reports:
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