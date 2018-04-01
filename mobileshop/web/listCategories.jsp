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
    <td>Название</td>
    </thead>
    <tbody>
    <c:forEach var="categories" items="${categories}" >
    <tr>
        <td>${categories.name}
        </td>
        <td><a href="/editCategories?category_id=${categories.category_id}">Изменить</a></td>
        <td><a href="/deleteCategories?category_id=${categories.category_id}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/listShapes">Список форм</a>
    <a href="/listSmartphones">Список смартфонов</a>
    <a href="/listColors">Список категорий</a>
</div>
</form>
</body>
</html>