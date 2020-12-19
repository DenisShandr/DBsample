<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="by.grodno.pvt.site.webappsample.service.Department"%>
<%@page import="by.grodno.pvt.site.webappsample.service.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<body>

<c:set var="user" scope="request" value="${requestScope.user}"/>


<form action="edit" method="POST">
    <input type="hidden" name="number"
           value="${user.id}"/>
    <br/>
    <div class="form-group">
        <label class="col-form-label" for="inputDefault">First Name:</label>
        <input type="text" class="form-control"
               class="form-control"
               value="${user.firstName}"
               name="firstName"
               id="inputDefault">
    </div>

    <br/>
    <p class="bg-info text-white">Last Name: <input type="text"
                      value="${user.lastName}"
                      name="lastName"/>
    </p>
    <br/>
    <p class="bg-info text-white">Salary: <input type="text"
                   value="${user.salary}"
                   name="salary"/>
    </p>
    <br/>
    <p class="bg-info text-white">BirthDate: <input type="date"
                      value="${SimpleDateFormat("yyyy-MM-dd")
							 .format(user.birthdate)}"
                      name="birthdate"/>
    </p>
    <br/>
    <div class="form-group">
        <div class="custom-control custom-radio">
            <c:if test="${user.male == true}">
                <input type="radio" id="customRadio1" name="male" class="custom-control-input" value="true" checked>
                <label class="custom-control-label" for="customRadio1">Male</label><br>
                <input type="radio" id="customRadio2" name="male" class="custom-control-input" value="false">
                <label class="custom-control-label" for="customRadio2">Female</label><br>
            </c:if>
            <c:if test="${user.male == false}">
                <input type="radio" id="customRadio1" name="male" class="custom-control-input" value="true">
                <label class="custom-control-label" for="customRadio1">Male</label><br>
                <input type="radio" id="customRadio2" name="male" class="custom-control-input" value="false" checked>
                <label class="custom-control-label" for="customRadio2">Female</label><br>
            </c:if>
        </div>
    </div>
    Department:  <select class="custom-select" id="user_dept" name="user_dept">
                     <option value="null">No department</option>
                     <c:if test="${user.department != null}">
                         <option value="${requestScope.dept.get(user.department)}" selected>
                             ${requestScope.dept.get(user.department).name}
                         </option>
                     </c:if>
                     <c:if test="${user.department == null}">
                         <option value="null">No department</option>>
                     </c:if>
                     <c:forEach items="${requestScope.dept}" var="dept">
                         <option value ="${dept.id}">${dept.name}</option>
                     </c:forEach>
                 </select>
    <br/>


    <input type="submit" value="Submit"/>
</form>


</body>
</html>