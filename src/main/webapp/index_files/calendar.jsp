<!-- JavaScript for building and displaying the calendar -->
<script>
    function buildCalendar(month, year) {
        let calendar = '<table class="calendar">';
        calendar += '<caption>' + new Date(year, month - 1).toLocaleString('default', { month: 'long', year: 'numeric' }) + '</caption>';
        calendar += '<thead><tr>';
        const daysOfWeek = ['M', 'T', 'W', 'T', 'F', 'S', 'S'];
        daysOfWeek.forEach(day => {
            calendar += '<th scope="col" title="' + day + '">' + day + '</th>';
        });
        calendar += '</tr></thead><tbody>';

        const firstDayOfMonth = new Date(year, month - 1, 1).getDay();
        const lastDayOfMonth = new Date(year, month, 0).getDate();

        let dayCount = 1;
        let currentDay = 1;

        calendar += '<tr>';
        for (let x = 0; x < firstDayOfMonth; x++) {
            calendar += '<td class="pad"><span>&nbsp;</span></td>';
            dayCount++;
        }

        while (currentDay <= lastDayOfMonth) {
            if (dayCount > 7) {
                dayCount = 1;
                calendar += '</tr><tr>';
            }

            calendar += '<td';
            if (currentDay === new Date().getDate() && month === new Date().getMonth() + 1 && year === new Date().getFullYear()) {
                calendar += ' class="today" style="color: #fff;"';
            }
            calendar += '><span>' + currentDay + '</span></td>';

            currentDay++;
            dayCount++;
        }

        calendar += '</tr></tbody></table>';

        return calendar;
    }

    // Get the current month and year
    const currentDate = new Date();
    const currentMonth = currentDate.getMonth() + 1;
    const currentYear = currentDate.getFullYear();

    // Build and display the calendar
    const calendarContent = buildCalendar(currentMonth, currentYear);
    document.getElementById('calendar-container').innerHTML = calendarContent;
</script>