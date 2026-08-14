# 统一编译/运行入口：.class 一律输出到 out/，绝不落在 src/ 或 common/
# 用法：
#   .\build.ps1                              编译全部 + 批量跑所有题
#   .\build.ps1 -Class P0002_AddTwoNumbers   编译 + 只跑指定题
param(
    [string]$Class = ""
)

$root = $PSScriptRoot
New-Item -ItemType Directory -Force "$root\out" | Out-Null

# 题目(src) + 基础框架(common) 一起编译，无包名平铺输出到 out/
Push-Location "$root\src"
javac -d "$root\out" *.java ..\common\*.java
$compileOk = $LASTEXITCODE
Pop-Location
if ($compileOk -ne 0) {
    Write-Host '编译失败'
    exit $compileOk
}

if ($Class) {
    java -cp "$root\out" $Class
} else {
    Get-ChildItem "$root\src" -Filter 'P*.java' | ForEach-Object {
        Write-Host "==== $($_.BaseName) ===="
        java -cp "$root\out" $_.BaseName
    }
}
