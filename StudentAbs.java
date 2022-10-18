import java.util.Random;
import java.util.regex.Pattern;

abstract public class StudentAbs {
    private String firstName;
    private String lastName;
    private static Integer totalNumberOfStudents = 0;
    // Exercise 7:
    protected boolean yearValidation;
    protected Integer grades[] = new Integer[6];

    public StudentAbs(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        totalNumberOfStudents++;
        yearValidation = false;
        Random alea = new Random();
        for(int i = 0; i < 6; i++){
            grades[i] = (int)Math.floor((12 + alea.nextGaussian()*3)*10)/10;
            grades[i] = grades[i] > 20? 20 : grades[i];
        }
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

    public boolean isYearValidation() {
        return yearValidation;
    }

    // An abstract methode is not instanciated then it hasn't body.
    abstract public void checkResult();

    public Integer[] getGrades() {
        return grades;
    }
}
