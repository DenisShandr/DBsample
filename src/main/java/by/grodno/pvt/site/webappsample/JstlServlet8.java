package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.Department;
import by.grodno.pvt.site.webappsample.service.DepartmentService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JstlServlet8 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String parameter = req.getParameter("number");
        Department dept = DepartmentService.getService().getDepartment(Integer.valueOf(parameter));
        resp.sendRedirect("/webappsample/jstl8.jsp?name=" + dept.getName() + "&number=" + dept.getId());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String parameter = req.getParameter("number");

        Department dept = null;
        dept = new Department(Integer.valueOf(parameter),
               req.getParameter("name"));

        DepartmentService.getService().editDepartment(dept);


        resp.sendRedirect("/webappsample/dept");
    }

}
