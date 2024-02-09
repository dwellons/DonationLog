<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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

                        </tr>
                    </c:forEach>
                </table>
             </c:if>

            <c:if test="${empty donation}">
                <p>No results found.</p>
             </c:if>

            <!-- End Search Results Table -->

            <a href="DonationSearch.jsp">Search Again</a>

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