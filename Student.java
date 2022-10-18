import java.util.Random;
import java.util.regex.Pattern;

public class Student {
    private String firstName;
    private String lastName;
    private static Integer totalNumberOfStudents = 0;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        totalNumberOfStudents++;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getTotalNumberOfStudents(){
        return totalNumberOfStudents;
    }


    public static void main(String[] args){
        Student student1 = new Student("Mamadou", "MARONE");
        Student student2 = new Student("Iba", "MARONE");
        System.out.println("The first student is " + student1.firstName + " " + student1.lastName);
        System.out.println("The second student is " + student2.firstName + " " +student2.lastName);

        // W is asked
        System.out.println(student1.toString());
        System.out.println(student1);
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    protected void finalize(){
        totalNumberOfStudents--;
    }
}
