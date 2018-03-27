<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменить категорию</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">${categoryToEdit.name}
</h1>
<div class="description">
    <form action="editCategories" method="post">
        Название </br>
        <input id="editName" name="editedCategory" type="text" value="${categoryToEdit.name}" class="textbox"> </br>
        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/listCategories">Cancel</a>
    </form>
</div>
</body>
</html>