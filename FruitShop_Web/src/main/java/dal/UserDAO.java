package dal;

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // 1. Kiểm tra Email đã tồn tại chưa (Dùng email làm định danh duy nhất)
    public boolean checkExist(String email) {
        try {
            String query = "SELECT * FROM users WHERE email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("⚠️ Email " + email + " đã tồn tại trong hệ thống.");
                return true; // Email này đã có người dùng rồi
            } else {
                System.out.println("✅ Email " + email + " chưa tồn tại, có thể đăng ký.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi checkExist: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // 2. Đăng ký tài khoản (Lưu vào cột fullname, role...)
    public void signup(String fullname, String email, String password) {
        try {
            // Sử dụng DEFAULT values từ database schema
            String query = "INSERT INTO users (fullname, email, password) VALUES (?, ?, ?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, password);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("✅ Đăng ký thành công! Dữ liệu đã được lưu vào database.");
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi Signup: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 3. Hàm Đăng nhập (Dùng Email và Password để khớp với lúc đăng ký)
    public User checkLogin(String email, String password) {
        User u = null;
        try {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Tạo đối tượng User từ dữ liệu lấy được
                u = new User();
                u.setId(rs.getInt("id"));
                u.setFullname(rs.getString("fullname"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getInt("role"));
                System.out.println("✅ Đăng nhập thành công! User: " + u.getFullname());
            } else {
                System.out.println("❌ Email hoặc mật khẩu không đúng.");
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi checkLogin: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return u;
    }
}