<!DOCTYPE html>
<html>
<head>
    <title>Welcome our new Finance Manager</title>
<#include "static/head.ftlh">
</head>
<body>
<div class="wrapper">
    <#include "static/navbar.ftlh">
    <div id="content">

        <h2>Expenses</h2>

        <#list expenses>
            <table class="table table-hover table-fixed">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Categories</th>
                    <th>Date</th>
                    <th>Amount</th>
                    <th>Comment</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <#items as e>
                    <tr>
                        <td>${e.name}</td>
                        <td>
                            <#list e.categories as c>
                                ${c.name}<#sep>, </#sep>
                            </#list>
                        </td>
                        <td>${e.date}</td>
                        <td>${e.amount}</td>
                        <td>${e.comment}</td>
                        <td>
                            <button type="button" class="btn btn-primary btn-sm">Edit</button>&nbsp;
                            <button type="button" class="btn btn-danger btn-sm">Delete</button>
                        </td>
                    </tr>
                </#items>
                </tbody>
            </table>
            <#else>
            NO VALUES
        </#list>
    </div>
</div>
<#include "static/footer.ftlh">
<#include "static/scripts.ftlh">
</body>
</html>