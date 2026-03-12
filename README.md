# Fruitshop - Hệ thống Quản lý và Kinh doanh Trái Cây Trực Tuyến

<div align="center">

![Java](https://img.shields.io/badge/Java-EE-orange?style=for-the-badge&logo=openjdk)
![Tomcat](https://img.shields.io/badge/Apache%20Tomcat-10.x-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![SQL](https://img.shields.io/badge/Database-SQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-MVC%20%2B%20DAO-0A7EA4?style=for-the-badge)

</div>

## 📌 Mục lục

- [1. Giới thiệu dự án](#1-giới-thiệu-dự-án)
- [2. Tính năng nổi bật](#2-tính-năng-nổi-bật)
- [3. Kiến trúc và công nghệ](#3-kiến-trúc-và-công-nghệ)
- [4. Cấu trúc thư mục](#4-cấu-trúc-thư-mục)
- [5. Hướng dẫn cài đặt](#5-hướng-dẫn-cài-đặt)
- [6. Quy trình làm việc nhóm](#6-quy-trình-làm-việc-nhóm)
- [7. Đội ngũ phát triển](#7-đội-ngũ-phát-triển)
- [8. Giấy phép](#8-giấy-phép)

---

## 1. Giới thiệu dự án

**Fruitshop** là hệ thống thương mại điện tử chuyên về kinh doanh trái cây trực tuyến, hỗ trợ toàn bộ quy trình từ duyệt sản phẩm, đặt hàng, thanh toán đến quản trị vận hành và báo cáo doanh thu.

Dự án được xây dựng theo kiến trúc **MVC (Model - View - Controller)** kết hợp **DAO Pattern**, giúp tách biệt nghiệp vụ rõ ràng, dễ mở rộng và bảo trì trong môi trường phát triển nhóm.

### 🎯 Mục tiêu

- Số hóa quy trình mua bán trái cây trên nền tảng web.
- Nâng cao trải nghiệm mua sắm với các tính năng hiện đại (Google Login, OTP email, wishlist, review).
- Cung cấp bộ công cụ quản trị mạnh cho admin để vận hành và tối ưu doanh thu.

---

## 2. Tính năng nổi bật

### 👤 Dành cho Khách hàng (User)

- Đăng ký, đăng nhập tài khoản truyền thống.
- Đăng nhập bằng **Google OAuth 2.0**.
- Quên mật khẩu qua **Email OTP** (JavaMail).
- Xem danh sách sản phẩm, chi tiết sản phẩm.
- Thêm vào giỏ hàng, cập nhật số lượng, xóa sản phẩm.
- Đặt hàng và thanh toán.
- Quản lý **Danh sách yêu thích (Wishlist)**.
- Quản lý địa chỉ giao hàng.
- Theo dõi lịch sử đơn hàng và chi tiết đơn.
- Đánh giá sản phẩm (Review).

### 🛠️ Dành cho Quản trị viên (Admin)

- Dashboard thống kê tổng quan.
- Quản lý người dùng.
- Quản lý danh mục.
- Quản lý sản phẩm.
- Quản lý đơn hàng.
- Quản lý banner.
- Quản lý chương trình khuyến mãi cuối tuần (Weekend Deals).
- Quản lý bài viết/blog (CKEditor + CKFinder).
- Báo cáo doanh thu.

---

## 3. Kiến trúc và công nghệ

### 🧱 Mô hình kiến trúc

- **MVC**:
  - `Controller`: xử lý request/response (Servlet).
  - `Model`: biểu diễn dữ liệu và nghiệp vụ.
  - `View`: giao diện người dùng (JSP).
- **DAO Pattern**:
  - Tách riêng lớp truy cập dữ liệu (JDBC), giảm phụ thuộc giữa nghiệp vụ và database.

### ⚙️ Tech Stack

| Thành phần | Công nghệ |
|---|---|
| Backend | Java EE (Servlet, JSP), JDBC |
| Frontend | HTML, CSS, JavaScript, Bootstrap |
| Database | SQL (`QuanLyGiaoVu`) |
| Build Tool | Maven |
| Application Server | Apache Tomcat |
| Tích hợp bên thứ ba | Google OAuth 2.0, JavaMail, CKEditor, CKFinder |

---

## 4. Cấu trúc thư mục

```text
Fruitshop_Web/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/      # Servlet xử lý luồng user/admin
│   │   │   ├── dal/             # Data Access Layer (DAO, JDBC)
│   │   │   ├── model/           # Entity/DTO/domain models
│   │   │   └── util/            # Tiện ích dùng chung
│   │   ├── resources/
│   │   │   ├── db.properties    # Cấu hình kết nối CSDL
│   │   │   └── mail.properties  # Cấu hình gửi mail OTP
│   │   └── webapp/
│   │       ├── *.jsp            # View pages
│   │       ├── admin/           # Giao diện admin
│   │       ├── assets/          # CSS/JS/Image/Plugins
│   │       └── WEB-INF/         # Cấu hình web app
│   └── test/
└── target/
```

---

## 5. Hướng dẫn cài đặt

### 5.1 Yêu cầu môi trường

- JDK 8+ (khuyến nghị JDK 11)
- Apache Maven 3.8+
- Apache Tomcat 9/10 (tùy tương thích servlet API của dự án)
- Hệ quản trị CSDL SQL Server/MySQL (theo script dự án)
- IntelliJ IDEA (khuyến nghị bản Ultimate hoặc Community + cấu hình Tomcat)

### 5.2 Clone source code

```bash
git clone <REPO_URL>
cd Fruitshop_Web
```

### 5.3 Khởi tạo database `QuanLyGiaoVu`

1. Tạo database mới với tên: `QuanLyGiaoVu`.
2. Chạy file script SQL schema + seed data của dự án.
3. Kiểm tra các bảng chính đã được tạo thành công (users, products, orders, categories, ...).

> Gợi ý: đặt script trong thư mục riêng như `database/` để dễ quản lý phiên bản schema.

### 5.4 Cấu hình kết nối database

Cập nhật thông tin trong file `src/main/resources/db.properties`:

```properties
db.url=jdbc:YOUR_DB_URL
db.username=YOUR_USERNAME
db.password=YOUR_PASSWORD
db.driver=YOUR_DB_DRIVER
```

### 5.5 Cấu hình gửi email OTP

Cập nhật file `src/main/resources/mail.properties`:

```properties
mail.smtp.host=smtp.gmail.com
mail.smtp.port=587
mail.username=YOUR_EMAIL
mail.password=YOUR_APP_PASSWORD
mail.smtp.auth=true
mail.smtp.starttls.enable=true
```

### 5.6 Cấu hình Google OAuth 2.0

1. Tạo OAuth Client trên Google Cloud Console.
2. Khai báo Redirect URI trỏ về endpoint callback của dự án.
3. Cập nhật `client_id`, `client_secret`, `redirect_uri` theo cấu hình servlet đăng nhập Google.

### 5.7 Build dự án

```bash
mvn clean package
```

### 5.8 Chạy trên IntelliJ + Tomcat

1. Import dự án Maven vào IntelliJ.
2. Tạo cấu hình chạy Tomcat local.
3. Deploy artifact dạng `war exploded`.
4. Run server và truy cập địa chỉ webapp (ví dụ: `http://localhost:8080/Fruitshop_Web`).

---

## 6. Quy trình làm việc nhóm

### 🌿 Chiến lược nhánh

- `main`: nhánh ổn định, sẵn sàng phát hành.
- `develop`: nhánh tích hợp tính năng.
- `feature/<ten-tinh-nang>`: nhánh phát triển tính năng mới.
- `hotfix/<ten-loi>`: nhánh xử lý lỗi khẩn cấp.

### ✅ Quy ước commit (Conventional Commits)

Sử dụng cú pháp:

```text
<type>(scope): <short description>
```

Các `type` được dùng:

- `feat`: thêm tính năng mới
- `fix`: sửa lỗi
- `refactor`: tái cấu trúc code, không đổi hành vi
- `docs`: cập nhật tài liệu
- `style`: chỉnh format, không đổi logic
- `test`: thêm/sửa test
- `chore`: công việc bảo trì/cấu hình

Ví dụ:

```text
feat(auth): add google oauth login flow
fix(cart): correct quantity update when item exists
refactor(order): extract order validation service
docs(readme): update setup instructions for tomcat
```

### 🔁 Pull Request

- Mỗi tính năng/bugfix mở 1 PR riêng.
- PR cần mô tả rõ mục tiêu, phạm vi ảnh hưởng và cách test.
- Tối thiểu 1 thành viên review trước khi merge.

---

## 7. Đội ngũ phát triển

| Thành viên | Vai trò |
|---|---|
| Phạm Nhật Khang | Nhóm trưởng / Core Developer |
| Phan Tín Thành | Developer |
| Nguyễn Trần Nhật Quân | Developer |

---

## 8. Giấy phép

Hiện tại dự án chưa khai báo license chính thức.

Khuyến nghị thêm file `LICENSE` (ví dụ: MIT hoặc Apache-2.0) để thuận tiện khi chia sẻ mã nguồn công khai.
