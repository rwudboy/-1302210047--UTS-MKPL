package lib;

import java.util.LinkedList;
import java.util.List;

public class Employee {
    private EmployeeDetails details;
    private EmploymentDate employmentDate;
    private Spouse spouse;
    private List<Child> children;
    private Salary salary;
    private TaxCalculator taxCalculator;

    public Employee(EmployeeDetails details, EmploymentDate employmentDate, boolean isForeigner, boolean gender) {
        this.details = details;
        this.employmentDate = employmentDate;
        this.spouse = null;
        this.children = new LinkedList<>();
        this.salary = new Salary(isForeigner);
        this.taxCalculator = new TaxCalculator();
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouse = new Spouse(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        children.add(new Child(childName, childIdNumber));
    }

    public int getAnnualIncomeTax() {
        return taxCalculator.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(),
                                          employmentDate.getMonthWorkingInYear(), salary.getAnnualDeductible(),
                                          spouse == null, children.size());
    }
}
// EmployeeInfo.java
public class EmployeeInfo {
    private EmployeeDetails details;
    private EmploymentDate employmentDate;
    private Spouse spouse;
    private List<Child> children;

    // Constructors, getters, setters
}

class EmployeeDetails {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    
    // Constructors, getters, setters
}

class EmploymentDate {
    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;
    
    // Constructors, getters, setters
}

class Spouse {
    private String spouseName;
    private String spouseIdNumber;

    // Constructors, getters, setters
}

class Child {
    private String childName;
    private String childIdNumber;

    // Constructors, getters, setters
}

class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private boolean isForeigner;

    public Salary(boolean isForeigner) {
        this.isForeigner = isForeigner;
    }

    // Methods for setting and getting salary details
}

class TaxCalculator {
    public int calculateTax(int monthlySalary, int otherMonthlyIncome, int monthWorkingInYear,
                            int annualDeductible, boolean noSpouse, int numberOfChildren) {
        // Tax calculation logic
    }
}
