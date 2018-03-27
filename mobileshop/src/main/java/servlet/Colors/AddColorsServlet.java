package servlet.Colors;

import dao.ColorsDAO;
import model.Colors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addColors")
public class AddColorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addColors.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int color_id;
        String name;
        int rgb;
        if (req.getParameter("color_id") != null &&
                (req.getParameter("rgb") != null)&&
        req.getParameter("name") != null) {
            HttpSession session = req.getSession();
            ColorsDAO colorsDAO = (ColorsDAO) session.getAttribute("colorsDAO");
            color_id = Integer.parseInt(req.getParameter("color_id"));
            rgb = Integer.parseInt(req.getParameter("rgb"));
            name = req.getParameter("name");
            Colors colors = new Colors(color_id,rgb,name);
            colorsDAO.addColor(colors);
            resp.sendRedirect("/listColors");
        }
    }
}