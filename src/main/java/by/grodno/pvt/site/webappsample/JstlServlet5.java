package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.Department;
import by.grodno.pvt.site.webappsample.service.DepartmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JstlServlet5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Department> dept = DepartmentService.getService().getDepartments();

        req.setAttribute("dept", dept);

        getServletContext().getRequestDispatcher("/jstl5.jsp").forward(req, resp);
    }

}