# Spring -01

### Q. 스프링 프레임워크란?

- 자바 플랫폼을 위한 오픈 소스 애플리케이션 프레임워크
- 동적인 웹 사이트 개발을 위한 여러 가지 서비스를 제공함
- 대한민국 공공기관의 웹 서비스 개발 시 사용을 권장하고 있는 전자정부 표준 프레임워크

### Q. 스프링의 특징은?

- **DI (Dependency Injection) → 의존성 주입**

: 설정 파일이나 어노테이션을 통해 객체간의 의존관계를 설정하여 개발자가 직접 의존하는 객체를 생성할 필요가 ❌

- **AOP (Aspect Oriented Programming) → 관점 지향 프로그래밍**

: 트랜잭션, 로깅, 보안 등 여러 모듈, 여러 계층에서 공통으로 필요로 하는 기능의 경우, 해당 기능을 분리해 관리

- **IoC (Inversion of Control) → 제어 반전**

: 컨트롤의 제어권이 개발자가 아닌 프레임워크에 있다는 뜻

: 객체의 생성부터 모든 생명주기의 관리까지 프레임워크가 주도하고 있다.

: 객체를 생성하고 직접 호출하는 것이 아니라, 만들어둔 자원을 호출하여 사용한다.

- **POJO (Plain Old Java Object)**

: 일반적인 J2EE 프레임워크에 비해 특정 라이브러리를 사용할 필요가 없어 개발이 쉽다.

: 기존 라이브러리의 지원이 용이하다.

### Q. 의존성 주입이란?

IoC (Inversion of Control)의 한 측면인 의존성 주입은 개체를 수동으로 생성하지 않고 대신 생성 방법을 설명하는 일반적인 개념이다. IoC 컨테이너는 필요한 경우 필요한 클래스를 인스턴스화 한다.

### Q. Spring MVC

→ 데이터와 화면 간의 의존관계를 벗어날 수 있게 하는 개발 기법

***→ 역할을 나누어 처리하기 때문에 서로의 결합도가 낮아져 좋은 코드가 되며 유지보수가 쉬움***

- **Model** : 논리적 데이터 기반 구조를 표현, 사용자 인터페이스에 관한 어떠한 정보도 가지고 있지 않음 → data 처리와 접근을 담당
- **View** : 사용자 인터페이스 내의 구성요소들을 표현 → 사용자에게 보여지는 화면
- **Controller** : Model과 View를 연결하고 있는 클래스를 대표 → Model과 View 내의 클래스들 간 정보교환

<aside>
💡 컨트롤러 : 간단히 말해서 DispatcherServlet에서 처리하는 모든 요청은 @Controller 어노테이션이 달린 클래스로 전달된다. 각 컨트롤러 클래스는 제공된 입력으로 요청을 처리하고 실행하는 메서드에 하나 이상의 요청을 매핑한다.

</aside>

### Q. Spring에서 Bean이란?

Spring Bean은 Spring IoC 컨테이너에 의해 초기화되는 Java Object 이다.

### Q. Spring Framework의 기본 Bean 범위는?

기본적으로 Spring Bean은 ***싱글톤***으로 초기화 된다.

### Q. Spring에 Bean을 어떻게 주입할 수 있나?

- 세터 주입
- 생성자 주입
- 필드 주입

구성은 XML 파일 또는 어노테이션을 사용하여 수행할 수 있다.

### Q. Bean을 주입하는 가장 좋은 방법은 무엇이며 그 이유는?

권장되는 접근 방식은 필수 의존성에는 생성자 인수를 사용하고, 선택적 의존성에는 설정자를 사용하는 것이다. 생성자 주입을 사용하면 불변 필드에 값을 주입하고 테스트를 더 쉽게 할 수 있다.

### Q. model1과 model2 패턴의 차이점은?

- **model1** : 뷰와 로직을 모두 jsp 페이지 하나에서 처리
- **model2** : jsp페이지와 servlet, 그리고 로직을 위한 클래스가 나뉘어 브라우저 요청을 한다.

### Q. Servlet과 JSP란?

- **Servlet**

: 자바 언어로 웹 개발을 위해 만들어진 것

: Container가 이해할 수 있게 구성된 순수 자바 코드로만 이루어 진 것

