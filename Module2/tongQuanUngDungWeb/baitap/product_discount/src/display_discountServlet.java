import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "display_discountServlet", urlPatterns = "/display_discount")
public class display_discountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float percent = Float.parseFloat(request.getParameter("percent"));

        double discountAmount = price * percent * 0.1;
        double discountPrice = discountAmount/ (price*0.1);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Discount Calculator</h1>");
        writer.println("<h3>Product Description:" + product + "</h3>");
        writer.println("<h3>Price:"+"$"+price+"</h3>");
        writer.println("<h3>Discount Percent:"+percent+"%"+"</h3>");
        writer.println("<h3>Discount Amount:"+"$"+discountAmount+"</h3>");
        writer.println("<h3>Discount Price:" +"$"+discountPrice + "</h3>");
        writer.println("</html>");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
