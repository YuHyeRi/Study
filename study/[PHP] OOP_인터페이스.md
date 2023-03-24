# [PHP] OOP_인터페이스

**추상 메소드(abstract method)**

추상 메소드란 자식 클래스에서 반드시 오버라이딩해야만 사용할 수 있는 메소드를 의미한다.
이러한 추상 메소드는 선언부만이 존재하며 구현부는 작성되어 있지 않다.
바로 이 작성되어 있지 않은 구현부를 자식 클래스에서 오버라이딩하여 사용하는 것이다.

```php
abstract 접근제어자 function 메소드이름();
```

위와 같이 선언부만 있고 구현부가 없다는 의미로 선언부 끝에 바로 세미콜론(;)을 추가한다.

---

**추상 클래스(abstract class)**

PHP에서는 최소한 하나 이상의 추상 메소드를 포함하는 클래스를 추상 클래스라고 한다.
이러한 추상 클래스는 객체 지향 프로그래밍에서 중요한 특징인 다형성을 가진 메소드의 집합을 
정의할 수 있게 해준다.
즉, 반드시 사용되어야 하는 메소드르르 추상 클래스에 추상 메소드로 선언해 놓으면, 
이 클래스를 상속받는 모든 클래스에서는 이 추상메소드를 반드시 재정의해야 한다.

```php
abstract class AbstractClass            // 추상 클래스
{
    abstract protected function move(); // 추상 메소드
    abstract protected function stop();

    public function start() // 공통 메소드
    {
        ...
    }
}
```

이러한 추상 클래스는 동작이 정의되어 있지 않은 추상 메소드를 포함하고 있으므로, 인스턴스를 
생성할 수 없다.
추상 클래스는 먼저 상속을 통해 자식 클래스를 만들고 만든 자식 클래스에서 추상 클래스의 
모든 추상 메소드를 오버라이딩하고 나서야 비로소 자식 클래스의 인스턴스를 생성할 수 있게 된다.

---

**인터페이스(interface)**

PHP에서 인터페이스란 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할도 담당하는 일종의 추상 클래스를 의미한다.

인터페이스를 사용하면 클래스가 반드시 구현해야 할 메소드가 어떻게 동작하는지를 알 필요 없이 다른 부분의 코드를 작성할 수 있다.
이러한 인터페이스는 메소드의 구현부가 정의되어 있지 않은 추상 메소드들로 구성되어 있으며, 
내부의 모든 추상 메소드는 public 메소드이다.

PHP에서는 interface 키워드를 사용하여 인터페이스를 정의한다.

```php
interface 인터페이스이름
{
    구현할 메소드;
}
```

이렇게 정의된 인터페이스는 implements 키워드를 사용하여 구현할 수 있다. 
인터페이스를 구현하는 클래스는 인터페이스의 모든 메소드를 구현해야 한다.
이렇게 구현되는 메소드는 인터페이스에서 정의된 형태와 완전히 같은 형태로 정의되어야 한다.

인터페이스의 모든 메소드는 클래스 안에서 모두 구현되어야 한다.

```php
interface Transport              // 인터페이스의 정의
{
    public function move();      // 구현할 메소드
    public function stop();
}

class Car implements Transport   // Transport 인터페이스를 구현하는 Car 클래스
{
    function move()              // 메소드 구현
    {
        ...
    }
function stop()              // 메소드 구현
    {
        ...
    }
}
```

인터페이스도 클래스처럼 extends 키워드를 사용하여 상속받을 수 있다.

```php
interface Transport                  // 인터페이스의 정의
{
    public function move();          // 구현할 메소드
    public function stop();          // 구현할 메소드
}

interface Overland extends Transport // Transport 인터페이스를 상속받는 Overland 인터페이스
{
    public function highpass();      // 구현할 메소드
}

class Car implements Overload        // Overland 인터페이스를 구현하는 Car 클래스
{
    function move()                  // 메소드 구현
    {
        ...
    }

    function stop()                  // 메소드 구현
    {
        ...
    }

    function highpass()              // 메소드 구현
    {
        ...
    }
}
```

<aside>
💡 PHP 인터페이스는 클래스와는 달리 각각의 인터페이스를 쉼표(,)로 구분하여 여러 개의 인터페이스를 동시에 상속받을 수 있다.

</aside>

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-OOP_-edf61173b15948ce8542f229439ad954?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_oop_interface](http://www.tcpschool.com/php/php_oop_interface)
