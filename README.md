# Bài thực hành: Kiểm thử hộp trắng (White-box Testing) bằng JUnit 5

Bài tập xây dựng **8 chương trình Java** theo yêu cầu, mỗi chương trình được tách thành **phương thức riêng**, có sử dụng **JUnit 5** để viết test case tự động nhằm đạt **100% statement coverage** và **100% branch coverage**.

## 1. Cấu trúc repo

```
thuchanh4-/
├── README.md
├── lib/
│   ├── junit-platform-console-standalone.jar   (JUnit 5)
│   └── jacoco.jar                             (JaCoCo CLI - do coverage)
├── src/
│   ├── main/java/
│   │   ├── CircleUtils.java          # Bài 1 - Chu vi & diện tích hình tròn
│   │   ├── RectangleUtils.java       # Bài 2 - Diện tích hình chữ nhật
│   │   ├── QuadraticEquation.java    # Bài 3 - Giải phương trình bậc 2
│   │   ├── ArrayUtils.java           # Bài 4 - Số nhỏ nhất của mảng
│   │   ├── PrimeUtils.java           # Bài 5 - Kiểm tra số nguyên tố
│   │   ├── AlternatingSum.java       # Bài 6 - S = 1 - 2 + 3 - 4 + ... + n
│   │   ├── GCDUtils.java             # Bài 7 - UCLN của a và b (Euclid)
│   │   └── FactorialSum.java         # Bài 8 - S = 1! + 2! + 3! + ... + n!
│   └── test/java/
│       ├── CircleUtilsTest.java
│       ├── RectangleUtilsTest.java
│       ├── QuadraticEquationTest.java
│       ├── ArrayUtilsTest.java
│       ├── PrimeUtilsTest.java
│       ├── AlternatingSumTest.java
│       ├── GCDUtilsTest.java
│       ├── FactorialSumTest.java
│       └── WhiteBoxCoverageTest.java   # Phân nhóm theo loại nhánh (Issue #2)
├── build/                              # (sinh ra khi biên dịch)
└── logs/
    ├── junit-run.log                   # Log đầy đủ 62 tests
    └── junit-summary.log
```

## 2. Yêu cầu đã thực hiện

| # | Yêu cầu | Trạng thái |
|---|---|---|
| 1 | Viết chương trình bằng Java, mỗi bài là một phương thức riêng | ✅ |
| 2 | Tách nhánh: linear / conditional / loop / exception rõ ràng trong code (có comment `// --- Nhanh dieu kien ---`) | ✅ |
| 3 | Dùng JUnit viết test tự động | ✅ (JUnit 5) |
| 4 | 100% statement coverage và 100% branch coverage | ✅ (đo bằng JaCoCo, xem `logs/coverage.csv`) |
| 5 | Tạo Issue #1: Viết test cho từng bài trên | ✅ |
| 6 | Tạo Issue #2: Viết test cho từng loại nhánh (linear/conditional/loop/exception) | ✅ |
| 7 | Có README.md, danh sách test case, ảnh/log kết quả | ✅ |
| 8 | Mã nguồn Java + mã nguồn test JUnit đầy đủ | ✅ |

## 3. Loại nhánh trong từng bài

| Bài | Linear | Conditional | Loop | Exception |
|-----|:------:|:-----------:|:----:|:---------:|
| 1. CircleUtils | ✔ (return) | ✔ (r>0) | – | ✔ (IllegalArgumentException) |
| 2. RectangleUtils | ✔ | ✔ | – | ✔ |
| 3. QuadraticEquation | ✔ | ✔ (delta<0, ==0, >0) | – | ✔ (a==0) |
| 4. ArrayUtils | ✔ | ✔ (null/empty) | ✔ | ✔ |
| 5. PrimeUtils | ✔ | ✔ (n=2, n chẵn) | ✔ | ✔ (n<2) |
| 6. AlternatingSum | ✔ | ✔ (n chẵn/lẻ) | ✔ | ✔ (n<1) |
| 7. GCDUtils | ✔ | – | ✔ (while) | ✔ (a,b≤0) |
| 8. FactorialSum | ✔ | ✔ | ✔ (2 vòng lặp) | ✔ (n<1, n>20) |

## 4. Cách chạy

### 4.1 Biên dịch và chạy test

```bash
# Thiết lập JDK 17+ (đã có sẵn OpenJDK 21 trong repo, hoặc cài đặt riêng)
export JAVA_HOME=/path/to/jdk
export PATH=$JAVA_HOME/bin:$PATH

# Biên dịch mã nguồn chính
javac -d build/classes src/main/java/*.java

# Biên dịch test (cần JUnit trong classpath)
javac -cp "build/classes:lib/junit-platform-console-standalone.jar" \
      -d build/test-classes src/test/java/*.java

# Chạy JUnit 5 Console Launcher
java -jar lib/junit-platform-console-standalone.jar execute \
     -cp "build/classes:build/test-classes" \
     --scan-classpath \
     --details=tree
```

### 4.2 Đo coverage bằng JaCoCo

```bash
# Instrument mã nguồn
java -jar lib/jacoco.jar instrument build/classes --dest build/instrumented

# Chạy test với agent thu thập coverage
java -jar lib/junit-platform-console-standalone.jar execute \
     -cp "build/instrumented:build/test-classes" \
     --scan-classpath

# Sinh báo cáo CSV
java -jar lib/jacoco.jar report build/instrumented \
     --csv logs/coverage.csv \
     --name "Thuc hanh 4 coverage"
```

## 5. Kết quả JUnit

```
[        16 containers found      ]
[         0 containers skipped    ]
[        16 containers started    ]
[        16 containers successful ]
[         0 containers failed     ]
[        62 tests found           ]
[         0 tests skipped         ]
[        62 tests started         ]
[         0 tests aborted         ]
[        62 tests successful      ]
[         0 tests failed          ]
```

**62/62 tests PASS** — đạt 100% statement và branch coverage trên tất cả 8 bài.

## 6. Danh sách test case chi tiết

Xem file `logs/test-cases.md` (sinh tự động bằng script `./scripts/gen-test-report.sh`).

## 7. Issues

- **Issue #1**: *Viết JUnit kiểm thử hộp trắng cho các hàm trên* — đã đóng (8 file test riêng + 1 file tổng hợp).
- **Issue #2**: *Viết JUnit kiểm thử hộp trắng cho các nhánh: điều kiện, điều kiện lặp, vòng lặp và ngoại lệ* — đã đóng (xem `WhiteBoxCoverageTest.java`, chia 4 nhóm `@Nested`).

## 8. Môi trường phát triển

- Java: OpenJDK 21
- JUnit: 5.10.2 (`junit-platform-console-standalone`)
- JaCoCo: 0.8.11 (đo coverage)
- Build: chỉ dùng `javac` + `java` (không Maven/Gradle để giữ repo gọn nhẹ)