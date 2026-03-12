# Quy Trinh Lam Viec Nhom - Du an Fruitshop

Tai lieu nay la quy dinh chinh thuc ve cach nhom phoi hop phat trien du an Fruitshop (Java Web MVC, Tomcat, SQL Server - QuanLyGiaoVu).

## 1. Thong tin nhom

- Pham Nhat Khang: Leader, reviewer chinh, nguoi duyet va merge.
- Phan Tin Thanh: Developer.
- Nguyen Tran Nhat Quan: Developer.

## 2. Branching Strategy

### Chuc nang tung nhanh

- main:
  - Chi chua code release on dinh.
  - Khong dung de phat trien tinh nang.
- develop:
  - Nhanh ghep code chung cua ca nhom.
  - Chi nhan code da qua review.
- feature/<ten-chuc-nang> hoac fix/<ten-loi>:
  - Nhanh ca nhan de phat trien task cu the.
  - Tao moi tu develop.

### Quy tac bat buoc

- Tuyet doi khong ai duoc push truc tiep len main.
- Tuyet doi khong ai duoc push truc tiep len develop.
- Moi thay doi bat buoc thong qua Pull Request.
- Chi Leader (Pham Nhat Khang) duoc approve va merge vao develop.

## 3. Daily Workflow (Step-by-step)

Moi thanh vien thuc hien dung thu tu sau:

1. Keo code moi nhat tu develop.
2. Tao nhanh moi tu develop theo task duoc giao.
3. Code trong nhanh ca nhan.
4. Tu test truoc khi commit:
   - Build thanh cong.
   - Chuc nang lien quan hoat dong dung.
   - Khong con debug code/log tam.
5. Commit theo chuan Conventional Commits.
6. Push nhanh len GitHub.
7. Tao Pull Request vao develop.
8. Gan Leader review.
9. Chinh sua theo comment review (neu co).
10. Merge chi khi du dieu kien review va conflict da duoc xu ly.

## 4. Quy uoc dat ten nhanh va commit

### Dat ten nhanh

Mau de dung:

- feat/shopping-cart
- feat/user-profile
- fix/login-error
- fix/order-total
- docs/workflow

Quy tac:

- Viet thuong, ngan gon, dung dau gach ngang.
- Mot nhanh chi xu ly mot nhom thay doi lien quan.

### Conventional Commits

Cau truc:

```text
<type>(scope): <short description>
```

Type su dung:

- feat: them tinh nang moi.
- fix: sua loi.
- docs: cap nhat tai lieu.
- refactor: cai to code, khong doi hanh vi.
- test: them/sua test.
- chore: cong viec cau hinh, bao tri.
- style: format code, khong doi logic.

Vi du:

```text
feat(auth): add google login callback
fix(cart): correct quantity update logic
docs(readme): update team workflow
```

## 5. Quy trinh Pull Request, Review va Merge

### Yeu cau khi tao Pull Request

Moi PR phai ghi ro:

- Da lam gi.
- Anh huong den module nao.
- Cach test nhanh.
- Co thay doi database hay khong.

### Dieu kien merge vao develop

- Khong con conflict.
- Da xu ly cac comment quan trong.
- Da duoc Leader (Pham Nhat Khang) review va approve.

## 6. Quy tac dong bo database QuanLyGiaoVu (Bat buoc)

Neu thay doi bang/cot/rang buoc du lieu, nguoi thuc hien phai:

1. Tao hoac cap nhat file SQL migration trong thu muc database/ cua du an.
2. Dat ten file co timestamp ro rang.
   - Vi du: 2026-03-12-add-order-status-column.sql
3. Mo ta ro thay doi DB trong Pull Request:
   - Bang nao thay doi.
   - Cot nao them/sua/xoa.
   - Anh huong du lieu hien tai.
   - Cach rollback (neu co).
4. Thong bao cho ca nhom tren kenh chung ngay khi mo PR.
5. Khong merge code lien quan DB neu chua co file SQL di kem.
6. Thanh vien khac phai pull code va chay SQL migration truoc khi tiep tuc code.

Nguyen tac vang:

- Khong sua CSDL am tham tren may ca nhan ma khong co file SQL.
- Khong de tinh trang moi may dung mot version schema khac nhau.

## 7. Quan ly task

 Nhom su dung GitHub Projects hoac Trello voi trang thai toi thieu:


Yeu cau:

- Moi task phai co nguoi phu trach va deadline.
- Moi PR phai lien ket voi task tuong ung.
- Cuoi ngay, cap nhat trang thai de Leader theo doi tien do.

## 8. Checklist truoc khi tao PR

- Da pull develop moi nhat.
- Da tao nhanh dung quy uoc.
- Build thanh cong.
- Commit dung chuan.
- Co file SQL neu co thay doi DB.
- PR mo ta day du va da gan Leader review.
