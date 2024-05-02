<div id="sidebar">

    <!-- Home Button  -->
    <!-- removing /donationlog_war makes links work on AWS -->
    <h1 id="logo"><a href="/DonationLog_war/ReadRecentDonations">homepage</a></h1>

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
            <a href = "/DonationLog_war/DonationCreate.jsp">Add a new Donation</a>
            <br>
            <a href = "mailto:dwellons@madisoncollege.edu?subject=Donation%20Log%20Issue%20Report&body=Please%20describe%20your%20issue%20above.">Report an Issue</a>
            <br>
            <a href = "logIn">Sign In</a>
            <br>
            <a href = "/DonationLog_war/Contacts.jsp">ECO Contacts</a>
            <br>
        </ul>
    </section>

    <!-- Display Weather Information -->
    <section>
        <h2>Local Weather Information</h2>
        <li>Location: ${location}</li>
        <li>Temperature: ${temperature} F</li>
        <li>Condition: ${condition}</li>
    </section>

    <!-- Search -->
    <section>
        <form action="https://www.google.com/search" method="GET" target="_blank">
            <input type="text" name="q" id="searchInput" placeholder="Google Search">
        </form>
    </section>

    <!-- Scripts -->
    <c:import url="/assets/index_files/scripts.jsp"/>

    <!-- Copyright -->
    <ul id="copyright">
        <li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
    </ul>
</div>

