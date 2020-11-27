[TOC]
# 每日一题
## 454. 四数相加 II

* 地址：https://leetcode-cn.com/problems/4sum-ii/
* `Class: leetcode.everyday.ForNumberSum`

----------------
* 思路：
    1. 将四个数组划分为两组：A和B为一组；C和D为一组
    2. 使用双重循环遍历A和B，对数组中的每一个a和b计算sum1=a+b
    3. 定义一个Map：sumMap,存放的是sum1和值为sum1的个数cnt
    4. 使用双重循环遍历C和D，对数组中的每一个c和d计算sum2=c+d
    5. 从sumMap寻找是否有键为-sum2的，如果有则表示sum1+sum2=0,则从sumMap中取出键为-sum2的个数cnt，将cnt累加到返回的结果中

----------------
* 自己的代码：

```java
 public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                if (sumMap.containsKey(sum)) {
                    int cnt = sumMap.get(sum);
                    sumMap.put(sum, cnt + 1);
                } else {
                    sumMap.put(sum, 1);
                }
            }
        }

        int result = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                if (sumMap.containsKey(-sum)) {
                    result = result + sumMap.get(-sum);
                }
            }
        }
        return result;
    }
```

* 官方解答代码：

```java
 public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }
```
------------------
* 与官方解答区别：
    1. 使用`sumMap.containsKey(sum)`判断是否有键sum，如果没有则将键对应的值设置为1，否则在原来的值的基础上加1
    2. 官方解答中使用了`countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1)`，其中的countAB.getOrDefault(u + v, 0) + 1表示：如果存在键u+v则在原来的值的基础上加1，否则设置值默认为1

* 考察点：
    Map的使用




