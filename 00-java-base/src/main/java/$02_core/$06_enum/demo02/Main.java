package $02_core.$06_enum.demo02;

// enum
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }

        if (day == Weekday.FRI) { // ok!
        }
        if (day.equals(Weekday.SUN)) { // ok, but more code!
        }

        int day1 = 1;
        // if (day1 == Weekday.SUN) { // Compile error: bad operand types for binary operator '=='
        // }
    }
}

enum Weekday {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}