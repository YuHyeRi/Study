# [Spring] spring 개념정리 1탄

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/09334d5f-51f7-4f8c-be41-4e2355bc1b13/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220310%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220310T012308Z&X-Amz-Expires=86400&X-Amz-Signature=53ab6991c8baf8201acf40c4466ee139294ca106252c68959c4db1cc5c4b2929&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

> **동작순서**
> 
1. 클라이언트(사용자)의 모든 요청은 DispatcherServlet이 받는다.
2. DispatcherServlet은 handlerMapping을 통해 요청에 해당하는 Controller를 실행
3. Controller는 적절한 서비스 객체를 호출 시킨다.
4. Servicee는 DB처리를 위해 Dao를 이용하여 데이터를 요청한다.
5. Dao는 Mybatis를 이용하는 Mapper를 통해 작업을 처리한다.
6. 처리한 데이터(결과)가 Mapper → Dao → Service → Controller로 전달된다.
7. Controller는 전달된 결과(처리된 데이터)를 View Resolver를 통해 전달받을 View가 있는지 검색한다.
8. 전달받은 View가 있다면 View에게 전달된 결과(처리된 데이터)를 전달한다.
9. View는 전달받은 결과(처리된 데이터)를 다시 DispatcherServlet에게 전달한다.
10. DispatcherServlet은 전달받은 결과(처리된 데이터)를 클라이언트에게 전달한다.

> **특징**
> 

고객이 대표전화로 전화를 걸면 상담원이 받아 관련 부서로 전화 연결을 해 주듯이 가장 먼저 전화를 받는 상담원이 바로 DispatcherServlet 이다.

(* DispatcherServlet의 등장은 web.xml의 역할을 상당히 축소시켜주었다. 기존에는 모든 Servlet에 대해 URL 매핑을 활용하기 위해서 web.xml에 모두 등록해주어야 햇지만, DispatcherServlet 이 해당 어플리케이션으로 들어오는 모든 요청을 핸들링해주면서 작업을 상당히 편리하게 할 수 있게 되었다.)

이 패턴으로 많은 개발자들이 함께 개발할 때 규격화 된 코드를 작성할 수 있고 공통된 코드를 각각의 컨트롤러가 아닌 DispatcherServlet에 한번만 작성하면 되므로 개발 시간도 크게 단축 되었다.

즉, 클라이언트로부터 오는 모든 요청은 DispatcherServlet을 거친다. 이때, DispatcherServlet 으로 들어온 요청은 HandlerMapper로 가서 각각의 요청 URL을 key로 해서, 해당되는 value. 즉, 등록된 URL과 일치하는 컨트롤러를 찾는다.

Controller는 Model과 View를 이어주는 역할을 한다. 비즈니스 로직이 구현되어 있다. 기존에는 컨트롤러 설정을 위해 xml을 사용하였는데 이제는 어노테이션을 사용하여 간편하게 설정할 수 있다. 각 메서드마다 필요한 어노테이션을 설정할 수 있기 때문에 여러 메서드를 하나의 컨트롤러에 집중해서 작성이 가능하다. 각각의 컨트롤러에서 요청에 대한 처리를 한 후, 데이터를 View를 통해 사용자에게 제공한다.

Spring Controller는 View에 의존적이지 않다. 

이유는, 컨트롤러에서 로직 처리를 한 후 뷰의 이름만 지정해주면 ViewResolver에서 View 객체를 생성한다. 이렇게 생성한 뷰 객체를 통해, 사용자는 원하는 데이터를 제공받을 수 있게 된다.

> **용어**
> 

### 🟡 **IoC (Inversion of Control) :** 제어의 역전, 제어의 흐름을 바꾼다.

→ 메소드나 객체의 호출작업을 개발자가 결정하는 것이 아니라, 외부에서 결정되는 것을 의미

→ 객체의 의존성을 역전시켜 객체 간의 결합도를 줄이고 ***유연한 코드를 작성할 수 있게 하여*** 가독성 및 코드중복, 유지보수를 편하게 할 수 있게 한다.

