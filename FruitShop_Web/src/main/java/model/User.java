package model;

public class User {
    private int id;
    private String fullname; // Đổi từ user_name sang fullname
    private String email;
    private String password;
    private int role;        // Đổi từ is_admin sang role

    public User() {
    }

    public User(String fullname, String email, String password, int role) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getter và Setter mới
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getRole() { return role; }
    public void setRole(int role) { this.role = role; }
}