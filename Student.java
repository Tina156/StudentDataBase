package StudentDataBase;

public class Student {
	private String sno;
	private String sname;// ÐÕÃû
	private String sex;// ÐÔ±ð
	private String dept;
	private int age;

	Student(String sno, String sname, String sex, String dept, int age) {
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.dept = dept;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public String getSex() {
		return sex;
	}

	public int getAge() {
		return age;
	}

	public String getDept() {
		return dept;
	}

	public Student() {

	}
}
