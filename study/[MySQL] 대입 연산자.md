# [**MySQL] 대입 연산자**

**대입 연산자(assignment operator)**

대입 연산자는 변수에 값을 대입할 때 사용하는 이항 연산자이다.

| 대입 연산자 | 설명 |
| --- | --- |
| = | 왼쪽 피연산자에 오른쪽 피연산자를 대입함
(SET문이나 UPDATE문의 SET절에서만 대입연산자로 사용됨) |
| := | 왼쪽 피연산자에 오른쪽 피연산자를 대입함 |

MySQL에서 ‘=’ 연산자는 두 가지 의미로 해석된다.

1. SET문이나 UPDATE문의 SET절에서 사용되면, 
왼쪽 피연산자에 오른쪽 피연산자를 대입하는 대입연산자로 해석된다.
2. SET문이나 UPDATE문의 SET절 이외에서 사용되면, 
왼쪽 피연산자와 오른쪽 피연산자를 비교하는 비교연산자로 해석된다.

이처럼 ‘=’ 연산자는 상황에 따라 다르게 해석될 수 있으므로, 작성자의 의도와는 다르게 해석될 
여지가 있다. 
MySQL에서는 언제나 대입 연산자로만 해석되는 두 번째 대입연산자(:=)를 별도로 제공하고 있다. 
첫 번째 대입 연산자(=)와 달리 두 번째 대입 연산자(:=)는 절대로 비교연산자로 해석되지 않는다.

*예제*

```sql
UPDATE Reservation
SET RoomNum = 504;
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_assignment_01](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_operator_assignment_01)

실행*결과*

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0fd46529-87a6-413d-9971-fb8ba258cec9/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221126%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221126T150851Z&X-Amz-Expires=86400&X-Amz-Signature=1c1f6a26bd2ddfbc0bf9496fda58910babab33412e8681751d25d3962bdce489&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-33ada3d8f5bc4f12b17c379fde7752a5
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_operator_assignment](http://www.tcpschool.com/mysql/mysql_operator_assignment)
