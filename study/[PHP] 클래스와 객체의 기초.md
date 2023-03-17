# [PHP] 클래스와 객체의 기초

**클래스(class)와 객체(object)**

객체란 실생활에서 우리가 인식할 수 있는 사물로 이해할 수 있다.
이러한 객체의 상태와 행동은 각각 프로퍼티와 메소드로 구현된다.

또한, 객체를 만들어 내기 위한 틀이나 설계도와 같은 개념이 바로 클래스이다.
즉, PHP에서는 클래스를 가지고 객체를 생성하여 사용하게 된다.

다음 예제는 Car 클래스와 객체를 보여주는 예제이다.

✅ 클래스(Class)

- 차(Car)

✅ 프로퍼티(property)

- $car->modelName = "아반떼"
- $car->modelYear = 2016
- $car->color = "노란색"
- $car->maxSpeed = 180

✅ 메소드(method)

- $car->accelerate()
- $car->brake()

✅ 인스턴스(instance)

- 내 차(myCar)

자동차 인스턴스는 모두 위와 같은 프로퍼티와 메소드를 가지게 될 것이다.
그러나 각 프로퍼티의 값은 인스턴스마다 전부 다를 것이다.

<aside>
💡 프로그래밍에서 인스턴스란 메모리에 생성된 객체를 의미한다.

</aside>

---

**객체 지향 프로그래밍(OOP, Object-Oriented Programming)**

OOP에서는 모든 데이터를 객체로 취급하며 객체가 바로 프로그래밍의 중심이 된다.
이로 인해 코드의 관리가 쉬워지고 적은 노력으로도 손쉽게 코드를 변경, 유지 관리할 수 있다.

객체 지향 프로그래밍이 가지는 특징은 다음과 같다.

1. 추상화(abstraction)
2. 캡슐화(encapsulation)
3. 정보 은닉(data hiding)
4. 상속성(inheritance)
5. 다형성(polymorphism)

캡슐화는 이미 작성된 코드를 수정하지 않고 다시 사용하는 것을 목표로 한다.

또한 정보 은닉을 통해 객체의 실제 구현 내용을 외부에서는 알지 못하도록 감추고 객체의 
인터페이스를 통해서만 데이터에 접근할 수 있도록 하여 보안을 강화한다.

상속은 클래스 간의 계층 관계를 만들어서 논리적이고 체계적으로 다른 클래스의 기능과 데이터를 사용할 수 있게 해준다.

또한, 다형성을 통해 하나의 변수나 함수 이름이 상황에 따라 다른 의미로 해석될 수 있도록 해준다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-a1b55a7cff5840ce8926ee697151b3ec?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_class_basic](http://www.tcpschool.com/php/php_class_basic)
