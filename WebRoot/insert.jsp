<%--
  Created by IntelliJ IDEA.
  User: zenith7ryu
  Date: 2018/3/18
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="Java" pageEncoding="UTF-8" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="width=device-width, initial-scale=1">
    <script type="text/javascript">
    </script>
    <title>登録</title>
</head>
<body>
<%--<jsp:useBean id="goods" class="entity.Goods" scope="session"/>--%>

<%--<% request.setCharacterEncoding("UTF-8"); %>--%>
<%--<% response.setContentType("UTF-8"); %>--%>

<h1>登録</h1>
<form action="./servlet.insert" method="post">
    商品名<input type="text" name="gname" size="20" maxlength="20"><br>
    数量<input type="text" name="gnum" size="10" maxlength="10"><br>
    値段<input type="text" name="price" size="10" maxlength="10"><br>

    <input type="submit" value="登録"/>
</form>

<form action="./servlet.Demo1" method="get">
    <input type="submit" value="demo1 get"/>
</form>

<form action="./servlet.Demo1" method="post">
    <input type="submit" value="demo1 post"/>
</form>

</body>
</html>
