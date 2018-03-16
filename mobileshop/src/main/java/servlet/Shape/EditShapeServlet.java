package servlet.Shape;

import dao.ShapeDAO;
import model.Shape;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/editShape")
public class EditShapeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShapeDAO shapeDAO = (ShapeDAO) session.getAttribute("shapeDAO");
        Shape shape = null;
        if (req.getParameter("shape_id") != null && req.getParameter("width") != null && req.getParameter("height") != null && req.getParameter("weight") != null) {
            int shape_id = Integer.parseInt(req.getParameter("shape_id"));
            int width = Integer.parseInt(req.getParameter("width"));
            int height = Integer.parseInt(req.getParameter("height"));
            int weight = Integer.parseInt(req.getParameter("weight"));
            shape = shapeDAO.getShape(shape_id);
        }
        session.setAttribute("ShapeToEdit", shape);
        req.getRequestDispatcher("editShape.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int shape_id;
        int width;
        int height;
        int weight;
        if (req.getParameter("shape_id") != null && req.getParameter("width") != null && req.getParameter("height") != null && req.getParameter("weight") != null) {
             shape_id = Integer.parseInt(req.getParameter("shape_id"));
             width = Integer.parseInt(req.getParameter("width"));
             height = Integer.parseInt(req.getParameter("height"));
             weight = Integer.parseInt(req.getParameter("weight"));
            HttpSession session = req.getSession();
            ShapeDAO shapeDAO = (ShapeDAO) session.getAttribute("shapeDAO");
            Shape shape = (Shape) session.getAttribute("ShapeToEdit");
            shape.setShape_id(shape_id);
            shape.setWidth(width);
            shape.setHeight(height);
            shape.setWeight(weight);
            shapeDAO.updateShape(shape);
            resp.sendRedirect("/ShapeList");
        }
    }
}