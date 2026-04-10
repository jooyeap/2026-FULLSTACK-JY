package java_class002_hiding;

public class StudentTest {
	public static void main(String[] args) {
		Student studentLee = new Student();
		//studentLee.studentName = "이상원"; / 접근 제어자가 private 라 접근불가
		studentLee.setStudentName("이상원");
		
		System.out.println(studentLee.getStudentName());
	}
}
