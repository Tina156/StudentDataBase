package StudentDataBase;

import java.util.*;

public class test {
	public static void main(String args[]) {
		Operation op = new Operation();
		Scanner in = new Scanner(System.in);
		int opt, key;
		String num, sno, cno;
		Student student = new Student();
		Course course = new Course();
		StudentCourse studentCourse = new StudentCourse();
		while (true) {
			showMainMenu();
			opt = MenuSelect();
			switch (opt) {
			case 1:
				while (true) {
					pause();
					clearScreen();
					showInputMenu();
					key = MenuSelect();
					switch (key) {
					case 1:
						System.out.println("输入学号为0时,停止保存学生数据\n");
						while (true) {
							Student s = new Student();
							System.out.print(" 学号：");
							num = in.next();
							if (num.equals("0")) {
								s = null;
								break;
							} else {
								s.setSno(num);
								System.out.print(" 姓名：");
								s.setSname(in.next());
								System.out.print(" 性别：");
								s.setSex(in.next());
								System.out.print(" 系：");
								s.setDept(in.next());
								System.out.print(" 年龄：");
								s.setAge(in.nextInt());
								op.add(s);
								System.out.println();
							}
						}
						continue;
					case 2:
						System.out.println("输入课序号为0时,停止保存学生数据\n");
						while (true) {
							System.out.print(" 课程号：");
							cno = in.next();
							if (cno.equals("0"))
								break;
							else {
								Course c = new Course();
								c.setCno(cno);
								System.out.print(" 课程名：");
								c.setCname(in.next());
								System.out.print(" 学分：");
								c.setCredit(in.nextInt());
								op.add(c);
								System.out.println();
							}
						}
						continue;
					case 3:
						System.out.println("输入学号为0时,停止保存学生成绩信息\n");
						while (true) {
							System.out.print("学号：");
							sno = in.next();
							if (sno.equals("0"))
								break;
							else {
								StudentCourse sc = new StudentCourse();
								sc.setSno(sno);
								System.out.print(" 课程号：");
								sc.setCno(in.next());
								System.out.print(" 分数：");
								sc.setGrade(in.nextInt());
								op.add(sc);
								System.out.println();
							}
						}
						continue;// 副菜单中若没有点选项返回主菜单，让界面停留在副菜单
					case 4:
						break;
					default:
						continue;
					}
					break;
				}
				break;
			case 2:
				while (true) {
					pause();
					clearScreen();
					showQueryMenu();
					key = MenuSelect();
					switch (key) {
					case 1:
						System.out.println("学号\t姓名 \t性别\t系\t年龄  ");
						ArrayList<Student> a = op.query();
						for (int i = 0; i < a.size(); i++) {
							Student s = a.get(i);
							System.out.println(s.getSno() + '\t' + s.getSname()
									+ '\t' + s.getSex() + '\t' + s.getDept()
									+ '\t' + s.getAge());
						}
						continue;// 副菜单中若没有点选项返回主菜单，让界面停留在副菜单
					case 2:
						System.out.print("学号:");
						sno = in.next();
						Student s = op.query(sno);
						System.out.println();
						System.out.println("学号\t姓名 \t性别\t系\t年龄  ");
						System.out.println(s.getSno() + '\t' + s.getSname()
								+ '\t' + s.getSex() + '\t' + s.getDept() + '\t'
								+ s.getAge());
						continue;
					case 3:
						System.out.print("学号:");
						sno = in.next();
						System.out.print("课序号:");
						cno = in.next();
						op.query(sno, cno);

						continue;
					case 4:
						System.out.print("学号:");
						sno = in.next();
						ArrayList<Course> b = op.queryStudentCourse(sno);
						int sum = 0;
						System.out.println("课序号\t课程名\t学分 ");
						for (int i = 0; i < b.size(); i++) {
							Course c = b.get(i);
							System.out.println(c.getCno() + '\t' + c.getCname()
									+ '\t' + c.getCredit());
							sum += c.getCredit();
						}
						System.out.println();
						System.out.println("总学分为:" + sum);
						continue;// 副菜单中若没有点选项返回主菜单，让界面停留在副菜单
					case 5:
						op.Ranking();
						continue;
					case 6:
						op.queryDepartment();
						continue;
					case 7:
						break;
					default:
						continue;
					}
					break;
				}
				break;
			case 3:
				while (true) {
					pause();
					clearScreen();
					showModifyMenu();
					key = MenuSelect();
					switch (key) {
					case 1:
						System.out.println("输入修改学号的学号:");
						num = in.next();
						student.setSno(num);
						System.out.println("修改后的姓名");
						student.setSname(in.next());
						System.out.println("修改后的性别");
						student.setSex(in.next());
						System.out.println("修改后的所在系");
						student.setDept(in.next());
						System.out.println("修改后的年龄");
						student.setAge(in.nextInt());
						if (op.modify(student))
							System.out.println("修改成功");
						else
							System.out.println("修改失败");
						continue;// 副菜单中若没有点选项返回主菜单，让界面停留在副菜单
					case 2:
						System.out.println("输入修改的课序号:");
						num = in.next();
						course.setCno(num);
						System.out.println("修改后的课程名");
						course.setCname(in.next());
						System.out.println("修改后的学分");
						course.setCredit(in.nextInt());
						if (op.modify(course))
							System.out.println("修改成功");
						else
							System.out.println("修改失败");
						continue;// 副菜单中若没有点选项返回主菜单，让界面停留在副菜单
					case 3:
						System.out.println("输入要修改学生的学号:");
						num = in.next();
						System.out.println("输入要修改学生的课序号:");
						cno = in.next();
						studentCourse.setSno(num);
						studentCourse.setCno(cno);
						System.out.println("修改后的成绩");
						studentCourse.setGrade(in.nextInt());
						if (op.modify(studentCourse))
							System.out.println("修改成功");
						else
							System.out.println("修改失败");
						continue;// 副菜单中若没有点选项返回主菜单，让界面停留在副菜单
					case 4:
						break;
					default:
						continue;
					}
					break;
				}
				break;
			case 4:
				while (true) {
					pause();
					clearScreen();
					showDeletionMenu();
					key = MenuSelect();
					switch (key) {
					case 1:
						System.out.println("输入删除学生的学号：");
						sno = in.next();
						if (op.deleteStudent(sno))
							System.out.println("删除成功");
						else
							System.out.println("删除失败");
						continue;
					case 2:
						System.out.println("输入要删除的课序号：");
						cno = in.next();
						if (op.deleteCourse(cno))
							System.out.println("删除成功");
						else
							System.out.println("删除失败");
						continue;
					case 3:
						System.out.print("输入学号:");
						sno = in.next();
						System.out.print("输入课序号:");
						cno = in.next();
						if (op.delete(sno, cno))
							System.out.println("删除成功");
						else
							System.out.println("删除失败");
						continue;
					case 4:
						break;
					default:
						continue;
					}
					break;
				}
				break;
			case 5:
				return;
			default:
				continue;
			}
			pause();
			clearScreen();
		}
	}

