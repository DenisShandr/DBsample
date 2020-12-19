<%@page import="by.grodno.pvt.site.webappsample.service.Department"%>

<html>
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">

<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="fragments/header.jsp"%>

<br />

<c:if test="${requestScope.dept != null}">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Num</th>
            <th scope="col">Name</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <c:forEach var="i" begin="1" end="${fn:length(requestScope.dept)}">
            <c:set var="currDept" scope="request"
                   value="${requestScope.dept[i-1]}" />
            <tr>
                <td scope="row">${i}</td>
                <td>${requestScope.currDept.name}</td>
                <td><a class="btn btn-warning"
                       href="http://localhost/webappsample/dept/edit?number=${requestScope.currDept.id}">Edit
                </a> <a>     </a>
                    <a class="btn btn-danger"
                       href="http://localhost/webappsample/dept/delete?number=${requestScope.currDept.id}">Delete
                    </a></td>
            </tr>

        </c:forEach>
    </table>
</c:if>

<a class="btn btn-primary"
   href="http://localhost/webappsample/jstl6.jsp">Add department</a>
<a>     </a>
<a class="btn btn-primary"
   href="http://localhost/webappsample/">View users</a>
<br />
<br />



</body>
</html>
