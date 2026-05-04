import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // ==========================================================
    // 1. Chu vi hình chữ nhật
    // ==========================================================
    @Test
    void testChuVi_SoNguyenDuong() {
        assertEquals(16.0, Main.chuViHinhChuNhat(5, 3));
    }

    @Test
    void testChuVi_SoThuc() {
        assertEquals(8.0, Main.chuViHinhChuNhat(2.5, 1.5));
    }

    @Test
    void testChuVi_HinhVuong() {
        assertEquals(16.0, Main.chuViHinhChuNhat(4, 4));
    }

    @Test
    void testChuVi_GiaTriBienNho() {
        assertEquals(0.004, Main.chuViHinhChuNhat(0.001, 0.001), 1e-9);
    }

    @Test
    void testChuVi_GiaTriLon() {
        assertEquals(3000.0, Main.chuViHinhChuNhat(1000, 500));
    }

    // Không hợp lệ
    @Test
    void testChuVi_ChieuDaiBang0() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.chuViHinhChuNhat(0, 3));
    }

    @Test
    void testChuVi_ChieuRongAm() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.chuViHinhChuNhat(5, -1));
    }

    // ==========================================================
    // 2. Diện tích hình chữ nhật
    // ==========================================================
    @Test
    void testDienTich_SoNguyenDuong() {
        assertEquals(15.0, Main.dienTichHinhChuNhat(5, 3));
    }

    @Test
    void testDienTich_SoThuc() {
        assertEquals(10.0, Main.dienTichHinhChuNhat(2.5, 4.0));
    }

    @Test
    void testDienTich_HinhVuong() {
        assertEquals(36.0, Main.dienTichHinhChuNhat(6, 6));
    }

    @Test
    void testDienTich_GiaTriBienNho() {
        assertEquals(0.01, Main.dienTichHinhChuNhat(0.1, 0.1), 1e-9);
    }

    // Không hợp lệ
    @Test
    void testDienTich_ChieuDaiBang0() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.dienTichHinhChuNhat(0, 5));
    }

    @Test
    void testDienTich_GiaTriAm() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.dienTichHinhChuNhat(-3, 5));
    }

    // ==========================================================
    // 3. Giải phương trình bậc 2
    // ==========================================================
    @Test
    void testPTBac2_HaiNghiemPhanBiet() {
        String kq = Main.giaiPhuongTrinhBac2(1, -5, 6);
        assertTrue(kq.contains("2 nghiệm"));
    }

    @Test
    void testPTBac2_NghiemKep() {
        String kq = Main.giaiPhuongTrinhBac2(1, -2, 1);
        assertTrue(kq.contains("nghiệm kép"));
        assertTrue(kq.contains("1.0"));
    }

    @Test
    void testPTBac2_VoNghiem() {
        String kq = Main.giaiPhuongTrinhBac2(1, 0, 1);
        assertTrue(kq.contains("vô nghiệm"));
    }

    @Test
    void testPTBac2_DeltaBang0() {
        String kq = Main.giaiPhuongTrinhBac2(1, -4, 4);
        assertTrue(kq.contains("nghiệm kép"));
    }

    // Không hợp lệ
    @Test
    void testPTBac2_ABang0() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.giaiPhuongTrinhBac2(0, 2, 1));
    }

    // ==========================================================
    // 4. Số ngày trong tháng
    // ==========================================================
    @Test
    void testSoNgay_Thang31Ngay() {
        assertEquals(31, Main.soNgayTrongThang(1, 2023));
    }

    @Test
    void testSoNgay_Thang30Ngay() {
        assertEquals(30, Main.soNgayTrongThang(4, 2023));
    }

    @Test
    void testSoNgay_Thang2NamNhuan() {
        assertEquals(29, Main.soNgayTrongThang(2, 2024));
    }

    @Test
    void testSoNgay_Thang2KhongNhuan() {
        assertEquals(28, Main.soNgayTrongThang(2, 2023));
    }

    @Test
    void testSoNgay_BienThang1() {
        assertEquals(31, Main.soNgayTrongThang(1, 2023));
    }

    @Test
    void testSoNgay_BienThang12() {
        assertEquals(31, Main.soNgayTrongThang(12, 2023));
    }

    // Không hợp lệ
    @Test
    void testSoNgay_Thang0() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.soNgayTrongThang(0, 2023));
    }

    @Test
    void testSoNgay_Thang13() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.soNgayTrongThang(13, 2023));
    }

    @Test
    void testSoNgay_NamAm() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.soNgayTrongThang(1, -1));
    }

    // ==========================================================
    // 5. Kiểm tra số nguyên tố
    // ==========================================================
    @Test
    void testNguyenTo_So2() {
        assertTrue(Main.laSoNguyenTo(2));
    }

    @Test
    void testNguyenTo_So3() {
        assertTrue(Main.laSoNguyenTo(3));
    }

    @Test
    void testNguyenTo_So97() {
        assertTrue(Main.laSoNguyenTo(97));
    }

    @Test
    void testNguyenTo_So4() {
        assertFalse(Main.laSoNguyenTo(4));
    }

    @Test
    void testNguyenTo_So9() {
        assertFalse(Main.laSoNguyenTo(9));
    }

    @Test
    void testNguyenTo_BienDuoi_So1() {
        assertFalse(Main.laSoNguyenTo(1));
    }

    @Test
    void testNguyenTo_BienDuoi_So0() {
        assertFalse(Main.laSoNguyenTo(0));
    }

    @Test
    void testNguyenTo_SoAm() {
        assertFalse(Main.laSoNguyenTo(-7));
    }

    // ==========================================================
    // 6. Tổng xen kẽ S = 1 - 2 + 3 - 4 + ... + n
    // ==========================================================
    @Test
    void testTongXenKe_N1() {
        assertEquals(1, Main.tinhTongXenKe(1));
    }

    @Test
    void testTongXenKe_N2() {
        assertEquals(-1, Main.tinhTongXenKe(2)); // 1-2
    }

    @Test
    void testTongXenKe_N4() {
        assertEquals(-2, Main.tinhTongXenKe(4)); // 1-2+3-4
    }

    @Test
    void testTongXenKe_N5() {
        assertEquals(3, Main.tinhTongXenKe(5));  // 1-2+3-4+5
    }

    @Test
    void testTongXenKe_NChan_N100() {
        assertEquals(-50, Main.tinhTongXenKe(100));
    }

    // Không hợp lệ
    @Test
    void testTongXenKe_NBang0() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.tinhTongXenKe(0));
    }

    @Test
    void testTongXenKe_NAm() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.tinhTongXenKe(-3));
    }

    // ==========================================================
    // 7. UCLN
    // ==========================================================
    @Test
    void testUCLN_CoBan() {
        assertEquals(4, Main.ucln(12, 8));
    }

    @Test
    void testUCLN_NguyenToCungNhau() {
        assertEquals(1, Main.ucln(7, 13));
    }

    @Test
    void testUCLN_BLaUocCuaA() {
        assertEquals(5, Main.ucln(10, 5));
    }

    @Test
    void testUCLN_ABangB() {
        assertEquals(6, Main.ucln(6, 6));
    }

    @Test
    void testUCLN_MotSoLa1() {
        assertEquals(1, Main.ucln(1, 100));
    }

    // Không hợp lệ
    @Test
    void testUCLN_GiaTriBang0() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.ucln(0, 5));
    }

    @Test
    void testUCLN_GiaTriAm() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.ucln(-4, 8));
    }

    // ==========================================================
    // 8. Giai thừa & Tổng giai thừa
    // ==========================================================
    @Test
    void testGiaiThua_0() {
        assertEquals(1, Main.giaiThua(0));
    }

    @Test
    void testGiaiThua_1() {
        assertEquals(1, Main.giaiThua(1));
    }

    @Test
    void testGiaiThua_5() {
        assertEquals(120, Main.giaiThua(5));
    }

    @Test
    void testGiaiThua_Am() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.giaiThua(-1));
    }

    @Test
    void testTongGiaiThua_N1() {
        assertEquals(1, Main.tongGiaiThua(1));
    }

    @Test
    void testTongGiaiThua_N3() {
        assertEquals(9, Main.tongGiaiThua(3));   // 1!+2!+3! = 1+2+6
    }

    @Test
    void testTongGiaiThua_N4() {
        assertEquals(33, Main.tongGiaiThua(4));  // 1+2+6+24
    }

    @Test
    void testTongGiaiThua_NLon() {
        assertTrue(Main.tongGiaiThua(10) > 0);
    }

    // Không hợp lệ
    @Test
    void testTongGiaiThua_NBang0() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.tongGiaiThua(0));
    }

    @Test
    void testTongGiaiThua_NAm() {
        assertThrows(IllegalArgumentException.class,
            () -> Main.tongGiaiThua(-5));
    }
}

// Issue 1: Test cases cho du lieu hop le da duoc thiet ke va kiem tra
