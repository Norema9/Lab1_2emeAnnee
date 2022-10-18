import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;

public class Promotion {   // Exercice 5: Find function //////////////////////////////
    private String name;
    private ArrayList<StudentGroup> groupes;

    public Promotion(String name){
        this.name = name;
        groupes = new ArrayList<StudentGroup>();
    }

    public void addStudentGroup(StudentGroup sg){
        this.groupes.add(sg);
    }

    public void presenceList(){
        for(StudentGroup sg : this.groupes){
            sg.displayPresenceList();
        }
    }

    public StudentGroup findStudentGroup(String name){
        for(StudentGroup SG : this.groupes){
            if(name.equals(SG.getName())){
                return SG;
            }
        }
        return null;
    }

    public StudentAbs findStudent(StudentGroup g, String first, String last){
        if(g != null){
            for(StudentAbs s : g.getAlist()){
                if(first.equals(s.getFirstName()) && last.equals(s.getLastName())){
                    return s;
                }
            }
        }
        return null;
    }

    // Exercice 5: File manipulation
    public void fillPromotion(String filename){
        try{
            FileReader fileProm = new FileReader(filename);
            BufferedReader br = new BufferedReader(fileProm);
            String line = br.readLine();
            while (line != null){
                //correction:
                /**
                 * Integer firstComma=line.indexOf(',');
                 *                 String lastName=line.substring(0,firstComma);
                 *                 Integer secondComma=line.indexOf(',',firstComma+1);
                 *                 String firstName=line.substring(firstComma+1,secondComma);
                 *                 Integer thirdComma=line.indexOf(',',secondComma+1);
                 *                 String groupName=line.substring(secondComma+1,thirdComma);
                 *
                 *                 StudentGroup g=this.findStudentGroup(groupName);
                 *                 if (g==null) {
                 *                     g = new StudentGroup(groupName);
                 *                     this.addStudentGroup(g);
                 *                     }
                 *
                 *                 Student s=this.findStudent(g,firstName,lastName);
                 *                 if (s==null){
                 *                     s=new Student(firstName,lastName);
                 *                     g.addStudent(s);
                 *                     }
                 *
                 *                 line = br.readLine();
                 */
                String[] parsedline = parsedLine(line);
                String StudentLastName = parsedline[0];
                String StudentFirstName = parsedline[1];
                String GroupeName = parsedline[2];
                String LocExch = parsedline[3];

                //test de fonctionnement nemuero1
                System.out.println(parsedline[0]);

                StudentGroup groupe = this.findStudentGroup(GroupeName);
                if(groupe == null){
                    StudentGroup g = new StudentGroup(GroupeName);
                    this.addStudentGroup(g);
                    if(LocExch != "Etranger"){
                        g.addStudent(new LocalStudent(StudentFirstName, StudentLastName));
                        this.addStudentGroup(g);
                    }
                    else{
                        g.addStudent(new ExchangeStudent(StudentFirstName, StudentLastName));
                        this.addStudentGroup(g);
                    }

                }
                else{
                    if(this.findStudent(groupe, StudentFirstName, StudentLastName) == null){
                        if(LocExch != "Etranger"){
                            groupe.addStudent(new LocalStudent(StudentFirstName, StudentLastName));
                            this.addStudentGroup(groupe);
                        }
                        else{
                            groupe.addStudent(new ExchangeStudent(StudentFirstName, StudentLastName));
                            this.addStudentGroup(groupe);
                        }
                    }
                }
                line = br.readLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Le code n'a pas réussi à ouvrir le fichier demandé");
        }
    }

    public String[] parsedLine(String line){
        return line.split(",", 4);
    }


    // the main function of my class allowing me to verify if my code works
    public static void main(String[] args){
        Promotion p = new Promotion("Promotion 2024");
        StudentGroup a = null;
        try{
            a = new StudentGroup("1G1TD1TP1");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Exos precedants
       /* p.addStudentGroup(a);

        a.addStudent(new LocalStudent("Antoine", "Tauvel"));
        a.addStudent(new LocalStudent("Sylvain", "Reynal"));
        a.addStudent(new LocalStudent("Christophe", "Bares"));

        p.presenceList();

        System.out.println(p.findStudentGroup("1G1TD1TP1"));
        System.out.println(p.findStudentGroup("1G1TD1TP2"));
        System.out.println(p.findStudent(p.findStudentGroup("1G1TD1TP1"), "Antoine", "Tauvel"));
        System.out.println(p.findStudent(p.findStudentGroup("1G1TD1TP1"), "Antoine", "Reynal"));*/

        // Exercice 5: File manipulation test

        /*p.fillPromotion("files/liste2_2020_2021.csv");
        p.presenceList();*/

        //Exercise 7:
        p.fillPromotion("files/liste2_2020_2021.csv");
        p.presenceList();
        System.out.println("Failed Students : ");
        for(StudentGroup g : p.groupes){
            for(StudentAbs s : g.getAlist()){
                s.checkResult();
                if(!s.isYearValidation()){
                    System.out.println(g.getName() + " " + s.getLastName() +
                            " " + s.getFirstName() + " " + s.getGrades()[0] +
                            ", " + s.getGrades()[1] + ", " + s.getGrades()[2] +
                            ", " + s.getGrades()[3] + ", " + s.getGrades()[4] +
                            ", " + s.getGrades()[5]);
                }
            }
        }
    }


}
