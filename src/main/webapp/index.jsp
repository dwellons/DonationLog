<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- Head -->
<c:import url="/assets/index_files/head.jsp"/>

<!-- Sidebar -->
<c:import url="/assets/index_files/userSidebar.jsp"/>

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

            <!-- Main Page Display -->
            <!-- Recent Donations Table -->
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
                            <th></th>
                        </tr>
                    </thead>

                    <c:forEach var="donation" items="${donations}">
                        <tr>
                            <td>${donation.donationID}</td>
                            <td>${donation.donorName}</td>
                            <td>${donation.donationType}</td>
                            <td>${donation.donationWeight}</td>
                            <td>
                                <fmt:formatDate value="${donation.donationDate}" pattern="MM-dd-YYYY"/>
                            </td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${empty donations}">
                <p>No results found.</p>
            </c:if>

            <div id="VolunteerImage">
                <a href="https://edgertonoutreach.org/">
                    <img src="assets/index_files/images/ECOVolunteers2023.png" alt="Volunteers at Edgerton
                        Community Outreach in 2023">
                    <!-- img source: https://edgertonoutreach.org/volunteer-information/ -->
                </a>
                
                <p>
                    Volunteers at Edgerton Community Outreach in 2023. Thank you!
                </p>

            </div>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>