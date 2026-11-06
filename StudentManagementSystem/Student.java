public class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private double marks;

    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        setAge(age);
        this.course = course;
        setMarks(marks);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>0 && age<100){
            this.age = age;
        }else{
            throw new IllegalArgumentException("Invalid Age.");
        }
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if(marks>0 && marks<=100){
            this.marks = marks;
        }else{
            throw new IllegalArgumentException("Invalid Marks. Marks should be greater than 0 and less than or equal to 100.");
        }

    }
}
