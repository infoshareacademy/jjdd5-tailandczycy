<!DOCTYPE html>
<html>
<head>
    <title>Welcome our new Finance Manager</title>
<#include "static/head.ftlh">
</head>
<body>
<div class="wrapper">
    <!-- Sidebar  -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3><a href="home">Finance Manager</a></h3>
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
                        <a href="home">Admin</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="add-expense">
                    <i class="fas fa-briefcase"></i>
                    Wydatki
                </a>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-copy"></i>
                    Kategorie
                </a>
                <ul class="collapse list-unstyled" id="pageSubmenu">
                    <li>
                        <a href="add-category">Dodaj</a>
                    </li>
                    <li>
                        <a href="edit-category">Edytuj</a>
                    </li>
                    <li>
                        <a href="delete-category">Usuń</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="about">
                    <i class="fas fa-question"></i>
                    O nas
                </a>
            </li>
            <li>
                <a href="">
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
                            <a class="nav-link" href=""></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="home">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

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