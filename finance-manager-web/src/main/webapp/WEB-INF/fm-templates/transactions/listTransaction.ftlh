<!DOCTYPE html>
<html>
<head>
    <#include "../static/head.ftlh">
    <title>Home</title>
</head>
<body>

<div class="wrapper">

    <#include "../static/navbar.ftlh">

    <div id="content">

        <#include "../static/menu.ftlh">

        <h2>Expenses</h2>
        <table class="table table-hover table-fixed">
        <thead>
                <#list expenses>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Date</th>
                    <th>Amount</th>
                    <th>Comment</th>
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
                                <button type="button" class="btn btn-primary btn-sm">
                                    <a href="/edit-expense?id=${expense.id}"> Edit </a
                                </button>&nbsp;<button
                                    type="button"
                                    class="btn btn-danger btn-sm">
                                <a href="/delete-expense-main?id=${expense.id}"> Delete </a>
                            </button>
                            </td>
                        </tr>
                    </#items>
                </#list>
        </tbody>
        </table>
    </div>

</div>

<#include "../static/footer.ftlh">
<#include "../static/scripts.ftlh">
<#include "../js/piechart.js">

</body>
</html>