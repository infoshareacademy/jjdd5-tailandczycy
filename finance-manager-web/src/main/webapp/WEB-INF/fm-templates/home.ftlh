<!DOCTYPE html>
<html>
<head>
    <title>Welcome our new Finance Manager</title>
<#include "static/head.ftlh">
</head>
<body>
<div class="wrapper">
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3><a href="home">Finance Manager</a></h3>
            <strong>FM</strong>
        </div>
        <ul class="list-unstyled components">
            <li>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-copy"></i>
                    Categories
                </a>
            <ul class="collapse list-unstyled" id="pageSubmenu">
                <li>
                <a href="add-category">Add</a>
                </li>
                <li>
                <a href="/categories">Display</a>
                </li>
            </ul>
            </li>
            <li>
                <a href="/add-expense">
                    <i class="fas fa-paper-plane"></i>
                    Add Expense
                </a>
            </li>
            <li>
                <a href="/about">
                    <i class="fas fa-question"></i>
                    About us
                </a>
            </li>
            <li>
                <a href="/contact">
                    <i class="fas fa-paper-plane"></i>
                    Contact
                </a>
            </li>
        </ul>
    </nav>
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
                        <td>${e.categories}</td>
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