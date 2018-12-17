<#include "../static/head.ftlh">
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
                    Account
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
                    Expenses
                </a>
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">
                    <i class="fas fa-copy"></i>
                    Categories
                </a>
                <ul class="collapse list-unstyled" id="pageSubmenu">
                    <li>
                        <a href="add-category">Add</a>
                    </li>
                    <li>
                        <a href="edit-category">Edit</a>
                    </li>
                    <li>
                        <a href="delete-category">Delete</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="about">
                    <i class="fas fa-question"></i>
                    About us
                </a>
            </li>
            <li>
                <a href="">
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
                            <a class="nav-link" href="#">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <h2>Expenses<span class="badge badge-secondary">Edit</span></h2>
        <form method="post" action="/edit-expense">
            <input type="hidden" name="expenseId" value="${expense.id}"/>
            <div class="form-group">
                <label for="usr">Name:</label>
                <input type="text" class="form-control" id="usr" name="name" value="${expense.name}">
            </div>
            <div class="form-group">
                <label for="pwd">Date:</label>
                <input type="date" class="form-control" id="pwd" name="date" value="${expense.date}">
            </div>
            <div class="form-group">
                <label for="amt">Amount:</label>
                <input type="number" class="form-control" id="amt" name="amount" value=${bigdecimal}>
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Category:</label>
                <select multiple class="form-control" id="exampleFormControlSelect2" name="categories">
                    <#list category as c>
                        <option value="${c.name}">${c.name}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Commentary:</label>
                <input type="text" value="${expense.comment}" class="form-control" id="exampleFormControlTextarea1" rows="3" name="comment"></input>
            </div>
            <input type="submit" name="save" class="btn btn-primary active" value="Send"/>
        </form>
    <#include "../static/footer.ftlh">
    <#include "../static/scripts.ftlh">
