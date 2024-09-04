package $07_collection.$03_equals.demo03;

import java.util.List;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao", 18),
                new Person("Xiao", 25),
                new Person("Bob", 20)
        );
        boolean exist = list.contains(new Person("Bob", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}

class Person {
    public String name;
    public int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            // boolean nameEquals = false;
            // if (this.name == null && p.name == null) {
            //     nameEquals = true;
            // }
            // if (this.name != null) {
            //     nameEquals = this.name.equals(p.name);
            // }
            // return nameEquals && this.age == p.age;
            return Objects.equals(this.name, p.name) && this.age == p.age;
        }
        return false;
    }
}