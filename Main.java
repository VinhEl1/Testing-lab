public class Main {

    // =========================================================
    // 1. Tính chu vi hình chữ nhật
    // =========================================================
    public static double chuViHinhChuNhat(double dai, double rong) {
        if (dai <= 0 || rong <= 0) {
            throw new IllegalArgumentException("Chiều dài và chiều rộng phải lớn hơn 0.");
        }
        return 2 * (dai + rong);
    }

    // =========================================================
    // 2. Tính diện tích hình chữ nhật
    // =========================================================
    public static double dienTichHinhChuNhat(double dai, double rong) {
        if (dai <= 0 || rong <= 0) {
            throw new IllegalArgumentException("Chiều dài và chiều rộng phải lớn hơn 0.");
        }
        return dai * rong;
    }

    // =========================================================
    // 3. Giải phương trình bậc 2: ax^2 + bx + c = 0
    // =========================================================
    public static String giaiPhuongTrinhBac2(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("a không được bằng 0 (không phải phương trình bậc 2).");
        }
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return "Phương trình vô nghiệm";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Phương trình có nghiệm kép: x = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2;
        }
    }

    // =========================================================
    // 4. Tính số ngày trong tháng
    // =========================================================
    public static int soNgayTrongThang(int thang, int nam) {
        if (thang < 1 || thang > 12) {
            throw new IllegalArgumentException("Tháng phải từ 1 đến 12.");
        }
        if (nam <= 0) {
            throw new IllegalArgumentException("Năm phải lớn hơn 0.");
        }
        boolean namNhuan = (nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0);
        int[] soNgay = {0, 31, namNhuan ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return soNgay[thang];
    }

    // =========================================================
    // 5. Kiểm tra số nguyên tố
    // =========================================================
    public static boolean laSoNguyenTo(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // =========================================================
    // 6. Tính tổng S = 1 - 2 + 3 - 4 + ... + n
    // =========================================================
    public static int tinhTongXenKe(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n phải lớn hơn 0.");
        }
        int tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += (i % 2 == 0) ? -i : i;
        }
        return tong;
    }

    // =========================================================
    // 7. Tìm UCLN của a và b (Thuật toán Euclid)
    // =========================================================
    public static int ucln(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("a và b phải lớn hơn 0.");
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // =========================================================
    // 8a. Tính giai thừa n!
    // =========================================================
    public static long giaiThua(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n phải >= 0.");
        }
        long ketQua = 1;
        for (int i = 1; i <= n; i++) {
            ketQua *= i;
        }
        return ketQua;
    }

    // =========================================================
    // 8b. Tính tổng S = 1! + 2! + 3! + ... + n!
    // =========================================================
    public static long tongGiaiThua(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n phải lớn hơn 0.");
        }
        long tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += giaiThua(i);
        }
        return tong;
    }

    // =========================================================
    // Main – chạy thử minh họa
    // =========================================================
    public static void main(String[] args) {
        System.out.println("=== 1. Chu vi hình chữ nhật (5, 3) = " + chuViHinhChuNhat(5, 3));
        System.out.println("=== 2. Diện tích hình chữ nhật (5, 3) = " + dienTichHinhChuNhat(5, 3));
        System.out.println("=== 3. PT bậc 2 (1,-5,6): " + giaiPhuongTrinhBac2(1, -5, 6));
        System.out.println("=== 4. Số ngày tháng 2/2024: " + soNgayTrongThang(2, 2024));
        System.out.println("=== 5. 7 là số nguyên tố? " + laSoNguyenTo(7));
        System.out.println("=== 6. Tổng xen kẽ n=5: " + tinhTongXenKe(5));
        System.out.println("=== 7. UCLN(12, 8) = " + ucln(12, 8));
        System.out.println("=== 8. Tổng giai thừa n=4: " + tongGiaiThua(4));
    }
}
