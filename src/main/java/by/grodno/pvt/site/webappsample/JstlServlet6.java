package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.Department;
import by.grodno.pvt.site.webappsample.service.DepartmentService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JstlServlet6 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Department dept = new Department(null, req.getParameter("name"));
        DepartmentService.getService().addDepartment(dept);
        resp.sendRedirect("/webappsample/dept");
    }
}
