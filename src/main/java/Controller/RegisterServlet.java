package Controller;

import Data.UserData;
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

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email =req.getParameter("email");
        String phoneno=req.getParameter("phoneno");
        String password =req.getParameter("password");

        UserData userData=new UserData(name,email,phoneno,password);
        userData.setName(name);
        userData.setEmail(email);
        userData.setPhoneNo(phoneno);
        userData.setPassword(password);

        UserModel  um = new UserModel();


        try {
            if(um.insertIntoDatabase(userData) > 0){
                HttpSession session = req.getSession();
                session.setAttribute("uname",userData.getName());
                if(um.getUserIdFromEmail(userData.getEmail()) != 0 ) {
                    session.setAttribute("userId",um.getUserIdFromEmail(userData.getEmail()));
                }
                RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                rd.forward(req,resp);
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
