package org.example.javafx_demo.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import org.example.javafx_demo.entity.Student;
import org.example.javafx_demo.repository.StudentRepository;

public class StudentForm {
    public TextField studentCode;
    public TextField studentFullname;
    public TextField studentEmail;
    public TextField studentPhone;

    StudentRepository studentRepository = new StudentRepository();

    public void doSomething(ActionEvent actionEvent) {
        Student student = new Student();
        student.setCode(studentCode.getText());
        student.setFullName(studentFullname.getText());
        student.setEmail(studentEmail.getText());
        student.setPhone(studentPhone.getText());
        studentRepository.save(student);
    }
}
