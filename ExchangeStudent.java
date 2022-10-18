public class ExchangeStudent extends StudentAbs{


    public ExchangeStudent(String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public void checkResult() {
        int moyenne = 0;
        for(int i = 0; i < 6; i++){
            moyenne = moyenne + this.grades[i];
        }
        moyenne = moyenne/6;
        if(moyenne >= 10){
            this.yearValidation = true;
        }
        else{
            this.yearValidation = false;
        }
    }
}
