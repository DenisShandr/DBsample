package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static by.grodno.pvt.site.webappsample.service.UserService.LOGGER;


public class JstlServlet4 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        User user = UserService.getService().getUser(Integer.valueOf(parameter));


        resp.sendRedirect("/webappsample/jstl4.jsp?firstName=" + user.getFirstName() + "&lastName=" + user.getLastName()
                + "&birthdate=" + new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthdate()) + "&male=" + user.isMale() + "&salary=" + user.getSalary()
                + "&number=" + user.getId());


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
                    Boolean.valueOf(req.getParameter("male")));
        } catch (ParseException e) {
            LOGGER.error("Something went wrong...", e);
        }
        user.setSalary(Double.valueOf(req.getParameter("salary")));
        UserService.getService().editUser(user);


        resp.sendRedirect("/webappsample/");
    }

}