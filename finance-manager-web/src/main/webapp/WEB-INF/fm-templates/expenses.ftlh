<!DOCTYPE html>
<html>
<head>
    <title>Expenses List</title>
</head>
<body>

<#-- text -->
<#list expenses>
    <#items as expense>
        <ul>
            <li>ID: ${expense.id}</li>
            <li>Name: ${expense.name}</li>
            <li>Comment: ${expense.comment}</li>
            <li>Amount: ${expense.amount}</li>
            <li>Date: ${expense.date}</li>
            <li><a href="/edit-expense?id=${expense.id}">edit expense</a></li>
            <li><a href="/delete-expense">delete expense</a></li>
        </ul>
        <#sep><br/>=============================<br/></#sep>
    </#items>
</#list>

</body>
</html>