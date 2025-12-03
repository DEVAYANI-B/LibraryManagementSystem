package main.java.com.examly.service;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import main.java.com.examly.entity.*;
import main.java.com.examly.service.*;
import main.java.com.examly.util.DBConnection;



public class BorrowRecordServiceImpl implements BorrowRecordService{
    private BookService bookService=new BookServiceImpl();

    @Override
    public boolean borrowBook(String memberId,String bookId){
        String sql="INSERT INTO record(memberId,bookId,borrowDate) VALUES(?,?,CURDATE())";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            boolean updated=bookService.reduceBookCopy(bookId);
            if(!updated){
                System.out.println("No copies available for this book");
                return false;
            }
            ps.setString(1,memberId);
            ps.setString(2,bookId);
            return ps.executeUpdate()>0;

        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean returnBook(int recId){
      String ssql="SELECT bookId FROM record WHERE recId=? AND returnDate IS NULL";
      String usql="UPDATE record SET returnDate=CURDATE() WHERE recId=?";

      try(Connection con=DBConnection.getConnection()){
        PreparedStatement ps=con.prepareStatement(ssql);
        ps.setInt(1,recId);
        ResultSet rs=ps.executeQuery();

        if(!rs.next()){
            System.out.println("Record not found or book already returned");
            return false;
        }
        String bookId=rs.getString("bookId");
        boolean updated=bookService.increaseBookCopy(bookId);
        if(!updated)return false;
        PreparedStatement ps1=con.prepareStatement(usql);
        ps1.setInt(1,recId);
        return ps1.executeUpdate()>0;
      }
      catch(SQLException e){
        e.printStackTrace();
        return false;
      }
    }
    @Override
    public List<BorrowRecord> getBorrowRecordsByMember(String memberId){
        String sql="SELECT * FROM record WHERE memberId=?";
        List<BorrowRecord> recbymem=new ArrayList<>();
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,memberId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                BorrowRecord br=new BorrowRecord(
                    rs.getInt("recId"),
                    rs.getString("memberId"),
                    rs.getString("bookId"),
                    rs.getDate("borrowDate"),
                    rs.getDate("returnDate")
                );
                recbymem.add(br);
            }
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        return recbymem;
    }
    @Override
    public List<BorrowRecord> getAllBorrowRecords(){
        String sql="SELECT * FROM record";
        List<BorrowRecord> rec=new ArrayList<>();
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                BorrowRecord br=new BorrowRecord(
                    rs.getInt("recId"),
                    rs.getString("memberId"),
                    rs.getString("bookId"),
                    rs.getDate("borrowDate"),
                    rs.getDate("returnDate")
                );
                rec.add(br);
            }
        }
        catch(SQLException e){
            e.printStackTrace();

        }
        return rec;

    }
}