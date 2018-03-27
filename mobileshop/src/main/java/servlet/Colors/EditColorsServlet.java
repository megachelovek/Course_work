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

@WebServlet("/editColors")
public class EditColorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ColorsDAO colorsDAO = (ColorsDAO) session.getAttribute("colorsDao");
        Colors colors = null;
        if (req.getParameter("color_id") != null && req.getParameter("rgb") != null && req.getParameter("name") != null) {
            int color_id = Integer.parseInt(req.getParameter("color_id"));
            String name = req.getParameter("name");
            int rgb = Integer.parseInt(req.getParameter("rgb"));
            colors = colorsDAO.getColor(color_id);
        }
        session.setAttribute("ColorToEdit", colors);
        req.getRequestDispatcher("editColor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        int color_id;
        int rgb;
        if (req.getParameter("color_id") != null && req.getParameter("rgb") != null && req.getParameter("name") != null) {
            color_id = Integer.parseInt(req.getParameter("color_id"));
            name = req.getParameter("name");
            rgb = Integer.parseInt(req.getParameter("rgb"));
            HttpSession session = req.getSession();
            ColorsDAO colorsDAO = (ColorsDAO) session.getAttribute("colorsDAO");
            Colors colors = (Colors) session.getAttribute("ColorToEdit");
            colors.setName(name);
            colors.setColor_id(color_id);
            colors.setRgb(rgb);
            colorsDAO.updateColor(colors);
            resp.sendRedirect("/listColors");
        }
    }
}