- **JSP**

: html 기반에 자바 코드를 블록화하여 삽입한 것

: Servlet을 좀 더 쉽게 접근할 수 있도록 만들어 진 것

### Q. Spring AOP와 OOP를 비교하여 설명하라.

**AOP**는 ***Aspect Oriented Programming***의 약자로, ‘ **관점 지향 프로그램** ‘ 이라고 한다. 애플리케이션의 핵심적인 기능과 부가적인 기능을 분리하여 Aspect라는 모듈로 만들어 설계하고 개발하는 방법이다. 

**OOP**는 ***Object Oriented Programming***의 약자로 ‘ **객체 지향 프로그래밍** ‘ 이라고 한다. 

OOP와 AOP는 서로 상반되는 개념은 아니며, 오히려 OOP를 더욱 OOP답게 사용할 수 있도록 하는 것이 AOP이다. 

공통적인 기능을 모든 모듈에 적용하기 위한 방법으로 상속을 이용하는데 Java 에서는 다중 상속이 불가능하다. 그리고 기능 구현 부분에서 핵심 코드와 공통 기능 코드가 섞여있어서 가독성도 떨어지고 효율성이 떨어진다. 이러한 이유로 AOP가 등장했다.

### Q. Spring MVC 동작방식은?

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ef629eda-79ea-4ca1-b551-acaf449f22ec/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220313%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220313T033853Z&X-Amz-Expires=86400&X-Amz-Signature=e9424a13045a72826eb1f1628a38d972daf9eeb0b6c710051ce31c6528ec12b1&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

1. 브라우저로부터 요청이 오면 DispatcherServlet이 그 요청을 받는다.
2. DispatcherServlet은 요청된 url을 HandlerMapping 객체에게 넘기고, 호출해야 할 Controller 메서드(핸들러) 정보를 얻는다.
3. DispatcherServlet이 HandlerAdapter 객체를 가져온다.
4. HandlerAdapter 객체의 메서드를 실행한다.
5. Controller 객체는 비즈니스 로직을 처리하고, 그 결과를 바탕으로 뷰에 전달할 객체를 Model 객체에 저장한다. DispatcherServlet에게 View name을 리턴한다.
6. DispatcherServlet은 View name을 View Resolver에게 전달하여 View 객체를 얻는다.
7. DispatcherServlet은 View 객체에 화면 표시를 의뢰한다.
8. View 객체는 해당하는 뷰 (jsp, thymeleaf,...) 를 호출하며 View는 Model 객체에서 화면 표시에 필요한 객체를 가져와 화면 표시를 처리한다.

### Q. WAS와 WS의 차이는?

- **WAS** (Web Application Server) : 비즈니스 로직을 넣을 수 ⭕ (Tomcat, PHP, ASP, Net 등)
- **WS** (Web Server) : 비즈니스 로직을 넣을 수 ❌ (Nginx, Apache 등)

### Q. JSTL은 무엇이고 사용하는 이유는 무엇인가?

JSP 표준 태그 라이브러리의 약자로, 자신만의 태그를 추가할 수 있는 기능을 제공한다. 주로 JSTL의 core에서 c를 사용하여 <c:if>, <c:forEach> 등으로 사용한다.

### Q. json VS xml

- **json**

: json은 경량의 DATA-교환 형식, 데이터를 저장하고 전달하는 메타언어이다.

: javaScript에서 객체를 만들 때 사용하는 표현식을 의미한다.

: 장점 → json은 문자열을 전송받은 후에 해당 문자열을 바로 파싱, xml보다 빠른 속도를 가짐

: 단점 → json은 개발자가 문자열 데이터의 무결성을 검증해야 함

- **xml**

: xml은 html과 매우 비슷한 문자 기반의 마크업 언어(text-based markup language)

: 장점 → 스키마를 사용하여 데이터의 무결성을 검증할 수 있음

: 단점 → xml은 배열을 사용할 수 ❌ (json은 배열 사용 ⭕), 데이터를 읽고 쓰는 것이 json 대비 느림

### Q. 동기 VS 비동기식

