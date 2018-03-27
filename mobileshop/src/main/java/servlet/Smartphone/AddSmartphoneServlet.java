package servlet.Smartphone;

import dao.SmartphoneDAO;
import model.Smartphone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addSmartphone")
public class AddSmartphoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addSmartphone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int product_id;
        String name;
        String cpu;
        int ram;
        int rom;
        int shape_id;
        int color_id;
        if (req.getParameter("color_id") != null &&
                req.getParameter("shape_id") != null&&
                req.getParameter("name") != null &&
                req.getParameter("product_id") != null &&
                req.getParameter("cpu") != null &&
                req.getParameter("rom") != null &&
                req.getParameter("ram") != null){
            HttpSession session = req.getSession();
            SmartphoneDAO smartphoneDAO = (SmartphoneDAO) session.getAttribute("smartphoneDAO");
            product_id = Integer.parseInt(req.getParameter("product_id"));
            name = req.getParameter("name");
            cpu = req.getParameter("name");
            ram = Integer.parseInt(req.getParameter("ram"));
            rom = Integer.parseInt(req.getParameter("rom"));
            shape_id = Integer.parseInt(req.getParameter("color_id"));
            color_id = Integer.parseInt(req.getParameter("color_id"));
            Smartphone smartphone = new Smartphone(product_id,name,cpu,ram,rom,shape_id,color_id);
            smartphoneDAO.addSmartphone(smartphone);
            resp.sendRedirect("/listSmartphones");
        }
    }
}