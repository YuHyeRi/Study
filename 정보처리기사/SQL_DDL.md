# SQL - DDL

## ***DDL (Data Define Language, 데이터 정의어)***

***👉 DB를 구축하거나 수정할 목적으로 사용하는 언어***

<aside>
💡 **CREATE, ALTER, DROP**

</aside>

### *CREATE SCHEMA*

```sql
CREATE SCHEMA 스키마명 AUTHORIZATION 사용자_id;
```

### *CREATE DOMAIN*

```sql
CREATE DOMAIN 도메인명 데이터타입(크기)
[DEFAULT 기본값]
[CONSTRAINT 제약조건명 CHECK (범위값)];
```

👽 ‘성별’을 ‘남’ 또는 ‘여’와 같이 정해진 1개의 문자로 표현되는 도메인 SEX를 정의하는 SQL문은?

```sql
CREATE DOMAIN SEX CHAR(1)
DEFAULT '남'
CONSTRAINT VALID-SEX CHECK(VALUE IN ('남','여'));
```

### *CREATE TABLE*

```sql
CREATE TABLE 테이블명
						(속성명 데이터타입,
						PRIMARY KEY (기본키_속성명),
						UNIQUE (대체키_속성명),
						FOREIGN KEY (외래키_속성명)
							REFERENCES 참조테이블 (속성명)
							ON DELETE 옵션
							ON UPDATE 옵션,
						CONSTRAINT 제약조건명 CHECK(조건식)]);
```

### *CREATE VIEW*

```sql
CREATE VIEW 뷰명 [(속성명, 속성명,...)] AS
SELECT ...
```

👽 고객테이블에서 ‘주소’가 ‘안산시’인 고객들의 ‘성명’과 ‘전화번호’를 ‘안산고객’이라는 뷰로 정의?

```sql
CREATE VIEW 안산고객 (성명, 전화번호) AS
SELECT 성명, 전화번호
FROM 고객
WHERE 주소 = '안산시';
```

### *CREATE INDEX*

```sql
CREATE [UNIQUE] INDEX 인덱스명
ON 테이블명 (속성명, 속성명,...)
[CLUSTER];
```

👽 고객 테이블에서 UNIQUE한 특성을 갖는 ‘고객번호’ 속성에 대해 내림차순으로 정렬하여 

‘고객번호_idx’라는 이름으로 인덱스를 정의하시오.

```sql
CREATE UNIQUE INDEX 고객번호_idx
ON 고객 (고객번호 DESC);
```

### *ALTER TABLE*

```sql
ALTER TABLE 테이블명 ADD 속성명 데이터타입 [DEFAULT '기본값'];
ALTER TABLE 테이블명 ALTER 속성명 [SET DEFAULT '기본값'];
ALTER TABLE 테이블명 DROP COLUMN 속성명 [CASCADE];
```

👽 학생 테이블에 최대 3문자로 구성되는 학년 속성을 추가하라.

```sql
ALTER TABLE 학생 ADD 학년 VARCHAR(3);
```

👽 학생 테이블의 ‘학번’ 필드의 데이터 타입과 크기를 VARCHAR(10)으로 하고 NULL 값이 입력되지 않도록 변경하라

```sql
ALTER TABLE 학생 ALTER 학번 VARCHAR(10) NOT NULL;
```

### *DROP*

```sql
DROP SCHEMA 스키마명 [CASCADE | RESTRICT];
DROP DOMAIN 도메인명 [CASCADE | RESTRICT];
DROP TABLE 테이블명 [CASCADE | RESTRICT];
DROP VIEW 뷰명 [CASCADE | RESTRICT];
DROP INDEX 인덱스명 [CASCADE | RESTRICT];
DROP CONSTRAINT 제약조건명;
```

- ***CASCADE : 제거할 요소를 참조하는 다른 모든 개체를 함께 제거한다.***
- ***RESTRICT : 다른 개체가 제거할 요소를 참조중일 때는 제거를 취소한다.***
