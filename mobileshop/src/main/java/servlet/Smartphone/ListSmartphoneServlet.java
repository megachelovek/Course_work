package servlet.Smartphone;

import dao.DAO;
import dao.SmartphoneDAO;
import dao.implementsDAO.SmartphoneDAOimplements;
import model.Smartphone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/listSmartphone")
public class ListSmartphoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        DAO dao = (DAO) session.getAttribute("dao");
        SmartphoneDAO smartphoneDAO = new SmartphoneDAOimplements(dao);
        List<Smartphone> smartphones = smartphoneDAO.getSmartphones();
        session.setAttribute("smartphones", smartphones);
        session.setAttribute("smartphoneDAO", smartphoneDAO);
        req.getRequestDispatcher("smartphone.jsp").forward(req,resp);
    }
}