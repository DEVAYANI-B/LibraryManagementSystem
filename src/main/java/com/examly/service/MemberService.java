package main.java.com.examly.service;
import main.java.com.examly.entity.Member;

import java.util.List;

public interface MemberService{
    boolean addMember(Member member);
    Member getMemberById(String memberId);
    List<Member> getAllMembers();
    boolean updateMember(Member member);
    boolean deleteMember(String memberId);
    List<Member> searchMemberByName(String mname);
}