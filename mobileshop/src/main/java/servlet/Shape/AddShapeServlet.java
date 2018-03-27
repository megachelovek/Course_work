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

@WebServlet("/addShape")
public class AddShapeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addShape.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int shape_id;
        int width;
        int height;
        int weight;
        if (req.getParameter("color_id") != null &&
                req.getParameter("width") != null&&
                req.getParameter("height") != null &&
        req.getParameter("weight") != null){
            HttpSession session = req.getSession();
            ShapeDAO shapeDAO = (ShapeDAO) session.getAttribute("shapeDAO");
            shape_id = Integer.parseInt(req.getParameter("shape_id"));
            width = Integer.parseInt(req.getParameter("width"));
            height = Integer.parseInt(req.getParameter("height"));
            weight = Integer.parseInt(req.getParameter("weight"));
            Shape shape = new Shape(shape_id,width,height,weight);
            shapeDAO.addShape(shape);
            resp.sendRedirect("/listShapes");
        }
    }
}