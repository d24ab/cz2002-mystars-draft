import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class StudentController {
	
	Student student;
	String courseCode;
	int indexNum;
	public void addCourse(Student student, Index newIndex) throws ClassNotFoundException, IOException,FileNotFoundException {
		int found=0;
		for(Index i: student.getRegisteredIndex()) {
			if(newIndex == i) {
				System.out.println("Index is already registered with this student");
				found=1;
			}
			else {
				//Add new course into Index
				ArrayList<Student> studentList = StudentManager.extractStudents();
				for(Student s : studentList) {
					if(s.getMatricNum().equals(student.getMatricNum())) {
						
					}
				}
				//Expand the index array by 1


			}
		}
	}
	public static void removeCourse( Student student, String courseCode) {
		//TODO

	}
	
	public static void printCourseRegistered(Student student) {
		 for (Index index : student.getRegisteredIndex()) {
			 System.out.println("Student is registered in " + index.getCourseCode() + " " + index.getIndexNum());
		 }
		
		
		
	}
	
	public void checkVacancies(String courseCode) {
		
	}
	
	public static void changeIndex(Student student, int newIndex, String Coursecode) {
		 for (Index index : student.getRegisteredIndex()) {
			 if(index.getCourseCode().equals(Coursecode)) {
				 //TO DO add error checking
				 index.setIndexNum(newIndex);
				 System.out.println("Successful! Changed index from "+ index.getIndexNum()+ " to "+ newIndex);
				 break;
			 }
		 }
	}
	
	public void swapIndex(Student student, Index ownIndex, Index peerIndex, User peer) {
		
	}
}
