package by.grodno.pvt.site.webappsample.service;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private static DepartmentService departmentService;

    public static final Logger LOGGER = Logger.getLogger(DepartmentService.class);

    private DepartmentService() {
    }

    public static DepartmentService getService() {
        if (departmentService == null) {
            departmentService = new DepartmentService();
        }
        return departmentService;
    }

    public List<Department> getDepartments() {
        List<Department> result = new ArrayList<Department>();
        try (Connection conn = DBUtils.getConnetion();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL_DEPT);
            while (rs.next()) {
                Department department = mapRawToDepartment(rs);
                result.add(department);
            }
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return result;
    }

    public Department getDepartment(Integer number){
        Department dept = new Department();
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.SELECT_DEPT_BY_ID)) {
            stmt.setInt(1, number);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                dept = mapRawToDepartment(rs);
            }
            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return dept;
    }

    private Department mapRawToDepartment(ResultSet rs) throws SQLException {
        Integer id = rs.getInt(1);
        String dName = rs.getString(2);
        Department department = new Department(id, dName);
        return department;
    };

    public void addDepartment(Department dept) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_DEPT, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, dept.getName());

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedKeys.next();
            LOGGER.info("User created with id: " + generatedKeys.getLong(1));

        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }

    public void deleteDepartment(Integer number) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.DELETE_DEPT_BY_ID)) {

            stmt.setInt(1, number);

            stmt.execute();

        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    };

    public void editDepartment(Department dept) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.UPDATE_DEPT_BY_ID)) {
            stmt.setString(1, dept.getName());
            stmt.setInt(2, dept.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }

    }
}
