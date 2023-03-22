# [PHP] OOP_상속

**상속(inheritance) 이란?**

상속이란 기존의 클래스에 기능을 추가하거나 재정의하여 새로운 클래스를 만드는 것을 의미한다.
이러한 상속은 캡슐화, 추상화와 더불어 객체 지향 프로그래밍을 구성하는 중요한 특징 중 하나이다.

상속을 이용하면 기존에 정의되어 있는 클래스의 모든 프로퍼티와 메소드를 물려받아 새로운 
클래스를 생성한다.
이 때 기존에 미리 정의되어 있던 클래스를 부모 클래스 또는 상위 클래스라고 한다. 
그리고 상속을 통해 새롭게 작성되는 클래스를 자식 클래스 또는 하위 클래스라고 한다.

---

**상속(inheritance)**

PHP에서는 상속을 통해 클래스 간의 계층 관계를 만들 수 있다.
자식 클래스는 부모 클래스의 모든 public, protected 멤버를 상속받게 된다.

PHP에서는 extend 키워드를 사용하여 상속을 정의한다.

다음 예제는 A클래스를 상속받는 B클래스를 정의하는 예제이다.

```php
class B extends A
{
    B 클래스만의 프로퍼티와 메소드;
}
```

위의 예제에서 B클래스는 A클래스의 자식 클래스가 되고, 반대로 A클래스는 B클래스의 부모 클래스가 된다.
B클래스는 A클래스의 private 멤버르르 제외한 모든 프로퍼티와 메소드를 상속받아 사용할 수 있다.
여기에 필요하다면 자신만의 프로퍼티와 메소드를 추가할 수 있다.

이렇게 상속을 이용하면 기존에 작성된 클래스를 손쉽게 재활용할 수 있다.
또한 공통적인 부분은 부모 클래스에 미리 작성하여 자식 클래스에서 중복되는 부분을 제거할 수도 있다.

PHP에서는 둘 이상의 부모 클래스에서 프로퍼티와 메소드를 상속받을 수는 없다. 
하나의 부모 클래스가 여러 자식 클래스를 가질 수는 있지만 자식 클래스는 오직 부모 클래스 하나만 가질 수 있다.

---

**오버라이딩(overriding)**

오버라이딩이란 이미 정의된 메소드를 같은 이름의 메소드로 다시 정의하는 것이라고 할 수 있다.
즉, 메소드 오버라이딩이란 상속받은 부모 클래스의 메소드를 재정의하여 사용하는 것을 의미한다.
PHP에서는 부모 클래스의 메소드와 이름만 작성하면 해당 메소드르르 오버라이딩 할 수 있다.

다음 예제는 자식 클래스에서 상속받은 메소드를 오버라이딩하는 예제이다.

```php
class A
{
    public $property = "class A";
    public function showProperty()
    {
        echo $this->property."<br>";
    }
}

class B extends A                    // 클래스 A를 상속 받음.
{
    public $property = "class B";
    public function showProperty()   // 클래스 A의 메소드를 오버라이딩
    {
        echo "hello ".$this->property."<br>";
    }
}

$a = new A();
$a->showProperty();                  // 클래스 A의 메소드 호출
$b = new B();
$b->showProperty();                  // 클래스 B의 메소드 호출
```

위의 예제에서 자식 클래스인 B클래스는 부모 클래스인 A클래스로부터 상속받은 showProperty 
메소드를 오버라이딩하여 사용한다.
따라서 B클래스의 인스턴스인 $b에서 showProperty 함수를 호출하면 오버라이딩 된 B클래스의 showProperty 함수가 호출된다.

<br><br>
👉🏻 출처 : https://www.notion.so/tgmary09/PHP-OOP_-3641cb10c096461c91533f93d5110a05?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_oop_inheritance](http://www.tcpschool.com/php/php_oop_inheritance)
