package servlet.Shape;

import dao.ShapeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteShape")
public class DeleteShapeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShapeDAO shapeDAO = (ShapeDAO) session.getAttribute("shapeDAO");
        if (req.getParameter("shape_id") != null) {
            int shape_id = Integer.parseInt(req.getParameter("shape_id"));
            shapeDAO.deleteShape(shape_id);
        }
        resp.sendRedirect("shape");
    }
}