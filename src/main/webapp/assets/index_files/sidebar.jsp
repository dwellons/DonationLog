<div id="sidebar">

    <!-- Home Button  -->
    <h1 id="logo"><a href="/DonationLog_war/homepage.jsp?submit=Login">homepage</a></h1>



    <!-- Search -->
    <section>
        <form action="https://www.google.com/search" method="GET" target="_blank">
            <input type="text" name="q" id="searchInput" placeholder="Google Search">
        </form>
    </section>

    <!--Calendar  -->
    <section class="box calendar" id="calendar-container">
        <!-- ID calendar-container will receive calendar script -->
    </section>

    <!-- Links -->
    <section class="box recent-posts">
        <header>
            <h2>I want to...</h2>
        </header>
        <ul>

            <!-- removing /donationlog_war makes links work on AWS -->
            <h2>AWS Links</h2>
            <a href = "/donationJSPs/DonationCreate.jsp">Add a new Donation</a>
            <br>
            <a href = "/donationJSPs/DonationRead.jsp">Search for a Donation</a>
            <br>
            <a href = "/userJSPs/UserCreate.jsp">Add a new User</a>
            <br>
            <a href = "/ReportIssue.jsp">Report an Issue</a>
            <br>

            <h2>Local Links (remove when ready)</h2>
            <!-- removing /donationlog_war makes links work on AWS -->
            <a href = "/DonationLog_war/DonationCreate.jsp">Add a new Donation</a>
            <br>
            <a href = "/DonationLog_war/DonationRead.jsp">Search for a Donation</a>
            <br>
            <a href = "/DonationLog_war/UserCreate.jsp">Add a new User</a>
            <br>
            <a href = "/DonationLog_war/ReportIssue.jsp">Report an Issue</a>
            <br>

            <a href = "logIn">Sign In</a>
            <br>
            <a href = "#">Sign Out</a>
            <br>
            <a href = "#">Contact</a>
            <br>
            <a href = "displayWeather">See the Current Weather</a>
            <br>

        </ul>
    </section>

    <!-- Copyright -->
    <ul id="copyright">
        <li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
    </ul>
</div>

<!-- Scripts -->
<script src="../js/jquery.min.js"></script>
<script src="../js/browser.min.js"></script>
<script src="../js/breakpoints.min.js"></script>
<script src="../js/util.js"></script>
<script src="../js/main.js"></script>
<script src="../features/calendar.js"></script>