<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                Update Donation
            </div>

            <!-- Update Donation FORM -->
            <h2>Update Donation</h2>

            <c:if test="${not empty donationUpdateMessage}">
                <h3>${donationUpdateMessage}</h3>
            </c:if>

            <br>

            <form action="updateDonation" method="post">

                <label for="donationID">Donation ID: </label>
                <input type="text" name="donationID" id="donationID" value="${donationToUpdate.donationID}" required>

                <label for="donorName">Donor Name: </label>
                <input type="text" id="donorName" name="donorName" value="${donationToUpdate.donorName}" required>
                <br>

                <label for="donationType">Donation Type: </label>
                <input type="text" id="donationType" name="donationType" value="${donationToUpdate.donationType}" required>
                <br>

                <label for="donationWeight">Donation Weight: </label>
                <input type="text" id="donationWeight" name="donationWeight" value="${donationToUpdate.donationWeight}" required>
                <br>

                <input type="submit" value="Update Donation">

            </form>

            <!-- Remove the message after displaying it, if it is present-->
            <c:remove var="donationUpdateMessage"/>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>