<!doctype html>
<html lang="pl-PL">
    <head>
    <#include "static/head.ftlh">
    </head>

<body onload="onLoad()">
<#assign login="active">

<div class="container-fluid">
    <div class="row">
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">

            <div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">

                <div class="jumbotron jumbotron-opacity jumbotron-login">
                    <h1 class="display-4"></h1>
                    <p class="lead">You are logged as:</p>
                    <hr class="my-4">
                    <div class="card-deck">
                        <div class="card">
                            <div class="card-body">
                                <p class="card-text">Full name: <b>${sessionName}</b></p>

                                <p class="card-text">Your email: <b>${sessionEmail}</b></p>

                                <div class="card-body">
                                    <a href="javascript:signOut();">Sign out</a>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </main>
    </div>
</div>
<script>
<#include "js/oauth.js">
</script>
</body>
<#include "static/scripts.ftlh">
</html>
