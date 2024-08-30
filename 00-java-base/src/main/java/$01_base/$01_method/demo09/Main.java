package $01_base.$01_method.demo09;

public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.setName("小明");
        ming.setAge(12);
        System.out.println(ming.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 200) {
            throw new IllegalArgumentException("age error.");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}