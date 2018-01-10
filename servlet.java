import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Prog2 extends HttpServlet
{

public void doGet(HttpServeletRequest req,httpServletResponse res)
                                         throws IOException,ServletException
{

PrintWriter pw=res.getWriter();
String s1,s2;
s1=req.getParameter("t1");
s2=req.getParameter("t2");

pw.println("<html>");
pw.println("<body>");

if(s1.equals("naresh") && s2.equals("abc"))
{
pw.println("<h1>Welcome</h1>");
pw.println("<h1>Welcome vicky</h1>");
pw.println("<h1>Welcome naresh</h1>");
pw.println("<h1>Welcome good by</h1>");
pw.println("<h1>Welcome hiiiii</h1>");
}
else
pw.println("<h1>invalid username and password</h1>");

pw.println("</body>");
pw.println("</html>");
}}