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

            <!-- USER SEARCH FORM -->
            <h2>User Search Form</h2>

            <form action="searchUser" method="get">

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

            <form action="searchUser" method="get">

                <input type ="submit" name="submit" value="Show All">

            </form>




            <!-- end user search form -->

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