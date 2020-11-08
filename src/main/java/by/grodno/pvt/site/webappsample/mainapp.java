package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.DBUtils;
import by.grodno.pvt.site.webappsample.service.SQL;
import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static by.grodno.pvt.site.webappsample.service.UserService.LOGGER;

public class mainapp {

    public static void main(String[] args) throws ParseException {
        Integer id = 13;
        String firstName = "Niko";
        String lastName = "Robin";
        String salary = "777";
        Date birthdate = new SimpleDateFormat("yyyy-MM-dd")
                .parse("1980-10-21");
        Boolean male = false;



        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_BY_ID)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setDouble(3, Double.parseDouble(salary));
            stmt.setTimestamp(4,
                    Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(birthdate)));
            stmt.setBoolean(5, male);
            stmt.setInt(6, id);

            stmt.executeUpdate();

        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }

    }
}
