<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                Weather
            </div>



            <!-- Search Results Table -->
            <h2>Current Weather Conditions</h2>

            <c:if test="${not empty temperature}">

                <table>
                    <thead>
                    <tr>
                        <th>Reporting Location</th>
                        <th>Temperature</th>
                        <th>Condition</th>

                    </tr>
                    </thead>

                        <tr>
                            <td>${location}</td>
                            <td>${temperature} degrees</td>
                            <td>${condition}</td>

                        </tr>

                </table>
            </c:if>

            <c:if test="${empty temperature}">
                <p>No results found.</p>
            </c:if>

            <a href="displayWeather">Refresh</a>

        </article>
    </div>
</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/features/calendar.js"></script>


</body>
</html>