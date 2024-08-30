package $01_base.$05_polymorphic.demo01;

// override
public class Main {
    public static void main(String[] args) {
        Person p = new Student();
        p.run(); // 应该打印Person.run还是Student.run?

        // runTwice(p);
    }

    public static void runTwice(Person p) {
        p.run();
        p.run();
    }
}

class Person {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}