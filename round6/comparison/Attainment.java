import java.util.Comparator;

public class Attainment implements Comparable<Attainment> {
    private String courseCode;
    private String studentNumber;
    private int grade;

    public Attainment(String courseCode, String studentNumber, int grade) {
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
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

    @Override
    public int compareTo(Attainment o) {
        int studentNumComparison = studentNumber.compareTo(o.studentNumber);
        if (studentNumComparison != 0) {
            return studentNumComparison;
        }
        return courseCode.compareTo(o.courseCode);
    }

    @Override
    public String toString() {
        return courseCode + " " + studentNumber + " " + grade;
    }

    public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment a1, Attainment a2) {
            int courseCodeComparison = a1.courseCode.compareTo(a2.courseCode);
            if (courseCodeComparison != 0) {
                return courseCodeComparison;
            }
            return a1.studentNumber.compareTo(a2.studentNumber);
        }
    };

    public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment a1, Attainment a2) {
            int courseCodeComparison = a1.courseCode.compareTo(a2.courseCode);
            if (courseCodeComparison != 0) {
                return courseCodeComparison;
            }
            return Integer.compare(a2.grade, a1.grade);
        }
    };
}