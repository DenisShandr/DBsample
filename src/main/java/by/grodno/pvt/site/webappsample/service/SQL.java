package by.grodno.pvt.site.webappsample.service;

public class SQL {

//	public static final String SELECT_ALL_USERS = "select * from public.testtable order by id";
	public static final String SELECT_ALL_USERS = "SELECT t.id, t.empl_name, empl_last_name, birthdate, male," +
		" d.dept_name, salary FROM public.testtable t LEFT JOIN public.dept d ON t.dept_num = d.id order by t.id";
	public static final String DELETE_BY_ID = "delete from public.testtable where id = ?";
	public static final String SELECT_BY_ID = "select * from public.testtable where id = ?";
	public static final String INSERT = "INSERT INTO public.testTable "
			+ "(empl_name, empl_last_name, salary, birthdate,  male) VALUES (?,?,?,?,?)";
	public static final String UPDATE_BY_ID = "update public.testTable  SET empl_name = ?,"
			+ " empl_last_name = ?, salary = ?, birthdate = ?,  male = ?, dept_num = ? where id = ?";
	public static final String SELECT_ALL_DEPT = "select * from public.dept order by id";
	public static final String INSERT_DEPT = "INSERT INTO public.dept (dept_name) VALUES (?)";
	public static final String DELETE_DEPT_BY_ID = "delete from public.dept where id = ?";
	public static final String SELECT_DEPT_BY_ID = "select * from public.dept where id = ?";
	public static final String UPDATE_DEPT_BY_ID = "update public.dept  SET dept_name = ? where id = ?";
}
