# @Resource, @Autowired, @Inject

## 🐑 의존 객체 자동 주입(Automatic Dependency Injection)

의존 객체 자동 주입은 스프링 설정파일에서 혹은 태그로 의존 객체 대상을 명시하지 않아도 스프링 컨테이너가 자동적으로 의존 대상 객체를 찾아 해당 객체에 필요한 의존성을 주입하는 것이다.

@Resource, @Autowired, @Inject 이 태그들의 차이점은 의존 객체를 찾는 방식이 다르다.

---

## ❤️ @Resource

→ Java에서 지원하는 어노테이션으로 특정 프레임워크에 종속적이지 않다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6198b4cf-3f95-4f78-a498-c53361fe6a12/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220210%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220210T065025Z&X-Amz-Expires=86400&X-Amz-Signature=a42b850f9ad88de9dae5f6e94e8f7ab9242887449fef1d7c2bb5fb437a32e4ff&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

name 속성의 이름을 기준으로 찾는다.

없으면 타입, 없으면 @Qualifier 어노테이션의 유무를 찾아 그 어노테이션이 붙은 속성에 의존성을 주입한다.

**반드시 <context:annotation-config/> 구문을 xml 설정파일에 추가해야 한다.**

- 사용할 수 있는 위치 : 멤버변수, setter 메소드

---

## ❤️ @Autowired

→ Spring에서 지원하는 어노테이션

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/9eec20fa-c893-47cf-8541-aa43f27ac026/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220210%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220210T065042Z&X-Amz-Expires=86400&X-Amz-Signature=a9cea19bbc2e00ff7288608df234be90e646aa50a1283fff24a0f377c7c3c0aa&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

@Autowired는 주입하려고 하는 객체의 타입이 일치하는지를 찾고 객체를 자동으로 주입한다.

만약에 타입이 존재하지 않는다면, @Autowired에 위치한 속성명이 일치하는 bean을 컨테이너에서 찾는다. 그리고 이름이 없을 경우, @Qualifier 어노테이션의 유무를 찾아 그 어노테이션이 붙은 속성에 의존성을 주입한다.

**반드시 <context:annotation-config/> 구문을 xml 설정파일에 추가해야 한다.**

- 사용할 수 있는 위치 : 멤버변수, setter 메소드, 생성자, 일반 메소드

---

## ❤️ @Qualifier

만약, 타입이 동일한 bean 객체가 여러개 있으면 Spring이 Exception을 발생시킨다.

(ex. @Autowired를 동일한 타입에 쓴 곳이 있다면)

Spring이 어떤 bean을 주입해야 될 지 모르기 때문에 Spring 컨테이너를 초기화 하는 과정에서 Exception

- @Autowired의 주입 대상이 한 개여야 하는데 실제로는 두 개 이상의 bean이 존재하여 주입할 때, 사용할 객체를 선택할 수 없기 때문
- 단, @Autowired가 적용된 필드나 설정 메서드의 property 이름과 같은 이름을 가진 bean 객체가 존재할 경우에는 이름이 같은 bean 객체를 주입받음

위의 내용의 에러 발생시 @Qualifier를 사용한다. 

```jsx
<context:annotation-config>
	<-- Member member = new Member() -->
	<bean id="member1" class="example.Member">
		<qualifier value="m1" />
	</bean>
<context:annotation-config/>
```

이런식으로 qualifier를 추가 하여 준다.

```jsx
public class MemberDao {
	@Autowired @Qualifier("m1")
	private Member member;

	public void setMember(Member member) {
		this.member = member;
	}
}
```

@Qualifier(”m1”) 이라고 해주었으니 member1 bean을 쓰겠다는 것이다.

Exception

@Qualifier에 지정한 한정자 값을 갖는 bean 객체가 존재하지 않으면 Exception이 발생한다.
