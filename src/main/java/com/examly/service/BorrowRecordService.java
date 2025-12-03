package main.java.com.examly.service;

import main.java.com.examly.entity.BorrowRecord;
import java.util.List;

public interface BorrowRecordService{
    boolean borrowBook(String memberId,String bookId);
    boolean returnBook(int recId);
    List<BorrowRecord>getBorrowRecordsByMember(String memberId);
    List<BorrowRecord> getAllBorrowRecords();
}