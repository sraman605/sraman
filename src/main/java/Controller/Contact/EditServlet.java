package Controller.Contact;

import Data.ContactData;
import Model.ContactModel;
import Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        ContactModel cm = new ContactModel();
        try {
            ContactData contact = cm.getDatabyId(id);
            System.out.println(contact.getName() + "asd");
            if(contact.getMobno() != null){
                req.setAttribute("contact", contact);
                req.getRequestDispatcher("/editpost.jsp").forward(req,resp);
            }

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String cid= req.getParameter("id");
     int id=Integer.parseInt(cid);
        String name = req.getParameter("name");
        String email =req.getParameter("email");
        String address =req.getParameter("address");
        Long phoneno=Long.parseLong(req.getParameter("phoneno"));
        Long mobno=Long.parseLong(req.getParameter("mobno"));

        ContactData contactData=new ContactData();
        contactData.setId(id);
        contactData.setName(name);
        contactData.setEmail(email);
        contactData.setAddress(address);
        contactData.setPhoneno(phoneno);
        contactData.setMobno(mobno);
        HttpSession session = req.getSession();
        contactData.setUserid((int)session.getAttribute("userId"));
        ContactModel cm = new ContactModel();

        try {
            if(cm.Edit(contactData) > 0){

                System.out.println("ok");
                resp.sendRedirect("/contact");

            }
            else{
                PrintWriter pw = resp.getWriter();
                pw.println("<h1> Sorry, problems in editing!</h1>");
            }
        } catch (SQLException e) {
            System.out.println("Cant be edited");
            e.printStackTrace();
        }
    }

}

