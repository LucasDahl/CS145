public class Employee {

    private String name;
    private int yearsWorked;

    public Employee(String n, int y) {

        name = n;

        if(y >= 0 ) {
            yearsWorked = y;
        } else {
            yearsWorked = 0;
        }



    }

//    public Employee(int i) {
//    }


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

    public int getYearsWorked() {
        return yearsWorked;
    }

    public String getVacationForm() {
        return "Yellow";
    }

    public String toString() {
        return name + " works " + getHours() + " hours and has " + getVacation() + " vacation Days.";
    }

    public int getSalary() {
        return 50000 + 1000 * yearsWorked;
    }

}
