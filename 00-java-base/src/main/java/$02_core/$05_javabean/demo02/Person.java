package $02_core.$05_javabean.demo02;

public class Person {
    private String name;
    private int age;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return this.age; }
    public void setAge(int age) { this.age = age; }

    // 只读属性（read-only）
    public boolean isChild() {
        return age <= 6;
    }
}