	public static void showDeletionMenu() {
		System.out.println("DeletionMenu:");
		System.out.println("**1.按学号删除学生信息                            **");
		System.out.println("**2.按课程号删除学生信息                        **");
		System.out.println("**3.按学号和课程号删除成绩信息           **");
		System.out.println("**4.返回上一级菜单        **");
	}

	public static void pause() {
		Scanner in = new Scanner(System.in);
		System.out.println("按任意键继续……");
		in.nextLine();
	}

	public static int MenuSelect() {
		int opt;
		Scanner in = new Scanner(System.in);
		System.out.println("选择功能:");
		opt = in.nextInt();
		in.nextLine();
		return opt;

	}

	public static void showQueryMenu() {
		System.out.println("QueryMenu");
		System.out.println("**1.查询学生信息                           **");
		System.out.println("**2.按学号查询学生信息              **");
		System.out.println("**3.查询某学生的某课程信息     **");
		System.out.println("**4.查询某学生明细及总学分     **");
		System.out.println("**5.总成绩榜排序                           **");
		System.out.println("**6.查询各个系的人数                  **");
		System.out.println("**7.返回上一级菜单                       **");
	}

	public static void showMainMenu() {
		System.out.println("MainMenu:");
		System.out.println("**1.信息输入         **");
		System.out.println("**2.信息查询         **");
		System.out.println("**3.信息修改         **");
		System.out.println("**4.信息删除         **");
		System.out.println("**5.退出程序           **");
	}

	public static void showInputMenu() {
		System.out.println("InputMenu:");
		System.out.println("**1.录入学生信息                **");
		System.out.println("**2.录入课程信息                **");
		System.out.println("**3.录入成绩信息                **");
		System.out.println("**4.返回上一级菜单            **");
	}

	public static void showModifyMenu() {
		System.out.println("ModifyMenu:");
		System.out.println("**1.按学号修改学生信息                 **");
		System.out.println("**2.按课程号修改课程信息              **");
		System.out.println("**3.按学号和课程号修改成绩信息**");
		System.out.println("**4.返回上一级菜单                            **");
	}

	public static void clearScreen()// 伪清屏
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}
}