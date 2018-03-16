package servlet.Smartphone;

import dao.SmartphoneDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteSmartphone")
public class DeleteSmartphoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SmartphoneDAO smartphoneDAO = (SmartphoneDAO) session.getAttribute("smartphoneDAO");
        if (req.getParameter("product_id") != null) {
            int product_id = Integer.parseInt(req.getParameter("product_id"));
            smartphoneDAO.deleteSmartphone(product_id);
        }
        resp.sendRedirect("smartphone");
    }
}