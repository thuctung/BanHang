use PTMPCN;
SELECT * FROM DonHang, ThongTinNguoiMuaHang where ThongTinNguoiMuaHang.sodienthoai = DonHang.sodienthoai EXCEPT Select sodienthoai from ThongTinNguoiMuaHang;