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
                Results
            </div>

            <!-- Display the User UPDATE Message -->
            <c:if test="${not empty userUpdateMessage}">
                <p>${userUpdateMessage}</p>
            </c:if>

            <!-- Display the User Delete Message -->
            <c:if test="${not empty userDeleteMessage}">
                <h3>${userDeleteMessage}</h3>
            </c:if>

            <!-- Display the User Add Message -->
            <c:if test="${not empty userAddMessage}">
                <h3>${userAddMessage}</h3>
            </c:if>

            <!-- Search Results Table -->
            <h2>Search Results</h2>

            <c:if test="${not empty users}">

                <table>
                    <thead>
                    <tr>
                        <th>User ID</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.ID}</td>
                            <td>${user.userName}</td>
                            <td>${user.password}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>

                                <!-- Remove -->
                                <form action="readDeleteUser" method="get">
                                    <!-- Adding to see the submit attribute in the servlet -->
                                    <input type="hidden" name="submit" value="Remove">
                                    <input type="hidden" name="ID" id="ID" value="${user.ID}" >
                                    <input type="submit" name="submit" value="Remove">
                                </form>

                                <!-- Update -->
                                <a href="UserUpdate.jsp?userID=${user.ID}">Modify</a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${empty users}">
                <p>No results found.</p>
            </c:if>

            <a href="UserRead.jsp">Search Again</a>

            <!-- Remove the messages after displaying them, if they are present. -->
            <c:remove var="userDeleteMessage"/>
            <c:remove var="userAddMessage"/>

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