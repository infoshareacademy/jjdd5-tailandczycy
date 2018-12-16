<#include "head.ftlh">
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
                            <a class="nav-link" href="">${date}</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    <#include "footer.ftlh">
    <#include "scripts.ftlh">
