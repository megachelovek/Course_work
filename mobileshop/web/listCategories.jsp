<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Список категорий</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">Список категорий</h1>
<table class="table" align="center">
    <thead>
    <td>Название</td>
    </thead>
    <tbody>
    <c:forEach items="${listCategories1}" var="categories"  >
    <tr>
        <td>${categories.name}
        </td>
        <td>Изм<a href="/editCategories?category_id=${categories.category_id}">Изменить</a></td>
        <td>Удал<a href="/deleteCategories?category_id=${categories.category_id}">Удалить</a></td>
    </tr>
    </tbody>
    </c:forEach>
</table>
<div class="description">
    <a href="/listShapes">Список форм</a>
    <a href="/listSmartphones">Список смартфонов</a>
    <a href="/listColors">Список цветов</a>
</div>
</form>
</body>
</html>