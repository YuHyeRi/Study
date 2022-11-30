# [**MySQL] 비트 연산자**

**비트 연산자(bitwise operator)**

비트 연산자는 논리 연산자와 비슷하지만, 비트(bit)단위로 논리 연산을 수행한다. 
또한 비트 단위로 전체 비트를 왼쪽이나 오른쪽으로 이동시킬 때도 사용한다.

| 비트 연산자 | 설명 |
| --- | --- |
| & | 대응되는 비트가 모두 1이면 1을 반환 (AND) |
| | | 대응되는 비트 중에서 하나라도 1이면 1을 반환 (OR) |
| ^ | 대응되는 비트가 서로 다르면 1을 반환 (XOR) |
| ~ | 비트를 1이면 0으로, 0이면 1로 반전시킴 (NOT) |
| << | 지정한 수만큼 비트를 전부 왼쪽으로 이동시킴 (left shift) |
| >> | 부호를 유지하면서 지정한 수만큼 비트를 전부 오른쪽으로 이동시킴 (right shift) |

*예제*

```sql
SELECT b'1000' & b'1111', // 첫 번째 비트만이 둘 다 1이므로, 연산 결과는 b'1000'이 됨

b'1000' | b'1111',        // 모든 비트에 하나라도 1이 포함되어 있으므로, 연산 결과는 b'1111'이 됨

b'1000' ^ b'1111',        // 첫 번째 비트를 제외한 모든 비트가 서로 다르므로, 연산 결과는 b'0111'이 됨

b'1100' >> 1,             // 모든 비트를 1비트씩 오른쪽으로 이동시키므로, 연산 결과는 b'0110'이 됨

b'1100' >> 2;             // 모든 비트를 2비트씩 오른쪽으로 이동시키므로, 연산 결과는 b'0011'이 됨
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_bitwise_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_bitwise_01)


<aside>
💡 MySQL에서는 ‘0’과 ‘1’로만 이루어진 문자열 앞에 ‘b’를 붙여 2진수를 표현할 수 있다.

</aside>

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-d4803bf17a6a458ab057c5f27130cd53
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_operator_bitwise](http://www.tcpschool.com/mysql/mysql_operator_bitwise)
