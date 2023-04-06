
public class Attainment {
    private final String courseCode;
    private final String studentNumber;
    private final int grade;
    
    
    public Attainment(String string, String string0, int parseInt) {
        this.courseCode =  string;
        this.studentNumber = string0;
        this.grade = parseInt;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public int getGrade() {
        return grade;
    }

   
}
