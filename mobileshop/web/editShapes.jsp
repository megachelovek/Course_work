<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменить форму</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">${shapeToEdit.name}
</h1>
<div class="description">
    <form action="editShape" method="post">
        Ширина </br>
        <input id="editWidth" name="editedShapeWidth" type="number" value="${shapeToEdit.width}" class="textbox"> </br>
        Высота </br>
        <input id="editHeight" name="editedShapeHeight" type="number" value="${shapeToEdit.height}" class="textbox"> </br>
        Вес </br>
        <input id="editWeight" name="editedShapeWeight" type="number" value="${shapeToEdit.weight}" class="textbox"> </br>

        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/listShape">Cancel</a>
    </form>
</div>
</body>
</html>