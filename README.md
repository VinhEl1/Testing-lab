# Bài thực hành 03 – Kiểm thử hộp đen (Black-box Testing)

## Mô tả
Dự án gồm 8 bài toán được kiểm thử theo phương pháp **kiểm thử hộp đen**, sử dụng các kỹ thuật:
- Phân lớp tương đương (Equivalence Partitioning)
- Phân tích giá trị biên (Boundary Value Analysis)
- Dữ liệu hợp lệ và không hợp lệ

---

## Danh sách bài toán

| # | Bài toán | Hàm |
|---|----------|-----|
| 1 | Tính chu vi hình chữ nhật | `chu_vi_hinh_chu_nhat(dai, rong)` |
| 2 | Tính diện tích hình chữ nhật | `dien_tich_hinh_chu_nhat(dai, rong)` |
| 3 | Giải phương trình bậc 2 | `giai_phuong_trinh_bac2(a, b, c)` |
| 4 | Tính số ngày của một tháng | `so_ngay_trong_thang(thang, nam)` |
| 5 | Kiểm tra số nguyên tố | `la_so_nguyen_to(n)` |
| 6 | Tính tổng S = 1 - 2 + 3 - 4 + ... + n | `tinh_tong_xen_ke(n)` |
| 7 | Tìm UCLN của a và b | `ucln(a, b)` |
| 8 | Tính tổng S = 1! + 2! + ... + n! | `tong_giai_thua(n)` |

---

## Cấu trúc dự án

```
.
├── main.py              # Mã nguồn chương trình (8 hàm)
├── test_black_box.py    # Toàn bộ test case kiểm thử hộp đen
└── README.md
```

---

## Cách chạy kiểm thử

```bash
python -m unittest test_black_box -v
```

**Kết quả:** 66 tests – tất cả PASS ✅

---

## Thiết kế test case theo từng bài

### Bài 1 & 2 – Hình chữ nhật
| Phân lớp | Đầu vào | Đầu ra mong đợi |
|----------|---------|-----------------|
| Hợp lệ – số nguyên dương | dai=5, rong=3 | CV=16, DT=15 |
| Hợp lệ – số thực | dai=2.5, rong=1.5 | CV=8.0 |
| Hợp lệ – hình vuông | dai=4, rong=4 | CV=16 |
| Biên dưới (+ε) | dai=0.001, rong=0.001 | CV≈0.004 |
| Không hợp lệ – bằng 0 | dai=0, rong=3 | ValueError |
| Không hợp lệ – âm | dai=-3, rong=5 | ValueError |
| Không hợp lệ – kiểu sai | dai="5", rong=3 | TypeError |

### Bài 3 – Phương trình bậc 2
| Phân lớp | a, b, c | Đầu ra mong đợi |
|----------|---------|-----------------|
| Δ > 0 (2 nghiệm) | 1, -5, 6 | x1=3, x2=2 |
| Δ = 0 (nghiệm kép) | 1, -2, 1 | x=1.0 |
| Δ < 0 (vô nghiệm) | 1, 0, 1 | "vô nghiệm" |
| a = 0 | 0, 2, 1 | ValueError |

### Bài 4 – Số ngày trong tháng
| Phân lớp | Đầu vào | Đầu ra mong đợi |
|----------|---------|-----------------|
| Tháng 31 ngày | 1/2023 | 31 |
| Tháng 30 ngày | 4/2023 | 30 |
| Tháng 2 năm nhuận | 2/2024 | 29 |
| Tháng 2 không nhuận | 2/2023 | 28 |
| Biên tháng (1 và 12) | 1, 12 | hợp lệ |
| Tháng 0 hoặc 13 | 0, 13 | ValueError |
| Năm âm | 1/-1 | ValueError |

### Bài 5 – Số nguyên tố
| Phân lớp | Đầu vào | Đầu ra mong đợi |
|----------|---------|-----------------|
| Số nguyên tố | 2, 3, 5, 97 | True |
| Không nguyên tố | 4, 9 | False |
| Biên dưới (0, 1) | 0, 1 | False |
| Số âm | -7 | False |
| Kiểu sai | 3.5 | TypeError |

### Bài 6 – Tổng xen kẽ
| Phân lớp | n | Đầu ra mong đợi |
|----------|---|-----------------|
| n=1 | 1 | 1 |
| n chẵn | 4 | -2 |
| n lẻ | 5 | 3 |
| n lớn (biên) | 100 | -50 |
| n=0 | 0 | ValueError |
| n âm | -3 | ValueError |

### Bài 7 – UCLN
| Phân lớp | a, b | Đầu ra mong đợi |
|----------|------|-----------------|
| Hợp lệ thông thường | 12, 8 | 4 |
| Nguyên tố cùng nhau | 7, 13 | 1 |
| b là ước của a | 10, 5 | 5 |
| a = b | 6, 6 | 6 |
| Một số = 0 | 0, 5 | ValueError |
| Số âm | -4, 8 | ValueError |

### Bài 8 – Tổng giai thừa
| Phân lớp | n | Đầu ra mong đợi |
|----------|---|-----------------|
| n=1 | 1 | 1 |
| n=3 | 3 | 9 (1+2+6) |
| n=4 | 4 | 33 (1+2+6+24) |
| n=0 | 0 | ValueError |
| n âm | -5 | ValueError |
| Kiểu sai | 2.5 | TypeError |
