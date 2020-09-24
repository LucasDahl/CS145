public class EmployeeExamples {

    public static void main(String[] args) {

        Employee[] team = new Employee[3];

        team[0] = new Employee();
        team[0].setName("Adam");

        team[1] = new Lawyer();
        team[1].setName("Dale");

        team[2] = new Employee();
        team[2].setName("Cara");

        for(int i = 0; i < team.length; i++) {
            System.out.println(team[i]); // automatically calls toString
            //System.out.printf("%-10s - %5d - %5d%n", team[i].getName(), team[i].getHours(), team[i].getVacation());
        }

//        Employee a  = new Employee();
//        a.setName("Adam");
//
//        Lawyer b = new Lawyer();
//        b.setName("Linda");
//
//        Employee c = new Lawyer();
//        c.setName("Cara");
//
//        System.out.println(a.getName());
//        System.out.println(a.getHours());
//        System.out.println(b.getName());
//        System.out.println(b.getHours());
//        System.out.println(c.getName());
//        System.out.println(c.getHours());

    }

}
