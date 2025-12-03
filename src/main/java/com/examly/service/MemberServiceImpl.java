package main.java.com.examly.service;

import main.java.com.examly.entity.Member;
import java.util.List;
import java.util.ArrayList;
import main.java.com.examly.util.DBConnection;
import java.sql.*;

public class MemberServiceImpl implements MemberService{

    @Override
    public boolean addMember(Member member){
        String sql="INSERT INTO members(memberId,mname,email) VALUES(?,?,?)";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,member.getMemberId());
            ps.setString(2,member.getMname());
            ps.setString(3,member.getEmail());
            return ps.executeUpdate()>0;

        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
               

    }
    @Override
    public Member getMemberById(String memberId){
        String sql="SELECT * FROM members WHERE memberId=?";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,memberId);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return new Member(
                    rs.getString("memberId"),
                    rs.getString("mname"),
                    rs.getString("email")
                );


            }

        }
        catch(SQLException e){
            e.printStackTrace();
           
        }
         return null;
    }
    @Override
    public List<Member> getAllMembers(){
        String sql="SELECT * FROM members";
        List<Member> members=new ArrayList<>();
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Member mem=new Member(
                rs.getString("memberId"),
                rs.getString("mname"),
                rs.getString("email"));
                members.add(mem);
            }

            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return members;
    }
    @Override
    public boolean updateMember(Member member){
        String sql="UPDATE members SET mname=?,email=? WHERE memberId=?";
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,member.getMname());
            ps.setString(2,member.getEmail());
            ps.setString(3,member.getMemberId());
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
                
    }
    @Override
    public boolean deleteMember(String memberId){
        String sql="DELETE FROM members WHERE memberId=?";

        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,memberId);
            return ps.executeUpdate()>0;
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }
    @Override
    public List<Member> searchMemberByName(String mname){
        String sql="SELECT * FROM members WHERE mname=?";
        List<Member> membyname =new ArrayList<>();
        try(Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,mname);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Member m=new Member(
                    rs.getString("memberId"),
                    rs.getString("mname"),
                    rs.getString("email")
                );
                membyname.add(m);
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return membyname;
    }
    

}