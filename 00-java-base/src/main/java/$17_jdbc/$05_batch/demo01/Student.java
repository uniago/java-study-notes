package $17_jdbc.$05_batch.demo01;

public class Student {
    public Long id;
    public String name;
    public Short grade;
    public Boolean gender;
    public Integer score;

    public Student() {
    }

    public Student(String name, Short grade, Boolean gender, Integer score) {
        this.name = name;
        this.grade = grade;
        this.gender = gender;
        this.score = score;
    }
}
