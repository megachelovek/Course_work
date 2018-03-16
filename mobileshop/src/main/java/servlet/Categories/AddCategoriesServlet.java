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

@WebServlet("/addCategories")
public class AddCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addCategories.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int category_id;
        String name;
        if (req.getParameter("category_id") != null &&
                req.getParameter("name") != null) {
            HttpSession session = req.getSession();
            CategoriesDAO categoriesDAO = (CategoriesDAO) session.getAttribute("categoriesDAO");
            category_id = Integer.parseInt(req.getParameter("category_id"));
            name = req.getParameter("name");
            Categories categories1 = new Categories(category_id,name);
            categoriesDAO.addCategory(categories1);
            resp.sendRedirect("/categories");
        }
    }
}