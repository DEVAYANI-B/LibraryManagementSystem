package com.examly.entity;

public class Book{
    private String bookId;
    private String title;
    private String author;
    private int availableCopies;

    public Book(){}
    public Book(String bookId,String title,String author,int availableCopies){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.availableCopies=availableCopies;

    }

    public String getBookId(){
        return bookId;
    }
    public void setBookId(String bookId){
        this.bookId=bookId;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public int getAvailableCopies(){
        return availableCopies;
    }
    public void setAvailableCopies(int availableCopies){
        this.availableCopies=availableCopies;
    }

    @Override
    public String toString(){
        return bookId+" "+title+" "+author+" "+availableCopies;
    }
}