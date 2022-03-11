# [Java] Java 개념정리 1탄

> **자바를 사용하는 이유**
> 
- 객체 지향 개념의 특징인 캡슐화, 상속, 다형성, 추상이 잘 적용된 언어
- Garbage Collector를 통한 메모리 관리 기능
- Multi-thread를 지원함

<aside>
💡 멀티 스레드(multi thread) : 일반적으로 하나의 프로세스는 하나의 스레드를 가지고 작업하나, 멀티 스레드는 ***하나의 프로세스 내에서 둘 이상의 스레드가 동시에 작업을 수행하는 것***을 의미한다.

</aside>

---

> **용어정리 - JVM**
> 

**🟣 JVM (Java Virtual Machine, 자바 가상 머신)**

메모리관리, gc를 수행하는 스택 기반의 가상머신

왜 알아야 하는가? 한정된 메모리를 효율적으로 사용하여 최고의 성능을 내기 위하여

따라서 메모리를 효율적으로 사용하기 위해서는 메모리의 구성과 각 특징에 대하여 이해할 필요⭕

**🟣 JRE (Java Runtime Environment, 자바 실행 환경)**

JRE는 자바 가상 머신이 자바 프로그램을 동작시킬 때 필요한 라이브러리 파일들과 기타 파일들을 가지고 있다. JRE는 JVM의 실행환경을 구현했다고 할 수 있다. (때문에 운영체제에 종속적)

**🟣 JDK (Java Development Kit, 자바 개발 도구)**

JRE + 개발을 위해 필요한 도구(java, javac, ...) 들을 포함한다.

---

> **객체지향이란?**
> 

객체란 기존의 방식인 변수 따로 함수 따로의 분산적이고 통일성 없는 추상화 과정을 ***통합***하여 표현대상(문제해결대상)을 좀 더 캡슐화 하기 쉽게 도와주는 도구이다. 캡슐화를 통한 정보은닉화, 상속 및 다형성을 통한 확장성과 재사용성을 얻고 이를 기반한 생산성과 유지보수의 용이성이 객체지향의 진정한 특징이다.

프로그래밍에서 필요한 데이터를 추상화시켜 상태와 행위를 가진 객체를 만들고 그 객체들 간의 유기적인 상호작용을 통해 logic을 구성하는 프로그래밍 방법을 의미한다.

**🟡 장점**

- **코드 재사용 용이** : 남이 만든 클래스를 가져와서 사용할 수 있고 상속을 통해 확장해서 사용가능
- **유지보수 용이**

→ 절자치향 : 요구사항의 변화가 데이터 구조와 코드를 변화시킴. 그 코드를 쓰는 모든 곳을 바꿔야 하마. 유지보수가 어려움

→ 객체지향 : 요구사항의 변화가 캡술화 된 클래스의 내부 구조를 변경하면, 이 클래스를 가져다쓰는 코드를 변경할 필요가 없어짐. 유지보수가 쉬움

- **대형 프로젝트에 적합** : 클래스 단위로 모듈화를 시켜 개발할 수 있으므로 대형 프로젝트 시 업무 분담이 쉬움

**🟡 단점**

- 처리 속도가 상대적으로 느림
- 객체가 많으면 용량이 커질 수 있음

---

> **Overriding**
> 

***→ 상위 클래스가 가지고 있는 메서드를 하위 클래스가 재정의하여 사용***

상속 받은 메서드와 기능이 동일하지만, 상세 구현이 조금 다른 경우 이를 반영하기 위해 새로운 메서드를 작성해야 하는데, 이 때 메서드 이름과 인자 리스트, 리턴 타입을 기존에 상속 받은 메서드와 동일하게 선언한다.

- 리턴 타입은 (같거나, 1.8부터는 sub class도 ⭕)
- 접근 제어자는 같거나, 넓은 범위 (줄이면 컴파일 error!!)
- 예외는 같거나 부모에러보다 하위 클래스의 에러이거나 아예 안하거나 (더 상위 에러를 던지면 컴파일 error!!)

상속 받은 메서드와 이름, 인자가 같으므로 메서드를 호출하는 방법이 같고, 리턴 타입 또한 같아서 호출 후 처리하는 방법이 같아지므로 기존 코드를 변경하지 않고도 수정된 내용을 반영할 수 있다. 또한 하나의 코드로 여러 객체를 처리할 수 있게 된다. 차, 버스, 택시 이걸 다 차 타입의 배열에 담고 객체마다 기능이 다를 경우에도 하나의 for문을 돌리면서 객체별로 재정의한 함수를 수행하면 되어서 편하다.

부모클래스에 디폴트 생성자가 반드시 있어야 한다.

없다면, 자식 클래스에서 부모의 다른 생성자 (인자 있는 생성자)를 명시적으로 호출해주어야 한다. (만약, 자식 생성자에서 부모를 한번도 호출하지 않으면, 자동으로 부모의 디폴트 생성자를 호출하는데 없으면 error!!!)

+부모클래스에 정의 된 static 메서드를 자식클래스에서 똑같은 이름의 static 메서드로 정의할 수 있지만, 이것은 각 클래스에 별개의 static 메서드를 정의한 것일 뿐, 오버라이딩 ❌. (static 멤버들은 자신들이 정의된 클래스에 묶여있다고 생각)

- ***예제***

