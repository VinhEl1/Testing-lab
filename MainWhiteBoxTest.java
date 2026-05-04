import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * KIỂM THỬ HỘP TRẮNG – White-box Testing
 * Mục tiêu: 100% Statement Coverage + 100% Branch Coverage
 *
 * Với mỗi hàm, phân tích các nhánh điều kiện, vòng lặp, đường đi logic
 * rồi thiết kế test case để đi qua tất cả các nhánh đó.
 */
public class MainWhiteBoxTest {

    // ==========================================================
    // BÀI 1 – Chu vi hình chữ nhật
    // ----------------------------------------------------------
    // Phân tích nhánh:
    //   [N1] if (dai <= 0 || rong <= 0) → TRUE  → throw exception
    //   [N2] if (dai <= 0 || rong <= 0) → FALSE → return 2*(dai+rong)
    // ==========================================================

    @Test
    void wb_ChuVi_N1_DaiAm() {
        // Nhánh N1: dai <= 0 → TRUE
        assertThrows(IllegalArgumentException.class,
            () -> Main.chuViHinhChuNhat(-1, 3));
    }

    @Test
    void wb_ChuVi_N1_RongBang0() {
        // Nhánh N1: rong <= 0 → TRUE
        assertThrows(IllegalArgumentException.class,
            () -> Main.chuViHinhChuNhat(5, 0));
    }

    @Test
    void wb_ChuVi_N2_HopLe() {
        // Nhánh N2: cả hai > 0 → tính chu vi
        assertEquals(16.0, Main.chuViHinhChuNhat(5, 3));
    }

    // ==========================================================
    // BÀI 2 – Diện tích hình chữ nhật
    // ----------------------------------------------------------
    // Phân tích nhánh:
    //   [N1] if (dai <= 0 || rong <= 0) → TRUE  → throw exception
    //   [N2] if (dai <= 0 || rong <= 0) → FALSE → return dai*rong
    // ==========================================================

    @Test
    void wb_DienTich_N1_RongAm() {
        // Nhánh N1: rong <= 0 → TRUE
        assertThrows(IllegalArgumentException.class,
            () -> Main.dienTichHinhChuNhat(5, -2));
    }

    @Test
    void wb_DienTich_N1_DaiBang0() {
        // Nhánh N1: dai <= 0 → TRUE
        assertThrows(IllegalArgumentException.class,
            () -> Main.dienTichHinhChuNhat(0, 4));
    }

    @Test
    void wb_DienTich_N2_HopLe() {
        // Nhánh N2: cả hai > 0 → tính diện tích
        assertEquals(15.0, Main.dienTichHinhChuNhat(5, 3));
    }

    // ==========================================================
    // BÀI 3 – Giải phương trình bậc 2
    // ----------------------------------------------------------
    // Phân tích nhánh:
    //   [N1] if (a == 0)      → TRUE  → throw exception
    //   [N2] if (delta < 0)   → TRUE  → vô nghiệm
    //   [N3] if (delta == 0)  → TRUE  → nghiệm kép   (biên delta)
    //   [N4] else (delta > 0) → FALSE → 2 nghiệm phân biệt
    // ==========================================================

    @Test
    void wb_PT_N1_ABang0() {
        // Nhánh N1: a=0 → throw exception
        assertThrows(IllegalArgumentException.class,
            () -> Main.giaiPhuongTrinhBac2(0, 3, 1));
    }

    @Test
    void wb_PT_N2_DeltaAm() {
        // Nhánh N2: delta < 0 → vô nghiệm
        // a=1, b=0, c=1 → delta = 0 - 4 = -4
        String kq = Main.giaiPhuongTrinhBac2(1, 0, 1);
        assertTrue(kq.contains("vô nghiệm"));
    }

    @Test
    void wb_PT_N3_DeltaBang0() {
        // Nhánh N3: delta = 0 → nghiệm kép (ĐƯỜNG ĐI BIÊN)
        // a=1, b=-2, c=1 → delta = 4 - 4 = 0
        String kq = Main.giaiPhuongTrinhBac2(1, -2, 1);
        assertTrue(kq.contains("nghiệm kép"));
        assertTrue(kq.contains("1.0"));
    }

    @Test
    void wb_PT_N4_DeltaDuong() {
        // Nhánh N4: delta > 0 → 2 nghiệm
        // a=1, b=-5, c=6 → delta = 25 - 24 = 1
        String kq = Main.giaiPhuongTrinhBac2(1, -5, 6);
        assertTrue(kq.contains("2 nghiệm"));
    }

    // ==========================================================
    // BÀI 4 – Số ngày trong tháng
    // ----------------------------------------------------------
    // Phân tích nhánh:
    //   [N1] if (thang < 1 || thang > 12) → TRUE  → throw
    //   [N2] if (nam <= 0)                → TRUE  → throw
    //   [N3] namNhuan = true  (nam%4==0 && nam%100!=0) → 29 ngày
    //   [N4] namNhuan = true  (nam%400==0)             → 29 ngày
    //   [N5] namNhuan = false                          → 28 ngày
    //   [N6] Tháng 31 ngày (1,3,5,7,8,10,12)
    //   [N7] Tháng 30 ngày (4,6,9,11)
    // ==========================================================

