import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager(5);
        int choice = 0,id,age;
        String name, course;
        double marks;
        do {
            System.out.println("=============== Student Management System ===============\n");
            System.out.println("1. Add Student");
            System.out.println("2. View all Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit Application");
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = readInt(sc);

            //switch
            switch (choice){
                case 1:
                    System.out.println("Enter the Student Details to add");
                    System.out.println("Enter the Student id: ");
                    id = readInt(sc);
                    System.out.println("Enter the Student name: ");
                    name = sc.nextLine();
                    System.out.println("Enter the Student age: ");
                    age = readInt(sc);
                    System.out.println("Enter the Course name: ");
                    course = sc.nextLine();
                    System.out.println("Enter the Student marks: ");
                    marks = Double.parseDouble(sc.nextLine());
                    manager.addStudent(new Student(id,name,age,course,marks));
                    break;

                case 2:
                    manager.viewAllStudents();
                    break;

                case 3:
                    System.out.println("Enter the Student ID to Search");
                    id = readInt(sc);
                    manager.searchStudent(id);
                    break;

                case 4:
                    System.out.println("Enter the Student id: ");
                    id = readInt(sc);
                    System.out.println("Enter the Student name to update: ");
                    name = sc.nextLine();
                    System.out.println("Enter the Student age to update: ");
                    age = readInt(sc);
                    System.out.println("Enter the Course name to update: ");
                    course = sc.nextLine();
                    System.out.println("Enter the Student marks to update: ");
                    marks = Double.parseDouble(sc.nextLine());
                    manager.updateStudent(id,name,age,course,marks);
                    break;

                case 5:
                    System.out.println("Enter the Student ID to Delete");
                    id = readInt(sc);
                    manager.deleteStudent(id);
                    break;

                case 6:
                    System.out.println("Exiting from Application .........\nDone.");
                    break;
                    
                default:
                    System.out.println("Invalid Entry of Choice. Try again with valid choice");
            }
        }while (choice!=6);
        sc.close();


    }
    public static int readInt(Scanner sc) {
                while(true){
                    try {
                        return readInt(sc);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Enter a valid integer.");
                        continue;
                    }
                }
            }
}