<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<!-- Head -->
<c:import url="/assets/index_files/head.jsp"/>

<!-- Sidebar -->
<c:import url="/assets/index_files/userSidebar.jsp"/>

<!-- Content -->
<div id="content">
    <div class="inner">

        <!-- Post -->
        <article class="box post post-excerpt">

            <!-- Header -->
            <c:import url="assets/index_files/header.jsp"/>

            <!-- Tab on Side -->
            <div class="info">
                Contact
            </div>

            <!-- Search Results Table -->
            <h3>Contact Information</h3>

            <table>
                <thead>
                <tr>
                    <th>Contact Name</th>
                    <th>Phone Number</th>
                    <th>Email Address</th>
                </tr>
                </thead>
                <tr>

                    <td>Sarah Williams</td>
                    <td>608-921-2905</td>
                    <td>outreachwilliams@gmail.com</td>
                </tr>
                <tr>
                    <td>Tanya Bennett</td>
                    <td>608-921-9578</td>
                    <td>outreachbennett@gmail.com</td>
                </tr>
                <tr>
                    <td>Amanda Kelling</td>
                    <td>608-921-3779</td>
                    <td>outreachkelling@gmail.com</td>

                </tr>
                <tr>
                    <td>Alyssa Vis</td>
                    <td>608-205-7239</td>
                    <td>outreachvis@gmail.com</td>

                </tr>
                <tr>
                    <td>Trinity Brehmer</td>
                    <td>608-921-9268</td>
                    <td>outreachbrehmer@gmail.com</td>

                </tr>
                <tr>
                    <td>Angela Attleson</td>
                    <td>608-884-9593</td>
                    <td>outreachattleson@gmail.com</td>

                </tr>
                <tr>
                    <td>Darin Wellons</td>
                    <td>608-205-7080</td>
                    <td>outreachwellons@gmail.com</td>
                </tr>
            </table>

        </article>
    </div>
</div>

<!-- Scripts -->
<c:import url="/assets/index_files/scripts.jsp"/>

</body>
</html>