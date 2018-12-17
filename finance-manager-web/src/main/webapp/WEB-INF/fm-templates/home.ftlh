<!DOCTYPE html>
<html>
<head>
    <#include "static/head.ftlh">
    <title>Home</title>
</head>
<body>

<div class="wrapper">

    <#include "static/navbar.ftlh">

    <div id="content">

        <#include "static/menu.ftlh">

        <h2>Wydatki</h2>
        <table class="table table-hover table-fixed">
            <thead>
                <#list expenses>
                <tr>
                    <th>#</th>
                    <th>Nazwa</th>
                    <th>Kategoria</th>
                    <th>Data</th>
                    <th>Kwota</th>
                    <th>Komentarz</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                    <#items as expense>
                        <tr>
                            <th scope="row">${expense.id}</th>
                            <td>${expense.name}</td>
                            <td><#list expense.categories as c>${c.name}</#list></td>
                            <td>${expense.date}</td>
                            <td>${expense.amount}</td>
                            <td>${expense.comment}</td>
                            <td>
                                <button type="button" class="btn btn-primary btn-sm">Edytuj</button>&nbsp;<button
                                    type="button"
                                    class="btn btn-danger btn-sm">
                                Usuń
                            </button>
                            </td>
                        </tr>
                    </#items>
                </#list>
            </tbody>
        </table>

        <h2>Analiza wydatków</h2>

        <div id="piechart"></div>

    </div>

</div>

<#include "static/footer.ftlh">
<#include "static/scripts.ftlh">
<#include "js/piechart.js">

</body>
</html>