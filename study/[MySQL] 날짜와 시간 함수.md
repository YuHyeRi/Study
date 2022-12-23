# [**MySQL] 날짜와 시간 함수**

**현재 날짜와 시간 정보**

NOW 함수는 현재 날짜와 시간을 반환한다.
이 때 반환되는 값은 'YYYY-MM-DD HH:MM:SS' 또는 YYYYMMDDHHMMSS 형태로 반환된다.

CURDATE() 함수는 현재 날짜를 반환한다.
이때 반환되는 값은 'YYYY-MM-DD' 또는 YYYYMMDD 형태로 반환된다.

CURTIME() 함수는 현재 시각을 반환한다.
이때 반환되는 값은 'HH:MM:SS' 또는 HHMMSS 형태로 반환된다.

```sql
SELECT NOW(),
CURDATE(),
CURTIME();
```

---

**특정 날짜와 시간 정보**

DATE 함수는 전달받은 값에 해당하는 날짜 정보를 반환한다.
MONTH 함수는 전달받은 값에서 월에 해당하는 값만으르 반환하며, 0부터 12 사이의 값을 가진다.
DAY 함수는 전달받은 값에서 일자에 해당하는 값만을 반환하며, 0부터 31 사이의 값을 가진다.
HOUR 함수는 전달받은 값에서 시간에 해당하는 값만을 반환하며, 0부터 23 사이의 값을 가진다.
MINUTE 함수는 전달받은 값에서 분에 해당하는 값만을 반환하며, 0부터 59 사이의 값을 가진다.
SECOND 함수는 전달받은 값에서 초에 해당하는 값만을 반환하며, 0부터 59 사이의 값을 가진다.

---

**요일과 월 이름**

MONTHNAME 함수는 전달받은 값의 월에 해당하는 이름을 반환한다.
DAYNAME 함수는 전달받은 값의 요일에 해당하는 이름을 반환한다.

```sql
SELECT MONTHNAME('2017-02-19'), 
DAYNAME('2017-02-19');
```


---

**연도별, 월별, 주별 일수**

DAYOFWEEK 함수는 전달받은 값의 일자가 해당 주에서 몇 번째 날인지를 반환한다.
이 함수는 1부터 7 사이의 값을 반환한다. (일요일=1, 토요일=7)

DAYOFMONTH 함수는 전달받은 값의 일자가 해당 월에서 몇 번째 날인지를 반환한다.
이 함수는 0부터 31 사이의 값을 반환한다.

DAYOFYEAR 함수는 전달받은 값의 일자가 해당 연도에서 몇 번째 날인지를 반환한다.
이 함수는 1부터 366 사이의 값을 반환한다.

```sql
SELECT DAYOFMONTH('2017-02-19'), 
DAYOFWEEK('2017-02-19'), 
DAYOFYEAR('2017-02-19');
```


---

**날짜와 시간의 형식화**

DATE_FORMAT 함수는 전달받은 형식에 맞춰 날짜와 시간 정보를 문자열로 반환한다.
DATE_FORMAT 함수에 인수로 전달할 수 있는 날짜와 시간 표현의 형식은 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4f6e48f0-5ffe-4267-892f-520777968a20/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221223%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221223T020413Z&X-Amz-Expires=86400&X-Amz-Signature=515003e0d1fd09099dba1902af6424dfc43c7e7a43a61860d844113c8bf9856c&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">
<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c7f3cdb6-c3ad-4820-826a-d86ef9fa6bd5/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221223%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221223T020425Z&X-Amz-Expires=86400&X-Amz-Signature=aa931f16100c197777b6a86111db7891a7a983ae18569d769c42921707acd037&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

```sql
SELECT DATE_FORMAT('2017-02-19 12:34:56', '%D %y %a %d %m %b %j');
```

[http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_builtInFunction_dateTime_05](http://www.tcpschool.com/examples/tryit/tryMysql.php?filename=mysql_builtInFunction_dateTime_05)

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-b5b0e993fea141dfb42fef648abbb257
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_builtInFunction_dateTime](http://www.tcpschool.com/mysql/mysql_builtInFunction_dateTime)
