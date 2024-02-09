<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

            <!-- Add User FORM -->
            <h2>Add a new User</h2>

            <c:if test="${not empty donationAddMessage}">
                <h3>${donationAddMessage}</h3>
            </c:if>

            <br>

            <form action="addDonation" method="post">

                <label for="donorName">Donor Name: </label>
                <input type="text" id="donorName"
                       name="donorName" required>
                <br>
                <br>

                <label for="donationType">Donation Type: </label>
                <input type="text" id="donationType"
                       name="donationType" required>
                <br>
                <br>

                <label for="donationWeight">Donation Weight: </label>
                <input type="text" id="donationWeight"
                       name="donationWeight" required>
                <br>
                <br>

                <input type="submit" value="Add Donation">

            </form>
            <!-- End Add User Form -->

            <!-- remove the message after displaying it, if it is present-->
            <c:remove var="donationAddMessage"/>

        </article>
    </div>
</div>

<!-- sidebar -->
<c:import url="/assets/index_files/sidebar.jsp"/>
<!-- end sidebar -->

<!-- Scripts -->
<script href="assets/js/jquery.min.js"></script>
<script href="assets/js/browser.min.js"></script>
<script href="assets/js/breakpoints.min.js"></script>
<script href="assets/js/util.js"></script>
<script href="assets/js/main.js"></script>

</body>
</html>