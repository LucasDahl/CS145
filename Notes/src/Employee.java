public class Employee {

    private String name;

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public int getVacation() {
        return 5;
    }

    public int getHours() {
        return 40;
    }

    public String getVacationForm() {
        return "Yellow";
    }

    public String toString() {
        return name + " works " + getHours() + " hours and has " + getVacation() + " vacation Days.";
    }

}
