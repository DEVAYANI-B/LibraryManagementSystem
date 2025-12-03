package main.java.com.examly.entity;

import java.util.Date;

public class BorrowRecord{
    private int recId;
    private String memberId;
    private String bookId;
    private Date borrowDate;
    private Date returnDate;

    public BorrowRecord(){}

    public BorrowRecord(int recId,String memberId,String bookId,Date borrowDate,Date returnDate){
        this.recId=recId;
        this.memberId=memberId;
        this.bookId=bookId;
        this.borrowDate=borrowDate;
        this.returnDate=returnDate;
    }
    public int getRecId(){
        return recId;
    }
    public void setRecId(int recId){
        this.recId=recId;
    }
    public String getMemberId(){
        return memberId;
    }
    public void setMemberId(String memberId){
        this.memberId=memberId;
    }
    public String getBookId(){
        return bookId;
    }
    public void setBookId(String bookId){
        this.bookId=bookId;
    }
    public Date getBorrowDate(){
        return borrowDate;
    }
    public void setBorrowDate(Date borrowDate){
        this.borrowDate=borrowDate;
    }
    public Date getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(Date returnDate){
        this.returnDate=returnDate;
    }
    @Override
    public String toString(){
        return recId+" "+memberId+" "+bookId+" "+borrowDate+" "+returnDate;
    }


}