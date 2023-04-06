public class Student {
    //private HashMap<List<Integer>, Integer> Sudoku;
    private final String name;
    private final String studentNumber;

    
    Student(String string, String string0) {
        this.name = string;
        this.studentNumber = string0;                
    }
       

    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    
}
