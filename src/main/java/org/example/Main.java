package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var comment = new Comment();
        comment.setAuthor("Alex");
        comment.setText("Demo comment");

        var commentService = context.getBean(CommentService.class);
        String value = commentService.publishComment(comment);
        logger.info(value);
    }
}