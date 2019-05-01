package Controller.Contact;

import Data.ContactData;
import Model.ContactModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 int id=Integer.parseInt(req.getParameter("id"));
        ContactData contactData=new ContactData();

    }
}
