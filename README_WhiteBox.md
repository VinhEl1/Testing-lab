# Bài thực hành 04 – Kiểm thử hộp trắng (White-box Testing)

## Thông tin
- **Ngôn ngữ:** Java 21
- **Framework kiểm thử:** JUnit 5
- **Mục tiêu:** 100% Statement Coverage + 100% Branch Coverage

---

## Cấu trúc repo

```
white-box-testing-java/
├── Main.java                # Mã nguồn: 8 hàm chức năng
├── MainWhiteBoxTest.java    # Test case kiểm thử hộp trắng (JUnit 5)
└── README.md
```

---

## Phân tích nhánh và test case theo từng bài

### Bài 1 – Chu vi hình chữ nhật
| Nhánh | Điều kiện | Test case | Kết quả mong đợi |
|-------|-----------|-----------|-----------------|
| N1 (TRUE) | dai <= 0 | dai=-1, rong=3 | IllegalArgumentException |
| N1 (TRUE) | rong <= 0 | dai=5, rong=0 | IllegalArgumentException |
| N2 (FALSE) | dai>0 và rong>0 | dai=5, rong=3 | 16.0 |

### Bài 2 – Diện tích hình chữ nhật
| Nhánh | Điều kiện | Test case | Kết quả mong đợi |
|-------|-----------|-----------|-----------------|
| N1 (TRUE) | rong <= 0 | dai=5, rong=-2 | IllegalArgumentException |
| N1 (TRUE) | dai <= 0 | dai=0, rong=4 | IllegalArgumentException |
| N2 (FALSE) | cả hai > 0 | dai=5, rong=3 | 15.0 |

### Bài 3 – Phương trình bậc 2
| Nhánh | Điều kiện | Test case | Kết quả mong đợi |
|-------|-----------|-----------|-----------------|
| N1 | a == 0 | a=0, b=3, c=1 | IllegalArgumentException |
| N2 | delta < 0 | a=1, b=0, c=1 | "vô nghiệm" |
| N3 | delta == 0 | a=1, b=-2, c=1 | "nghiệm kép: x=1.0" |
| N4 | delta > 0 | a=1, b=-5, c=6 | "2 nghiệm: x1=3.0, x2=2.0" |

### Bài 4 – Số ngày trong tháng
| Nhánh | Điều kiện | Test case | Kết quả mong đợi |
|-------|-----------|-----------|-----------------|
| N1 | thang < 1 | thang=0 | IllegalArgumentException |
| N1 | thang > 12 | thang=13 | IllegalArgumentException |
| N2 | nam <= 0 | nam=0 | IllegalArgumentException |
| N3 | namNhuan (chia hết 4, không chia hết 100) | 2/2024 | 29 |
| N4 | namNhuan (chia hết 400) | 2/2000 | 29 |
| N5 | Không nhuận (chia hết 100, không chia hết 400) | 2/1900 | 28 |
| N6 | Tháng 31 ngày | 7/2023 | 31 |
| N7 | Tháng 30 ngày | 9/2023 | 30 |

### Bài 5 – Kiểm tra số nguyên tố
| Nhánh | Điều kiện | Test case | Kết quả mong đợi |
|-------|-----------|-----------|-----------------|
| N1 | n < 2 | n=1, n=-5 | false |
| N2 | n == 2 | n=2 | true |
| N3 | n % 2 == 0 và n > 2 | n=8 | false |
| N4 | Vòng lặp 0 lần | n=3 | true |
| N5 | Vòng lặp tìm thấy ước | n=9 | false |
| N6 | Vòng lặp chạy hết, không có ước | n=13 | true |

### Bài 6 – Tổng xen kẽ
| Nhánh | Điều kiện | Test case | Kết quả mong đợi |
|-------|-----------|-----------|-----------------|
| N1 | n <= 0 | n=0 | IllegalArgumentException |
| N2 | i % 2 == 0 (trừ) | n=2 | -1 |
| N3 | i % 2 != 0 (cộng) | n=1 | 1 |
| N2+N3 | cả hai nhánh | n=4 | -2 |

### Bài 7 – UCLN
| Nhánh | Điều kiện | Test case | Kết quả mong đợi |
|-------|-----------|-----------|-----------------|
| N1 | a <= 0 | a=0, b=5 | IllegalArgumentException |
| N1 | b <= 0 | a=5, b=-1 | IllegalArgumentException |
| N3 | Vòng lặp 1 lần | a=10, b=5 | 5 |
| N4 | Vòng lặp nhiều lần | a=12, b=8 | 4 |
| Đặc biệt | a == b | a=7, b=7 | 7 |

### Bài 8 – Giai thừa & Tổng giai thừa
| Nhánh | Điều kiện | Test case | Kết quả mong đợi |
|-------|-----------|-----------|-----------------|
| N1 | n < 0 | n=-3 | IllegalArgumentException |
| N2 | Vòng lặp 0 lần (n=0) | n=0 | 1 |
| N3 | Vòng lặp 1 lần (n=1) | n=1 | 1 |
| N4 | Vòng lặp nhiều lần | n=5 | 120 |
| N5 | n<=0 trong tongGiaiThua | n=0 | IllegalArgumentException |
| N6 | tongGiaiThua vòng lặp 1 lần | n=1 | 1 |
| N7 | tongGiaiThua vòng lặp nhiều lần | n=4 | 33 |

---

## Cách chạy kiểm thử trong IntelliJ IDEA

1. Mở project → thêm `Main.java` và `MainWhiteBoxTest.java` vào `src/`
2. Click `@Test` bị gạch đỏ → **Alt+Enter** → **"Add JUnit 5 to classpath"**
3. Chuột phải `MainWhiteBoxTest.java` → **"Run 'MainWhiteBoxTest'"**
4. Xem **Coverage**: Chuột phải → **"Run with Coverage"** để kiểm tra % bao phủ
