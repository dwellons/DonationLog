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

            <!-- main page display -->

            <form action="searchDonations" method="get" id="loadAllForm">
                <input type ="submit" name="submit" value="Show All Donations">
            </form>

            <!-- end main page display -->


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