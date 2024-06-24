package org.example.javafx_demo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.example.javafx_demo.entity.Article;
import org.example.javafx_demo.repository.ArticleRepository;


import java.net.URL;
import java.util.ResourceBundle;

public class ArticleTableView implements Initializable {

    public TableView tableView;

    private ArticleRepository articleRepository = new ArticleRepository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Article> data = FXCollections.observableArrayList(articleRepository.findAll());
        tableView.setItems(data);
    }
}