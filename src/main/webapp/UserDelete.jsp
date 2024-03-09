<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                Remove User
            </div>

            <!-- Display the User Delete Message -->
            <c:if test="${not empty userDeleteMessage}">
                <h3>${userDeleteMessage}</h3>
            </c:if>

            <!-- Delete User Table -->
            <h2>Confirm Removal</h2>

            <c:if test="${not empty users}">

                <table>
                    <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Enter User ID To Verify Removal</th>
                    </tr>
                    </thead>

                    <tr>
                        <td>${users.ID}</td>
                        <td>${users.userName}</td>
                        <td>${users.password}</td>
                        <td>${users.firstName}</td>
                        <td>${users.lastName}</td>
                        <td>

                            <form action="deleteUser" method="post">

                                <!-- Adding to see the submit attribute in the servlet -->
                                <input type="hidden" name="submit" value="Submit">

                                <label for="ID"></label>
                                <input type="text" name="ID" id="ID">
                                <input type="submit" name="submit" value="Remove">

                            </form>

                        </td>
                    </tr>

                </table>
            </c:if>

            <c:if test="${empty users}">
                <p>No results found.</p>
            </c:if>

            <a href="DonationRead.jsp">Go Back to Search</a>

            <!-- Remove the messages after displaying them, if they are present. -->
            <c:remove var="donationDeleteMessage"/>
            <c:remove var="donationAddMessage"/>

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