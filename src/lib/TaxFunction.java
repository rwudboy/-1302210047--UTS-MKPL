package lib;

public class TaxFunction {

    public static int calculateTax(TaxCalculationInput input) {
        int monthlySalary = input.getMonthlySalary();
        int otherMonthlyIncome = input.getOtherMonthlyIncome();
        int numberOfMonthWorking = input.getNumberOfMonthWorking();
        int deductible = input.getDeductible();
        boolean isMarried = input.isMarried();
        int numberOfChildren = input.getNumberOfChildren();

        int tax = 0;

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }

        if (isMarried) {
            tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (54000000 + 4500000 + (numberOfChildren * 1500000))));
        } else {
            tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - 54000000));
        }

        if (tax < 0) {
            return 0;
        } else {
            return tax;
        }
    }
	//
}
