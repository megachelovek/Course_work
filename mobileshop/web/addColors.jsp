<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить цвет</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">Добавить цвет</h1>
<div class="description">
    <form action="addColors" method="post">
        RGB код </br>
        <input name="rgb" type="number" placeholder="0" class="textbox"></br>
        Имя цвета </br>
        <input name="color_name" type="text" placeholder="color_name" class="textbox"> </br>
        <input type="submit" value="Add_color" class="button"/>
        <a href="/listSmartphone">Cancel</a>
    </form>
</div>
</body>
</html>