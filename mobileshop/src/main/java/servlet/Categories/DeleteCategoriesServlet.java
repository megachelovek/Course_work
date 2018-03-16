package servlet.Categories;

import dao.CategoriesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteCategories")
public class DeleteCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CategoriesDAO categoriesDAO = (CategoriesDAO) session.getAttribute("categoriesDAO");
        if (req.getParameter("category_id") != null) {
            int category_id = Integer.parseInt(req.getParameter("category_id"));
            categoriesDAO.deleteCategory(category_id);
        }
        resp.sendRedirect("categories");
    }
}