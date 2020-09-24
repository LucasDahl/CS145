public class TrialLawyer extends Lawyer {

    private int numberOfCases;

    public TrialLawyer(int x, String n) {
        super(n);
        numberOfCases = x;
    }

    public String toString() {
        return "Trial Lawyer: " + getName() + " works " + getHours() + " hours and has " + getVacation() + " vacation Days.";
    }

    public int getSalary() {
        return 75000 + 2000 * getYearsWorked() + 2 * numberOfCases;
    }

    public int getVacation() {
        return super.getVacation() + 100;
    }

}
