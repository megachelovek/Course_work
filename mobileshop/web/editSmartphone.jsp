<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Изменить смартфон</title>
    <link rel="stylesheet" type="text/css" href="WEB-INF/css/weblabscss.css"/>
</head>
<body>
<h1 class="header">${smartphoneToEdit.name}
</h1>
<div class="description">
    <form action="editSmartphone" method="post">
        Название </br>
        <input id="editName" name="editedSmartphoneName" type="text" value="${smartphoneToEdit.name}" class="textbox"> </br>
        CPU </br>
        <input id="editCpu" name="editedSmartphoneCpu" type="text" value="${smartphoneToEdit.cpu}" class="textbox"> </br>
        RAM </br>
        <input id="editRam" name="editedSmartphoneRam" type="number" value="${smartphoneToEdit.ram}" class="textbox"> </br>
        ROM </br>
        <input id="editRom" name="editedSmartphoneRom" type="number" value="${smartphoneToEdit.rom}" class="textbox"> </br>
        <select class="description" name="selectorShape">
            <option>${smartphoneToEdit.shape}
            </option>
            <c:forEach items="${shapes}" var="shape">
                <option>${smartphoneToEdit.shape}
                </option>
            </c:forEach>
        </select>
        <select class="description" name="selectorColor">
            <option>${smartphoneToEdit.color}
            </option>
            <c:forEach items="${colors}" var="color">
                <option>${smartphoneToEdit.color}
                </option>
            </c:forEach>
        </select>


        <input id="submitButton" type="submit" value="Accept" class="button"/>
        <a href="/listShape">Cancel</a>
    </form>
</div>
</body>
</html>