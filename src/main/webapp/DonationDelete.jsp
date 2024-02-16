<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- Head -->
<c:import url="/assets/index_files/head.jsp"/>
<!-- End Head -->

<!-- Sidebar -->
<c:import url="/assets/index_files/sidebar.jsp"/>
<!-- End Sidebar -->

<!-- Content -->
<div id="content">
    <div class="inner">

        <!-- Post -->
        <article class="box post post-excerpt">

            <!-- Header -->
            <c:import url="assets/index_files/header.jsp"/>
            <!--End Header -->

            <!-- Tab on Side -->
            <div class="info">
                Remove
            </div>

            <!-- Delete Donation FORM -->
            <h2>Delete Donation</h2>

            <!-- Display the Donation Delete Message -->
            <c:if test="${not empty donationDeleteMessage}">
                <h3>${donationDeleteMessage}</h3>
            </c:if>

            <br>

            <form action="deleteDonation" method="post">

                <!-- adding to see the submit attribute in the sevlet -->
                <input type="hidden" name="submit" value="Submit">

                <label for="donationID">Donation ID: </label>
                <input type="text" name="donationID" id="donationID" value="${donationToDelete.donationID}" >
                <br>

                <label for="donorName">Donor Name: </label>
                <input type="text" id="donorName" name="donorName" value="${donationToDelete.donorName}" >
                <br>

                <label for="donationType">Donation Type: </label>
                <input type="text" id="donationType" name="donationType" value="${donationToDelete.donationType}" >
                <br>

                <label for="donationWeight">Donation Weight: </label>
                <input type="text" id="donationWeight" name="donationWeight" value="${donationToDelete.donationWeight}">
                <br>

                <input type="submit" name="submit" value="Remove">

            </form>
            <!-- End Delete Donation Form -->

            <!-- Remove the message after displaying it, if it is present.-->
            <c:remove var="donationDeleteMessage"/>

        </article>
    </div>
</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/calendar/calendar.js"></script>

</body>
</html>
