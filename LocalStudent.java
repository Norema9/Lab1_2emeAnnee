public class LocalStudent extends StudentAbs{
    public LocalStudent(String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public void checkResult() {
        this.yearValidation = true;
        for(int i = 0; i < 6; i++){
            if(grades[i] < 10){
                this.yearValidation = false;
            }
        }
    }
}
