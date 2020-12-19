<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="by.grodno.pvt.site.webappsample.service.Department"%>
<%@page import="by.grodno.pvt.site.webappsample.service.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<html>
   <body>
      <%@ include file="fragments/header.jsp"%>
      <form action = "user" method = "POST">
         First Name: <input type = "text" name = "firstName">
         <br />
         Last Name: <input type = "text" name = "lastName" />
         <br />
         BirthDate: <input type = "date" name = "birthdate" />
         <br />
         <input type="radio" id="male" name="male" value="true">
			<label for="male">Male</label><br>
		 <input type="radio" id="female" name="male" value="false">
			<label for="female">Female</label><br>
         Salary: <input type = "text" name = "salary" />
         <br />
         Department:  <select id="user_dept" name="user_dept">
                           <option value="null">No department</option>
                           <c:forEach items="${requestScope.dept}" var="dept">
                                <option value ="${dept.id}">${dept.name}</option>
                           </c:forEach>
                       </select>
         <br/>
         <input type = "submit" value = "Submit" />
      </form>
   </body>
</html>

