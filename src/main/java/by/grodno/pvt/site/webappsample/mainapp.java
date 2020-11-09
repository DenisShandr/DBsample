package by.grodno.pvt.site.webappsample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mainapp {

    public static void main(String[] args) throws ParseException {
        Integer id = 14;
        String firstName = "Niko";
        String lastName = "Robin";
        String salary = "777";
        Date birthdate = new SimpleDateFormat("yyyy-MM-dd")
                .parse("1980-10-21");
        Boolean male = false;

//
//        try (Connection conn = DBUtils.getConnetion();
//             PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_BY_ID)) {
//
//            stmt.setString(1, firstName);
//            stmt.setString(2, lastName);
//            stmt.setDouble(3, Double.parseDouble(salary));
//            stmt.setTimestamp(4,
//                    Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(birthdate)));
//            stmt.setBoolean(5, male);
//            stmt.setInt(6, id);
//
//            stmt.executeUpdate();
//
//        } catch (Exception e) {
//            LOGGER.error("Something went wrong...", e);
//        }

//
//
//        User user = UserService.getService().getUser(15);
//
//        try (Connection conn = DBUtils.getConnetion();
//             PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_BY_ID)) {
//            stmt.setString(1, user.getFirstName());
//            stmt.setString(2, user.getLastName());
//            stmt.setDouble(3, user.getSalary());
//            stmt.setTimestamp(4,
//                    Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
//                            .format(user.getBirthdate())));
//            stmt.setBoolean(5, user.isMale());
//            stmt.setInt(6, user.getId()-1);
//
//            stmt.executeUpdate();
//
//        } catch (Exception e) {
//            LOGGER.error("Something went wrong...", e);
//        }
//

    }
}
