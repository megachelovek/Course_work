package servlet.Smartphone;

import dao.SmartphoneDAO;
import model.Smartphone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/editSmartphone")
public class EditSmartphoneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        SmartphoneDAO smartphoneDAO = (SmartphoneDAO) session.getAttribute("smartphoneDAO");
        Smartphone smartphone = null;
        if (req.getParameter("product_id") != null && req.getParameter("name") != null && req.getParameter("cpu") != null && req.getParameter("ram") != null && req.getParameter("rom") != null && req.getParameter("shape_id") != null && req.getParameter("color_id") != null) {
           int product_id = Integer.parseInt(req.getParameter("product_id"));
           String name = req.getParameter("name");
           String cpu = req.getParameter("cpu");
           int ram = Integer.parseInt(req.getParameter("ram"));
           int  rom = Integer.parseInt(req.getParameter("rom"));
           int shape_id = Integer.parseInt(req.getParameter("shape_id"));
           int color_id = Integer.parseInt(req.getParameter("color_id"));
           smartphone = smartphoneDAO.getSmartphone(product_id);
        }
        session.setAttribute("SmartphoneToEdit", smartphone);
        req.getRequestDispatcher("editSmartphone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int product_id;
        String name;
        String cpu;
        int ram;
        int rom;
        int shape_id;
        int color_id;
        if (req.getParameter("product_id") != null && req.getParameter("name") != null && req.getParameter("cpu") != null && req.getParameter("ram") != null && req.getParameter("rom") != null && req.getParameter("shape_id") != null && req.getParameter("color_id") != null) {
             product_id = Integer.parseInt(req.getParameter("product_id"));
             name = req.getParameter("name");
             cpu = req.getParameter("cpu");
             ram = Integer.parseInt(req.getParameter("ram"));
             rom = Integer.parseInt(req.getParameter("rom"));
             shape_id = Integer.parseInt(req.getParameter("shape_id"));
             color_id = Integer.parseInt(req.getParameter("color_id"));
            HttpSession session = req.getSession();
            SmartphoneDAO smartphoneDAO = (SmartphoneDAO) session.getAttribute("smartphoneDAO");
            Smartphone smartphone = (Smartphone) session.getAttribute("SmartphoneToEdit");
            smartphone.setProduct_id(product_id);
            smartphone.setName(name);
            smartphone.setCpu(cpu);
            smartphone.setRam(ram);
            smartphone.setRam(rom);
            smartphone.setShape_id(shape_id);
            smartphone.setShape_id(shape_id);
            smartphoneDAO.updateSmartphone(smartphone);
            resp.sendRedirect("/listSmartphone");
        }
    }
}