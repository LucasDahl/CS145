// Extends makes lawyer a subclass of Employee
public class Lawyer extends Employee {

    private int numberOfCases;


    public Lawyer(String n, int inComingCases) {

        super(n, 0);
        numberOfCases = inComingCases;
    }

    public Lawyer(String n) {
        super(n, 0);
        numberOfCases = 0;
    }

    public Lawyer(String n, int x, int y) {
        super(n, y);
        numberOfCases = x;
    }

    public int getNumberOfCases() {
        return numberOfCases;
    }

    public int getHours() {
        return 75;
    }

    public String getVacationForm() {
        return "Green";
    }

    // Lawyers get two more days of vacation than regular employees


    @Override
    public int getVacation() {
        return super.getVacation() + 2;
    }

    public int getSalary() {
        return 50000 + 2000 * getYearsWorked();
    }
}
