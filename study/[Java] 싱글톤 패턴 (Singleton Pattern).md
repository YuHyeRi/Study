# [Java] 싱글톤 패턴 (Singleton Pattern)

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/eaaefde0-a65b-42a3-9cd7-2ad4ac045e94/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220627%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220627T021401Z&X-Amz-Expires=86400&X-Amz-Signature=51e7f5c4c33799526b0ef8d701b08ee162378109839eb1d4d2dd8138e223a1d9&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

### *싱글톤 패턴이란?*

싱글톤 패턴의 정의는 단순하다. **객체의 인스턴스가 오직 1개만 생성되는 패턴**을 의미한다. 
싱글톤 패턴을 구현하는 방법은 여러가지가 있지만 여기서는 객체를 미리 생성해두고 가져오는 
가장 단순하고 안전한 방법을 소개하겠다.

```java
public class Singleton {

    private static Singleton instance = new Singleton();
    
    private Singleton() {
        // 생성자는 외부에서 호출못하게 private 으로 지정해야 한다.
    }

    public static Singleton getInstance() {
        return instance;
    }

    public void say() {
        System.out.println("hi, there");
    }
}
```
<br><br>

### *싱글톤 패턴을 사용하는 이유는?*

위와 같이 인스턴스를 오직 한개로만 가져가면 어떤 이점이 있을까?

가장 먼저 떠올릴 수 있는 이점은 아무래도 ‘**메모리 측면**’일 것이다. 최초 한번의 new 연산자를 통해 고정된 메모리 영역을 사용하기 때문에 *추후 해당 객체에 접근할 때 메모리 낭비를 방지할 수 있다.* 뿐만 아니라 이미 생성된 인스턴스를 활용하니 *속도 측면*에서도 이점이 있다고 볼 수 있다.

또 다른 이점은 다른 클래스 간에 데이터 공유가 쉽다는 것이다. 싱글톤 인스턴스가 전역으로 사용
되는 인스턴스이기 때문에 다른 클래스의 인스턴스들이 접근하여 사용할 수 있다. 하지만 여러 
클래스의 인스턴스에서 싱글톤 인스턴스의 데이터에 동시에 접근하게 되면 동시성 문제가 발생할 수 있으니 이점을 유의하여 설계하는 것이 좋다.

이 외에도 도메인 관점에서 인스턴스가 하나만 존재하는 것을 보증하고 싶은 경우 싱글톤 패턴을 
사용하기도 한다.
<br><br>

### *싱글톤 패턴의 문제점*

싱글톤 패턴을 적용하면 위와 같은 효율에서의 이점을 얻을 수 있다. 
그러나 싱글톤 패턴이 다음과 같은 많은 문제점들을 수반하기 때문에 trade-off를 잘 고려해야 한다.

먼저 싱글톤 패턴을 구현하는 코드 자체가 많이 필요하다. 앞서 소개한 구현 방법 외에도 
정적 팩토리 메서드에서 객체 생성을 확인하고 생성자를 호출하는 경우에 멀티스레딩 환경에서 
발생할 수 있는 동시성 문제 해결을 위해 syncronized 키워드를 사용해야 한다.

두번째는 테스트하기 어렵다는 것이다. 싱글톤 인스턴스는 자원을 공유하고 있기 때문에 테스트가 결정적으로 격리된 환경에서 수행되려면 매번 인스턴스의 상태를 초기화시켜주어야 한다. 
그렇지 않으면 어플리케이션 전역에서 상태를 공유하기 때문에 테스트가 온전하게 수행되지 못한다.

세번째로는 의존 관계상 클라이언트가 구체 클래스에 의존하게 된다. new 키워드를 직접 사용하여 클래스 안에서 객체를 생성하고 있으므로, 이는 SOLID 원칙 중 DIP를 위반하게 되고 OCP원칙 또한 위반할 가능성이 높다.

이 외에도 자식 클래스를 만들 수 없다는 점과 내부 상태를 변경하기 어렵다는 점 등 여러가지 
문제들이 존재한다. 

결과적으로 이러한 문제들을 안고 있는 싱글톤패턴은 유연성이 많이 떨어지는 패턴이라고 할 수 있다.
<br><br>

### *결론*

오직 한 개의 인스턴스 생성을 보증하여 효율을 찾을 수 있지만 그에 못지 않게 수반되는 문제점도 많다. 싱글톤 패턴은 안티패턴으로 불릴만큼 단톡으로 사용한다면 객체 지향에 위반되는 사례가 
많다. Spring container 같은 프레임워크의 도움을 받으면 싱글톤 패턴의 문제점들을 보완하면서 
장점의 혜택을 누릴 수 있다. 
실제로 Spring Bean은 Contaioner의 도움을 받아 싱글톤 스콥으로 관리되고 있다.

프레임워크 도움 없이 싱글톤 패턴을 적용하고 싶다면 위에서 살펴본 장단점의 trade-off를 잘 고려하여 사용하는 것이 좋을 것이다.

---
<br><br>

### ***Singleton Pattern (싱글톤 패턴)***

- 프로그래밍을 하다보면 여러개의 인스턴스를 만들었을 때 문제가 발생하는 경우가 존재한다.
(ex. 동일한 날짜를 표시하는 객체, 하나의 회사라는 객체)
- 이러한 경우 프로그램 내에 단 하나의 인스턴스만 생성하여 사용하는 싱글톤 패턴을 사용한다.
- 싱글톤 패턴은 static variable, method를 활용하여 구현할 수 있다.
<br>

***Company.java***

```java
package ch18;

public class Company {
	/* 생성자를 따로 지정안하면 default생성자가 public으로 생성되는데
	singleton에서는 외부에서 마음대로 사용하지못하도록 private으로 생성자를 생성한다.
	그리고 유일한 인스턴스는 내부에서 만든다.
	*/ 
	private Company() {
		
	}
	
	private static Company instance = new Company(); 
	//유일한 인스턴스는 내부에서 만든다.
	
	
	// 인스턴스를 사용할 수 있도록 해주는 public함수
	// 싱글톤 패턴에서 유일한 인스턴스이기 때문에 미리 생성하고 외부에서 호출해야해서 static으로 지정한다.
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}
```
<br>

***CompanyTest.java***

```java
package ch18;

public class CompanyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Company company1 = Company.getInstance();
		Company company2 = Company.getInstance();
		
		System.out.println(company1);
		System.out.println(company2);
		// 하나의 인스턴스로 생성한 것이기 때문에 주소공간이 같다.
	}
}
```
<br><br>
👉 notion : https://www.notion.so/Java-Singleton-Pattern-57ba6887ba7940878099ca234312488d
<br>
👉 Reference : [https://velog.io/@seongwon97/Java-Singleton-Pattern-싱글톤-패턴](https://velog.io/@seongwon97/Java-Singleton-Pattern-%EC%8B%B1%EA%B8%80%ED%86%A4-%ED%8C%A8%ED%84%B4)
<br>
[https://tecoble.techcourse.co.kr/post/2020-11-07-singleton/](https://tecoble.techcourse.co.kr/post/2020-11-07-singleton/)
