# [**MySQL] 비교 연산자**

**비교 연산자(comparison operator)**

비교 연산자는 피연산자 사이의 상대적인 크기를 판단하여, 
참(true)이면 1을 반환하고 거짓(false)이면 0을 반환한다.

| 비교 연산자 | 설명 |
| --- | --- |
| = | 왼쪽 피연산자와 오른쪽 피연산자가 같으면 참을 반환함 |
| !=, <> | 왼쪽 피연산자와 오른쪽 피연산자가 같지 않으면 참을 반환함 |
| < | 왼쪽 피연산자가 오른쪽 피연산자보다 작으면 참을 반환함 |
| ≤ | 왼쪽 피연산자가 오른쪽 피연산자보다 작거나 같으면 참을 반환함 |
| > | 왼쪽 피연산자가 오른쪽 피연산자보다 크면 참을 반환함 |
| ≥ | 왼쪽 피연산자가 오른쪽 피연산자보다 크거나 같으면 참을 반환함 |
| < = > | 양쪽의 피연산자가 모두 NULL이면 참을 반환하고, 
하나의 피연산자만 NULL이면 거짓을 반환함 |
| IS | 왼쪽 피연산자와 오른쪽 피연산자가 같으면 참을 반환함
(오른쪽 피연산자가 불리언 값인 TRUE, FALSE, UNKNOWN 값일 때 사용함) |
| IS NOT | 왼쪽 피연산자와 오른쪽 피연산자가 같지 않으면 참을 반환함
(오른쪽 피연산자가 불리언 값인 TRUE, FALSE, UNKNOWN 값일 때 사용함) |
| IS NULL | 피연산자의 값이 NULL이면 참을 반환함 |
| IS NOT NULL | 피연산자의 값이 NULL이 아니면 참을 반환함 |
| BETWEEN min AND max | 피연산자의 값이 min 값보다 크거나 같고, max 값보다 작거나 같으면 참을 반환함 |
| NOT BETWEEN min AND max | 피연산자의 값이 min 값보다 작거나 max 크면 참을 반환함 |
| IN() | 피연산자의 값이 인수로 전달받은 리스트에 존재하면 참을 반환함 |
| NOT IN() | 피연산자의 값이 인수로 전달받은 리스트에 존재하지 않으면 참을 반환함 |

*예제*

```sql
SELECT 3 = 3,      // 3과 3이 같은지를 비교

0 = NULL,          // 0과 NULL이 같은지를 비교

1 IS TRUE,         // 1과 TRUE가 같은지를 비교

1 IS NULL,         // 1과 NULL이 같은지를 비교

3 BETWEEN 2 AND 7, // 3이 2보다 크거나 같고, 7보다 작거나 같은지를 비교

5 IN (2, 3, 4, 5); // 5가 2, 3, 4, 5중에 포함되는지를 비교
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_comparison_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_comparison_01)


<aside>
💡 대부분의 프로그래밍 언어에서 동등 연산자는 ‘ == ‘로 사용한다.
그러자 MySQL에서는 대입 연산자와 같은 모양인 ‘ = ‘로 사용한다는 점을 주의해야 한다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-ded9eece78184d788f5f794335886ed0
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_operator_comparison](http://www.tcpschool.com/mysql/mysql_operator_comparison)
