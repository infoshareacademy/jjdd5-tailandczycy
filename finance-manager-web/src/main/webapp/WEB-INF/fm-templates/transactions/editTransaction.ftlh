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
                            <a class="nav-link" href="#">Login</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <h2>Wydatki<span class="badge badge-secondary">Nowy</span></h2>
        <form>
            <div class="form-group">
                <label for="usr">Nazwa:</label>
                <input type="text" class="form-control" id="usr" value="???">
            </div>
            <div class="form-group">
                <label for="pwd">Data:</label>
                <input type="date" class="form-control" id="pwd" value="???">
            </div>
            <div class="form-group">
                <label for="pwd">Kwota:</label>
                <input type="number" class="form-control" id="pwd" value="???">
            </div>
            <div class="form-group">
                <label for="exampleFormControlSelect2">Kategoria:</label>
                <select multiple class="form-control" id="exampleFormControlSelect2">
                    <option>Dom i rachunki</option>
                    <option>Odzież i obuwie</option>
                    <option>Wydatki podstawowe</option>
                    <option>Zdrowie i uroda</option>
                    <option>Rozrywka i podróże</option>
                    <option>Samochód i transport</option>
                </select>
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Komentarz:</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>
        </form>
        <button type="button" class="btn btn-primary active">Wyślij</button>
    <#include "../static/footer.ftlh">
    <#include "../static/scripts.ftlh">
