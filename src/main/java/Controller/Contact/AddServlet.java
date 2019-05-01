package Controller.Contact;

import Data.ContactData;
import Data.UserData;
import Model.ContactModel;
import Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Inside add servlet");

        String name = req.getParameter("name");
            String email =req.getParameter("email");
            String address =req.getParameter("address");
            Long phoneno=Long.parseLong(req.getParameter("phoneno"));
            Long mobno=Long.parseLong(req.getParameter("mobno"));

            ContactData contactData=new ContactData();
            contactData.setName(name);
            contactData.setEmail(email);
            contactData.setAddress(address);
            contactData.setPhoneno(phoneno);
            contactData.setMobno(mobno);
            HttpSession session = req.getSession();
            contactData.setUserid((int)session.getAttribute("userId"));

            ContactModel cm = new ContactModel();
            UserModel um =new UserModel();


            try {
                if(cm.insertIntoDatabase(contactData) > 0){
                    System.out.println("Inside isert");
                    System.out.println("ok");

                    resp.sendRedirect("/contact");

                }
                else{
                    PrintWriter pw = resp.getWriter();
                    pw.println("<h1> Sorry, problems inserting in database</h1>");
                }
            } catch (SQLException e) {
                System.out.println("Cant saved to the database");
                e.printStackTrace();
            }
        }
    }

