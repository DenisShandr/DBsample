<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
   <body>
      <%@ include file="fragments/header.jsp"%>
      <form action = "user" method = "POST">
         First Name: <input type = "text" name = "firstName">
         <br />
         Last Name: <input type = "text" name = "lastName" />
         <br />
         BirthDate: <input type = "text" name = "birthdate" />
         <br />
         <input type="radio" id="male" name="male" value="true">
			<label for="male">Male</label><br>
		 <input type="radio" id="female" name="male" value="false">
			<label for="female">Female</label><br>
         Salary: <input type = "text" name = "salary" />
         <br />
         <input type = "submit" value = "Submit" />
      </form>
   </body>
</html>

