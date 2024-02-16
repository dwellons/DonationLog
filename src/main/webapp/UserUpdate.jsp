<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                Update User
            </div>

            <!-- Update User Form -->
            <h2>Update User</h2>

            <c:if test="${not empty userUpdateMessage}">
                <h3>${userUpdateMessage}</h3>
            </c:if>

            <br>

            <form action="updateUser" method="post">

                <label for="ID">User ID: </label>
                <input type="text" name="ID" id="ID" value="${userToUpdate.ID}" required>

                <label for="userName">Username: </label>
                <input type="text" id="userName" name="userName" value="${userToUpdate.userName}" required>
                <br>

                <label for="password">Password </label>
                <input type="text" id="password" name="password" value="${userToUpdate.password}" required>
                <br>

                <label for="firstName">First Name: </label>
                <input type="text" id="firstName" name="firstName" value="${userToUpdate.firstName}" required>
                <br>

                <label for="lastName">Last Name: </label>
                <input type="text" id="lastName" name="lastName" value="${userToUpdate.lastName}" required>
                <br>

                <input type="submit" value="Update User">

            </form>

            <!-- Remove the message after displaying it, if it is present-->
            <c:remove var="userUpdateMessage"/>

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
