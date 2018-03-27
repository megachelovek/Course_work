<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить форму</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">Добавить форму
</h1>
<div class="description">
    <form action="addShape" method="post">
        Добавление новой формы для устройств</br>
        Ширина </br>
        <input name="width" type="number" placeholder="0" class="textbox"></br>
        Высота </br>
        <input name="height" type="number" placeholder="0" class="textbox"></br>
        Вес </br>
        <input name="weight" type="number" placeholder="0" class="textbox"></br>
        <input type="submit" value="Add_shape" class="button"/>
        <a href="/listSmartphone">Cancel</a>
    </form>
</div>
</body>
</html>