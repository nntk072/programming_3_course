
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

class StudentRegister {
    private final List<Student> listStudents;
    private final List<Course> listCourses;
    private final List<Attainment> listAttainment;
    
    public StudentRegister() {
        this.listStudents= new ArrayList<>();
        this.listCourses = new ArrayList<>();
        this.listAttainment = new ArrayList<>();
        
    }
    void addAttainment(Attainment attainment) {
        listAttainment.add(attainment);
      }
    void addStudent(Student student) {
        listStudents.add(student);
        listStudents.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }
    void addCourse(Course course) {
        listCourses.add(course);
        listCourses.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        
    }
    Iterable<Student> getStudents() {
        //List<Student> listStudentssorted = new ArrayList<>(listStudents);
        //listStudentssorted.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        //return listStudentssorted;
        
        return listStudents;
    }
    Iterable<Course> getCourses() {
        //List<Course> listCoursessorted = new ArrayList<>(listCourses);
        //listCoursessorted.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        //return listCoursessorted;
        
        return listCourses;
    }

    void printStudentAttainments(String studentNumber) {
        Boolean u = false;
        List<String> haha = new ArrayList<>();
        for (var i:listStudents) {
            if (i.getStudentNumber().equals(studentNumber)) {
                haha.add(i.getName());
                haha.add(i.getStudentNumber());
                u = true;
                break;
            }
        }
        if(!u) {
        System.out.println("Unknown student number: " + studentNumber);
        return;
        }
        //System.out.println(listCourses);
        System.out.println(haha.get(0) + " (" + haha.get(1) + "):");
        for(var i : listAttainment) {
            if (i.getStudentNumber().contains(studentNumber)) {
                for (var m: listCourses){
                    if (m.getCode().contains(i.getCourseCode())) {
                    System.out.println("  " + i.getCourseCode() +" " + m.getName() + ": " + i.getGrade());
                    }
                }
            }
        }
    }
    
    void printStudentAttainments(String studentNumber, String order) {
        Boolean u = false;
        List<String> haha = new ArrayList<>();
        for (var i:listStudents) {
            if (i.getStudentNumber().contains(studentNumber)) {
                haha.add(i.getName());
                haha.add(i.getStudentNumber());
                u = true;
                break;
            }
        }
        if(!u) {
            System.out.println("Unknown student number: " + studentNumber);
            return;
        }
        
        System.out.println(haha.get(0) + " (" + haha.get(1) + "):");
        
        TreeMap<String, ArrayList<Object>> in4byname = new TreeMap<>();
        TreeMap<String, ArrayList<Object>> in4bycode = new TreeMap<>();
        for(var i : listAttainment) {
                if (i.getStudentNumber().contains(studentNumber)) {
                    for (var m: listCourses){
                        if (m.getCode().contains(i.getCourseCode())) {
                            ArrayList<Object> smallList = new ArrayList<>();
                            smallList.add(i.getCourseCode());
                            smallList.add(i.getGrade());
                            in4byname.put(m.getName(), smallList);
                            ArrayList<Object> smallList2 = new ArrayList<>();
                            smallList2.add(m.getName());
                            smallList2.add(i.getGrade());
                            in4bycode.put(i.getCourseCode(), smallList2);
                        }
                    }
                }
            }
        //System.out.println(in4byname);
        //System.out.println(in4bycode);

        // in4byname: physics 3 = [fys.113, 5]
        // in4bycode: fys.113 = [Physics 3, 5]
        //print by name
        if ("by name".equals(order)) {
            for(Map.Entry<String, ArrayList<Object>> entry : in4byname.entrySet()) {
                //System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                ArrayList<Object> value = entry.getValue();
                System.out.println("  " + value.get(0) + " " + entry.getKey() + ": " + value.get(1));
                }
        }
        
        else if ("by code".equals(order)) {
            //print by code
            for(Map.Entry<String, ArrayList<Object>> entry : in4bycode.entrySet()) {
                    //System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue())
                    ArrayList<Object> value = entry.getValue();;
                    System.out.println("  " + entry.getKey()+ " " + value.get(0) + ": " + value.get(1));
            }
        }
        

        
                
        
        
        
    }


}
