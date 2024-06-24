package org.example.javafx_demo.repository;

import org.example.javafx_demo.entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentRepository {

    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/javafx_mysql";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    public Student save(Student student) {
        try {
            // 1. Mở kết nối đến database.
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            // 2. Tạo câu lệnh prepareStatement
            String prepareSql =
                    "insert into students " + "(code, full_name, email, phone) " + "values " + "(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(prepareSql);
            // 3. Thực thi câu lệnh
            preparedStatement.setString(1, student.getCode());
            preparedStatement.setString(2, student.getFullName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.execute();
            System.out.println("Save success!");
            // 4. Đóng kết nối.
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error. Please try again.");
            e.printStackTrace();
        }
        return student;
    }

    public ArrayList<Student> findAll(){
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prSql = "select * from students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prSql);
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String fullName = resultSet.getString("full_name");
                String phone = resultSet.getString("phone");
                Student obj = new Student();
                obj.setCode(code);
                obj.setFullName(fullName);
                obj.setPhone(phone);
                students.add(obj);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student();
        student.setCode("ST001");
        student.setFullName("Hong Luyen");
        student.setEmail("luyen@gmail.com");
        student.setPhone("01923123321");
        studentRepository.save(student);
        System.out.println("Success");
    }
}
