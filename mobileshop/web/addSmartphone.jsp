<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Добавить смартфон</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">Добавить смартфон
</h1>
<div class="description">
    <form action="addShape" method="post">
        Добавление нового смартфона</br>
        Название </br>
        <input name="name" type="text" placeholder="name" class="textbox"></br>
        Cpu </br>
        <input name="cpu" type="text" placeholder="0" class="textbox"></br>
        Ram </br>
        <input name="ram" type="number" placeholder="0" class="textbox"></br>
        Rom </br>
        <input name="rom" type="number" placeholder="0" class="textbox"></br>
        Shape </br>
        <select class="description" name="shape_selector">
            <c:forEach items="${shape}" var="shape">
                <option>${shape.width}
                </option>
            </c:forEach>
        </select>
        Color </br>
        <select class="description" name="color_selector">
            <c:forEach items="${color}" var="color">
                <option>${color.name}
                </option>
            </c:forEach>
        </select>

        <input type="submit" value="Add_smartphone" class="button"/>
        <a href="/listSmartphone">Cancel</a>
    </form>
</div>
</body>
</html>