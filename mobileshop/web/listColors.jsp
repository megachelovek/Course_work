<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Список цветов</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">Список цветов</h1>
<table class="table" align="center">
    <thead>
    <td>RGB</td>
    <td>Название</td>
    </thead>
    <tbody>
    <c:forEach items="${color}" var="color">
    <tr>
        <td>${color.rgb}
        </td>
        <td>${color.name}
        </td>
        <td><a href="/editColors?color_id=${color.color_id}">Изменить</a></td>
        <td><a href="/deleteColors?color_id=${color.color_id}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/listShapes">Список форм</a>
    <a href="/listSmartphones">Список смартфонов</a>
    <a href="/listCategories">Список категорий</a>
</div>
</form>
</body>
</html>