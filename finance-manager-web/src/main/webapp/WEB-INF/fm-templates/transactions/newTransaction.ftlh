<!DOCTYPE html>
<html>
<head>
    <title>New Transaction</title>
</head>

<body>

<#include "static/home.ftlh">


</body>

</html>



<h1>All Expenses</h1>
<p><#list expenses as expense>
        ${expense.amount}
    </#list></p>