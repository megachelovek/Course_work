<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Список смартфонов</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">Список смартфонов</h1>
<table class="table" align="center">
    <thead>
    <td>Название</td>
    <td>CPU</td>
    <td>RAM</td>
    <td>ROM</td>
    <td>Форма</td>
    <td>Цвет</td>
    </thead>
    <tbody>
    <c:forEach items="${smartphone}" var="smartphone">
    <tr>
        <td>${smartphone.name}
        </td>
        <td>{smartphone.cpu}
        </td>
        <td>${smartphone.ram}
        </td>
        <td>${smartphone.rom}
        </td>
        <td>${smartphone.shape_id}
        </td>
        <td>${smartphone.color_id}
        </td>
        <td><a href="/editSmartphone?product_id=${smartphone.product_id}">Изменить</a></td>
        <td><a href="/deleteSmartphone?product_id=${smartphone.product_id}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/listColors">Список цветов</a>
    <a href="/listShapes">Список форм</a>
    <a href="/listCategories">Список категорий</a>
</div>
</form>
</body>
</html>