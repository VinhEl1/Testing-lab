# Kết quả chạy kiểm thử – Black-box Testing (Java)

## Môi trường chạy
- Ngôn ngữ: Java 21
- Framework kiểm thử: JUnit 5
- Tổng số test case: 66
- Kết quả: ✅ 66/66 PASS – 0 FAIL

---

## Chi tiết kết quả theo từng bài

### Bài 1 – Chu vi hình chữ nhật
| Test case | Đầu vào | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----------|---------|------------------|-----------------|------------|
| Số nguyên dương | dai=5, rong=3 | 16.0 | 16.0 | ✅ PASS |
| Số thực | dai=2.5, rong=1.5 | 8.0 | 8.0 | ✅ PASS |
| Hình vuông | dai=4, rong=4 | 16.0 | 16.0 | ✅ PASS |
| Giá trị biên nhỏ | dai=0.001, rong=0.001 | 0.004 | 0.004 | ✅ PASS |
| Giá trị lớn | dai=1000, rong=500 | 3000.0 | 3000.0 | ✅ PASS |
| Chiều dài = 0 | dai=0, rong=3 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |
| Chiều rộng âm | dai=5, rong=-1 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |

### Bài 2 – Diện tích hình chữ nhật
| Test case | Đầu vào | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----------|---------|------------------|-----------------|------------|
| Số nguyên dương | dai=5, rong=3 | 15.0 | 15.0 | ✅ PASS |
| Số thực | dai=2.5, rong=4.0 | 10.0 | 10.0 | ✅ PASS |
| Hình vuông | dai=6, rong=6 | 36.0 | 36.0 | ✅ PASS |
| Giá trị biên nhỏ | dai=0.1, rong=0.1 | 0.01 | 0.01 | ✅ PASS |
| Chiều dài = 0 | dai=0, rong=5 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |
| Giá trị âm | dai=-3, rong=5 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |

### Bài 3 – Giải phương trình bậc 2
| Test case | Đầu vào (a,b,c) | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----------|-----------------|------------------|-----------------|------------|
| Δ > 0 (2 nghiệm) | 1, -5, 6 | x1=3.0, x2=2.0 | x1=3.0, x2=2.0 | ✅ PASS |
| Δ = 0 (nghiệm kép) | 1, -2, 1 | x=1.0 | x=1.0 | ✅ PASS |
| Δ < 0 (vô nghiệm) | 1, 0, 1 | "vô nghiệm" | "vô nghiệm" | ✅ PASS |
| Delta biên = 0 | 1, -4, 4 | nghiệm kép x=2.0 | nghiệm kép x=2.0 | ✅ PASS |
| a = 0 | 0, 2, 1 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |

### Bài 4 – Số ngày trong tháng
| Test case | Đầu vào | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----------|---------|------------------|-----------------|------------|
| Tháng 31 ngày | tháng=1, năm=2023 | 31 | 31 | ✅ PASS |
| Tháng 30 ngày | tháng=4, năm=2023 | 30 | 30 | ✅ PASS |
| Tháng 2 năm nhuận | tháng=2, năm=2024 | 29 | 29 | ✅ PASS |
| Tháng 2 không nhuận | tháng=2, năm=2023 | 28 | 28 | ✅ PASS |
| Biên tháng=1 | tháng=1, năm=2023 | 31 | 31 | ✅ PASS |
| Biên tháng=12 | tháng=12, năm=2023 | 31 | 31 | ✅ PASS |
| Tháng = 0 | tháng=0, năm=2023 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |
| Tháng = 13 | tháng=13, năm=2023 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |
| Năm âm | tháng=1, năm=-1 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |

### Bài 5 – Kiểm tra số nguyên tố
| Test case | Đầu vào | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----------|---------|------------------|-----------------|------------|
| n=2 (nhỏ nhất) | 2 | true | true | ✅ PASS |
| n=3 | 3 | true | true | ✅ PASS |
| n=97 (lớn) | 97 | true | true | ✅ PASS |
| n=4 (hợp số) | 4 | false | false | ✅ PASS |
| n=9 (hợp số) | 9 | false | false | ✅ PASS |
| Biên n=1 | 1 | false | false | ✅ PASS |
| Biên n=0 | 0 | false | false | ✅ PASS |
| Số âm | -7 | false | false | ✅ PASS |

### Bài 6 – Tổng xen kẽ S = 1 - 2 + 3 - ... + n
| Test case | Đầu vào | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----------|---------|------------------|-----------------|------------|
| n=1 | 1 | 1 | 1 | ✅ PASS |
| n=2 | 2 | -1 | -1 | ✅ PASS |
| n=4 (chẵn) | 4 | -2 | -2 | ✅ PASS |
| n=5 (lẻ) | 5 | 3 | 3 | ✅ PASS |
| n=100 (biên lớn) | 100 | -50 | -50 | ✅ PASS |
| n=0 | 0 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |
| n âm | -3 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |

### Bài 7 – Tìm UCLN
| Test case | Đầu vào | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----------|---------|------------------|-----------------|------------|
| Cơ bản | a=12, b=8 | 4 | 4 | ✅ PASS |
| Nguyên tố cùng nhau | a=7, b=13 | 1 | 1 | ✅ PASS |
| b là ước của a | a=10, b=5 | 5 | 5 | ✅ PASS |
| a = b | a=6, b=6 | 6 | 6 | ✅ PASS |
| Một số = 1 | a=1, b=100 | 1 | 1 | ✅ PASS |
| a = 0 | a=0, b=5 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |
| Giá trị âm | a=-4, b=8 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |

### Bài 8 – Tổng giai thừa S = 1! + 2! + ... + n!
| Test case | Đầu vào | Kết quả mong đợi | Kết quả thực tế | Trạng thái |
|-----------|---------|------------------|-----------------|------------|
| giaiThua(0) | 0 | 1 | 1 | ✅ PASS |
| giaiThua(1) | 1 | 1 | 1 | ✅ PASS |
| giaiThua(5) | 5 | 120 | 120 | ✅ PASS |
| giaiThua âm | -1 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |
| tongGiaiThua(1) | 1 | 1 | 1 | ✅ PASS |
| tongGiaiThua(3) | 3 | 9 | 9 | ✅ PASS |
| tongGiaiThua(4) | 4 | 33 | 33 | ✅ PASS |
| tongGiaiThua lớn | 10 | > 0 | 4037913 | ✅ PASS |
| n = 0 | 0 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |
| n âm | -5 | IllegalArgumentException | IllegalArgumentException | ✅ PASS |

---

## Tổng kết

```
Tests run: 66
Failures:   0
Errors:     0
Skipped:    0

BUILD SUCCESS
```
