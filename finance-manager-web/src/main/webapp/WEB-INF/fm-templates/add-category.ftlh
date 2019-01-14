<!DOCTYPE html>
<html>
<head>
    <title>Welcome our new Finance Manager</title>
    <#include "static/head.ftlh">
</head>
<body>
<div class="wrapper">
    <#include "static/navbar.ftlh">
    <div id="content" class="container col-4 myContent">

        <h2 id="myH2">Add category</h2>

        <form>
            <div class="form-group">
                <label for="name">Name of category</label>
                <input type="text" class="form-control" id="name" placeholder="Enter Name">
            </div>
            <div class="form-group">
                <label for="c2">Limit</label>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <div class="input-group-text">PLN</div>
                    </div>
                    <input type="number" value="100" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="c2" />
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