    @Test
    void wb_NgayThang_N1_ThangNhoHon1() {
        // Nhánh N1: thang < 1
        assertThrows(IllegalArgumentException.class,
            () -> Main.soNgayTrongThang(0, 2023));
    }

    @Test
    void wb_NgayThang_N1_ThangLonHon12() {
        // Nhánh N1: thang > 12
        assertThrows(IllegalArgumentException.class,
            () -> Main.soNgayTrongThang(13, 2023));
    }

    @Test
    void wb_NgayThang_N2_NamAm() {
        // Nhánh N2: nam <= 0
        assertThrows(IllegalArgumentException.class,
            () -> Main.soNgayTrongThang(1, 0));
    }

    @Test
    void wb_NgayThang_N3_NamNhuan_ChiaChet4KhongChia100() {
        // Nhánh N3: năm nhuận thường (2024 % 4 == 0, 2024 % 100 != 0)
        assertEquals(29, Main.soNgayTrongThang(2, 2024));
    }

    @Test
    void wb_NgayThang_N4_NamNhuan_ChiaChet400() {
        // Nhánh N4: năm nhuận đặc biệt (2000 % 400 == 0)
        assertEquals(29, Main.soNgayTrongThang(2, 2000));
    }

    @Test
    void wb_NgayThang_N5_NamKhongNhuan_ChiaChet100KhongChia400() {
        // Nhánh N5: không nhuận (1900 % 100 == 0 nhưng 1900 % 400 != 0)
        assertEquals(28, Main.soNgayTrongThang(2, 1900));
    }

    @Test
    void wb_NgayThang_N6_Thang31Ngay() {
        // Nhánh N6: tháng có 31 ngày
        assertEquals(31, Main.soNgayTrongThang(7, 2023));
    }

    @Test
    void wb_NgayThang_N7_Thang30Ngay() {
        // Nhánh N7: tháng có 30 ngày
        assertEquals(30, Main.soNgayTrongThang(9, 2023));
    }

    // ==========================================================
    // BÀI 5 – Kiểm tra số nguyên tố
    // ----------------------------------------------------------
    // Phân tích nhánh + vòng lặp:
    //   [N1] if (n < 2)        → TRUE  → return false
    //   [N2] if (n == 2)       → TRUE  → return true
    //   [N3] if (n % 2 == 0)   → TRUE  → return false (n chẵn > 2)
    //   [N4] Vòng lặp for: chạy 0 lần (n=3 → sqrt(3)<3)
    //   [N5] Vòng lặp for: if(n%i==0) → TRUE → return false (tìm thấy ước)
    //   [N6] Vòng lặp for: chạy hết → return true (không có ước)
    // ==========================================================

    @Test
    void wb_NguyenTo_N1_NNhoHon2() {
        // Nhánh N1: n < 2 → false
        assertFalse(Main.laSoNguyenTo(1));
        assertFalse(Main.laSoNguyenTo(-5));
    }

    @Test
    void wb_NguyenTo_N2_NBang2() {
        // Nhánh N2: n == 2 → true (số nguyên tố chẵn duy nhất)
        assertTrue(Main.laSoNguyenTo(2));
    }

    @Test
    void wb_NguyenTo_N3_NChanLonHon2() {
        // Nhánh N3: n % 2 == 0 và n > 2 → false
        assertFalse(Main.laSoNguyenTo(8));
    }

    @Test
    void wb_NguyenTo_N4_VongLap0Lan() {
        // Nhánh N4: vòng lặp chạy 0 lần → n=3 là nguyên tố
        assertTrue(Main.laSoNguyenTo(3));
    }

    @Test
    void wb_NguyenTo_N5_TimThayUoc() {
        // Nhánh N5: vòng lặp tìm thấy ước → n=9 (9%3==0)
        assertFalse(Main.laSoNguyenTo(9));
    }

    @Test
    void wb_NguyenTo_N6_KhongCoUoc() {
        // Nhánh N6: vòng lặp chạy hết, không tìm thấy ước → true
        assertTrue(Main.laSoNguyenTo(13));
    }

    // ==========================================================
    // BÀI 6 – Tổng xen kẽ S = 1 - 2 + 3 - ... + n
    // ----------------------------------------------------------
    // Phân tích nhánh + vòng lặp:
    //   [N1] if (n <= 0)         → TRUE  → throw exception
    //   [N2] Vòng lặp: i%2==0   → TRUE  → tong -= i
    //   [N3] Vòng lặp: i%2==0   → FALSE → tong += i
    // ==========================================================

    @Test
    void wb_TongXenKe_N1_NBang0() {
        // Nhánh N1: n <= 0 → throw
        assertThrows(IllegalArgumentException.class,
            () -> Main.tinhTongXenKe(0));
    }

