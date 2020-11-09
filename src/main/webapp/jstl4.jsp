<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>
<form action="user/edit" method = "POST">
   <input type="hidden" name="number"
          value="<%=(request.getParameter("number"))%>" />
   <br />
   First Name: <input type = "text"
                      value="<%=request.getParameter("firstName")%>"
                      name = "firstName">
   <br />
   Last Name: <input type = "text"
                     value="<%=request.getParameter("lastName")%>"
                     name = "lastName" />
   <br />
   Salary: <input type = "text"
                  value="<%=request.getParameter("salary")%>"
                  name = "salary" />
   <br />
   BirthDate: <input type = "text"
                     value="<%=request.getParameter("birthdate")%>"
                     name = "birthdate" />
   <br />
   <c:if test="${param.male == true}">
      <input type="radio" id="male"   name="male" value="true" checked>
      <label for="male">Male</label><br>
      <input type="radio" id="female" name="male" value="false">
      <label for="female">Female</label><br>
   </c:if>
   <c:if test="${param.male == false}">
      <input type="radio" id="male"   name="male" value="true">
      <label for="male">Male</label><br>
      <input type="radio" id="female" name="male" value="false" checked>
      <label for="female">Female</label><br>
   </c:if>

   <input type = "submit" value = "Submit" />
</form>


</body>
</html>