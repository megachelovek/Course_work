package servlet.Colors;

import dao.ColorsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteColors")
public class DeleteColorsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ColorsDAO colorsDAO = (ColorsDAO) session.getAttribute("colorsDAO");
        if (req.getParameter("color_id") != null) {
            int color_id = Integer.parseInt(req.getParameter("color_id"));
            colorsDAO.deleteColor(color_id);
        }
        resp.sendRedirect("/listColors");
    }
}