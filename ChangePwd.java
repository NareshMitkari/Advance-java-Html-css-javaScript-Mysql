import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*; 
public class ChangePwd extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{

PrintWriter pw=res.getWriter();
pw.println("<html>");
pw.println("<body>");
String s1,s2,s3,s4,psd="",s5;
boolean chk=false,chk1=false;


HttpSession s=req.getSession(true);
s1=(String)s.getAttribute("userid");
s2=(String)s.getAttribute("oldpass");
//pw.println(s1);
//pw.println(s2);
s3=req.getParameter("pass");
s4=req.getParameter("pass1");
s5=req.getParameter("oldpwd");


try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/naresh","root","Naresh@8446");  
 
if(s5.equals(s2))
{chk1=true;
psd=s4;
Statement stmt=con.createStatement(); 
ResultSet rs=stmt.executeQuery
("select * from user where pass='"+s5 +"' and uname='"+s1+"'");
if(rs.next())
{
PreparedStatement pst=con.prepareStatement
("update user set pass=? where uname=? ");
chk=true;
pw.println("..............");  
pst.setString(1,psd);
 
pst.setString(2,s1);



pst.executeUpdate();
 
pw.println("Password updated");

pw.println(".............."); 
}
else if(chk==false)
pw.println("Enter Valid Id and password"); 
}
else 
pw.println("CHECK ONCE AGAIN SOMETHING IS WRONG");

}catch(Exception e){ System.out.println(e);} 

if(chk==true){

pw.println
("<a href='http://localhost:8080/UserServ1.html'>Click here</a>");

}

pw.println("</body>");
pw.println("</html>");
}


}