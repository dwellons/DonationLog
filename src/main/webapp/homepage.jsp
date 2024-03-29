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
            <form action="readDonations" method="get" id="loadAllForm">
                <input type ="submit" name="submit" value="Show All Donations">
            </form>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>