초기에는 객체 간의 의존관계를 연결하는 동안 제어권을 개발자가 직접 가지고 있었는데 이 제어권이 스프링 컨테이너로 넘어가서 객체의 생성부터 생명주기의 관리까지 스프링 컨테이너가 하는 것을 의미하는 용어.

***즉, 모든 객체에 대한 제어권이 바뀐 것을 IoC, 제어의 역전이라 한다.***

Dependency Injection(의존성 주입)과 Inversion Of Control(제어의 역전)은 같은 의미로 사용된다. IoC는 DI를 통해 달성된다.

### 🟡 DI (Dependency Injection) : 의존성 주입

→ 스프링이 다른 프레임워크와 차별화되어 제공하는 의존 관계 주입 기능으로, ***객체를 직접 생성하는 것이 아니라 외부에서 생성한 후 주입 시켜주는 방식***

→ DI를 통해 모듈 간의 결합도가 낮아지고 유연성이 높아진다.

객체를 직접 생성하는 것이 아니라 외부에서 생성한 후 주입을 시켜주는 방식을 의미한다. 스프링 프레임워크는 Framework 레벨에서 DI를 제공해준다. DI를 이용하며 이를 통해 Life Cycle을 용이하게 관리할 수 있으며 이것이 스프링 프레임워크의 핵심적인 동작이라고 할 수 있다.

### 🟡 AOP (Aspect Oriented Programming) : 관점 지향 프로그래밍

Spring의 핵심 개념 중 하나인 DI가 애플리케이션 모듈들 간의 결합도를 낮춰준다면, AOP는 애플리케이션 전체에 걸쳐 사용되는 기능을 ***재사용하도록*** 지원하는 것. 기존에 OOP에서 바라보던 관점을 다르게 하여 부가기능적인 측면에서 보았을 때 공통된 요소를 추출하는 것이다.

AOP 방법은 ‘핵심기능’과 ‘공통기능’을 분리시켜놓고, 공통기능을 필요로 하는 핵심 기능들에서 사용하는 방식이다.

### 🟡 서비스 추상화

→ ***코드들을 비슷한 것들끼리 모으고(강한 응집력), 서로 다른 코드들이 서로를 구속하지 않는(낮은 결합도) 프로그램 개발을 말하는 것이다.***

<aside>
💡 추상화란 ***하위 시스템의 공통점을 뽑아내서 분리시키는 것을 말한다.*** 그렇게하면 하위 시스템이 어떤 것인지 알지 못해도, 또는 하위 시스템이 바뀌더라도 일관된 방법으로 접근할 수 있다.                                                                                                           *- 토비의 스프링 중*

</aside>

즉, 개발환경 혹은 어떤 비즈니스 로직을 위한 로우레벨의 기술에 구애 받지 않게 하기 위해서, 그리고 책임을 분리 시키기위한 추상화 개념이다.

예를 들자면, 아주 많은 DB의 종류가 있다. 그렇다면 각자를 관리하기 위해 각각 다른 트랜잭션 코드가 필요하다면? 만약 DB가 바뀌가 된다면 그에 따라 트랜잭션 관리 코드 또한 바뀌어야 할 것이다. 여기서 중요한 개념이 바로 ‘서비스 추상화’ 개념이다.

트랜잭션을 관리하기 위한 최상위 인터페이스를 선언하고 각 DB에 대한 transactionManager 클래스를 DI 해주면? 트랜잭션 관련 코드는 통일되는 동시에 DB가 바뀐다면 DI 설정 xml 파일만 교체해주면 된다. *DB가 바뀌게 되더라도 트랜잭션 관련 코드의 변경은 하나도 없는 것이다.* 이것이 바로 서비스 추상화의 장점인 것이다.


#### 👉 노션 : https://www.notion.so/Spring-spring-1-bcee822e28534fd292d1e5e821661d95
#### 👉 출처 : [https://buddev.tistory.com/72](https://buddev.tistory.com/72)
#### 👉 출처 : [https://velog.io/@gillog/Spring-DIDependency-Injection](https://velog.io/@gillog/Spring-DIDependency-Injection)
