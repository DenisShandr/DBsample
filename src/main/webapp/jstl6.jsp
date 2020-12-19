<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<%@ include file="fragments/header.jsp"%>
<form action = "dept/add" method = "POST">
    Department Name: <input type = "text" name = "name">
    <br />
    <input type = "submit" value = "Submit" />
</form>
</body>
</html>

