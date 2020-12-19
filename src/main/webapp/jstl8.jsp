<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>
<form action="dept/edit" method = "POST">
    <input type="hidden" name="number"
           value="<%=(request.getParameter("number"))%>" />
    <br />
    Department Name: <input type = "text"
                       value="<%=request.getParameter("name")%>"
                       name = "name">
    <br />

    <input type = "submit" value = "Submit" />
</form>


</body>
</html>