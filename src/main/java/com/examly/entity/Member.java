package main.java.com.examly.entity;


public class Member{
    private String memberId;
    private String mname;
    private String email;

    public Member(){}
    public Member(String memberId,String mname,String email){
        this.memberId=memberId;
        this.mname=mname;
        this.email=email;
    }
    public String getMemberId(){
        return memberId;
    }
    public void setMemberId(String memberId){
        this.memberId=memberId;
    }
    public String getMname(){
        return mname;
    }
    public void setMname(String mname){
        this.mname=mname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    @Override
    public String toString(){
        return memberId+" "+mname+" "+email;
    }
}