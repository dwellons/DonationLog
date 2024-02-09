<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- Head -->
<c:import url="/assets/index_files/head.jsp"/>
<!-- End Head -->

<!-- Content -->
<div id="content">
    <div class="inner">

        <!-- Post -->
        <article class="box post post-excerpt">

            <!-- Header -->
            <c:import url="assets/index_files/header.jsp"/>
            <!--End Header -->


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

            <!-- Search Results Table -->
            <h2>Search Results</h2>

            <c:if test="${not empty donations}">

                <table>
                    <!-- The content of the page should use a table to display
                        the results with each found employee in a row.
                        The HTML table and header row should
                        be part of the template text of the page.-->
                    <thead>
                    <tr>
                        <th>Donation ID</th>
                        <th>Donor Name</th>
                        <th>Donation Type</th>
                        <th>Donation Weight</th>
                        <th>Donation Date</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                     <c:forEach var="donation" items="${donations}">
                        <tr>
                            <td>${donation.donationID}</td>
                            <td>${donation.donorName}</td>
                            <td>${donation.donationType}</td>
                            <td>${donation.donationWeight}</td>
                            <td>${donation.donationDate}</td>
                            <td>
                                <!-- Links to DonationUpdate.jsp -->
                                <a href="DonationUpdate.jsp?donationID=${donation.donationID}">Modify</a>

                                <!-- Links to DonationDelete.jsp -->
                                <a href="DonationDelete.jsp?donationID=${donation.donationID}">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
             </c:if>

            <c:if test="${empty donations}">
                <p>No results found.</p>
             </c:if>

            <a href="DonationRead.jsp">Search Again</a>
            <!-- End Search Results Table -->

            <!-- Remove the messages after displaying them, if they are present. -->
            <c:remove var="donationDeleteMessage"/>
            <c:remove var="donationAddMessage"/>

        </article>
    </div>
</div>

<!-- Sidebar -->
<c:import url="/assets/index_files/sidebar.jsp"/>
<!-- End Sidebar -->

<!-- Scripts -->
<script href="assets/js/jquery.min.js"></script>
<script href="assets/js/browser.min.js"></script>
<script href="assets/js/breakpoints.min.js"></script>
<script href="assets/js/util.js"></script>
<script href="assets/js/main.js"></script>

</body>
</html>