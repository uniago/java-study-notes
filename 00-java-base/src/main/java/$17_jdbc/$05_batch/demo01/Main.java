package $17_jdbc.$05_batch.demo01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {    // JDBC连接的URL, 不同数据库有不同的格式:
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "123456";
    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", (short) 1,  false, 90),
                new Student("Bob", (short) 2, true, 85),
                new Student("Charlie", (short) 3, true, 95)
        };
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)")) {
                // 对同一个PreparedStatement反复设置参数并调用addBatch():
                for (Student s : students) {
                    ps.setString(1, s.name);
                    ps.setBoolean(2, s.gender);
                    ps.setInt(3, s.grade);
                    ps.setInt(4, s.score);
                    ps.addBatch(); // 添加到batch
                }
                // 执行batch:
                int[] ns = ps.executeBatch();
                for (int n : ns) {
                    System.out.println(n + " inserted."); // batch中每个SQL执行的结果数量
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
