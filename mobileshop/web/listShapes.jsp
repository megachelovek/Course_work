<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Список форм-факторов</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">Список форм-факторов</h1>
<table class="table" align="center">
    <thead>
    <td>Ширина</td>
    <td>Высота</td>
    <td>Вес</td>
    </thead>
    <tbody>
    <c:forEach items="${shape}" var="shape">
    <tr>
        <td>${shape.width}
        </td>
        <td>${shape.height}
        </td>
        <td>${shape.weight}
        </td>
        <td><a href="/editShape?shape_id=${shape.shape_id}">Изменить</a></td>
        <td><a href="/deleteShape?shape_id=${shape.shape_id}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/listColors">Список цветов</a>
    <a href="/listSmartphones">Список смартфонов</a>
    <a href="/listCategories">Список категорий</a>
</div>
</form>
</body>
</html>