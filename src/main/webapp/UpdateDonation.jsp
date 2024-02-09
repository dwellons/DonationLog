<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- head -->
<c:import url="/assets/index_files/head.jsp"/>
<!-- end head -->

<!-- Content -->
<div id="content">
    <div class="inner">

        <!-- Post -->
        <article class="box post post-excerpt">

            <!-- header -->
            <c:import url="assets/index_files/header.jsp"/>
            <!--end header -->

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
            <!-- End Update Donation Form -->

            <!-- remove the message after displaying it, if it is present-->
            <c:remove var="donationUpdateMessage"/>

        </article>
    </div>
</div>

<!-- sidebar -->
<c:import url="/assets/index_files/sidebar.jsp"/>
<!-- end sidebar -->

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>
