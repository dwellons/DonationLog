<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                Report an Issue
            </div>

            <!-- Add Donation Form -->
            <h2>Report an Issue</h2>

            <!-- Display the Donation Add Message -->
            <c:if test="${not empty donationAddMessage}">
                <h3>${donationAddMessage}</h3>
            </c:if>

            <br>

            <!-- this action needs to forward to report issue controller -->
            <form action="createDonation" method="post">

                <label for="donorName">Your Name: </label>
                <input type="text" id="donorName"
                       name="donorName" required>
                <br>

                <label for="donationWeight">Describe the issue: </label>
                <input type="text" id="donationWeight"
                       name="donationWeight" required>
                <br>

                <input type="submit" value="Report">

            </form>

            <!-- Remove the message after displaying it, if it is present. -->
            <c:remove var="donationAddMessage"/>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>