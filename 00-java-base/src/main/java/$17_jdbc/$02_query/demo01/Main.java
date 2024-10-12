package $17_jdbc.$02_query.demo01;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "123456";
        // try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
        //     try (Statement stmt = conn.createStatement()) {
        //         try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
        //             while (rs.next()) {
        //                 long id = rs.getLong(1); // 注意：索引从1开始
        //                 long grade = rs.getLong(2);
        //                 String name = rs.getString(3);
        //                 int gender = rs.getInt(4);
        //                 System.out.println("id = " + id);
        //                 System.out.println("grade = " + grade);
        //                 System.out.println("name = " + name);
        //                 System.out.println("gender = " + gender);
        //                 System.out.println("--------------------------------------------------------------------------------");
        //             }
        //         }
        //     }
        // }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?")) {
                ps.setObject(1, "M"); // 注意：索引从1开始
                ps.setObject(2, 3);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong("id");
                        long grade = rs.getLong("grade");
                        String name = rs.getString("name");
                        String gender = rs.getString("gender");
                        System.out.println("id = " + id);
                        System.out.println("grade = " + grade);
                        System.out.println("name = " + name);
                        System.out.println("gender = " + gender);
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                }
            }
        }
    }

    void login(Statement stmt, String name, String pass) throws SQLException {
        stmt.executeQuery("SELECT * FROM user WHERE login='" + name + "' AND pass='" + pass + "'");
    }

    void login(Connection conn, String name, String pass) throws SQLException {
        String sql = "SELECT * FROM user WHERE login=? AND pass=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, name);
        ps.setObject(2, pass);
    }
}
