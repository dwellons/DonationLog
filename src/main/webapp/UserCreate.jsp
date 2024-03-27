<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                New User
            </div>

            <!-- Add User Form -->
            <!-- removing /donationlog_war makes links work on AWS -->
            <h2>Add a new User</h2>

            <br>
            <a href = "/DonationLog_war/UserRead.jsp">Search Existing Users</a>
            <br>

            <!-- Display the User Add Message -->
            <c:if test="${not empty userAddMessage}">
                <h3>${userAddMessage}</h3>
            </c:if>

            <br>

            <form action="createUser" method="post">

                <label for="userName">Username: </label>
                <input type="text" id="userName"
                       name="userName" required>
                <br>

                <label for="password">Password: </label>
                <input type="text" id="password"
                       name="password" required>
                <br>

                <label for="firstName">First Name: </label>
                <input type="text" id="firstName"
                       name="firstName" required>
                <br>

                <label for="lastName">Last Name: </label>
                <input type="text" id="lastName"
                       name="lastName" required>
                <br>

                <input type="submit" value="Add User">

            </form>



            <!-- Remove the message after displaying it, if it is present. -->
            <c:remove var="userAddMessage"/>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>