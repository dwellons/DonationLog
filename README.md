## Problem Statement

Smaller, non-profit organizations like food pantries and re-sale stores rely on donations
for a most of their inventory. Where I work, we are getting food donations from multiple
businesses in town every day, and the volunteers in the food pantry record them all in a
notebook. We take in donations like clothes, household items, toys, etc. from community
members as well, and there is no real way we are tracking those at all. The amounts,
values, weights, kinds, and who donated them are all information that we need to have at
the end of the year.

There isn't often a lot of extra resources for software that tracks and manages those
donations in a helpful way, and individuals are left doing it by hand in a notebook or in
a spreadsheet if at all. While this works, it can be time-consuming and if an individual
doesn't have the right background using spreadsheets, that can be just as time-consuming
as going through a notebook. I want to create an application that will let users record
donations as they come, and then let managers be able to search through the recordings
using different search options. It will return a summary that the manager can use for
finances or other reasons, or to share with donors. I want it to be open source and
free to use so that any organization can use it.


### Project Technologies/Techniques

* Security/Authentication
    * AWS Cognito
* Database
    * MySQL 8.x
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
    * Google Maps API
    * Hibernate Validator
    * Hibernate Search
* Project Lombok
* Unit Testing
    * JUnit tests to cover all testable logic
* IDE: IntelliJ IDEA


### Design

* [User Stories](DesignDocuments/userStories.md)
* [Screen Design](DesignDocuments/Screens.md)
