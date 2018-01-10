import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*; 
public class Mysql extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{

PrintWriter pw=res.getWriter();
String s1,s2,s3,s4;
boolean chk=false;
s1=req.getParameter("uid");
s2=req.getParameter("p");
HttpSession s=req.getSession(true);
s.setAttribute("userid",s1);
s.setAttribute("oldpass",s2);



try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/naresh","root","Naresh@8446");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
//ResultSet rs=stmt.executeQuery("select * from user");

ResultSet rs=stmt.executeQuery
("select * from user where uname='"+s1 +"' and pass='"+s2+"'");  
pw.println("<html>");
pw.println("<body>");

if(rs.next()) {
s3=rs.getString(1);
s4=rs.getString(4);
if(s1.equals(s3) && s2.equals(s4))
{pw.println("welcome in it solution infotech");
pw.println("<a href='http://localhost:8080/userlogin.html'>Click here</a>");
chk=true;
}


  }

pw.println("</body>");
pw.println("</html>");
con.close();
}catch(Exception e){ System.out.println(e);} 

if(chk==false)
pw.println("invalid user name or password");


}


}