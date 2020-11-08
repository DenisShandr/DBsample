package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JstlServlet4 extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String parameter = req.getParameter("id");
        int id;
        if (!(parameter == null)) {
            id = Integer.valueOf(parameter);
        } else {
            id = 0;
        }

        try {
            UserService.getService()
                    .editUser(Integer.valueOf(id),
                            req.getParameter("firstName"),
                            req.getParameter("lastName"),
                            req.getParameter("salary"),
                            new SimpleDateFormat("yyyy-MM-dd")
                                    .parse(req.getParameter("birthdate")),
                            Boolean.valueOf(req.getParameter("male")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/webappsample/jstl1");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        User user = UserService.getService().getUser(Integer.parseInt(parameter));
        req.setAttribute("id", user.getId());
        req.setAttribute("firstName", user.getFirstName());
        req.setAttribute("lastName", user.getLastName());
        req.setAttribute("salary", user.getSalary());
        req.setAttribute("birthday", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
                .format(user.getBirthdate()));
        req.setAttribute("male", user.isMale());
        getServletContext().getRequestDispatcher("/jstl4.jsp").forward(req, resp);

    }

}