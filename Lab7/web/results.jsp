<%
    String r = request.getParameter("r");
    String x = request.getParameter("x");
    String y = request.getParameter("y");
    String contains = (String) request.getAttribute("contains");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Lab7</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<table border="1">
    <tr><th>X<th>Y<th>R
    <tr><td><%=x%><td><%=y%><td><%=r%>
</table>
<br>
<span class="field">Matched: <span><%=contains%></span></span>
<br>
<a href="">Go back</a>
</body>
</html>
