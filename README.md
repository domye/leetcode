# 力扣刷题仓库

按题号平铺存放，每题一个文件 `src/P####_题名.java`，附轻量测试（`T.java`），零依赖、开箱即跑。

## 结构

```
src/
  T.java                  # 轻量断言工具（T.eq / T.eqSet / T.summary）
  P0001_TwoSum.java
  P0003_LengthOfLongestSubstring.java
  ...
out/                      # 编译产物（.class），由 javac -d 生成，勿手改
```

## 快速上手（新增一题）

```java
import java.util.*;

public class P9999_Example {
    public int solve(int[] nums) {
        // ...你的解法
        return 0;
    }

    public static void main(String[] args) {
        P9999_Example s = new P9999_Example();
        T.eq(期望值, s.solve(new int[]{...}), "用例名");
        T.summary(); // 打印 通过/失败 汇总，失败时退出码 1
    }
}
```

## 运行单题

```powershell
cd src
javac -d ../out *.java
java -cp ../out P9999_Example
```

或直接在 IntelliJ 里右键运行对应类的 main。

## 批量跑全部题（验证整库）

```powershell
cd src
javac -d ../out *.java
Get-ChildItem -Filter 'P*.java' | ForEach-Object {
    $class = $_.BaseName
    Write-Host "==== $class ===="
    java -cp ../out $class  # 任一失败会以退出码 1 结束
}
```

## T 支持的断言

| 断言 | 用途 |
|------|------|
| `T.eq(int, int, name)` / `T.eq(long, long, name)` | 数值相等 |
| `T.eq(double, double, eps, name)` | 浮点相等（允许误差） |
| `T.eq(int[], int[], name)` | 一维数组相等 |
| `T.eq(int[][], int[][], name)` | 二维数组相等 |
| `T.eq(List, List, name)` | 列表相等（按序） |
| `T.eqSet(List<List<String>>, List<List<String>>, name)` | 集合相等（内外均不要求顺序，如异位词分组） |

> 返回 `int[]` 的题期望 `T.eq(int[],...)`，返回 `long` 的题期望 `T.eq(long,...)`，原题返回类型按题目为准。

## 待补/未完成

标有 `TODO` 或测试 FAIL 的题即为未完成，正好作为练习入口：

- `P0238_ProductExceptSelf`：方法返回 null，未实现
- `P2841_MaximumSumOfAlmostUniqueSubarray`：方法返回 1L，未实现
