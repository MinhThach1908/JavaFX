package org.example.javafx_demo.repository;

import org.example.javafx_demo.entity.Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleRepository {

    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/javafx_mysql";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    public Article save(Article obj) {
        try {
            // 1. Mở kết nối đến database.
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            // 2. Tạo câu lệnh prepareStatement
            String prepareSql =
                    "insert into articles " + "(title, description, content) " + "values " + "(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(prepareSql);
            // 3. Thực thi câu lệnh
            preparedStatement.setString(1, obj.getTitle());
            preparedStatement.setString(2, obj.getDescription());
            preparedStatement.setString(3, obj.getContent());
            preparedStatement.execute();
            // 4. Đóng kết nối.
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error. Please try again.");
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        ArticleRepository repository = new ArticleRepository();
        Article article = new Article();
        article.setTitle("Title");
        article.setDescription("Description");
        article.setContent("Content");
        repository.save(article);
    }
}
