# [**MySQL] 논리 연산자**

**논리 연산자(logical operator)**

논리 연산자는 논리식을 판단하여, 참(true)이면 1을 반환하고 거짓(false)이면 0을 반환한다.

| 논리 연산자 | 설명 |
| --- | --- |
| AND | 논리식이 모두 참이면 참을 반환 |
| && | 논리식이 모두 참이면 참을 반환 |
| OR | 논리식 중에서 하나라도 참이면 참을 반환 |
| || | 논리식 중에서 하나라도 참이면 참을 반환 |
| XOR | 논리식이 서로 다르면 참을 반환 |
| NOT | 논리식의 결과가 참이면 거짓을, 거짓이면 참을 반환 |
| ! | 논리식의 결과가 참이면 거짓을, 거짓이면 참을 반환 |

*예제*

```sql
SELECT NOT 0, // 피연산자가 0이면 1을 반환하고, 1이면 0을 반환

1 AND 1,      // 피연산자가 모두 1일때만 1을 반환하고, 나머지 경우에는 0을 반환

0 OR 0,       // 피연산자가 모두 0일때만 0을 반환하고, 나머지 경우에는 1을 반환

1 XOR 0;      // 피연산자가 서로 다르면 1을 반환하고, 서로 같으면 0을 반환
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_logic_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_logic_01)

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-68942662830948039a1de56e7dd17669
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_operator_logic](http://www.tcpschool.com/mysql/mysql_operator_logic)
