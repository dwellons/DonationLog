<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- head -->
<c:import url="/assets/index_files/head.jsp"/>
<!-- end head -->

<!-- Sidebar -->
<c:import url="/assets/index_files/sidebar.jsp"/>
<!-- End Sidebar -->

<!-- Content -->
<div id="content">
    <div class="inner">

        <!-- Post -->
        <article class="box post post-excerpt">

            <!-- header -->
            <c:import url="assets/index_files/header.jsp"/>
            <!--end header -->

            <!-- Tab on Side -->
            <div class="info">
                Search
            </div>

            <!-- USER SEARCH FORM -->
            <h2>Search for a Past Donation</h2>

            <form action="searchDonations" method="get">

                <label for="searchType">What will you be searching by?</label>

                </br>

                <input type="radio" id="donorName"
                       name="searchType" value="donorName" required>
                <label for="donorName">Donor Name</label>

                <br>

                <input type="radio" id="donationType"
                       name="searchType" value="donationType" required>
                <label for="donationType">Donation Type</label>

                <br>

                <br>

                <label for="searchTerm">
                    Enter Search Term (Donor's Name,
                    Donation Type (Add Calendar!) ): </label>

                <br>

                <input type="text" id="searchTerm" name="searchTerm" required>

                <br>

                <input type="submit" name="submit" value="Submit">

            </form>

            <br>
            <br>

            <form action="searchDonations" method="get">

                <input type ="submit" name="submit" value="Show All Donations">

            </form>




            <!-- end user search form -->

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