package controller;

import dal.UserDAO;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
// ... import giữ nguyên
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Form login gửi name="user" - dùng làm email để check
        String email = request.getParameter("user");
        String pass = request.getParameter("pass");

        // Validate input
        if (email == null || email.trim().isEmpty() || pass == null || pass.trim().isEmpty()) {
            request.setAttribute("error", "Email/tên đăng nhập và mật khẩu không được để trống!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        UserDAO dao = new UserDAO();
        User account = dao.checkLogin(email, pass);

        if (account == null) {
            request.setAttribute("error", "Email/tên đăng nhập hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            response.sendRedirect("index.jsp");
        }
    }
}