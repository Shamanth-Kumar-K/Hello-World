
public class StudentManager {
    private int studentCount;
    private Student[] students;

    public StudentManager(int capacity) {
        if(capacity<=0){
            throw new IllegalArgumentException("Capacity Must be positive");
        }
        students = new Student[capacity];
        studentCount = 0;
    }

    public void addStudent(Student student) {
        if(studentCount<students.length){
            if(student==null) {
                System.out.println("Student is null. Insertion Failed...");
                return;
            }
            if (isIdExists(student.getId())) {
                    System.out.println("The Student Id is already exists !");
                    System.out.println("Failed to insert the student. Try again...");
                    return;
                }
            students[studentCount] = student;
            studentCount++;
            System.out.println("Successfully inserted Student !");
        }else{
            System.out.println("Student list is Full. Insertion Failed...");
        }
    }
    private boolean isIdExists(int id){
        for(int i=0; i<studentCount; i++){
            if(students[i].getId()==id){
                return true;
            }
        }
        return false;
    }

    public void viewAllStudents(){
        if(studentCount==0){
            System.out.println("No students are registered");
            return;
        }
        for(int i=0; i<studentCount; i++){
            Student s = students[i];
            System.out.println("=============== Student Details ===============\n");
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getAge());
            System.out.println(s.getCourse());
            System.out.println(s.getMarks());
            System.out.println("\n-----------------------------------------------\n");
        }
    }

    public void searchStudent(int id){
        if(studentCount==0){
            System.out.println("No students registered");
            return;
        }
        for(int i=0; i<studentCount; i++){
            Student s = students[i];
            if(s.getId()==id){
                System.out.println("========== Student details ===========\n");
                System.out.println(s.getId());
                System.out.println(s.getName());
                System.out.println(s.getAge());
                System.out.println(s.getCourse());
                System.out.println(s.getMarks());
                System.out.println("\n--------------------------------------\n");
                return;
            }
        }
        System.out.println("Student not found");
    }

    public void updateStudent(int id,String name, int age, String course, double marks){
        if(studentCount==0){
            System.out.println("No students registered");
            return;
        }
        for(int i=0; i<studentCount; i++){
            Student s = students[i];
            if(s.getId()==id){
                try {
                    Student temp = new Student(id, name, age, course, marks);
                    s.setName(temp.getName());
                    try{
                    s.setAge(temp.getAge());
                    }catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    s.setCourse(temp.getCourse());
                    s.setMarks(temp.getMarks());

                    System.out.println("Student details updated successfully!");
                    return;

                } catch (IllegalArgumentException e) {
                    System.out.println("Update failed: " + e.getMessage());
                    return;
                }
            }
        }
        System.out.println("No student found");
    }

    public void deleteStudent(int id){
        if(studentCount==0){
            System.out.println("No students registered");
            return;
        }
        for(int i=0; i<studentCount; i++){
            Student s = students[i];
            if(s.getId()==id){
                for(int j=i; j<studentCount-1; j++){
                    students[j] = students[j+1];
                }
                students[studentCount-1] = null;
                studentCount--;
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student not found");
    }
}
