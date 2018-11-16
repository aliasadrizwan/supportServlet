import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/support")
public class SupportServlet extends HttpServlet {
    int ticketId = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Support Form</title><link href='resources/css/style.css' type='text/css' rel='stylesheet' /></head><body>");
        out.print("<form method='post'>");
        out.print("<label>Name: <input type='text' name='name' /></label>");
        out.print("<label>Email: <input type='email' name='email' /></label>");
        out.print("<label>Problem: <input type='text' name='problem' /></label>");
        out.print("<label>Description: <textarea name='problemDescription'></textarea></label>");
        out.print("<input type='submit' name='submit' value='Help' />");
        out.print("</form>");
        out.print("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        ServletContext sc = this.getServletContext();
        String supportEmail = sc.getInitParameter("support-email");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Support Form</title><link href='resources/css/style.css' type='text/css' rel='stylesheet' /></head><body>");
        out.print("<div>");
        out.print("<p> Thank you! "+name+" for contacting us. We should receive reply from us with in 24 hrs in your email address "+email+"." +
                "  Let us know in our support email "+supportEmail+" if you don’t receive reply within 24 hrs." +
                "  Please be sure to attach your reference "+(++ticketId)+" in your email." +
                "</p>");

        out.print("</div>");
        out.print("</body></html>");

    }
}
