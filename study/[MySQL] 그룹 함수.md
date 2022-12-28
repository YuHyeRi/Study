# [**MySQL] 그룹 함수**

**그룹(aggregate) 함수**

MySQL에서는 하나의 값이 아닌 값들의 집합에 대해서 동작하는 그룹(aggregate) 함수를 제공하고 있다.
MySQL에서 자주 사용되는 대표적인 그룹 함수는 다음과 같다.

1. COUNT
2. MIN, MAX
3. SUM
4. AVG

대부분의 그룹 함수는 NULL 값을 제외하고 동작한 결과를 반환한다.

---

**COUNT**

COUNT 함수는 선택된 필드에서 특정 조건을 만족하는 레코드의 총 개수를 반환한다.
만약 조건을 만족하는 레코드가 없다면, COUNT 함수는 0을 반환한다.
이 때 중복된 값을 제외하려면 필드 이름 앞에 DISTINCT 키워드를 사용하면 된다.

---

**MIN과 MAX**

MIN 함수는 선택된 필드에 저장된 값 중 가장 작은 값을 반환한다.
MAX 함수는 선택된 필드에 저장된 값 중에서 가장 큰 값을 반환한다.

MIN과 MAX 함수는 문자열 타입의 필드에서도 최솟값과 최댓값을 구할 수 있다.

---

**SUM**

SUM 함수는 선택된 숫자 타입의 필드에 저장된 값의 총 합을 반환한다.

---

**AVG**

AVG 함수는 선택된 숫자 타입의 필드에 저장된 값의 평균값을 반환한다.

---

**GROUP BY절**

GROUP BY절은 선택된 레코드의 집합을 필드의 값이나 표현식의 의해 그룹화 한 결과 집합을 반환한다.
즉, GROUP BY절은 하나의 그룹을 하나의 레코드로 반환하므로, 결과 집합의 크기를 줄여주는 역할을 한다.
이러한 GROUP BY절은 SELECT문에서만 사용할 수 있으며, 앞서 살펴본 그룹함수를 사용할 때 자주 같이 사용된다.
GROUP BY절에 사용된 필드의 이름은 반드시 SELECT문에도 같이 명시되어야 한다.

---

**HAVING절**

HAVING절은 SELECT문의 WHERE절처럼 GROUP BY절에 의한 반환되는 결과 집합의 조건을 설정할 수 있게 해준다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/MySQL-42569121d841424d8b07e5adbc4573f9
<br>
👉🏻 출처 : [http://www.tcpschool.com/mysql/mysql_builtInFunction_aggregate](http://www.tcpschool.com/mysql/mysql_builtInFunction_aggregate)
