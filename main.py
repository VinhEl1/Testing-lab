import math


# 1. Tính chu vi hình chữ nhật
def chu_vi_hinh_chu_nhat(dai, rong):
    if not (isinstance(dai, (int, float)) and isinstance(rong, (int, float))):
        raise TypeError("Chiều dài và chiều rộng phải là số.")
    if dai <= 0 or rong <= 0:
        raise ValueError("Chiều dài và chiều rộng phải lớn hơn 0.")
    return 2 * (dai + rong)


# 2. Tính diện tích hình chữ nhật
def dien_tich_hinh_chu_nhat(dai, rong):
    if not (isinstance(dai, (int, float)) and isinstance(rong, (int, float))):
        raise TypeError("Chiều dài và chiều rộng phải là số.")
    if dai <= 0 or rong <= 0:
        raise ValueError("Chiều dài và chiều rộng phải lớn hơn 0.")
    return dai * rong


# 3. Giải phương trình bậc 2: ax^2 + bx + c = 0
def giai_phuong_trinh_bac2(a, b, c):
    if not all(isinstance(x, (int, float)) for x in [a, b, c]):
        raise TypeError("a, b, c phải là số.")
    if a == 0:
        raise ValueError("a không được bằng 0 (không phải phương trình bậc 2).")
    delta = b**2 - 4 * a * c
    if delta < 0:
        return "Phương trình vô nghiệm"
    elif delta == 0:
        x = -b / (2 * a)
        return f"Phương trình có nghiệm kép: x = {x}"
    else:
        x1 = (-b + math.sqrt(delta)) / (2 * a)
        x2 = (-b - math.sqrt(delta)) / (2 * a)
        return f"Phương trình có 2 nghiệm: x1 = {x1}, x2 = {x2}"


# 4. Tính số ngày của một tháng
def so_ngay_trong_thang(thang, nam):
    if not (isinstance(thang, int) and isinstance(nam, int)):
        raise TypeError("Tháng và năm phải là số nguyên.")
    if thang < 1 or thang > 12:
        raise ValueError("Tháng phải từ 1 đến 12.")
    if nam <= 0:
        raise ValueError("Năm phải lớn hơn 0.")
    nam_nhuan = (nam % 4 == 0 and nam % 100 != 0) or (nam % 400 == 0)
    so_ngay = [0, 31, 29 if nam_nhuan else 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    return so_ngay[thang]


# 5. Kiểm tra số nguyên tố
def la_so_nguyen_to(n):
    if not isinstance(n, int):
        raise TypeError("n phải là số nguyên.")
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        if n % i == 0:
            return False
    return True


# 6. Tính tổng S = 1 - 2 + 3 - 4 + ... + n
def tinh_tong_xen_ke(n):
    if not isinstance(n, int):
        raise TypeError("n phải là số nguyên.")
    if n <= 0:
        raise ValueError("n phải lớn hơn 0.")
    tong = 0
    for i in range(1, n + 1):
        if i % 2 == 0:
            tong -= i
        else:
            tong += i
    return tong


# 7. Tìm UCLN của a và b
def ucln(a, b):
    if not (isinstance(a, int) and isinstance(b, int)):
        raise TypeError("a và b phải là số nguyên.")
    if a <= 0 or b <= 0:
        raise ValueError("a và b phải lớn hơn 0.")
    while b:
        a, b = b, a % b
    return a


# 8. Tính tổng S = 1! + 2! + 3! + ... + n!
def giai_thua(n):
    if not isinstance(n, int):
        raise TypeError("n phải là số nguyên.")
    if n < 0:
        raise ValueError("n phải >= 0.")
    if n == 0:
        return 1
    ket_qua = 1
    for i in range(1, n + 1):
        ket_qua *= i
    return ket_qua


def tong_giai_thua(n):
    if not isinstance(n, int):
        raise TypeError("n phải là số nguyên.")
    if n <= 0:
        raise ValueError("n phải lớn hơn 0.")
    return sum(giai_thua(i) for i in range(1, n + 1))
