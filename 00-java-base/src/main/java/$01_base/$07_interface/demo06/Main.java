package $01_base.$07_interface.demo06;

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

interface Income {
    double getTax();
}

abstract class AbstractIncome implements Income {
    protected double income;

    public AbstractIncome(double income) {
        this.income = income;
    }

    @Override
    public abstract double getTax();
}

class Salary extends AbstractIncome {

    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}

class StateCouncilSpecialAllowance extends AbstractIncome {

    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}