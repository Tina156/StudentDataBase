package StudentDataBase;

import java.util.ArrayList;
import java.sql.*;

public class Operation {
	private Connection getConnection() {
		String drivers = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "system";
		String passwd = "123456";
		Connection connection = null;
		try {
			Class.forName(drivers); // 加载Oracle驱动程序
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
		try { // 连接数据库
			connection = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return connection;
	}

	public boolean add(Student s) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO s(sno,sname,sex,dept,age) VALUES(?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, s.getSno());
			preparedStatement.setString(2, s.getSname());
			preparedStatement.setString(3, s.getSex());
			preparedStatement.setString(4, s.getDept());
			preparedStatement.setInt(5, s.getAge());
			connection.setAutoCommit(true);
			flag = preparedStatement.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public boolean add(Course c) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO c(cno,cname,credit) VALUES(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, c.getCno());
			preparedStatement.setString(2, c.getCname());
			preparedStatement.setInt(3, c.getCredit());
			connection.setAutoCommit(true);
			flag = preparedStatement.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public boolean add(StudentCourse sc) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO SC(sno,cno,grade) VALUES(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sc.getSno());
			preparedStatement.setString(2, sc.getCno());
			preparedStatement.setInt(3, sc.getGrade());
			connection.setAutoCommit(true);
			flag = preparedStatement.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public boolean deleteStudent(String sno) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		String sql1 = "delete from sc where sno=?";
		String sql2 = "delete from s where sno=?";
		try {
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement1.setString(1, sno);
			preparedStatement2.setString(1, sno);
			connection.setAutoCommit(true);
			flag = preparedStatement1.executeUpdate();
			flag = preparedStatement2.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement1 != null)
				preparedStatement1.close();
			if (preparedStatement2 != null)
				preparedStatement2.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public boolean deleteCourse(String cno) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement1 = null;
		PreparedStatement preparedStatement2 = null;
		String sql1 = "delete from sc where cno=?";
		String sql2 = "delete from c where cno=?";
		try {
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement1.setString(1, cno);
			preparedStatement2.setString(1, cno);
			connection.setAutoCommit(true);
			flag = preparedStatement1.executeUpdate();
			flag = preparedStatement2.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement1 != null)
				preparedStatement1.close();
			if (preparedStatement2 != null)
				preparedStatement2.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public boolean delete(String sno, String cno) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement = null;
		String sql = "delete from sc where sno=? and cno=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sno);
			preparedStatement.setString(2, cno);
			connection.setAutoCommit(true);
			flag = preparedStatement.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
			;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public boolean modify(Student p) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement = null;
		String sql = "update s set sname=?,sex=?,dept=?,age=? where sno=?";
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, p.getSname());
			preparedStatement.setString(2, p.getSex());
			preparedStatement.setString(3, p.getDept());
			preparedStatement.setInt(4, p.getAge());
			preparedStatement.setString(5, p.getSno());
			flag = preparedStatement.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public boolean modify(Course c) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement = null;
		String sql = "update c set cname=?,credit=? where cno=?";
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, c.getCname());
			preparedStatement.setInt(2, c.getCredit());
			preparedStatement.setString(3, c.getCno());
			flag = preparedStatement.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public boolean modify(StudentCourse sc) {
		Connection connection = getConnection();
		int flag = 0;
		PreparedStatement preparedStatement = null;
		String sql = "update sc set grade=? where cno=? and sno=?";
		try {
			connection.setAutoCommit(true);
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, sc.getGrade());
			preparedStatement.setString(2, sc.getCno());
			preparedStatement.setString(3, sc.getSno());
			flag = preparedStatement.executeUpdate();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (flag == 0)
			return false;
		else
			return true;
	}

	public ArrayList<Student> query() {
		ArrayList<Student> al = new ArrayList<Student>();
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		String sql = "select *　from s";
		try {
			preparedStatement = connection.prepareStatement(sql);
			connection.setAutoCommit(true);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setSno(rs.getString("sno"));
				s.setSname(rs.getString("sname"));
				s.setSex(rs.getString("sex"));
				s.setDept(rs.getString("dept"));
				s.setAge(rs.getInt("age"));
				al.add(s);
			}
			if (rs != null)
				rs.close();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return al;
	}

