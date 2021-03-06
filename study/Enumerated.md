# @Enumerated

## π§ Enum μ΄λ ?

β μ°λ¦¬κ° νν μμλ₯Ό μ μν  λ, final static string κ³Ό κ°μ λ°©μμΌλ‘ μ μνλ€. κ·Έλ¬λ μ΄λ κ² μμλ₯Ό μ μνλ©΄ λ€μν λ¬Έμ λ₯Ό λ°μμν¬ μ μλ€. μ΄λ¬ν λ¬Έμ μ λ€μ λ³΄μνκΈ° μν΄ μλ° 1.5 λ²μ λΆν° μλ‘­κ² μΆκ°λ κ²μ΄ βEnumβμ΄λ€.

Enumμ μ΄κ±°νμ΄λΌκ³  λΆλ¦¬λ©°, **μλ‘ μ°κ΄λ μμλ€μ μ§ν©**μ μλ―Ένλ€.

***π» μ₯μ ***

- μ½λκ° λ¨μν΄μ§λ©°, κ°λμ±μ΄ μ’μμ§λ€
- μΈμ€ν΄μ€ μμ±κ³Ό μμμ λ°©μ§νμ¬ μμκ°μ νμμμ μ±μ΄ λ³΄μ₯λλ€
- enum classλ₯Ό μ¬μ©νμ¬ μλ‘μ΄ μμλ€μ νμμ μ μν¨μΌλ‘ μ μν νμμ΄μΈμ νμμ κ°μ§ λ°μ΄ν°κ°μ μ»΄νμΌμ μ²΄ν¬ νλ€
- ν€μλ enumμ μ°κΈ° λλ¬Έμ κ΅¬νμ μλκ° μ΄κ±°μμ λΆλͺνκ² μ μ μλ€

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/46bbfaf1-1b17-4315-a264-ee8a1781a7ba/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220225T061709Z&X-Amz-Expires=86400&X-Amz-Signature=7d25febd5c1aa52f948a43b524c1fb7b63cb816c9ff02f90998d0121156ef469&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

 (*μ°Έκ³  : [https://limkydev.tistory.com/50](https://limkydev.tistory.com/50))

### π§π» @Enumerated

java enum typeμ μν°ν° ν΄λμ€μ μμ±μΌλ‘ μ¬μ©ν  μ μλ€.

μ΄ μ΄λΈνμ΄μμλ λ κ°μ§ enumTypeμ΄ μ‘΄μ¬νλ€.

- EnumType.ORDINAL : enum μμκ°μ DBμ μ μ₯
- EnumType.STRING : enum μ΄λ¦μ DBμ μ μ₯

μλ₯Ό λ€μ΄ enumμ΄ λ€μκ³Ό κ°μ΄ μκ²Όλ€κ³  νμ.

```jsx
enum Gender {
	MALE,
	FEMALE
}
```

ORDINALλ‘ μ§μ νμ¬ gender μμ±μ Gender.MALE κ°μ μννλ©΄ DBμ μ μ₯λλ κ°μ 1μ΄λ€.

κ·ΈλΌ Gender.FEMALE κ°μΌλ‘ μννλ€λ©΄?

Genderμ μ μΈλμ΄ μλ μμκ° κ°μ΄ λκΈ° λλ¬Έμ λΉμ°ν 2κ° DBμ μ μ₯λλ€.

```jsx
@Enumerated(EnumType.ORDINAL)
	private Gender gender;
```

STRINGμΌλ‘ μ§μ νλ©΄ βMALEβ, βFEMALEβ λ¬Έμμ΄ μμ²΄κ° μ μ₯λλ€.

```jsx
@Enumerated(EnumType.STRING)
	private Gender gender;
```

νμ€νΈλ₯Ό λλ €λ³΄μ

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

νμ΄λΈκ΅¬μ‘°

```jsx
CREATE TABLE EMEMBER (
	ID INTEGER NOT NULL,
	GENDER INTEGER,
	GENDER1 VARCHAR(255),
	PRIMARY KEY (ID)
}
```

μ¬μ€ μ΄μ κ°μ μ μ₯λ²μ μΆμ²ν΄μ£Όκ³  μΆμ§ μλ€.

ORDINALλ‘ μ€μ  ν Gender enum νμμ΄ λ³κ²½λλ€λ©΄ μκΈ°μΉ λͺ»ν λ¬Έμ κ° λ°μν  μ μκΈ°λ νκ³ , STRING μ€μ μ λ¬Έμμ΄ μμ²΄κ° μ μ₯λκΈ° λλ¬Έμ DB κ³΅κ° λ­λΉκ° λ°μνλ€.

μ΄λ₯Ό λμ²΄ν  μ μλ κ°μ₯ μ’μ λ°©λ²μ Converterλ₯Ό μ¬μ©νλ κ²μ΄λ€.

(*μ°Έκ³  : http://lng1982.tistory.com/279)

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/eda97b82-b578-49e9-9646-22eb286327f0/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220225%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220225T061726Z&X-Amz-Expires=86400&X-Amz-Signature=15e6d0093c089da432fc9a689ed94f69065786f297e7dd1bf866a6f0f9602769&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

(* μ°Έκ³  : [https://lng1982.tistory.com/280](https://lng1982.tistory.com/280))

#### π μ°Έκ³  : https://www.notion.so/Enumerated-44002cdbefad46d588107ae29d58a7a0
