package Controller.Contact;

import Data.ContactData;
import Data.UserData;
import Model.ContactModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("userId") == null) {
            resp.sendRedirect("/");
        } else {

            int userid = Integer.parseInt(req.getSession().getAttribute("userId").toString());
            List<ContactData> contact = new ArrayList<>();

            ContactModel contactModel = new ContactModel();

            try {
                contact = contactModel.display(userid);
            } catch (
                    SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("contacts", contact);
            req.getRequestDispatcher("/contact.jsp").forward(req, resp);
        }
    }
}


