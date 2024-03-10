<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- Head -->
<c:import url="/assets/index_files/head.jsp"/>

<!-- Sidebar -->
<c:import url="/assets/index_files/sidebar.jsp"/>

<!-- Content -->
<div id="content">
    <div class="inner">

        <!-- Post -->
        <article class="box post post-excerpt">

            <!-- Header -->
            <c:import url="assets/index_files/header.jsp"/>

            <!-- Tab on Side -->
            <div class="info">
                Remove Donation
            </div>

            <!-- Display the Donation Delete Message -->
            <c:if test="${not empty donationDeleteMessage}">
                <h3>${donationDeleteMessage}</h3>
            </c:if>

            <!-- Delete Donation Table -->
            <h2>Confirm Removal</h2>

            <c:if test="${not empty donations}">

                <table>
                    <thead>
                    <tr>
                        <th>Donation Number</th>
                        <th>Donor Name</th>
                        <th>Donation Type</th>
                        <th>Donation Weight</th>
                        <th>Donation Date</th>
                        <th>Enter Donation Number To Verify Removal</th>
                    </tr>
                    </thead>

                    <tr>
                        <td>${donations.donationID}</td>
                        <td>${donations.donorName}</td>
                        <td>${donations.donationType}</td>
                        <td>${donations.donationWeight}</td>
                        <td>${donations.donationDate}</td>
                        <td>

                            <form action="deleteDonation" method="post">

                                <!-- Adding to see the submit attribute in the servlet -->
                                <input type="hidden" name="submit" value="Submit">

                                <label for="donationID"></label>
                                <input type="text" name="donationID" id="donationID">
                                <input type="submit" name="submit" value="Remove">

                            </form>

                        </td>
                    </tr>

                </table>
            </c:if>

            <c:if test="${empty donations}">
                <p>No results found.</p>
            </c:if>

            <a href="DonationRead.jsp">Go Back to Search</a>

            <!-- Remove the messages after displaying them, if they are present. -->
            <c:remove var="donationDeleteMessage"/>
            <c:remove var="donationAddMessage"/>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>