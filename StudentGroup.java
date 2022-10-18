import java.util.ArrayList;
import java.util.regex.Pattern;

public class StudentGroup {
    private String name;
    private static Integer numberOfGroup = 0;
    ArrayList<StudentAbs> alist;


    public StudentGroup(String name) throws Exception {
        if(!Pattern.matches("[1-2]G[1-3]TD[1-3]TP[1-6]", name)) {
            throw new Exception(name +" is not a real ENSEA name");
        }
        else{
            this.name = name;
            numberOfGroup++;
        }
        this.alist  = new ArrayList<StudentAbs>();
    }

    public void addStudent(StudentAbs eleve){
        this.alist.add(eleve);
    }
    public void displayPresenceList(){
        for(StudentAbs s : this.alist){
            System.out.println(s.getFirstName() + " " + s.getLastName());
        }
    }

    public ArrayList<StudentAbs> getAlist(){ return alist;}
    public String getName(){
        return this.name;
    }

    public static void main (String[] args){
        StudentGroup a = null, b = null, c = null;
        try{
            a = new StudentGroup("1G1TD1TP1");
            b = new StudentGroup("3G1TD1TP1");
            c = new StudentGroup("1G1TD1TP2");
        }
        catch (Exception e){
            e.printStackTrace();
        }
         System.out.println(a);
         System.out.println(b);
         System.out.println(c);

        // To execute de c construction, a solution is to make three "Try" and "Catch exception" for every object
        // because the code go out of the try as soon as an exception is generated.

        //Exercice 3 : End

        // Exercice 4: Beginning
        /* Student s1 = new Student("MARONE", "Mamadou");
         Student s2 = new Student("RONEMA", "Mamado");
         Student s3 = new Student("NOM", "Clement");*/
        LocalStudent s1 = new LocalStudent("MARONE", "Mamadou");
        LocalStudent s2 = new LocalStudent("RONEMA", "Mamado");
        LocalStudent s3 = new LocalStudent("NOM", "Clement");


         a.addStudent(s1);
         System.out.println(a);

         a.addStudent(s3);
         System.out.println(a);

         // Exercice 4: End



    }


    @Override
    public String toString() {
        return "StudentGroup: " +
                "name = " + name + " & " + "number of students = " + this.alist.size();
    }
}
