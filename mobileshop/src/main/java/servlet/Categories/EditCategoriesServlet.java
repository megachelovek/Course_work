package servlet.Categories;

import dao.CategoriesDAO;
import model.Categories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/editCategories")
public class EditCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CategoriesDAO categoriesDAO = (CategoriesDAO) session.getAttribute("categoriesDAO");
        Categories categories = null;
        if (req.getParameter("category_id") != null) {
            int category_id = Integer.parseInt(req.getParameter("category_id"));
            categories = categoriesDAO.getCategory(category_id);
        }
        session.setAttribute("CategoryToEdit", categories);
        req.getRequestDispatcher("editCategory.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name;
        int category_id;
        if (req.getParameter("category_id") != null &&
                req.getParameter("name") != null) {
            category_id = Integer.parseInt(req.getParameter("category_id"));
            name = req.getParameter("name");
            HttpSession session = req.getSession();
            CategoriesDAO categoriesDAO = (CategoriesDAO) session.getAttribute("categoriesDAO");
            Categories categories = (Categories) session.getAttribute("CategoryToEdit");
            categories.setName(name);
            categories.setCategory_id(category_id);
            categoriesDAO.updateCategory(categories);
            resp.sendRedirect("/listCategories");
        }
    }
}