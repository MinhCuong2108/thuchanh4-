# Danh sách test case — Thực hành 4 (Kiểm thử hộp trắng)

Tổng cộng **62 test**, đạt **100% instruction coverage** và **100% branch coverage** trên tất cả 8 class.

## 1. `CircleUtilsTest` (4 test)

| # | Test case | Loại nhánh | Mục đích |
|---|---|---|---|
| 1 | `perimeterValid` | Linear | Chu vi đúng với `r=1` và `r=MIN_VALUE` |
| 2 | `areaValid` | Linear | Diện tích đúng với `r=1` và `r=2` |
| 3 | `perimeterInvalid` | Conditional + Exception | Throw khi `r=0`, `r=-1`, `r=NaN`, `r=+Inf` |
| 4 | `areaInvalid` | Conditional + Exception | Throw khi `r=0`, `r=-2.5`, `r=NaN`, `r=-Inf` |

## 2. `RectangleUtilsTest` (5 test)

| # | Test case | Loại nhánh | Mục đích |
|---|---|---|---|
| 1 | `areaValid` | Linear | Diện tích đúng với `(2,3)` và `(1,1)` |
| 2 | `perimeterValid` | Linear | Chu vi đúng với `(2,3)` |
| 3 | `areaInvalidWidth` | Conditional + Exception | Throw khi `width=0, -1, NaN, +Inf` |
| 4 | `areaInvalidHeight` | Conditional + Exception | Throw khi `height=0, -1, NaN, -Inf` |
| 5 | `perimeterInvalid` | Conditional + Exception | Throw khi cạnh không hợp lệ |

## 3. `QuadraticEquationTest` (5 test)

| # | Test case | Loại nhánh | Mục đích |
|---|---|---|---|
| 1 | `twoRoots` | Conditional (delta>0) | `x²-5x+6=0` → `{3, 2}` |
| 2 | `doubleRoot` | Conditional (delta==0) | `x²-4x+4=0` → `{2}` |
| 3 | `noRealRoots` | Conditional (delta<0) | `x²+x+1=0` → `{}` |
| 4 | `zeroA` | Exception | Throw khi `a=0` |
| 5 | `describeAllBranches` | Linear | Chuỗi mô tả đúng cả 3 trường hợp |

## 4. `ArrayUtilsTest` (6 test)

| # | Test case | Loại nhánh | Mục đích |
|---|---|---|---|
| 1 | `minIntMany` | Loop | Min nhiều phần tử, bao gồm phần tử âm, bằng nhau, 1 phần tử |
| 2 | `minIntNull` | Conditional + Exception | Throw khi mảng null |
| 3 | `minIntEmpty` | Conditional + Exception | Throw khi mảng rỗng |
| 4 | `minDoubleValid` | Loop | Min với mảng double |
| 5 | `minDoubleInvalid` | Conditional + Exception | Throw khi mảng null/rỗng |
| 6 | `minDoubleNaN` | Loop + Exception | Throw khi phần tử NaN / vô cực |

## 5. `PrimeUtilsTest` (4 test)

| # | Test case | Loại nhánh | Mục đích |
|---|---|---|---|
| 1 | `primesTrue` | Conditional | 2, 3, 5, 7, 11, 13, 97 đều là nguyên tố |
| 2 | `primesFalse` | Conditional | 4, 9, 15, 100 không nguyên tố |
| 3 | `primesInvalid` | Exception | Throw khi `n=0, 1, -5` |
| 4 | `primesUpTo` | Loop | Liệt kê đúng đến 10, hoặc rỗng khi ≤ 1 |

## 6. `AlternatingSumTest` (5 test)

| # | Test case | Loại nhánh | Mục đích |
|---|---|---|---|
| 1 | `oddN` | Conditional + Loop | `n=1, 3, 5` |
| 2 | `evenN` | Conditional + Loop | `n=2, 4, 10` |
| 3 | `invalidN` | Exception | Throw khi `n=0, -3` |
| 4 | `formulaAll` | Conditional | Công thức đóng đúng cho cả 2 trường hợp |
| 5 | `formulaInvalid` | Exception | Throw khi `n=0, -1` |

## 7. `GCDUtilsTest` (4 test)

| # | Test case | Loại nhánh | Mục đích |
|---|---|---|---|
| 1 | `gcdValid` | Loop | UCLN với `(17,13), (54,24), (5,5), (7,14), (13,26)` |
| 2 | `gcdInvalid` | Exception | Throw khi `a=0, b=0, a<0, b<0` |
| 3 | `gcdRecursive` | Conditional | Đệ quy đúng |
| 4 | `gcdRecursiveInvalid` | Exception | Throw khi `a=0, a<0, b<0` |

## 8. `FactorialSumTest` (4 test)

| # | Test case | Loại nhánh | Mục đích |
|---|---|---|---|
| 1 | `factorialValid` | Loop | Giai thừa 0!, 1!, …, 20! |
| 2 | `factorialInvalid` | Exception | Throw khi `n=-1, n=21` |
| 3 | `sumValid` | Loop | Tổng giai thừa `n=1, 2, 3, 4` |
| 4 | `sumInvalid` | Exception | Throw khi `n=0, -1, 21` |

## 9. `WhiteBoxCoverageTest` (25 test, phân nhóm theo loại nhánh — Issue #2)

### Linear branch (3 test)
| # | Test case |
|---|---|
| 1 | `perimeterValid` |
| 2 | `rectangleAreaValid` |
| 3 | `sumFactorialsLinear` |

### Conditional branch (7 test)
| # | Test case |
|---|---|
| 1 | `quadraticTwoRoots` |
| 2 | `quadraticDoubleRoot` |
| 3 | `quadraticNoRoot` |
| 4 | `alternatingOddN` |
| 5 | `alternatingEvenN` |
| 6 | `primeTwo` |
| 7 | `primeEvenComposite` |

### Loop (5 test)
| # | Test case |
|---|---|
| 1 | `minArrayLoop` |
| 2 | `sumFactorialLoop` |
| 3 | `gcdLoop` |
| 4 | `primeOddLoop` |
| 5 | `primesUpToLoop` |

### Exception handling (10 test)
| # | Test case |
|---|---|
| 1 | `circleZeroRadius` |
| 2 | `rectangleNegativeSide` |
| 3 | `quadraticZeroA` |
| 4 | `arrayNull` |
| 5 | `arrayEmpty` |
| 6 | `primeTooSmall` |
| 7 | `alternatingZeroN` |
| 8 | `gcdNegative` |
| 9 | `factorialNegative` |
| 10 | `sumFactorialZero` |

---

## Kết quả JaCoCo

```
JaCoCo Coverage Report,default,RectangleUtils,0,49,0,12,0,9,0,9,0,3
JaCoCo Coverage Report,default,QuadraticEquation,0,108,0,10,0,17,0,7,0,2
JaCoCo Coverage Report,default,FactorialSum,0,67,0,12,0,16,0,8,0,2
JaCoCo Coverage Report,default,CircleUtils,0,31,0,6,0,7,0,6,0,3
JaCoCo Coverage Report,default,AlternatingSum,0,60,0,10,0,13,0,7,0,2
JaCoCo Coverage Report,default,ArrayUtils,0,95,0,20,0,20,0,12,0,2
JaCoCo Coverage Report,default,GCDUtils,0,49,0,12,0,14,0,8,0,2
JaCoCo Coverage Report,default,PrimeUtils,0,81,0,20,0,23,0,12,0,2
```

- **Instructions**: 540/540 = **100%**
- **Branches**: 102/102 = **100%**