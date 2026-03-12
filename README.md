# Quy Trình Làm Việc Nhóm - Dự án Fruitshop

Tài liệu này là quy định chính thức về cách nhóm phối hợp phát triển dự án Fruitshop (Java Web MVC, Tomcat, SQL Server - QuanLyGiaoVu).

## 1. Thông tin nhóm

- Phạm Nhật Khang: Leader, reviewer chính, người duyệt và merge.
- Phan Tín Thành: Developer.
- Nguyễn Trần Nhật Quân: Developer.

## 2. Chiến lược phân nhánh

### Chức năng từng nhánh

- main:
  - Chỉ chứa code release ổn định.
  - Không dùng để phát triển tính năng.
- develop:
  - Nhánh ghép code chung của cả nhóm.
  - Chỉ nhận code đã qua review.
- feature/<ten-chuc-nang> hoặc fix/<ten-loi>:
  - Nhánh cá nhân để phát triển task cụ thể.
  - Tạo mới từ develop.

### Quy tắc bắt buộc

- Tuyệt đối không ai được push trực tiếp lên main.
- Tuyệt đối không ai được push trực tiếp lên develop.
- Mọi thay đổi bắt buộc thông qua Pull Request.
- Chỉ Leader (Phạm Nhật Khang) được approve và merge vào develop.

## 3. Quy trình làm việc hằng ngày (Step-by-step)

Mỗi thành viên thực hiện đúng thứ tự sau:

1. Kéo code mới nhất từ develop.
2. Tạo nhánh mới từ develop theo task được giao.
3. Code trong nhánh cá nhân.
4. Tự test trước khi commit:
   - Build thành công.
   - Chức năng liên quan hoạt động đúng.
   - Không còn debug code/log tạm.
5. Commit theo chuẩn Conventional Commits.
6. Push nhánh lên GitHub.
7. Tạo Pull Request vào develop.
8. Gắn Leader review.
9. Chỉnh sửa theo comment review (nếu có).
10. Merge chỉ khi đủ điều kiện review và conflict đã được xử lý.

## 4. Quy ước đặt tên nhánh và commit

### Đặt tên nhánh

Mẫu dễ dùng:

- feat/shopping-cart
- feat/user-profile
- fix/login-error
- fix/order-total
- docs/workflow

Quy tắc:

- Viết thường, ngắn gọn, dùng dấu gạch ngang.
- Một nhánh chỉ xử lý một nhóm thay đổi liên quan.

### Conventional Commits

Cấu trúc:

```text
<type>(scope): <short description>
```

Type sử dụng:

- feat: thêm tính năng mới.
- fix: sửa lỗi.
- docs: cập nhật tài liệu.
- refactor: cải tổ code, không đổi hành vi.
- test: thêm/sửa test.
- chore: công việc cấu hình, bảo trì.
- style: format code, không đổi logic.

Ví dụ:

```text
feat(auth): add google login callback
fix(cart): correct quantity update logic
docs(readme): update team workflow
```

## 5. Quy trình Pull Request, Review và Merge

### Yêu cầu khi tạo Pull Request

Mỗi PR phải ghi rõ:

- Đã làm gì.
- Ảnh hưởng đến module nào.
- Cách test nhanh.
- Có thay đổi database hay không.

### Điều kiện merge vào develop

- Không còn conflict.
- Đã xử lý các comment quan trọng.
- Đã được Leader (Phạm Nhật Khang) review và approve.

## 6. Quy tắc đồng bộ database QuanLyGiaoVu (Bắt buộc)

Nếu thay đổi bảng/cột/ràng buộc dữ liệu, người thực hiện phải:

1. Tạo hoặc cập nhật file SQL migration trong thư mục database/ của dự án.
2. Đặt tên file có timestamp rõ ràng.
   - Ví dụ: 2026-03-12-add-order-status-column.sql
3. Mô tả rõ thay đổi DB trong Pull Request:
   - Bảng nào thay đổi.
   - Cột nào thêm/sửa/xóa.
   - Ảnh hưởng dữ liệu hiện tại.
   - Cách rollback (nếu có).
4. Thông báo cho cả nhóm trên kênh chung ngay khi mở PR.
5. Không merge code liên quan DB nếu chưa có file SQL đi kèm.
6. Thành viên khác phải pull code và chạy SQL migration trước khi tiếp tục code.

Nguyên tắc vàng:

- Không sửa CSDL âm thầm trên máy cá nhân mà không có file SQL.
- Không để tình trạng mỗi máy dùng một version schema khác nhau.

## 7. Quản lý task

Nhóm sử dụng GitHub Projects hoặc Trello với trạng thái tối thiểu:

- To Do
- In Progress
- In Review
- Done

Yêu cầu:

- Mỗi task phải có người phụ trách và deadline.
- Mỗi PR phải liên kết với task tương ứng.
- Cuối ngày, cập nhật trạng thái để Leader theo dõi tiến độ.

## 8. Checklist trước khi tạo PR

- Đã pull develop mới nhất.
- Đã tạo nhánh đúng quy ước.
- Build thành công.
- Commit đúng chuẩn.
- Có file SQL nếu có thay đổi DB.
- PR mô tả đầy đủ và đã gắn Leader review.
