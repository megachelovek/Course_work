package servlet.Shape;

import dao.DAO;
import dao.ShapeDAO;
import dao.implementsDAO.ShapeDAOimplements;
import model.Shape;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/listShape")
public class ListShapeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        DAO dao = (DAO) session.getAttribute("dao");
        ShapeDAO shapeDAO = new ShapeDAOimplements(dao);
        List<Shape> shapes = shapeDAO.getShapes();
        session.setAttribute("shapes", shapes);
        session.setAttribute("shapeDAO", shapeDAO);
        req.getRequestDispatcher("shape.jsp").forward(req,resp);
    }
}