    @Test
    void wb_TongXenKe_N2_iChan() {
        // Nhánh N2: i chẵn → tong -= i
        // n=2: i=1(+1) i=2(-2) → tong = -1
        assertEquals(-1, Main.tinhTongXenKe(2));
    }

    @Test
    void wb_TongXenKe_N3_iLe() {
        // Nhánh N3: i lẻ → tong += i
        // n=1: i=1(+1) → tong = 1
        assertEquals(1, Main.tinhTongXenKe(1));
    }

    @Test
    void wb_TongXenKe_CaHaiNhanh() {
        // Cả nhánh N2 và N3 đều được đi qua khi n >= 2
        // n=4: 1-2+3-4 = -2
        assertEquals(-2, Main.tinhTongXenKe(4));
    }

    // ==========================================================
    // BÀI 7 – Tìm UCLN
    // ----------------------------------------------------------
    // Phân tích nhánh + vòng lặp:
    //   [N1] if (a <= 0 || b <= 0) → TRUE  → throw exception
    //   [N2] while (b != 0)        → FALSE ngay (b=0 không xảy ra vì đã check > 0)
    //   [N3] while (b != 0)        → TRUE  → chạy 1 lần (b là ước của a)
    //   [N4] while (b != 0)        → TRUE  → chạy nhiều lần
    // ==========================================================

    @Test
    void wb_UCLN_N1_ABang0() {
        // Nhánh N1: a <= 0 → throw
        assertThrows(IllegalArgumentException.class,
            () -> Main.ucln(0, 5));
    }

    @Test
    void wb_UCLN_N1_BAm() {
        // Nhánh N1: b <= 0 → throw
        assertThrows(IllegalArgumentException.class,
            () -> Main.ucln(5, -1));
    }

    @Test
    void wb_UCLN_N3_VongLap1Lan() {
        // Nhánh N3: vòng lặp 1 lần (b là ước của a → a%b = 0 ngay)
        // ucln(10, 5): lần 1: a=5, b=0 → dừng → kết quả 5
        assertEquals(5, Main.ucln(10, 5));
    }

    @Test
    void wb_UCLN_N4_VongLapNhieuLan() {
        // Nhánh N4: vòng lặp nhiều lần
        // ucln(12, 8): 12%8=4 → ucln(8,4): 8%4=0 → dừng → kết quả 4
        assertEquals(4, Main.ucln(12, 8));
    }

    @Test
    void wb_UCLN_ABangB() {
        // Trường hợp đặc biệt: a = b → UCLN = a
        assertEquals(7, Main.ucln(7, 7));
    }

    // ==========================================================
    // BÀI 8 – Giai thừa & Tổng giai thừa
    // ----------------------------------------------------------
    // Phân tích nhánh + vòng lặp giaiThua(n):
    //   [N1] if (n < 0)         → TRUE  → throw
    //   [N2] Vòng lặp: 0 lần   → n=0   → return 1
    //   [N3] Vòng lặp: 1 lần   → n=1   → return 1
    //   [N4] Vòng lặp: nhiều lần → n>1 → nhân dần
    //
    // Phân tích nhánh tongGiaiThua(n):
    //   [N5] if (n <= 0)        → TRUE  → throw
    //   [N6] Vòng lặp: 1 lần   → n=1   → return 1!
    //   [N7] Vòng lặp: nhiều lần → n>1 → cộng dần
    // ==========================================================

    @Test
    void wb_GiaiThua_N1_NAm() {
        // Nhánh N1: n < 0 → throw
        assertThrows(IllegalArgumentException.class,
            () -> Main.giaiThua(-3));
    }

    @Test
    void wb_GiaiThua_N2_VongLap0Lan() {
        // Nhánh N2: n=0, vòng lặp không chạy → return 1
        assertEquals(1, Main.giaiThua(0));
    }

    @Test
    void wb_GiaiThua_N3_VongLap1Lan() {
        // Nhánh N3: n=1, vòng lặp chạy 1 lần
        assertEquals(1, Main.giaiThua(1));
    }

    @Test
    void wb_GiaiThua_N4_VongLapNhieuLan() {
        // Nhánh N4: n=5, vòng lặp 5 lần
        assertEquals(120, Main.giaiThua(5));
    }

    @Test
    void wb_TongGiaiThua_N5_NBang0() {
        // Nhánh N5: n <= 0 → throw
        assertThrows(IllegalArgumentException.class,
            () -> Main.tongGiaiThua(0));
    }

    @Test
    void wb_TongGiaiThua_N6_VongLap1Lan() {
        // Nhánh N6: n=1 → 1! = 1
        assertEquals(1, Main.tongGiaiThua(1));
    }

    @Test
    void wb_TongGiaiThua_N7_VongLapNhieuLan() {
        // Nhánh N7: n=4 → 1!+2!+3!+4! = 1+2+6+24 = 33
        assertEquals(33, Main.tongGiaiThua(4));
    }
}
