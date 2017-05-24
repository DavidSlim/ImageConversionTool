$(document).ready(function () {
    $(".datepicker").datepicker({
        inline: true,
        showWeek: true,
        firstDay: 1,
        dateFormat: "yy/mm/dd",
        showOn: "button",
        buttonImage: "images/log.jpg",
        buttonText: "Date",
        buttonImageOnly: true
    });
});
