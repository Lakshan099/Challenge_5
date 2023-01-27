import java.util.Scanner;

public class main {

    public static void main(String[] args) throws InterruptedException {

        double perDayPayment;
        int noOfDays;

        Scanner s = new Scanner(System.in); // create scanner as s
        System.out.print("Enter Per Day Payment: ");
        perDayPayment = s.nextDouble(); 

        System.out.print("Enter Number Of Days: ");
        noOfDays = s.nextInt(); 

        SalaryCalculator s1 = new SalaryCalculator(perDayPayment, noOfDays); // create SalaryCalculator object

        s1.calculate();

        System.out.println();

        System.out.println("Employer's Contribution: " + s1.getempContribution());

        System.out.println("Final Salary: " + s1.getFinalSalary());

    }

}
