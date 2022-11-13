# [**MySQL] 관계형 데이터베이스**

**관계형 데이터베이스(relational database)란?**

관계형 데이터베이스는 현재 가장 많이 사용되고 있는 데이터베이스의 한 종류이다. 
관계형 데이터베이스란 테이블로 이루어져 있으며, 이 테이블은 키(key)와 값(value)의 관계를 
나타낸다. 

이처럼 데이터의 종속성을 관계(relationship)라고 표현하는 것이 관계형 데이터베이스의 특징이다.

관계형 데이터베이스의 테이블은 다음 그림처럼 구성된다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/d549fb2e-d981-47cb-aa0c-6ed70a549d5d/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221113%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221113T030830Z&X-Amz-Expires=86400&X-Amz-Signature=70d0c1f946ce4150c7e3eadb1d460a2712ef606aa24196886711ccfe4de63d9f&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

테이블은 이름을 가지고 있으며, 행(row)과 열(column) 그리고 거기에 대응하는 값을 가진다. 
관계형 데이터베이스는 위와 같이 구성된 테이블이 다른 테이블들과 관계를 맺고 모여있는 집합체로 이해할 수 있다.

---

**관계형 데이터베이스의 특징**

관계형 데이터베이스의 특징은 다음과 같다.

1. 데이터의 분류, 정렬, 탐색 속도가 빠르다.
2. 오랫동안 사용된 만큼 신뢰성이 높고, 어떤 상황에서도 데이터의 무결성을 보장해 준다.
3. 기존에 작성된 스키마를 수정하기가 어렵다.
4. 데이터베이스의 부하를 분석하는 것이 어렵다.

---

**관계형 데이터베이스 용어**

관계형 데이터베이스에 관련된 대표적인 용어는 다음과 같다.

1. 열(column)

각각의 열은 유일한 이름을 가지고 있으며, 자신만의 타입을 가지고 있다.
이러한 열은 필드 또는 속성(attribute)라고 불린다.

1. 행(row)

행은 관계된 데이터의 묶음을 의미한다. 한 테이블의 모든 행은 같은 수의 열을 가지고 있다. 
이러한 행은 튜플 또는 레코드라고 불린다.

1. 값(value)

테이블은 각각의 행과 열에 대응하는 값을 가지고 있다.
이러한 값은 열의 타입에 맞는 값이어야 한다.

1. 키(key)

테이블에서 행의 식별자로 이용되는 열을 키 또는 기본 키(primary key)라고 한다.
즉, 테이블에 저장된 레코드를 고유하게 식별하는 후보 키(candidate key) 중에서 
데이터베이스 설계자가 지정한 속성을 의미한다.

1. 관계(relationship)

테이블 간의 관계는 관계를 맺는 테이블의 수에 따라 다음과 같이 나눌 수 있다.

- 일대일(one-to-one) 관계
- 일대다(one-to-many) 관계
- 다대다(many-to-many) 관계

관계형 데이터베이스에서는 이러한 관계를 나타내가 위해 외래 키(foreign key)라는 것을 사용한다.
외래 키는 한 테이블의 키 중에서 다른 테이블의 행(row)을 식별할 수 있는 키를 의미한다.

테이블 간의 관계를 그림으로 표현하면 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8202105e-b63a-49d7-b267-69584b4526b3/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221113%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221113T030813Z&X-Amz-Expires=86400&X-Amz-Signature=91c22afdeee27227b77135ce68e986f291faad312e6212a6a586470b5e522d1e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

1. 스키마(schema)

스키마는 테이블을 디자인하기 위한 청사진이라고 할 수 있다.
이러한 스키마는 테이블의 각 열에 대한 항목과 타입 뿐만 아니라 기본 키와 외래 키도 나타내야 
한다.

스키마는 개체-관계 다이어그램(entity-relationship diagram)이나 문자열로 표현할 수 있다.

<aside>
💡 *문법*
Reservation(ID, Name, Date, RoomNum)

</aside>

위의 문자열을 개체-관계 다이어그램으로 나타내면 다음과 같다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a82b9b3f-0b99-416a-afc8-1f239b9c693f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221113%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221113T030748Z&X-Amz-Expires=86400&X-Amz-Signature=d08fcf5437932e375aa71443fc770ab3b5c9e66b52dd030f6e8b3624bbe1c952&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject">

<br><br>
👉 노션 : https://www.notion.so/tgmary09/MySQL-922d3e0c1d8044ccabce4cda882b87c7
<br>
👉 출처 : [http://www.tcpschool.com/mysql/mysql_intro_relationalDB](http://www.tcpschool.com/mysql/mysql_intro_relationalDB)
