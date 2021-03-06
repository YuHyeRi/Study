# @Resource, @Autowired, @Inject

## ๐ ์์กด ๊ฐ์ฒด ์๋ ์ฃผ์(Automatic Dependency Injection)

์์กด ๊ฐ์ฒด ์๋ ์ฃผ์์ ์คํ๋ง ์ค์ ํ์ผ์์ ํน์ ํ๊ทธ๋ก ์์กด ๊ฐ์ฒด ๋์์ ๋ช์ํ์ง ์์๋ ์คํ๋ง ์ปจํ์ด๋๊ฐ ์๋์ ์ผ๋ก ์์กด ๋์ ๊ฐ์ฒด๋ฅผ ์ฐพ์ ํด๋น ๊ฐ์ฒด์ ํ์ํ ์์กด์ฑ์ ์ฃผ์ํ๋ ๊ฒ์ด๋ค.

@Resource, @Autowired, @Inject ์ด ํ๊ทธ๋ค์ ์ฐจ์ด์ ์ ์์กด ๊ฐ์ฒด๋ฅผ ์ฐพ๋ ๋ฐฉ์์ด ๋ค๋ฅด๋ค.

---

## โค๏ธ @Resource

โ Java์์ ์ง์ํ๋ ์ด๋ธํ์ด์์ผ๋ก ํน์  ํ๋ ์์ํฌ์ ์ข์์ ์ด์ง ์๋ค.

name ์์ฑ์ ์ด๋ฆ์ ๊ธฐ์ค์ผ๋ก ์ฐพ๋๋ค.

์์ผ๋ฉด ํ์, ์์ผ๋ฉด @Qualifier ์ด๋ธํ์ด์์ ์ ๋ฌด๋ฅผ ์ฐพ์ ๊ทธ ์ด๋ธํ์ด์์ด ๋ถ์ ์์ฑ์ ์์กด์ฑ์ ์ฃผ์ํ๋ค.

**๋ฐ๋์ <context:annotation-config/> ๊ตฌ๋ฌธ์ xml ์ค์ ํ์ผ์ ์ถ๊ฐํด์ผ ํ๋ค.**

- ์ฌ์ฉํ  ์ ์๋ ์์น : ๋ฉค๋ฒ๋ณ์, setter ๋ฉ์๋

---

## โค๏ธ @Autowired

โ Spring์์ ์ง์ํ๋ ์ด๋ธํ์ด์


@Autowired๋ ์ฃผ์ํ๋ ค๊ณ  ํ๋ ๊ฐ์ฒด์ ํ์์ด ์ผ์นํ๋์ง๋ฅผ ์ฐพ๊ณ  ๊ฐ์ฒด๋ฅผ ์๋์ผ๋ก ์ฃผ์ํ๋ค.

๋ง์ฝ์ ํ์์ด ์กด์ฌํ์ง ์๋๋ค๋ฉด, @Autowired์ ์์นํ ์์ฑ๋ช์ด ์ผ์นํ๋ bean์ ์ปจํ์ด๋์์ ์ฐพ๋๋ค. ๊ทธ๋ฆฌ๊ณ  ์ด๋ฆ์ด ์์ ๊ฒฝ์ฐ, @Qualifier ์ด๋ธํ์ด์์ ์ ๋ฌด๋ฅผ ์ฐพ์ ๊ทธ ์ด๋ธํ์ด์์ด ๋ถ์ ์์ฑ์ ์์กด์ฑ์ ์ฃผ์ํ๋ค.

**๋ฐ๋์ <context:annotation-config/> ๊ตฌ๋ฌธ์ xml ์ค์ ํ์ผ์ ์ถ๊ฐํด์ผ ํ๋ค.**

- ์ฌ์ฉํ  ์ ์๋ ์์น : ๋ฉค๋ฒ๋ณ์, setter ๋ฉ์๋, ์์ฑ์, ์ผ๋ฐ ๋ฉ์๋

---

## โค๏ธ @Qualifier

๋ง์ฝ, ํ์์ด ๋์ผํ bean ๊ฐ์ฒด๊ฐ ์ฌ๋ฌ๊ฐ ์์ผ๋ฉด Spring์ด Exception์ ๋ฐ์์ํจ๋ค.

(ex. @Autowired๋ฅผ ๋์ผํ ํ์์ ์ด ๊ณณ์ด ์๋ค๋ฉด)

Spring์ด ์ด๋ค bean์ ์ฃผ์ํด์ผ ๋  ์ง ๋ชจ๋ฅด๊ธฐ ๋๋ฌธ์ Spring ์ปจํ์ด๋๋ฅผ ์ด๊ธฐํ ํ๋ ๊ณผ์ ์์ Exception

- @Autowired์ ์ฃผ์ ๋์์ด ํ ๊ฐ์ฌ์ผ ํ๋๋ฐ ์ค์ ๋ก๋ ๋ ๊ฐ ์ด์์ bean์ด ์กด์ฌํ์ฌ ์ฃผ์ํ  ๋, ์ฌ์ฉํ  ๊ฐ์ฒด๋ฅผ ์ ํํ  ์ ์๊ธฐ ๋๋ฌธ
- ๋จ, @Autowired๊ฐ ์ ์ฉ๋ ํ๋๋ ์ค์  ๋ฉ์๋์ property ์ด๋ฆ๊ณผ ๊ฐ์ ์ด๋ฆ์ ๊ฐ์ง bean ๊ฐ์ฒด๊ฐ ์กด์ฌํ  ๊ฒฝ์ฐ์๋ ์ด๋ฆ์ด ๊ฐ์ bean ๊ฐ์ฒด๋ฅผ ์ฃผ์๋ฐ์

์์ ๋ด์ฉ์ ์๋ฌ ๋ฐ์์ @Qualifier๋ฅผ ์ฌ์ฉํ๋ค. 

```jsx
<context:annotation-config>
	<-- Member member = new Member() -->
	<bean id="member1" class="example.Member">
		<qualifier value="m1" />
	</bean>
<context:annotation-config/>
```

์ด๋ฐ์์ผ๋ก qualifier๋ฅผ ์ถ๊ฐ ํ์ฌ ์ค๋ค.

```jsx
public class MemberDao {
	@Autowired @Qualifier("m1")
	private Member member;

	public void setMember(Member member) {
		this.member = member;
	}
}
```

@Qualifier(โm1โ) ์ด๋ผ๊ณ  ํด์ฃผ์์ผ๋ member1 bean์ ์ฐ๊ฒ ๋ค๋ ๊ฒ์ด๋ค.

Exception

@Qualifier์ ์ง์ ํ ํ์ ์ ๊ฐ์ ๊ฐ๋ bean ๊ฐ์ฒด๊ฐ ์กด์ฌํ์ง ์์ผ๋ฉด Exception์ด ๋ฐ์ํ๋ค.
