# SQL - DCL, DML

## ***DCL (Data Control Language, 데이터 제어어)***

***👉 데이터의 보안, 무결성, 회복, 병행제어 등을 정의하는데 사용하는 언어***

<aside>
💡 GRANT, REVOKE, COMMIT, ROLLBACK

</aside>

### *GRANT / REVOKE*

1. **사용자 등급 지정 및 해제**

```sql
GRANT 사용자등급 TO 사용자_ID_리스트;
REVOKE 사용자등급 FROM 사용자_ID_리스트;
```

- 사용자 등급
    - ***DBA*** : 데이터베이스 관리자
    - ***RESOURCE*** : 데이터베이스 및 테이블 생성 가능자
    - ***CONNECT*** : 단순 사용자
    
1. **테이블 및 속성에 대한 권한 부여 및 취소**

```sql
GRANT 권한_리스트 ON 개체 TO 사용자 [WITH GRANT OPTION];
REVOKE [GRANT OPTION FOR] 권한 리스트 ON 개체 FROM 사용자 [CASCADE];
```

- ***WITH GRANT OPTION*** : 부여받은 권한을 다른 사용자에게 다시 부여할 수 있는 권한을 부여함
- ***GRANT OPTION FOR*** : 다른 사용자에게 권한을 부여할 수 있는 권한을 취소함
- CASCADE : 권한 취소 시 권한을 부여 받았던 사용자가 다른 사용자에게 부여한 권한도 연쇄적으로 취소함

👽 사용자 ID가 ‘NABI’ 인 사람에게 <고객> 테이블에 대한 모든 권한과 다른 사람에게 권한을 부여할 수 있는 권한까지 부여하는 SQL문을 작성하라

```sql
GRANT ALL ON 고객 TO NABI WITH GRANT OPTION;
```

👽 사용자 ID가 ‘STAR’인 사람에게 부여한 <고객> 테이블에 대한 권한 중 UPDATE 권한을 다른 사람에게 부여할 수 있는 권한만 취소하는 SQL문을 작성하라

```sql
REVOKE GRANT OPTION FOR UPDATE ON 고객 FROM STAR;
```

### *COMMIT*

트랜잭션 처리가 정상적으로 완료 된 후, 트랜잭션이 수행한 내용을 데이터베이스에 반영하는 명령어

### *ROLLBACK*

변경되었으나 아직 COMMIT 되지 않은 모든 내용들을 취소하고 데이터베이스를 이전 상태로 되돌리는 명령어

### *SAVEPOINT*

트랜잭션 내 ROLLBACK할 위치인 저장점을 지정하는 명령어

```sql
ROLLBACK TO 세이브포인트명;
```

---

## ***DML (Data Mainpulation Language, 데이터 조작어)***

***👉 저장된 데이터를 실질적으로 관리하는 데 사용되는 언어***

<aside>
💡 SELECT, INSERT, UPDATE, DELETE
</aside>

#### 🟣 노션 링크 : https://www.notion.so/SQL-DCL-DML-345b9ccb0d0540a88f89c1ed4d722215
