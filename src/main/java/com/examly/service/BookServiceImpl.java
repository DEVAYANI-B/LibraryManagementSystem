package com.examly.service;

import java.util.List;
import java.util.ArrayList;
import com.examly.entity.Book;
import com.examly.util.DBConnection;
import java.sql.*;

public class BookServiceImpl implements BookService{
    
    @Override
    public boolean addBook(Book book){
        String sql="INSERT INTO books(bookid,title,author,availableCopies) VALUES(?,?,?,?)";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,book.getBookId());
            ps.setString(2,book.getTitle());
            ps.setString(3,book.getAuthor());
            ps.setInt(4,book.getAvailableCopies());

            return ps.executeUpdate()>0;

        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Book getbookById(String bookId){
        String sql="SELECT * FROM books WHERE bookId=?";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,bookId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            return new Book(
                rs.getString("bookId"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("availableCopies")
            );
            }
        
        }
        catch(SQLException e){
            e.printStackTrace();
            
        }
        return null;

    }

    @Override
    public List<Book> getAllBooks(){
        String sql="SELECT * FROM books";
        List<Book> books=new ArrayList<>();
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Book book=new Book(
                    rs.getString("bookId"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getInt("availableCopies")
                );
                books.add(book);

            }
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        return books;
    }

    @Override
    public boolean updateBook(Book book){
        String sql="UPDATE books SET title=?,author=?,availableCopies=? WHERE bookId=?";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            
            ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getAvailableCopies());
            ps.setString(4,book.getBookId());

            return ps.executeUpdate() > 0;
            
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
    }
    @Override
    public boolean deleteBook(String bookId){
        String sql="DELETE FROM books WHERE bookId=?";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,bookId);
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public List<Book> searchBookByTitle(String title){
        String sql="SELECT * FROM books WHERE title=?";
        List<Book> books=new ArrayList<>();
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,title);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Book book= new Book(
                rs.getString("bookId"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("availableCopies"));
                books.add(book);
            }
            
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return books;

    }
    @Override
    public boolean reduceBookCopy(String bookId){
        String sql="UPDATE books SET availableCopies=availableCopies-1 WHERE bookId=? AND availableCopies>0";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,bookId);
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean increaseBookCopy(String bookId){
        String sql="UPDATE books SET availableCopies=availableCopies+1 WHERE bookId=?";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,bookId);
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
}
