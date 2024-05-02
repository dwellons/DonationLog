<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- Head -->
<c:import url="/assets/index_files/head.jsp"/>

<!-- Sidebar -->
<c:import url="/assets/index_files/adminSidebar.jsp"/>

<!-- Content -->
<div id="content">
    <div class="inner">

        <!-- Post -->
        <article class="box post post-excerpt">

            <!-- Header -->
            <c:import url="assets/index_files/header.jsp"/>

            <!-- Tab on Side -->
            <div class="info">
                Search Donations
            </div>

            <!-- Display the Donation UPDATE Message -->
            <c:if test="${not empty donationUpdateMessage}">
                <p>${donationUpdateMessage}</p>
            </c:if>

            <!-- Display the Donation Delete Message -->
            <c:if test="${not empty donationDeleteMessage}">
                <h3>${donationDeleteMessage}</h3>
            </c:if>

            <!-- Display the Donation Add Message -->
            <c:if test="${not empty donationAddMessage}">
                <h3>${donationAddMessage}</h3>
            </c:if>



            <!-- Donation Search Form -->
            <h2>Search for a Past Donation</h2>

            <form action="readDonations" method="get">

                <label for="searchType">What will you be searching by?</label>

                </br>

                <input type="radio" id="donorName"
                       name="searchType" value="donorName" required>
                <label for="donorName">Donor Name</label>

                <br>

                <input type="radio" id="donationType"
                       name="searchType" value="donationType" required>
                <label for="donationType">Donation Type</label>

                <br>
                <br>

                <label for="searchTerm">Enter the Donor's Name or the Type of Donation
                        (frozen, dairy, etc.) </label>

                <br>

                <input type="text" id="searchTerm" name="searchTerm" required>

                <br>

                <input type="submit" name="submit" value="Search" id="SearchButton">

            </form>

            <br>

            <form action="readDonations" method="get">

                <input type ="submit" name="submit" value="Show All Donations">

            </form>

            <!-- Remove the message after displaying it, if it is present-->
            <c:remove var="donationUpdateMessage"/>
            <c:remove var="donationDeleteMessage"/>
            <c:remove var="donationAddMessage"/>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>