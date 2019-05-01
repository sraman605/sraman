package Controller.Auth;

import Data.LoginData;
import Data.UserData;
import Model.UserModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    private UserData doesUserExist;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserModel usermodel = new UserModel();

        try {
            ResultSet user = usermodel.loginUser(email, password);
            if (user.next()) {
                int userId = user.getInt("id");
                String userName = user.getString("name");

                HttpSession session = req.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("uname", userName);
                resp.sendRedirect("/");
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    }

