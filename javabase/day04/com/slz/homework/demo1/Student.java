package com.slz.homework.demo1;

/**
 * @ Author : SunLZ
 * @ Project : JavaLearning
 * @ Date : 2024/6/2
 */
public class Student {
    private String name;
    private BookPaper bookPaper;

    public Student(String name, BookPaper bookPaper) {
        this.name = name;
        this.bookPaper = bookPaper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookPaper getBookPaper() {
        return bookPaper;
    }

    public void setBookPaper(BookPaper bookPaper) {
        this.bookPaper = bookPaper;
    }
}
