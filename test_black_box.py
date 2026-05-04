import unittest
from main import (
    chu_vi_hinh_chu_nhat,
    dien_tich_hinh_chu_nhat,
    giai_phuong_trinh_bac2,
    so_ngay_trong_thang,
    la_so_nguyen_to,
    tinh_tong_xen_ke,
    ucln,
    giai_thua,
    tong_giai_thua,
)


# ============================================================
# 1. Chu vi hình chữ nhật
# ============================================================
class TestChuViHinhChuNhat(unittest.TestCase):

    # --- Dữ liệu hợp lệ ---
    def test_so_nguyen_duong(self):
        self.assertEqual(chu_vi_hinh_chu_nhat(5, 3), 16)

    def test_so_thuc_duong(self):
        self.assertAlmostEqual(chu_vi_hinh_chu_nhat(2.5, 1.5), 8.0)

    def test_hinh_vuong(self):
        self.assertEqual(chu_vi_hinh_chu_nhat(4, 4), 16)

    # Giá trị biên
    def test_gia_tri_bien_nho(self):
        self.assertAlmostEqual(chu_vi_hinh_chu_nhat(0.001, 0.001), 0.004)

    def test_gia_tri_lon(self):
        self.assertEqual(chu_vi_hinh_chu_nhat(1000, 500), 3000)

    # --- Dữ liệu không hợp lệ ---
    def test_chieu_dai_bang_0(self):
        with self.assertRaises(ValueError):
            chu_vi_hinh_chu_nhat(0, 3)

    def test_chieu_rong_am(self):
        with self.assertRaises(ValueError):
            chu_vi_hinh_chu_nhat(5, -1)

    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            chu_vi_hinh_chu_nhat("5", 3)


# ============================================================
# 2. Diện tích hình chữ nhật
# ============================================================
class TestDienTichHinhChuNhat(unittest.TestCase):

    def test_so_nguyen_duong(self):
        self.assertEqual(dien_tich_hinh_chu_nhat(5, 3), 15)

    def test_so_thuc(self):
        self.assertAlmostEqual(dien_tich_hinh_chu_nhat(2.5, 4.0), 10.0)

    def test_hinh_vuong(self):
        self.assertEqual(dien_tich_hinh_chu_nhat(6, 6), 36)

    # Giá trị biên
    def test_gia_tri_bien_nho(self):
        self.assertAlmostEqual(dien_tich_hinh_chu_nhat(0.1, 0.1), 0.01)

    # Không hợp lệ
    def test_chieu_dai_bang_0(self):
        with self.assertRaises(ValueError):
            dien_tich_hinh_chu_nhat(0, 5)

    def test_gia_tri_am(self):
        with self.assertRaises(ValueError):
            dien_tich_hinh_chu_nhat(-3, 5)

    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            dien_tich_hinh_chu_nhat(None, 5)


# ============================================================
# 3. Giải phương trình bậc 2
# ============================================================
class TestGiaiPhuongTrinhBac2(unittest.TestCase):

    def test_hai_nghiem_phan_biet(self):
        ket_qua = giai_phuong_trinh_bac2(1, -5, 6)
        self.assertIn("2 nghiệm", ket_qua)

    def test_nghiem_kep(self):
        ket_qua = giai_phuong_trinh_bac2(1, -2, 1)
        self.assertIn("nghiệm kép", ket_qua)
        self.assertIn("1.0", ket_qua)

    def test_vo_nghiem(self):
        ket_qua = giai_phuong_trinh_bac2(1, 0, 1)
        self.assertIn("vô nghiệm", ket_qua)

    # Giá trị biên delta = 0
    def test_delta_bang_0(self):
        ket_qua = giai_phuong_trinh_bac2(1, -4, 4)
        self.assertIn("nghiệm kép", ket_qua)

    # Không hợp lệ
    def test_a_bang_0(self):
        with self.assertRaises(ValueError):
            giai_phuong_trinh_bac2(0, 2, 1)

    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            giai_phuong_trinh_bac2("a", 1, 1)


# ============================================================
# 4. Số ngày trong tháng
# ============================================================
class TestSoNgayTrongThang(unittest.TestCase):

    def test_thang_co_31_ngay(self):
        self.assertEqual(so_ngay_trong_thang(1, 2023), 31)

    def test_thang_co_30_ngay(self):
        self.assertEqual(so_ngay_trong_thang(4, 2023), 30)

    def test_thang_2_nam_nhuan(self):
        self.assertEqual(so_ngay_trong_thang(2, 2024), 29)

    def test_thang_2_khong_nhuan(self):
        self.assertEqual(so_ngay_trong_thang(2, 2023), 28)

    # Giá trị biên tháng
    def test_thang_1(self):
        self.assertEqual(so_ngay_trong_thang(1, 2023), 31)

    def test_thang_12(self):
        self.assertEqual(so_ngay_trong_thang(12, 2023), 31)

    # Không hợp lệ
    def test_thang_0(self):
        with self.assertRaises(ValueError):
            so_ngay_trong_thang(0, 2023)

    def test_thang_13(self):
        with self.assertRaises(ValueError):
            so_ngay_trong_thang(13, 2023)

    def test_nam_am(self):
        with self.assertRaises(ValueError):
            so_ngay_trong_thang(1, -1)

    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            so_ngay_trong_thang("Jan", 2023)


