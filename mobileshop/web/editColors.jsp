<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменить цвет</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">${colorToEdit.name}
</h1>
<div class="description">
    <form action="editColor" method="post">
        Цвет </br>
        <input id="editColor" name="editedColorRGB" type="number" value="${colorToEdit.rgb}" class="textbox"> </br>
        Название </br>
        <input id="editName" name="editedColorName" type="text" value="${colorToEdit.name}" class="textbox"> </br>
        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/listColors">Cancel</a>
    </form>
</div>
</body>
</html>