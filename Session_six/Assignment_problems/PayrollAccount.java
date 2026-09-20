import java.util.Scanner;

public class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary) {
        this.basicSalary = basicSalary < 0 ? 0 : basicSalary;
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage");
        } else {
            basicSalary -= basicSalary * percent / 100;
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double salary = sc.nextDouble();

        PayrollAccount account = new PayrollAccount(salary);

        System.out.print("Enter bonus amount: ");
        double bonus = sc.nextDouble();
        account.creditBonus(bonus);

        System.out.print("Enter tax percentage: ");
        double tax = sc.nextDouble();
        account.deductTax(tax);

        System.out.println("Net salary: Rs " + account.getNetSalary());

        sc.close();
    }
}