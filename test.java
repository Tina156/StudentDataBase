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
						System.out.println("����ѧ��Ϊ0ʱ,ֹͣ����ѧ������\n");
						while (true) {
							Student s = new Student();
							System.out.print(" ѧ�ţ�");
							num = in.next();
							if (num.equals("0")) {
								s = null;
								break;
							} else {
								s.setSno(num);
								System.out.print(" ������");
								s.setSname(in.next());
								System.out.print(" �Ա�");
								s.setSex(in.next());
								System.out.print(" ϵ��");
								s.setDept(in.next());
								System.out.print(" ���䣺");
								s.setAge(in.nextInt());
								op.add(s);
								System.out.println();
							}
						}
						continue;
					case 2:
						System.out.println("��������Ϊ0ʱ,ֹͣ����ѧ������\n");
						while (true) {
							System.out.print(" �γ̺ţ�");
							cno = in.next();
							if (cno.equals("0"))
								break;
							else {
								Course c = new Course();
								c.setCno(cno);
								System.out.print(" �γ�����");
								c.setCname(in.next());
								System.out.print(" ѧ�֣�");
								c.setCredit(in.nextInt());
								op.add(c);
								System.out.println();
							}
						}
						continue;
					case 3:
						System.out.println("����ѧ��Ϊ0ʱ,ֹͣ����ѧ���ɼ���Ϣ\n");
						while (true) {
							System.out.print("ѧ�ţ�");
							sno = in.next();
							if (sno.equals("0"))
								break;
							else {
								StudentCourse sc = new StudentCourse();
								sc.setSno(sno);
								System.out.print(" �γ̺ţ�");
								sc.setCno(in.next());
								System.out.print(" ������");
								sc.setGrade(in.nextInt());
								op.add(sc);
								System.out.println();
							}
						}
						continue;// ���˵�����û�е�ѡ������˵����ý���ͣ���ڸ��˵�
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
						System.out.println("ѧ��\t���� \t�Ա�\tϵ\t����  ");
						ArrayList<Student> a = op.query();
						for (int i = 0; i < a.size(); i++) {
							Student s = a.get(i);
							System.out.println(s.getSno() + '\t' + s.getSname()
									+ '\t' + s.getSex() + '\t' + s.getDept()
									+ '\t' + s.getAge());
						}
						continue;// ���˵�����û�е�ѡ������˵����ý���ͣ���ڸ��˵�
					case 2:
						System.out.print("ѧ��:");
						sno = in.next();
						Student s = op.query(sno);
						System.out.println();
						System.out.println("ѧ��\t���� \t�Ա�\tϵ\t����  ");
						System.out.println(s.getSno() + '\t' + s.getSname()
								+ '\t' + s.getSex() + '\t' + s.getDept() + '\t'
								+ s.getAge());
						continue;
					case 3:
						System.out.print("ѧ��:");
						sno = in.next();
						System.out.print("�����:");
						cno = in.next();
						op.query(sno, cno);

						continue;
					case 4:
						System.out.print("ѧ��:");
						sno = in.next();
						ArrayList<Course> b = op.queryStudentCourse(sno);
						int sum = 0;
						System.out.println("�����\t�γ���\tѧ�� ");
						for (int i = 0; i < b.size(); i++) {
							Course c = b.get(i);
							System.out.println(c.getCno() + '\t' + c.getCname()
									+ '\t' + c.getCredit());
							sum += c.getCredit();
						}
						System.out.println();
						System.out.println("��ѧ��Ϊ:" + sum);
						continue;// ���˵�����û�е�ѡ������˵����ý���ͣ���ڸ��˵�
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
						System.out.println("�����޸�ѧ�ŵ�ѧ��:");
						num = in.next();
						student.setSno(num);
						System.out.println("�޸ĺ������");
						student.setSname(in.next());
						System.out.println("�޸ĺ���Ա�");
						student.setSex(in.next());
						System.out.println("�޸ĺ������ϵ");
						student.setDept(in.next());
						System.out.println("�޸ĺ������");
						student.setAge(in.nextInt());
						if (op.modify(student))
							System.out.println("�޸ĳɹ�");
						else
							System.out.println("�޸�ʧ��");
						continue;// ���˵�����û�е�ѡ������˵����ý���ͣ���ڸ��˵�
					case 2:
						System.out.println("�����޸ĵĿ����:");
						num = in.next();
						course.setCno(num);
						System.out.println("�޸ĺ�Ŀγ���");
						course.setCname(in.next());
						System.out.println("�޸ĺ��ѧ��");
						course.setCredit(in.nextInt());
						if (op.modify(course))
							System.out.println("�޸ĳɹ�");
						else
							System.out.println("�޸�ʧ��");
						continue;// ���˵�����û�е�ѡ������˵����ý���ͣ���ڸ��˵�
					case 3:
						System.out.println("����Ҫ�޸�ѧ����ѧ��:");
						num = in.next();
						System.out.println("����Ҫ�޸�ѧ���Ŀ����:");
						cno = in.next();
						studentCourse.setSno(num);
						studentCourse.setCno(cno);
						System.out.println("�޸ĺ�ĳɼ�");
						studentCourse.setGrade(in.nextInt());
						if (op.modify(studentCourse))
							System.out.println("�޸ĳɹ�");
						else
							System.out.println("�޸�ʧ��");
						continue;// ���˵�����û�е�ѡ������˵����ý���ͣ���ڸ��˵�
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
						System.out.println("����ɾ��ѧ����ѧ�ţ�");
						sno = in.next();
						if (op.deleteStudent(sno))
							System.out.println("ɾ���ɹ�");
						else
							System.out.println("ɾ��ʧ��");
						continue;
					case 2:
						System.out.println("����Ҫɾ���Ŀ���ţ�");
						cno = in.next();
						if (op.deleteCourse(cno))
							System.out.println("ɾ���ɹ�");
						else
							System.out.println("ɾ��ʧ��");
						continue;
					case 3:
						System.out.print("����ѧ��:");
						sno = in.next();
						System.out.print("��������:");
						cno = in.next();
						if (op.delete(sno, cno))
							System.out.println("ɾ���ɹ�");
						else
							System.out.println("ɾ��ʧ��");
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
		System.out.println("**1.��ѧ��ɾ��ѧ����Ϣ                            **");
		System.out.println("**2.���γ̺�ɾ��ѧ����Ϣ                        **");
		System.out.println("**3.��ѧ�źͿγ̺�ɾ���ɼ���Ϣ           **");
		System.out.println("**4.������һ���˵�        **");
	}

	public static void pause() {
		Scanner in = new Scanner(System.in);
		System.out.println("���������������");
		in.nextLine();
	}

	public static int MenuSelect() {
		int opt;
		Scanner in = new Scanner(System.in);
		System.out.println("ѡ����:");
		opt = in.nextInt();
		in.nextLine();
		return opt;

	}

	public static void showQueryMenu() {
		System.out.println("QueryMenu");
		System.out.println("**1.��ѯѧ����Ϣ                           **");
		System.out.println("**2.��ѧ�Ų�ѯѧ����Ϣ              **");
		System.out.println("**3.��ѯĳѧ����ĳ�γ���Ϣ     **");
		System.out.println("**4.��ѯĳѧ����ϸ����ѧ��     **");
		System.out.println("**5.�ܳɼ�������                           **");
		System.out.println("**6.��ѯ����ϵ������                  **");
		System.out.println("**7.������һ���˵�                       **");
	}

	public static void showMainMenu() {
		System.out.println("MainMenu:");
		System.out.println("**1.��Ϣ����         **");
		System.out.println("**2.��Ϣ��ѯ         **");
		System.out.println("**3.��Ϣ�޸�         **");
		System.out.println("**4.��Ϣɾ��         **");
		System.out.println("**5.�˳�����           **");
	}

	public static void showInputMenu() {
		System.out.println("InputMenu:");
		System.out.println("**1.¼��ѧ����Ϣ                **");
		System.out.println("**2.¼��γ���Ϣ                **");
		System.out.println("**3.¼��ɼ���Ϣ                **");
		System.out.println("**4.������һ���˵�            **");
	}

	public static void showModifyMenu() {
		System.out.println("ModifyMenu:");
		System.out.println("**1.��ѧ���޸�ѧ����Ϣ                 **");
		System.out.println("**2.���γ̺��޸Ŀγ���Ϣ              **");
		System.out.println("**3.��ѧ�źͿγ̺��޸ĳɼ���Ϣ**");
		System.out.println("**4.������һ���˵�                            **");
	}

	public static void clearScreen()// α����
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