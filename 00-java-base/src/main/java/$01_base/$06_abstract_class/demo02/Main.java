package $01_base.$06_abstract_class.demo02;

public class Main {
    public static void main(String[] args) {
        Income[] incomes = {
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));
    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income: incomes) {
            total += income.getTax();
        }
        return total;
    }
}

abstract class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }
    abstract double getTax();
}

class Salary extends Income {

    public Salary(double income) {
        super(income);
    }

    @Override
    protected double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance (double income) {
        super(income);
    }

    @Override
    protected double getTax() {
        return 0;
    }
}