- **동기식** : 요청과 결과가 ***동시에 ⭕***. 설계가 간단하지만 ***결과가 나올때까지 아무것도 못하고*** 대기해야 하므로 비동기식보다 비효율적이다.
- **비동기식** : 요청과 결과가 ***동시에 ❌***. ***하나의 요청을 처리하는 동안 다른 요청도 처리 가능.*** 동기보다 복잡하고 결과가 주어지는데 시간이 걸리더라도 그동안 다른 작업을 할 수 있으므로 자원을 보다 효율적으로 사용할 수 있음

### Q. AJAX란?

Ajax는 JavaScript의 라이브러리 중 하나이며Asynchronous Javascript And Xml (비동기식 자바스크립트와 xml) 의 약자이다. 전체 페이지를 새로 고치지 않고도 페이지의 일부만을 위한 데이터를 로드하는 기법이며 Ajax를 한마디로 정의하자면, ***JavaScript를 사용한 비동기 통신***, ***클라이언트와 서버 간의 XML 데이터를 주고 받는 기술***이라고 할 수 있다.

***[ 특징 ]***

- 전체 페이지를 갱신하지 않고 일부만 업데이트 가능
- 사용자에게 즉각적인 반응과 풍부한 UI 경험 제공 가능
- ActiveX나 플러그인 프로그램 설치 없이 이용 가능
- JavaScript 방식, jQuery 방식으로 구현 가능

***[ 단점 ]***

- javaScript 이므로 브라우저에 따른 크로스 브라우저 처리가 필요
- 오픈 소스로 차별화가 어려움
- 연속적인 데이터 요청 시, 서버 부하가 증가하여 페이지가 느려짐
- 페이지 내 복잡도가 증가하여 에러 발생시 디버깅이 어려움

### Q. jQuery란?

자바스크립트 라이브러리로 간단한 문법으로 ajax를 사용할 수 있음

### Q. 스프링 VS 스프링부트

<aside>
💡 스프링 부트 : Spring Boot는 가장 적은 양의 코드로 Spring 애플리케이션을 실행할 수 있도록 상용구 구성을 줄이기 위해 미리 구성된 프레임워크 세트를 제공하는 프로젝트이다.

</aside>

- Embed Tomcat을 사용하기 때문에 따로 Tomcat을 설치하거나 매번 버전을 관리해주어야 하는 수고로움을 덜어준다. (Spring Boot 내부에 Tomcat이 포함되어 있다.)
- starter를 통한 dependency 자동화

아마 Spring 유저들이 가장 열광한 기능이 아닐까 싶다. 과거 Spring Framework에서는 각각의 dependency 들의 호환되는 버전을 일일이 맞추어 주어야 했고, 때문에 하나의 버전을 올리고자 하면 다른 dependency 에 까지 영향을 미쳐 version 관리에 어려움이 많았다. 그러나 이제 starter가 대부분의 dependency 를 관리해주기 때문에 이러한 걱정을 많이 덜게 되었다.

- XML 설정을 하지 않아도 된다.
- jar file을 이용해 자바 옵션만으로 손쉽게 배포가 가능하다. Spring Actuaor 를 이용한 애플리케이션의 모니터링과 관리를 제공한다.

### Q. @RequestMapping 어노테이션은 어떻게 작동하는가?

Spring 컨트롤러 방법으로 웹 요청을 매핑하는데 사용된다. 간단한 사용 사례 외에도 HTTP 헤더 매핑, URI의 일부를 @PathVariable로 바인딩, URI 매개변수 및 @RequestParam 어노테이션 작업에 사용할 수 있다.

👉 노션 : https://www.notion.so/Spring-01-78219b93cf5c4ea0b56bcf5721f47b45

👉 출처 : [https://velog.io/@kk1112k/백엔드-개발-기술면접-정리-Spring-추가중](https://velog.io/@kk1112k/%EB%B0%B1%EC%97%94%EB%93%9C-%EA%B0%9C%EB%B0%9C-%EA%B8%B0%EC%88%A0%EB%A9%B4%EC%A0%91-%EC%A0%95%EB%A6%AC-Spring-%EC%B6%94%EA%B0%80%EC%A4%91)

[https://recordsoflife.tistory.com/302](https://recordsoflife.tistory.com/302)

[https://wookcode.tistory.com/99](https://wookcode.tistory.com/99)
