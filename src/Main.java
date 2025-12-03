import java.util.*;
import main.java.com.examly.entity.*;
import main.java.com.examly.service.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BookService bookservice=new BookServiceImpl();
        MemberService memService = new MemberServiceImpl();
while(true){
        System.out.println("\n===LIBRARY MANAGEMENT SYSTEM===");
        System.out.println("1.Book Menu");
        System.out.println("2.Member Menu");
        System.out.println("3.BorrowRecord Menu");
        System.out.println("4.Exit");
        System.out.print("Enter your Choice: ");
        int ch=sc.nextInt();
        sc.nextLine();
        

        switch(ch){
            case 1: BookMenu(bookservice,sc); break;
            case 2: MemberMenu(memService,sc); break;
            case 4:System.exit(0); break;
            default: System.out.println("Invalid Choice");
        }


}


    }
    public static void BookMenu(BookService service,Scanner sc){
        while(true){
            System.out.println("---Book Menu---");
            System.out.println("1.Add Book");
            System.out.println("2.View Book By Id");
            System.out.println("3.View all Books");
            System.out.println("4.Update Book by Id");
            System.out.println("5.Delete Book by Id");
            System.out.println("6.Search Books by Title");
            System.out.println("7.Decrease available Book Copies");
            System.out.println("8.Increase available Book Copies");
            System.out.println("9.Back to Main Menu");
            System.out.print("Enter choice: ");
            int ch=sc.nextInt();
            sc.nextLine();
            if(ch==9)return;

            switch(ch){
                
                case 1:
                    System.out.print("Enter bookId: ");
                    String bookId=sc.nextLine();
                    System.out.print("Enter title: ");
                    String title=sc.nextLine();
                    System.out.print("Enter author: ");
                    String author=sc.nextLine();
                    System.out.print("Enter availableCopies: ");
                    int availableCopies=sc.nextInt();
                    sc.nextLine();
                    Book book=new Book(bookId,title,author,availableCopies);
                    System.out.println(service.addBook(book) ? "Book added successfully" :"Failed to add book");
                    break;
                case 2:
                    System.out.print("Enter bookId: ");
                    Book b=service.getbookById(sc.nextLine());
                    System.out.println(b!=null ?b.getBookId()+"\n"+b.getTitle() : "Book not found" );
                    break;
                case 3:
                    for(Book bk: service.getAllBooks()){
                        System.out.println(bk.getBookId()+"\n"+bk.getTitle());
                    }
                    break;
                case 4:
                    System.out.print("Book id to update: ");
                    String uid=sc.nextLine();
                    System.out.print("New title: ");
                    String ntitle=sc.nextLine();
                    System.out.print("New author: ");
                    String nauthor=sc.nextLine();
                    System.out.print("New available copies: ");
                    int ncopies=sc.nextInt();
                    sc.nextLine();
                    Book updated=new Book(uid,ntitle,nauthor,ncopies);
                    System.out.println(service.updateBook(updated) ? "Updated" : "Failed to update");
                    break;
                case 5:
                    System.out.print("Enter bookId to delete: ");
                    System.out.println(service.deleteBook(sc.nextLine()) ? "Deleted" : "Failed");
                    break;
                case 6:
                    System.out.print("Enter title: ");
                    List<Book> bks=service.searchBookByTitle(sc.nextLine());
                    for(Book bo: bks){
                        System.out.println(bo.getBookId()+"\n"+bo.getAuthor()+"\n"+bo.getAvailableCopies());
                    }
                    break;
                case 7:
                    System.out.print("Enter Book ID: ");
                    System.out.println(service.reduceBookCopy(sc.nextLine()) ? "Decreased" : "Failed");
                    break;
                case 8:
                    System.out.print("Enter Book ID: ");
                    System.out.println(service.increaseBookCopy(sc.nextLine()) ? "Increased" : "Failed");
                    break;
                default:
                    System.out.println("Invalid choice!");




            }
        }
    }

     public static void MemberMenu(MemberService service,Scanner sc){
        while(true){
            System.out.println("---Member Menu---");
            System.out.println("1.Add Member");
            System.out.println("2.View Member By Id");
            System.out.println("3.View all Members");
            System.out.println("4.Update Member by Id");
            System.out.println("5.Delete Member by Id");
            System.out.println("6.Search Member by name");
            System.out.println("7.Back to Main Menu");
            System.out.print("Enter choice: ");
            int ch=sc.nextInt();
            sc.nextLine();
            if(ch==7)return;

            switch(ch){
                
                case 1:
                    System.out.print("Enter memberId: ");
                    String memberId=sc.nextLine();
                    System.out.print("Enter mname: ");
                    String mname=sc.nextLine();
                    System.out.print("Enter email: ");
                    String email=sc.nextLine();
                    
                    Member member=new Member(memberId,mname,email);
                    System.out.println(service.addMember(member) ? "Member added successfully" :"Failed to add Member");
                    break;
                case 2:
                    System.out.print("Enter memberId: ");
                    Member m=service.getMemberById(sc.nextLine());
                    System.out.println(m!=null ?m.getMemberId()+"\n"+m.getMname() : "Member not found" );
                    break;
                case 3:
                    for(Member mb: service.getAllMembers()){
                        System.out.println(mb.getMemberId()+"\n"+mb.getMname());
                    }
                    break;
                case 4:
                    System.out.print("Member id to update: ");
                    String uid=sc.nextLine();
                    System.out.print("New mname: ");
                    String nmname=sc.nextLine();
                    System.out.print("New email: ");
                    String nemail=sc.nextLine();
                   
                    Member updated=new Member(uid,nmname,nemail);
                    System.out.println(service.updateMember(updated) ? "Updated" : "Failed to update");
                    break;
                case 5:
                    System.out.print("Enter member id to delete: ");
                    System.out.println(service.deleteMember(sc.nextLine()) ? "Deleted" : "Failed");
                    break;
                case 6:
                    System.out.print("Enter name: ");
                    List<Member> mbs=service.searchMemberByName(sc.nextLine());
                    for(Member mm: mbs){
                        System.out.println(mm.getMemberId()+"\n"+mm.getMname()+"\n"+mm.getEmail());
                    }
                    break;
               
                default:
                    System.out.println("Invalid choice!");




            }
        }
    }
}