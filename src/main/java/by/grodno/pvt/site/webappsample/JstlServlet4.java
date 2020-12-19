package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.Department;
import by.grodno.pvt.site.webappsample.service.DepartmentService;
import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static by.grodno.pvt.site.webappsample.service.UserService.LOGGER;


public class JstlServlet4 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        User user = UserService.getService().getUser(Integer.valueOf(parameter));
        List<Department> dept = DepartmentService.getService().getDepartments();
        req.setAttribute("dept", dept);
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/jstl4.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String parameter = req.getParameter("number");

        User user = null;
        try {
            user = new User(Integer.valueOf(parameter),
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    new SimpleDateFormat("yyy-MM-dd").parse(req.getParameter("birthdate")),
                    Boolean.valueOf(req.getParameter("male")),
                    Integer.valueOf(req.getParameter("user_dept")));
        } catch (ParseException e) {
            LOGGER.error("Something went wrong...", e);
        }
        user.setSalary(Double.valueOf(req.getParameter("salary")));
        UserService.getService().editUser(user);


        resp.sendRedirect("/webappsample/");
    }

}