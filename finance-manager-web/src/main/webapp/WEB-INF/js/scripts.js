$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});
$(function () {
    $('#datetimepicker1').datetimepicker();
});