<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                Homepage
            </div>

            <!-- Display the Donation Update Message -->
            <c:if test="${not empty donationUpdateMessage}">
                <p>${donationUpdateMessage}</p>
            </c:if>

            <!-- Main Page Display -->
            <!-- Search Results Table -->
            <h3>Recent Donations</h3>

            <c:if test="${not empty donations}">

                <table>
                    <thead>
                    <tr>
                        <th>Donation Number</th>
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
                            <td>
                                <fmt:formatDate value="${donation.donationDate}" pattern="yyyy-MM-dd"/>
                            </td>
                            <td>

                                <!-- Remove -->
                                <form action="readDeleteDonations" method="get">
                                    <!-- Adding to see the submit attribute in the servlet -->
                                    <input type="hidden" name="submit" value="Remove">
                                    <input type="hidden" name="donationID" id="donationID" value="${donation.donationID}" >
                                    <input type="submit" name="submit" value="Remove">
                                </form>

                                <!-- Update -->
                                <a href="DonationUpdate.jsp?donationID=${donation.donationID}">Modify</a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${empty donations}">
                <p>No results found.</p>
            </c:if>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>