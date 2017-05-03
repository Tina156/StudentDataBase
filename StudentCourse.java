package StudentDataBase;

public class StudentCourse {
	private String cno;
	private String sno;// ÐÕÃû
	private int grade;

	StudentCourse(String sno, String cno, int grade) {
		this.cno = cno;
		this.sno = sno;
		this.grade = grade;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getCno() {
		return cno;
	}

	public String getSno() {
		return sno;
	}

	public int getGrade() {
		return grade;
	}

	public StudentCourse() {

	}

}
