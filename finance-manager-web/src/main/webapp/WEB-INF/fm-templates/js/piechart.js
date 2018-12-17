<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var data = google.visualization.arrayToDataTable([
        ['Task', 'Hours per Day'],
        ['Dom i rachunki', 8],
        ['Odzież i obuwie', 2],
        ['Wydatki podstawowe', 8],
        ['Zdrowie i uroda', 2],
        ['Rozrywka i podróże', 2],
        ['Samochód i transport', 2]
    ]);

    var options = {'title': 'Miesiąc', 'width': 550, 'height': 400};

    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    chart.draw(data, options);
}
</script>

