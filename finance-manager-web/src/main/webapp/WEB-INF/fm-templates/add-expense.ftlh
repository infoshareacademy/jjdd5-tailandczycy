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

        <h2 id="myH2">Add expense</h2>

        <form method="post">
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
                        <span class="input-group-text" id="basic-addon1">PLN</span>
                    </div>
                    <input type="number" value="100" min="0" step="0.01" data-number-to-fixed="2" data-number-stepfactor="100" class="form-control currency" id="c2" />
                </div>
            </div>
            <div class="form-group">
                <label for="pwd">Date:</label>
                <input type="date" class="form-control" id="pwd">
            </div>
                <#list categories>
                    <div class="form-group">
                    <#items as c>
                        <label class="checkbox-inline">
                            <input type="checkbox" value="${c.id}">${c.name}
                        </label>
                    </#items>
                    </div>
                    <#else>
                        <div class="form-group">
                            <label class="checkbox-inline">
                                <input type="checkbox" value="0" checked>Other
                            </label>
                        </div>
                </#list>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<#include "static/footer.ftlh">
<#include "static/scripts.ftlh">
</body>
</html>