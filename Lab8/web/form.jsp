<!DOCTYPE html>
<!--
 Университет ИТМО
 Кафедра вычислительной техники
 Программирование интернет-приложений

 Лабораторная работа №8
 Работа с Java Servlets, GlassFish, JSP-страницами
 Вариант: 1330

 Выполнил:
 студент II курса факультета ПИиКТ
 Дьяков Андрей Александрович, группа P3200

 Преподаватель:
 Гаврилов Антон Валерьевич

 Санкт-Петербург, 2016г.
-->

<html>
<head>
    <title>Lab8</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/main.css">
    <script>
        function isNumeric(n) {
            return !isNaN(parseFloat(n)) && isFinite(n);
        }

        function checkForm() {
            var x = document.getElementById("x").value;
            var y = document.getElementById("y").value;
            var r = -1;
            if(document.getElementById("r1").checked) r = 1;
            if(document.getElementById("r2").checked) r = 2;
            if(document.getElementById("r3").checked) r = 3;
            if(document.getElementById("r4").checked) r = 4;
            if(document.getElementById("r5").checked) r = 5;

            if(!(isNumeric(r) && 1 <= r && r <= 5)) {
                alert("Invalid R. Must be [1; 5] number");
                return false;
            }
            if(!(isNumeric(x) && -4 <= x && x <= 4)) {
                alert("Invalid X. Must be [-4; 4] number");
                return false;
            }
            if(!(isNumeric(y) && -3 <= y && y <= 3)) {
                alert("Invalid Y. Must be [-3; 3] number");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div id="header">
    Дьяков Андрей Александрович, P3200<br>
    Вариант: 1330
</div>
<form action="" method="post" onsubmit="return checkForm();">
    <table id="form">
        <tr>
            <td colspan="2">
                <img id="graph" src="images/graph.png">
        <tr>
            <td>
                <label for="x"><span>X:</span></label>
                <select id="x" name="x">
                    <option disabled selected>Выберите X:</option>
                    <option value="-4">-4</option>
                    <option value="-3">-3</option>
                    <option value="-2">-2</option>
                    <option value="-1">-1</option>
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <br>
            <td rowspan="2">
                <span>R:</span><br>
                <input type="radio" id="r1" name="r" value="1"><label for="r1">1</label>
                <input type="radio" id="r2" name="r" value="2"><label for="r2">2</label>
                <input type="radio" id="r3" name="r" value="3"><label for="r3">3</label>
                <input type="radio" id="r4" name="r" value="4"><label for="r4">4</label>
                <input type="radio" id="r5" name="r" value="5"><label for="r5">5</label>
        <tr>
            <td>
                <label for="y"><span>Y:</span></label>
                <input type="text" id="y" name="y" placeholder="Введите Y">
        <tr>
            <td colspan="2">
                <input type="submit" value="Рассчитать">
    </table>
</form>
<script>
document.getElementById("graph").onclick = function imgClick(e) {
    var r = -1;
    if(document.getElementById("r1").checked) r = 1;
    if(document.getElementById("r2").checked) r = 2;
    if(document.getElementById("r3").checked) r = 3;
    if(document.getElementById("r4").checked) r = 4;
    if(document.getElementById("r5").checked) r = 5;
    if(!(isNumeric(r) && 1 <= r && r <= 5)) {
        alert("Invalid R. Must be [1; 5] number");
        return false;
    }

    var x_click = e.offsetX == undefined ? e.layerX - 75 : e.offsetX;
    var y_click = e.offsetY == undefined ? e.layerY - 64 : e.offsetY;
    x_click = (x_click - 108) / 80 * r;
    y_click = (110 - y_click) / 80 * r;


    if(!(isNumeric(x_click) && -4 <= x_click && x_click <= 4)) {
        alert("Invalid X. Must be [-4; 4] number");
        return false;
    }
    if(!(isNumeric(y_click) && -3 <= y_click && y_click <= 3)) {
        alert("Invalid Y. Must be [-3; 3] number");
        return false;
    }

    document.getElementById("x").value = Math.round(x_click);
    document.getElementById("y").value = y_click;
}
</script>
<table border="1">
    <tr><th>X<th>Y<th>R<th>Matched
    <tr><td>${matches.matches[0].vertex.x}<td>${matches.matches[0].vertex.y}<td>${matches.matches[0].r}<td>${matches.matches[0].matched}
    <tr><td>${matches.matches[1].vertex.x}<td>${matches.matches[1].vertex.y}<td>${matches.matches[1].r}<td>${matches.matches[1].matched}
    <tr><td>${matches.matches[2].vertex.x}<td>${matches.matches[2].vertex.y}<td>${matches.matches[2].r}<td>${matches.matches[2].matched}
    <tr><td>${matches.matches[3].vertex.x}<td>${matches.matches[3].vertex.y}<td>${matches.matches[3].r}<td>${matches.matches[3].matched}
    <tr><td>${matches.matches[4].vertex.x}<td>${matches.matches[4].vertex.y}<td>${matches.matches[4].r}<td>${matches.matches[4].matched}
</table>
</body>
</html>