```java
// 부모 클래스
class Woman {
	public String name;
	public int age;

	// info 메서드
	public void info() {
		System.out.println("여자의 이름은 " + name + "이고 나이는 " + age + "살 입니다!");
	}
}

// Woman클래스(부모클래스)를 상속 받음
class Job extends Woman {
	String job;

	// Woman클래스(부모클래스)에 있는 info() 메서드를 재정의
	public void info() {
		super.info();
		System.out.println("여자의 직업은 " + job + "입니다.");
	}
}

public class OverTest {
	public static void main(String[] args) {
	
		// Job 객체 생성
		Job job = new Job();

		// 변수 설정
		job.name = "혜리";
		job.age = 32;
		job.job = "프로그래머";

		// 함수 호출
		job.info();
	}
}
```

- ***실행결과***

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/0cec3b49-bae2-41f3-b82b-4f8fc6ae16ae/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220311%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220311T043948Z&X-Amz-Expires=86400&X-Amz-Signature=92d1f29e7f89db03ff670dc668468fb8e7ade74f30c86eb411b78cab31216bca&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

Job class(자식클래스)에서 Woman class(부모클래스)를 상속받아 부모클래스에 있는 info()를 재정의하여 사용하였고, 메인 메서드에서 Job 객체를 생성하고 호출하였기 때문에 Job 클래스의 내용이 실행되었다.

부모클래스의 info()와는 다르다. 부모클래스를 호출하였다면, 실행결과는 < 여자의 이름은 “혜리”, 나이는 32살 입니다. > 가 되었을 것이다. 자식클래스만 호출했을 경우 부모클래스의 내용도 그대로 가져오고 싶을 때는 어떻게 해야할까? 여자의 이름과 나이, 직업을 모두 알고 싶을 때는 똑같이 재정의 해도 되고, super 예약어를 사용해도 된다.

- ***예제소스  1***

```java
class Job extends Woman {
	String job;
	
	public void info() {
		System.out.println("여자의 직업은 " + job + "입니다.");
		System.out.println("여자의 이름은 " + name + ", 나이는 " + age + "살 입니다."); // 추가
	}
}
```

- ***예제소스 2***

```java
class Job extends Woman {
	String job;

	public void info() {
		super.info(); // 추가
		System.out.println("여자의 직업은 " + job + "입니다.");
	}	
}
```

- ***실행결과***

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/19204978-25cf-4934-8297-d7d1fe4b4bd4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220311%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220311T044014Z&X-Amz-Expires=86400&X-Amz-Signature=430cb9f450a0c4c2fc9a5160b1f4b023877c12bfa9d0ac0ed38dbbcb2d4795d5&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

🟠 부모클래스에 있던 변수들은 자식클래스에서 상속 받았기 때문에 자식클래스에서 선언을 해주지 않았더라도 사용할 수 있다.

🟠 super 예약어를 사용하는 이유는 자식클래스에서 재정의된 info() 메서드에 의해 부모클래스에 있는 info() 메서드가 덮어쓰여지기 때문이다.

---

> **Overloading**
> 

***→ 같은 이름의 메서드 여러개를 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술***

→ *‘메서드 오버로딩’*과 ‘생성자 오버로딩’이 있고(같은 개념이라고 볼 수 있음), ***같은 이름의 메서드를 여러 개 정의***하고 ***매개변수의 유형과 개수를 다르게 하여*** 다양한 유형의 호출에 응답할 수 있게 됨

하나의 클래스나 상속 받은 클래스 내에 같거나 비슷한 기능의 메서드 이름을 같게 정의하여 편리성을 추구한다. 메서드의 이름 동일하여야 하고, 파라미터 리스트는 반드시 달라야 한다. (개수, 타입, 순서) 이것들로 메서드를 구분한다. 리턴, 접근제어자는 상관❌ . 메서드를 호출할 때 인자에 따라 구별할 필요 없이 같은 이름으로 호출하면 알아서 알맞는 인자의 메서드를 불러준다.

- ***예제***

메서드 이름이 cat인 메서드가 3개가 있지만, 각각 매개변수의 유형과 개수가 다르다.

호출 시 매개변수를 입력하면 호출 매개변수에 따라 매칭되어 맞는 함수를 실행시켜 준다.

```java
class OverLoadingTest {
	
	// cat 메서드
	void cat() {     
		System.out.println("매개변수 없음");
	}

	// 매개변수 int형이 2개가 있는 cat 메서드
	void cat(int i, int j) {
		System.out.println("매개변수 : " + i + "," + j);
	}

	// 매개변수 String형이 1개가 있는 cat 메서드
	void cat(String foo) {
		System.out.println("매개변수 : " + foo);
	}
}

public class OverTest {
	public static void main(String[] args) {
		
	// OverLoadingTest 객체 생성
	OverLoadingTest ot = new OverLoadingTest();

	// cat() 호출
	ot.cat();

	// 매개변수가 int형 2개인 cat() 호출
	ot.cat(10,20);

	// 매개변수가 String형 1개인 cat() 호출
	ot.cat("오늘은 2022년 3월 11일 입니다.");
	
	}	
}
```

- ***실행결과***

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/258484b6-b22d-4070-bf0d-2afff03e0d75/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220311%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220311T044035Z&X-Amz-Expires=86400&X-Amz-Signature=8e92d0542c822e39681017759b02d9a21ceb234203b63d0ddb8a541b1ad8b384&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/86960cd7-4485-4f7a-a61d-ecb965f318c4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220311%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220311T044047Z&X-Amz-Expires=86400&X-Amz-Signature=2a2fb6d34de7a6e77eebf2f6e14b3fad47b9970f97a1ef430b304ee8e2eb3e19&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

👉 노션 : https://www.notion.so/Java-Java-1-a6c0763caf674253809834fa1acc36ed

👉 출처 : [https://buddev.tistory.com/73](https://buddev.tistory.com/73)

👉 출처 : [https://private.tistory.com/25](https://private.tistory.com/25)
