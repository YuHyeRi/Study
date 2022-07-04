# Spring -03

### Q. MVC에 대해 설명하라

- MVC패턴은 Model, View, Controller 이 3가지로 나뉘어 역할을 분할하여 처리한다.
- 역할을 나누어 처리하기 때문에 ***서로의 결합도가 낮아져*** 좋은 코드가 되며 유지보수가 쉽다.

### Q. MVC 패턴 진행 방식(한번더!)

1. CT로 부터 요청이 들어오면 DispatcherServlet이 가장 먼저 받는다.
2. HandlerMapping이 요청 URL과 매핑되는 Controller를 검색 후 리턴한다.
3. HandlerAdaper에서 알맞는 Controller 처리 요청한다.
4. ViewResolver에서 Controller가 리턴한 후, View 검색 후 View를 CT로 보낸다.

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/34e0e8d0-9f45-4006-a715-db9a2461e907/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220315%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220315T071905Z&X-Amz-Expires=86400&X-Amz-Signature=680b67e750d6b688808ff37e02bffbce0ece10cdd8900d93e8a8130395974af5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

### Q. JPA에서 Entity 를 설계할 때 주의점은?

- ***Entity에는 가급적 Setter 사용하지 말 것***

→ Entity가 영속성이 유지되는 도중 수정되면 그 값은 DB에 그대로 반영된다. 그런데 Setter를 열어두고 값을 변경한는 경우에는 변경 포인트가 많아 유지보수가 어려워질 수 있다.

- 모든 연관관계는 자연로딩으로 설정한다.

→ 즉시로딩(Eager)를 사용할 경우, 어떤 SQL이 나갈지 추적하기 어렵다.

- 컬렉션은 필드에서 바로 초기화한다.
- ***Entity는 최대한 순수하게 유지한다.***

### Q. DTO를 사용해야 하는 이유는?

- 순환참조를 예방할 수 있다

→ JPA로 개발할 때, 양방향 참조를 했다면 순환참조를 조심해야 한다.

<aside>
💡 순환참조란 서로 다른 여러 빈들이 서로 물고늘어져 계속 연결되어 있음을 의미한다. 아래처럼 A는 B에서 필요한데 B는 또 A에서 필요한 상태를 말한다. Bean A → Bean B → Bean A       👉 참고 : [https://keichee.tistory.com/446](https://keichee.tistory.com/446)

</aside>

- Entity  내부 구현을 캡슐화 할 수 있다.
- DB Layer와 View Layer 사이의 역할을 분리하기 위해서다.

### Q. ‘ 생성자 주입 ‘을 사용한 이유

- 필드주입은 점차 테스트 코드의 중요성이 부각됨에 따라, ***필드의 객체를 수정할 수 없는 ‘필드주입’***은 사용하지 않는 것이 좋다. 또한 필드주입은 반드시 DI 프레임워크가 존재해야하므로 사용을 지양해야 한다.

```java
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MemberService memberService;
}
```

- 생성자 주입은 생성자로 객체를 생성하는 시점에 필요한 Bean을 주입한다. 그러므로 순환참조를 해결할 수 있다. 필드를 final로 선언 가능하다. DI 컨테이너를 사용하지 않고도 테스트를 진행할 수 있다.

```java
@Component
public class MadExample {
	
	// final로 선언할 수 있는 보너스
	private final HelloService helloService;

	// '단일생성자'인 경우 추가적인 어노테이션 필요X
	public MadExample (HelloService helloService) {
		this.helloService = helloService;
	}
}
```

### Q. 생성자 주입 사용시 장점은?

- 순환 참조 방지

→ 순환 참조는 A → B를 참조하면서 B → A를 참조하는 경우 발생하는 문제이다.

→ 생성자 주입은 Bean을 먼저 생성하지 않고, 주입하려는 Bean을 찾는다. 때문에 실행시 바로 순환참조 에러가 뜨면서 찾을 수 있다.

- final 선언 가능

→ 생성자 주입시, 의존성 주입이 클래스 인스턴스화 중에 시작되므로 final을 선언할 수 있다. 따라서 객체의 변경을 불가능하게 할 수 있다.

- 테스트 코드 작성 용이

→ 스프링 컨테이너 도움 없이 테스트 코드를 더 편리하게 작성 가능하다.

### Q. Garbage Collection (가비지 컬렉션) 이란?

- C/C++ 언어와 달리, Java는 개발자가 명시적으로 객체를 해제할 필요가 없다. Java 언어의 큰 장점이기도 하다. ***사용하지 않는 객체를 메모리에서 삭제하는 작업***을 Gargabe Collection(GC) 라고 하며, JVM에서 GC를 수행한다.

### Q. 자바 컬렉션 List, Set, Map은?⭐⭐⭐

→ ***List*** : 순서가 있는 데이터의 집합으로, 데이터의 중복 허용

→ ***Set*** : 순서를 유지하지 않는 데이터의 집합으로, 데이터의 중복 허용X

→ ***Map*** : key, value 로 이루어진 데이터의 집합으로, 순서는 유지되지 않으며, 키의 중복을 허용하지 않으나, 값의 중복은 허용

### Q. Spring의 DI에 대한 자세한 설명과 ‘생성자 주입’이 좋은 이유는?

필드주입을 사용하기 되면 배터리 일체형 핸드폰과 같다고 볼 수 있다. 반면에 ‘ Setter주입 ‘과 ‘ 생성자 주입 ‘은 분리형으로 볼 수 있어 보다 유연하다.

### Q. 테스트 코드란?

단위테스트를 실행할 경우, 개발초기에 오류를 발견할 수 있다.

### Q. ORM(Object Relational Mapping)이란?

- ORM이란 ***객체와 DB 테이블이 매핑***을 이루는 것을 말한다. 즉, 객체가 테이블이 되도록 매핑 시켜주는 것이다. (객체-관계 매핑)
- ORM을 이용하면 SQL Query가 아닌 직관적인 코드(메서드)로서 데이터를 조작할 수 있다.

(* 참고 : [https://sanseongko.github.io/java-orm](https://sanseongko.github.io/java-orm))

### Q. JPA의 장단점은?

<aside>
💡 JPA : 현재 자바 진영의 ORM 기술표준으로 ‘인터페이스의 모음’이다. 즉, 실제로 동작하는 것은 아니다. JPA 인터페이스를 구현한 대표적인 오픈소스는 Hibernate 이다.

</aside>

- 장점

→ 생산성 : SQL의 반복작업이 없어진다.

→ 유지보수 : 테이블 컬럼 하나가 바뀌면, Mybatis에서는 관련 DAO의 파라미터, 결과 SQL 등을 모두 확인하여 수정해주어야하지만, JPA는 대신 해준다.

- 단점

→ 성능 : 직접 SQL을 호출하는 것보다 성능이 떨어질 수 있다.

→ 세밀함 : 복잡한 통계 분석 쿼리를 메서드 호출로 처리하기 힘들다. (이러한 문제 보완을 위해 JPA에서 JPQL을 지원한다.)

👉 노션 : https://www.notion.so/Spring-03-5ef57cea947741ac88e9609e5d9ec39a
👉 출처 : [https://wookcode.tistory.com/99](https://wookcode.tistory.com/99)
