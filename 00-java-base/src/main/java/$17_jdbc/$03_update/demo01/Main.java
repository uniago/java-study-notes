package $17_jdbc.$03_update.demo01;

import java.sql.*;

public class Main {

    // JDBC连接的URL, 不同数据库有不同的格式:
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "123456";

    public static void main(String[] args) {
        // insert01();
        // insert02();
        // update();
        delete();
    }

    private static void insert01() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO students (id, grade, name, gender) VALUES (?,?,?,?)")) {
                ps.setObject(1, 999); // 注意：索引从1开始
                ps.setObject(2, 1); // grade
                ps.setObject(3, "Bob"); // name
                ps.setObject(4, "M"); // gender
                int n = ps.executeUpdate(); // 1
                System.out.println(n);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insert02() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO students (grade, name, gender) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                ps.setObject(1, 1); // grade
                ps.setObject(2, "Bob"); // name
                ps.setObject(3, "M"); // gender
                int n = ps.executeUpdate(); // 1
                System.out.println(n);
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        long id = rs.getLong(1); // 注意：索引从1开始
                        System.out.println("id = " + id);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void update() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
                ps.setObject(1, "Box"); // 注意：索引从1开始
                ps.setObject(2, 999);
                int n = ps.executeUpdate(); // 返回更新的行数
                System.out.println(n);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void delete() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
                ps.setObject(1, 999); // 注意：索引从1开始
                int n = ps.executeUpdate(); // 删除的行数
                System.out.println(n);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
