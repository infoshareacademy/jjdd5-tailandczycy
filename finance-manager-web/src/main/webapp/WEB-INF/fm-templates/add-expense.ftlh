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
            <li>
                <a href="#pageSubmenu1" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-briefcase"></i>
                    Expenses
                </a>
                <ul class="collapse list-unstyled" id="pageSubmenu1">
                    <li>
                        <a href="/add-expense">Add</a>
                    </li>
                    <li>
                        <a href="/expenses">Display</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-copy"></i>
                    Categories
                </a>
                <ul class="collapse list-unstyled" id="pageSubmenu2">
                    <li>
                        <a href="add-category">Add</a>
                    </li>
                    <li>
                        <a href="/categories">Display</a>
                    </li>
                </ul>
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

        <form>
            <div class="form-group">
                <label for="name">Name of Expense</label>
                <input type="text" class="form-control" id="name" placeholder="Enter Name">
            </div>
            <div class="form-group">
                <label for="comment">Password</label>
                <input type="text" class="form-control" id="comment" aria-describedby="commentHelp" placeholder="Enter comment">
                <small id="commentHelp" class="form-text text-muted">It is optional field</small>
            </div>
            <div class="form-group">
                <label for="c2">Amount</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <div class="input-group-text">PLN</div>
                    </div>
                    <input type="number" value="100" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="c2" />
                </div>
                <div class="form-group">
                    <label for="pwd">Date:</label>
                    <input type="date" class="form-control" id="pwd">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<#include "static/footer.ftlh">
<#include "static/scripts.ftlh">
</body>
</html>