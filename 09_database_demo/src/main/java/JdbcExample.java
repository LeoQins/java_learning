import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
    // --- 请根据你的MySQL配置修改以下常量 ---
    // 数据库 URL, 'testdb' 是数据库名，你需要先创建它
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
    // 数据库用户名
    static final String USER = "root";
    // 数据库密码
    static final String PASS = "your_password"; // <-- 修改为你的密码

    public static void main(String[] args) {
        // 使用 try-with-resources 语句可以自动关闭资源
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            
            System.out.println("成功连接到数据库...");

            // 1. 创建一个表 (如果不存在)
            System.out.println("创建 users 表...");
            String createTableSql = "CREATE TABLE IF NOT EXISTS users (" +
                                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                                    "name VARCHAR(50), " +
                                    "email VARCHAR(50))";
            stmt.executeUpdate(createTableSql);

            // 2. 清空表中的旧数据，以便每次运行都是干净的
            System.out.println("清空 users 表...");
            stmt.executeUpdate("TRUNCATE TABLE users");

            // 3. 插入一些数据
            System.out.println("插入数据...");
            stmt.executeUpdate("INSERT INTO users (name, email) VALUES ('Alice', 'alice@example.com')");
            stmt.executeUpdate("INSERT INTO users (name, email) VALUES ('Bob', 'bob@example.com')");

            // 4. 执行查询
            System.out.println("\n查询 users 表中的所有数据:");
            String sql = "SELECT id, name, email FROM users";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                // 5. 处理结果集
                while (rs.next()) {
                    // 通过列名获取数据
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");

                    // 打印结果
                    System.out.print("ID: " + id);
                    System.out.print(", 姓名: " + name);
                    System.out.println(", 邮箱: " + email);
                }
            } // ResultSet 会在这里自动关闭

        } catch (SQLException e) {
            System.err.println("数据库操作失败! 请检查你的配置和SQL语句。");
            e.printStackTrace();
        } // Connection 和 Statement 会在这里自动关闭
    }
}
