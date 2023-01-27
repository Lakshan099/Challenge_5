class SalaryCalculator {
    private double perDayPayment;
    private int noOfDays;
    private double basicSalary;
    private double allowances;
    private double epf;
    private double finalSalary;
    private double employerContribution;

    public SalaryCalculator(double perDayPayment, int noOfDays) {
        this.perDayPayment = perDayPayment;
        this.noOfDays = noOfDays;
    }

    public void calculate() throws InterruptedException {

        basicSalary = perDayPayment * noOfDays; // main thread cal the basic salary

        Thread thread2 = new Thread(() -> allowances = basicSalary * 0.05); // thread 2 cal the allowances
        thread2.join();

        Thread thread3 = new Thread(() -> { // thread 3 cal the epf
            double totalMonthlyEarnings = basicSalary + allowances;
            epf = totalMonthlyEarnings * 0.08;

            employerContribution = totalMonthlyEarnings * 0.12;
        });
        thread3.start();
        thread3.join();

        finalSalary = basicSalary + allowances + epf;
    }

    public double getFinalSalary() {
        return finalSalary;
    }

    public double getempContribution() {
        return employerContribution;
    }
}