# ============================================================
# 5. Kiểm tra số nguyên tố
# ============================================================
class TestLaSoNguyenTo(unittest.TestCase):

    def test_so_nguyen_to_nho(self):
        self.assertTrue(la_so_nguyen_to(2))
        self.assertTrue(la_so_nguyen_to(3))
        self.assertTrue(la_so_nguyen_to(5))

    def test_so_khong_nguyen_to(self):
        self.assertFalse(la_so_nguyen_to(4))
        self.assertFalse(la_so_nguyen_to(9))

    def test_so_nguyen_to_lon(self):
        self.assertTrue(la_so_nguyen_to(97))

    # Giá trị biên
    def test_bien_duoi_n_1(self):
        self.assertFalse(la_so_nguyen_to(1))

    def test_bien_duoi_n_0(self):
        self.assertFalse(la_so_nguyen_to(0))

    def test_so_am(self):
        self.assertFalse(la_so_nguyen_to(-7))

    # Không hợp lệ
    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            la_so_nguyen_to(3.5)


# ============================================================
# 6. Tổng xen kẽ S = 1 - 2 + 3 - 4 + ... + n
# ============================================================
class TestTinhTongXenKe(unittest.TestCase):

    def test_n_1(self):
        self.assertEqual(tinh_tong_xen_ke(1), 1)

    def test_n_2(self):
        self.assertEqual(tinh_tong_xen_ke(2), -1)  # 1 - 2

    def test_n_4(self):
        self.assertEqual(tinh_tong_xen_ke(4), -2)  # 1-2+3-4

    def test_n_5(self):
        self.assertEqual(tinh_tong_xen_ke(5), 3)   # 1-2+3-4+5

    # Giá trị biên
    def test_n_lon(self):
        # n chẵn: S = -n/2
        self.assertEqual(tinh_tong_xen_ke(100), -50)

    # Không hợp lệ
    def test_n_bang_0(self):
        with self.assertRaises(ValueError):
            tinh_tong_xen_ke(0)

    def test_n_am(self):
        with self.assertRaises(ValueError):
            tinh_tong_xen_ke(-3)

    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            tinh_tong_xen_ke(2.5)


# ============================================================
# 7. Tìm UCLN
# ============================================================
class TestUCLN(unittest.TestCase):

    def test_ucln_co_ban(self):
        self.assertEqual(ucln(12, 8), 4)

    def test_ucln_nguyen_to_cung_nhau(self):
        self.assertEqual(ucln(7, 13), 1)

    def test_ucln_bang_so_nho_hon(self):
        self.assertEqual(ucln(10, 5), 5)

    def test_ucln_bang_nhau(self):
        self.assertEqual(ucln(6, 6), 6)

    # Giá trị biên
    def test_mot_so_la_1(self):
        self.assertEqual(ucln(1, 100), 1)

    # Không hợp lệ
    def test_gia_tri_0(self):
        with self.assertRaises(ValueError):
            ucln(0, 5)

    def test_gia_tri_am(self):
        with self.assertRaises(ValueError):
            ucln(-4, 8)

    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            ucln(4.5, 3)


# ============================================================
# 8. Giai thừa và tổng S = 1! + 2! + ... + n!
# ============================================================
class TestGiaiThua(unittest.TestCase):

    def test_giai_thua_0(self):
        self.assertEqual(giai_thua(0), 1)

    def test_giai_thua_1(self):
        self.assertEqual(giai_thua(1), 1)

    def test_giai_thua_5(self):
        self.assertEqual(giai_thua(5), 120)

    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            giai_thua(3.5)

    def test_am(self):
        with self.assertRaises(ValueError):
            giai_thua(-1)


class TestTongGiaiThua(unittest.TestCase):

    def test_n_1(self):
        self.assertEqual(tong_giai_thua(1), 1)   # 1!

    def test_n_3(self):
        self.assertEqual(tong_giai_thua(3), 9)   # 1! + 2! + 3! = 1+2+6

    def test_n_4(self):
        self.assertEqual(tong_giai_thua(4), 33)  # 1+2+6+24

    # Giá trị biên
    def test_n_lon(self):
        # Chỉ kiểm tra không raise lỗi và kết quả dương
        ket_qua = tong_giai_thua(10)
        self.assertGreater(ket_qua, 0)

    # Không hợp lệ
    def test_n_bang_0(self):
        with self.assertRaises(ValueError):
            tong_giai_thua(0)

    def test_n_am(self):
        with self.assertRaises(ValueError):
            tong_giai_thua(-5)

    def test_kieu_du_lieu_sai(self):
        with self.assertRaises(TypeError):
            tong_giai_thua(2.5)


if __name__ == "__main__":
    unittest.main(verbosity=2)
