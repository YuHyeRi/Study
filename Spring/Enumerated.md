# @Enumerated

## 👧 Enum 이란 ?

→ 우리가 흔히 상수를 정의할 때, final static string 과 같은 방식으로 정의한다. 그러나 이렇게 상수를 정의하면 다양한 문제를 발생시킬 수 있다. 이러한 문제점들을 보완하기 위해 자바 1.5 버전부터 새롭게 추가된 것이 ‘Enum’이다.

Enum은 열거형이라고 불리며, **서로 연관된 상수들의 집합**을 의미한다.

***👻 장점***

- 코드가 단순해지며, 가독성이 좋아진다
- 인스턴스 생성과 상속을 방지하여 상수값의 타입안정성이 보장된다
- enum class를 사용하여 새로운 상수들의 타입을 정의함으로 정의한 타입이외의 타입을 가진 데이터값을 컴파일시 체크 한다
- 키워드 enum을 쓰기 때문에 구현의 의도가 열거임을 분명하게 알 수 있다

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/46bbfaf1-1b17-4315-a264-ee8a1781a7ba/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220225T061709Z&X-Amz-Expires=86400&X-Amz-Signature=7d25febd5c1aa52f948a43b524c1fb7b63cb816c9ff02f90998d0121156ef469&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

 (*참고 : [https://limkydev.tistory.com/50](https://limkydev.tistory.com/50))

### 👧🏻 @Enumerated

java enum type을 엔티티 클래스의 속성으로 사용할 수 있다.

이 어노테이션에는 두 가지 enumType이 존재한다.

- EnumType.ORDINAL : enum 순서값을 DB에 저장
- EnumType.STRING : enum 이름을 DB에 저장

예를 들어 enum이 다음과 같이 생겼다고 하자.

```jsx
enum Gender {
	MALE,
	FEMALE
}
```

ORDINAL로 지정하여 gender 속성에 Gender.MALE 값을 셋팅하면 DB에 저장되는 값은 1이다.

그럼 Gender.FEMALE 값으로 셋팅한다면?

Gender에 선언되어 있는 순서가 값이 되기 때문에 당연히 2가 DB에 저장된다.

```jsx
@Enumerated(EnumType.ORDINAL)
	private Gender gender;
```

STRING으로 지정하면 ‘MALE’, ‘FEMALE’ 문자열 자체가 저장된다.

```jsx
@Enumerated(EnumType.STRING)
	private Gender gender;
```

테스트를 돌려보자

```jsx
@Test
@Transactional
public void enumTest() {
	EMember member = new EMember();
	member.setId(1);
	member.setGender(Gender.MALE);
	member.setGender1(Gender.FEMALE);

	em.persist(member);
	em.flush();
	em.clear();

	member = em.find(EMember.class, 1);
	assertThat(Gender.MALE, is(member.getGender()));
	assertThat(Gender.FEMALE.name(), is(member.getGender1().name()));
}
```

테이블구조

```jsx
CREATE TABLE EMEMBER (
	ID INTEGER NOT NULL,
	GENDER INTEGER,
	GENDER1 VARCHAR(255),
	PRIMARY KEY (ID)
}
```

사실 이와 같은 저장법은 추천해주고 싶지 않다.

ORDINAL로 설정 후 Gender enum 타입이 변경된다면 예기치 못한 문제가 발생할 수 있기도 하고, STRING 설정은 문자열 자체가 저장되기 때문에 DB 공간 낭비가 발생한다.

이를 대체할 수 있는 가장 좋은 방법은 Converter를 사용하는 것이다.

(*참고 : http://lng1982.tistory.com/279)

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/eda97b82-b578-49e9-9646-22eb286327f0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220225T061726Z&X-Amz-Expires=86400&X-Amz-Signature=15e6d0093c089da432fc9a689ed94f69065786f297e7dd1bf866a6f0f9602769&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

(* 참고 : [https://lng1982.tistory.com/280](https://lng1982.tistory.com/280))

#### 👉 참고 : https://www.notion.so/Enumerated-44002cdbefad46d588107ae29d58a7a0
