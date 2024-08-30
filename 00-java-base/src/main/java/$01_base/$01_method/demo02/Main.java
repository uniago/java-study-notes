package $01_base.$01_method.demo02;

// private field
public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.setName("Xiao Ming"); // 设置name
        ming.setAge(12); // 设置age
        System.out.println(ming.getName() + ", " + ming.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    // public void setName(String name) {
    //     this.name = name;
    // }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("invalid name");
        }
        this.name = name.strip(); // 去掉首尾空格
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }
}