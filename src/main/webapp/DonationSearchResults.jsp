<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                Results
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

            <!-- Search Results Table -->
            <h2>Search Results</h2>

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

            <a href="DonationRead.jsp">Search Again</a>

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