import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CourseManager {
	
    private static ArrayList<Course> courseList;
    private static final String filename = "src/data/Course.dat";

    public static void addCourse(Course course) throws IOException, ClassNotFoundException {
        String filename = "src/data/Courses.dat";
        ArrayList<Course> courseList = IOController.readFile(filename);
        int found =0;
        for(Course c : courseList) {
        	if(c.getCourseCode().equals(course.getCourseCode())) {
        		System.out.println("The course is already in the database");
        		found=1;
        		break;
        	}
        }
        if(found==0) {
        	courseList.add(course);
	        System.out.println("Succesfully added student into the database");
	        IOController.writeFile(filename, courseList);
        }
    }

    public static void removeCourse(String courseCode) throws IOException, ClassNotFoundException {
    	courseList = IOController.readFile(filename);
        Course toDelete = null;
        for (Course c: courseList) {
            if (c.getCourseCode().equals(courseCode)) {
                toDelete = c;
                break;
            }
        }
        if (toDelete != null) {
        	System.out.println("Removing index...");
        	courseList.remove(toDelete);
        	System.out.println("Success");
        	IOController.writeFile(filename, courseList);
        }
        else {
        	System.out.println("There is no such index in the database");
        }
        
    }
    
    public static ArrayList<Course> extractCourse() {
    	try {
	        ArrayList<Course> courseList = IOController.readFile("src/data/Courses.dat");
	        return courseList;
		}
		catch(Exception e) {
			System.out.println("File not found");	
			return null;
		}
    }
    
    
    public static void UpdateCourseDB(ArrayList<Course> courseList) {
    	try {
			IOController.writeFile(filename, courseList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
