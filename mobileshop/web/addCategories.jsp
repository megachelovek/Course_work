<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить категорию</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">Добавить категорию</h1>
<div class="description">
    <form action="/addCategories" method="post">
        Название категории </br>
        <input name="category_name" type="text" placeholder="category_name" class="textbox"> </br>
        <input type="submit" value="Add_categories" class="button"/>
        <a href="/listSmartphone">Cancel</a>
    </form>
</div>
</body>
</html>