// Extends makes lawyer a subclass of Employee
public class Lawyer extends Employee {

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
}
