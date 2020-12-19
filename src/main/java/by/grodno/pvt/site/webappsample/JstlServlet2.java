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

public class JstlServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Department> dept = DepartmentService.getService().getDepartments();
		req.setAttribute("dept", dept);
		getServletContext().getRequestDispatcher("/jstl2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			User user = new User(null, 
					             req.getParameter("firstName"), 
					             req.getParameter("lastName"),
					             new SimpleDateFormat("yyyy-MM-dd")
					                 .parse(req.getParameter("birthdate")),
					             Boolean.valueOf(req.getParameter("male")),
								 Integer.valueOf(req.getParameter("user_depts")));
			user.setSalary(Double.valueOf(req.getParameter("salary")));
			UserService.getService().addUser(user);

		} catch (ParseException e) {
			LOGGER.error("Something went wrong...", e);
		}
		resp.sendRedirect("/webappsample/");
	}

}
