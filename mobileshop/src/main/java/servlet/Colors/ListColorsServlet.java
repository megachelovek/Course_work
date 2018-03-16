package servlet.Colors;

import dao.DAO;
import dao.ColorsDAO;
import dao.implementsDAO.ColorsDAOimplements;
import model.Colors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/listColors")
public class ListColorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        DAO dao = (DAO) session.getAttribute("dao");
        ColorsDAO colorsDAO = new ColorsDAOimplements(dao);
        List<Colors> colors = colorsDAO.getColors();
        session.setAttribute("colors", colors);
        session.setAttribute("colorsDAO", colorsDAO);
        req.getRequestDispatcher("colors.jsp").forward(req,resp);
    }
}