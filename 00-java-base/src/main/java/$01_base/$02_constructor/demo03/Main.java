package $01_base.$02_constructor.demo03;

// 构造方法
public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Xiao Ming", 15); // 既可以调用带参数的构造方法
        Person p2 = new Person(); // 也可以调用无参数构造方法
        System.out.println("p1 = " + p1.getAge());
        System.out.println("p2 = " + p2.getAge());
    }
}

class Person {
    private String name;
    private int age = 10;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}