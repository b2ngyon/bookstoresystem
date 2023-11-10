package com.nyy.bookstore.entity;


import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="BOOK")
public class Book {

    @Id
    @SequenceGenerator(name="book_seq",sequenceName = "book_seq",allocationSize = 50)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "book_seq")
    private int bookId;

    @Column(name="BOOK_TITLE",nullable = false,length = 256)
    private String bookTitle;

    @Column(name="DESCRIPTION",nullable = true,length = 512)
    private String description;

    @Column(name="AUTHOR",nullable = false,length = 256)
    private String author;

    @Column(name="BOOK_TYPE",nullable = true,length = 256)
    private String bookType;

    @Column(name="PUBLISH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;


    public Book() {
    }

    public Book(String bookTitle, String description, String author, String bookType, Date publishDate) {
        this.bookTitle = bookTitle;
        this.description = description;
        this.author = author;
        this.bookType = bookType;
        this.publishDate = publishDate;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookType() {
        return bookType;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() && Objects.equals(getBookTitle(), book.getBookTitle()) && Objects.equals(getDescription(), book.getDescription()) && Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getBookType(), book.getBookType()) && Objects.equals(getPublishDate(), book.getPublishDate());
    }

    @Override
    public int hashCode() {
        int result = getBookId();
        result = 31 * result + getBookTitle().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + (getBookType() != null ? getBookType().hashCode() : 0);
        result = 31 * result + getPublishDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", bookType='" + bookType + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
