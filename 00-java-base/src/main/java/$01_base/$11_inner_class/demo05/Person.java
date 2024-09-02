package $01_base.$11_inner_class.demo05;

public class Person {
    private String name;
    private int age;

    public Person() {
        // 默认构造器
        System.out.println("默认构造");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void introduce() {
        System.out.println("Hello, my name is " + name + ", and I am " + age + " years old.");
    }
}

class Main {
    public static void main(String[] args) {
        // 使用匿名内部类初始化 Person 类
        Person person = new Person() {
            {
                // 初始化代码块
                System.out.println("代码块");
                setName("Alice");
                setAge(30);
            }

            // 重写 introduce 方法
            @Override
            public void introduce() {
                super.introduce();
                System.out.println("Nice to meet you!");
            }
        };

        person.introduce();  // 输出: Hello, my name is Alice, and I am 30 years old. Nice to meet you!
    }
}
