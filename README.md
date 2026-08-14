# 力扣刷题仓库

按题号平铺存放，每题一个文件 `src/P####_题名.java`，附轻量测试（`T.java`），零依赖、开箱即跑。

## 结构

```
src/                      # 题目源码（每题一个文件，按题号）
  P0001_TwoSum.java
  P0002_AddTwoNumbers.java
  ...
common/                   # 基础框架（所有题共用）
  T.java                  # 轻量断言工具（T.eq / T.eqSet / T.summary）
  ListNode.java           # 链表节点（of() 构造 / toArray() 转数组）
out/                      # 编译产物（.class），由 build.ps1 生成，勿手改
```

## 快速上手（新增一题）

1. 在 `src/` 新建 `P9999_Example.java`：

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

2. 运行（`.class` 自动进 `out/`，不污染源码目录）：

```powershell
.\build.ps1 -Class P9999_Example
```

链表题直接复用 `ListNode`：`ListNode.of(2,4,3)` 构造、`.toArray()` 转数组后用 `T.eq(int[],...)` 断言，无需自行定义。

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
