<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Finance Manager</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <#include "static/styles.css">

    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
            integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
            crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
            integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
            crossorigin="anonymous"></script>

</head>

<body>

<div class="wrapper">
    <!-- Sidebar  -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3>Finance Manager</h3>
            <strong>FM</strong>
        </div>

        <ul class="list-unstyled components">
            <li class="active">
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-home"></i>
                    Konto
                </a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="#">Użytkownik 1</a>
                    </li>
                    <li>
                        <a href="#">Użytkownik 2</a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="#">
                    <i class="fas fa-briefcase"></i>
                    Wydatki
                </a>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-copy"></i>
                    Kategorie
                </a>
                <ul class="collapse list-unstyled" id="pageSubmenu">
                    <li>
                        <a href="#">Dodaj</a>
                    </li>
                    <li>
                        <a href="#">Edytuj</a>
                    </li>
                    <li>
                        <a href="#">Usuń</a>
                    </li>
                </ul>
            </li>


            <li>
                <a href="#">
                    <i class="fas fa-question"></i>
                    O nas
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="fas fa-paper-plane"></i>
                    Kontakt
                </a>
            </li>

        </ul>
    </nav>

    <div id="content">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span>Menu</span>
                </button>
                <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-align-justify"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">${date}</a>
                        </li>


                        <li class="nav-item active">
                            <a class="nav-link" href="#">Login</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>

        <h2>Wydatki</h2>

        <div id="piechart"></div>

        <h2>Analiza wydatków</h2>

        <table class="table">
            <thead class="thead-light">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nazwa</th>
                <th scope="col">Kategoria</th>
                <th scope="col">Kwota</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Miks</td>
                <td>Dom i rachunki</td>
                <td>25</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Marcin</td>
                <td>Rozrywka i podróże</td>
                <td>45</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Mati</td>
                <td>Odzież i obuwie</td>
                <td>16</td>
            </tr>
            <tr>
                <th scope="row">4</th>
                <td>Łukasz</td>
                <td>Odzież i obuwie</td>
                <td>55</td>
            </tr>
            <tr>
                <th scope="row">5</th>
                <td>Łukasz</td>
                <td>Wydatki podstawowe</td>
                <td>18</td>
            </tr>
            <tr>
                <th scope="row">6</th>
                <td>Miks</td>
                <td>Zdrowie i uroda</td>
                <td>10</td>
            </tr>
            <tr>
                <th scope="row">7</th>
                <td>Marcin</td>
                <td>Rozrywka i podróże</td>
                <td>88</td>
            </tr>
            <tr>
                <th scope="row">8</th>
                <td>Miks</td>
                <td>Samochód i transport</td>
                <td>48</td>
            </tr>
            <tr>
                <th scope="row">9</th>
                <td>Marcin</td>
                <td>Wydatki podstawowe</td>
                <td>66</td>
            </tr>
            <tr>
                <th scope="row">10</th>
                <td>Mati</td>
                <td>Samochód i transport</td>
                <td>55</td>
            </tr>
            </tbody>
        </table>

        <h2><#include "static/buttons.ftlh"></h2>
        <div class="line"></div>
        <#include "static/footer.ftlh">
    </div>

</div>


<!-- jQuery CDN - Slim version (=without AJAX) -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<!-- Popper.JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>


<script type="text/javascript">
    // Load google charts
    google.charts.load('current', {'packages': ['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    // Draw the chart and set the chart values
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

        // Optional; add a title and set the width and height of the chart
        var options = {'title': 'Miesiąc', 'width': 550, 'height': 400};

        // Display the chart inside the <div> element with id="piechart"
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
    }
</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#sidebarCollapse').on('click', function () {
            $('#sidebar').toggleClass('active');
        });
    });
</script>


</body>

</html>