	public Student query(String sno) {
		Student s = new Student();
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		String sql = "select sno,sname,sex,dept,age　from s where sno=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sno);
			connection.setAutoCommit(true);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				s.setSno(rs.getString("sno"));
				s.setSname(rs.getString("sname"));
				s.setSex(rs.getString("sex"));
				s.setDept(rs.getString("dept"));
				s.setAge(rs.getInt("age"));
				if (rs.next() == false)
					break;
			}
			;
			if (rs != null)
				rs.close();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return s;

	}

	public ArrayList<Course> queryStudentCourse(String sno) {
		ArrayList<Course> al = new ArrayList<Course>();
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		String sql = "select *　from c where cno in(select cno from sc where sno=?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sno);
			connection.setAutoCommit(true);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Course c = new Course();
				c.setCno(rs.getString("cno"));
				c.setCname(rs.getString("cname"));
				c.setCredit(rs.getInt("credit"));
				al.add(c);
			}
			if (rs != null)
				rs.close();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return al;
	}

	public void queryDepartment() {
		int count = 0, sum;
		String dept;
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		String sql = "select dept,count(*) from s group by dept";
		try {
			preparedStatement = connection.prepareStatement(sql);
			connection.setAutoCommit(true);
			rs = preparedStatement.executeQuery();
			System.out.println();
			System.out.println("序号\t系名\t学生人数  ");
			while (rs.next()) {
				dept = rs.getString("dept");
				sum = rs.getInt("count(*)");
				count++;
				System.out.println(count + "\t" + dept + "\t" + sum);
			}
			if (rs != null)
				rs.close();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void query(String sno, String cno) {
		Connection connection = getConnection();
		ResultSet rs = null;
		String sname = null, cname = null;
		int grade = 0;
		PreparedStatement preparedStatement = null;
		String sql = "select  s.sno,sname,cname,grade from sc,s,c where s.sno=sc.sno and sc.cno=c.cno and s.sno=? and c.cno=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sno);
			preparedStatement.setString(2, cno);
			connection.setAutoCommit(true);
			rs = preparedStatement.executeQuery();
			System.out.println();
			System.out.println("学号\t姓名 \t课程名 \t成绩   ");
			while (rs.next()) {
				sno = rs.getString("sno");
				sname = rs.getString("sname");
				cname = rs.getString("cname");
				grade = rs.getInt("grade");
				System.out.println(sno + '\t' + sname + '\t' + cname + '\t'
						+ grade);
			}
			if (rs != null)
				rs.close();
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Ranking() {
		String num, name;
		int sum, rank;
		Connection connection = getConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement1 = null,preparedStatement2 = null,preparedStatement3 = null;
		System.out.println("\t学号 \t姓名 \t总分\t排名");
		String sql1="create view temp2 as select s.sno,sname,SUM(grade) as sum from s,sc where s.sno=sc.sno group by s.sno,sname order by SUM(grade) desc";
		String sql2="select sno,sname,sum,(select count(*) from temp b where b.sum>a.sum)+1 as Rank from temp2 a";
		String sql3="drop view temp2";
		try{
				preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement3 = connection.prepareStatement(sql3);
			connection.setAutoCommit(true);
			preparedStatement1.execute();
			rs=preparedStatement2.executeQuery();
			while (rs.next()) {
				num = rs.getString("sno");
				name = rs.getString("sname");
				sum = rs.getInt("sum");
				rank = rs.getInt("Rank");
				System.out.println("\t" + num + "\t" + name + "\t" + sum + "\t"
						+ rank);
			}
			preparedStatement3.execute();
			if (rs != null)
				rs.close();
			if (connection != null)
				connection.close();
			if (preparedStatement1 != null)
				preparedStatement1.close();
			if (preparedStatement2 != null)
				preparedStatement2.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
			//drop table New_table;
	}
}
