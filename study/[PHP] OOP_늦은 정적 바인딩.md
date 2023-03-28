# [PHP] OOP_늦은 정적 바인딩

**바인딩(binding)**

바인딩이란 프로그램에 사용된 구성 요소의 실제 값 또는 프로퍼티를 결정짓는 행위를 의미한다.
예를 들어 함수를 호출하는 부분에서 실제 함수가 위치한 메모리를 연결하는 것도 바로 바인딩이다.
이러한 바인딩은 크게 다음과 같이 구분할 수 있다.

1. 정적 바인딩(static binding) : 실행 시간 전에 일어나고 실행 시간에는 변하지 않은 상태로 
유지되는 바인딩
2. 동적 바인딩(dynamic binding) : 실행 시간에 이루어지거나 실행 시간에 변경되는 바인딩. 
이러한 동적 바인딩은 늦은 바인딩(late binding)이라고도 불린다.

하지만 PHP에서는 정적 바인딩과 동적 바인딩의 중간 정도 수준인 늦은 정적 바인딩(LSB)을 
제공하고 있다.

---

**늦은 정적 바인딩(late static bindings, LSB)**

PHP 5.3.0부터 제공되는 늦은 정적 바인딩은 static 키워드와 함께 범위 지정 연산자(::)를 사용하여 
수행할 수 있다.
늦은 정적 바인딩은 마지막으로 호출된 비전송 호출(non-forwarding call)의 클래스 이름을 저장하여 동작한다.
이 때 정적 메소드 호출에서는 범위 지정 연산자(::) 좌측에 명시된 클래스의 이름을 저장하며, 
비정적 메소드 호출에서는 해당 객체의 클래스 이름을 저장한다.
static::은 정의된 클래스를 컴파일 시간에 결정할 수 없고, 프로그램 실행 시 전달되는 정보로 
결정하므로 늦은 바인딩이다.
또한 정적 메소드 호출에도 사용할 수 있으므로 정적 바인딩이기도 하다.

<aside>
💡 범위 지정 연산자(::, scope resolution operator)는 클래스의 상수, 정적(static) 멤버 또는 재정의된 멤버에 접근할 수 있도록 해주는 연산자이다.

</aside>

---

**정적 메소드 호출에서의 늦은 정적 바인딩**

다음 예제는 self 키워드와 함께 범위 지정 연산자(::)를 사용하여 정적 메소드를 호출하는 예제이다.

```php
class A
{
    public static function className()
    {
        echo __CLASS__;
    }
    public static function printClass(
    {
        self::className();
    }
}
class B extends A
{
    public static function className(
    {
        echo __CLASS__;
    }
}

① B::printClass(); // A
```

위의 예제에서 ①번 라인의 실행 결과는 클래스 A를 출력한다.
즉, 클래스 B에서 printClass() 메소드를 호출하지만, 이 메소드는 클래스 A에서 정의되므로 
클래스 A를 출력하게 된다.

이처럼 현재 클래스를 참조하는 self::와 상수 __CLASS__는 사용하는 메소드가 어디에 정의되어 
있는가에 따라 그 값이 결정된다.

하지만 늦은 정적 바인딩을 사용하면, 클래스 B에서 호출한 printClass() 메소드가 현재 클래스로 
클래스 B를 참조하게 할 수 있다.

다음 예제는 static 키워드와 함께 범위 지정 연산자(::)를 사용하여 정적 메소드를 호출하는 예제이다.

```php
class A
{
    public static function className()
    {
        echo __CLASS__;
    }
    public static function printClass()
    {
        static::className();
    }
}
class B extends A
{
    public static function className()
    {
        echo __CLASS__;
    }
}

① B::printClass(); // B
```

위의 예제에서 ①번 라인의 실행 결과는 클래스 B를 출력한다.
printClass() 메소드가 클래스 A에서 정의되지만, 클래스 B에서 이  메소드를 호출하므로 클래스 B를 출력하게 된다.

이처럼 static 키워드와 범위 지정 연산자(::)를 함께 사용하면 늦은 정적 바인딩을 수행할 수 있다.

---

**비정적 메소드 호출에서의 늦은 정적 바인딩**

다음 예제는 static 키워드와 함께 범위 지정 연산자(::)를 사용하여 비정적 메소드를 호출하는
예제이다.

```php
class A
{
    private function className()
    {
        echo __CLASS__."<br>";
    }
    public function printClass()
    {
①      $this->className();
②      static::className();
    }
}

class B extends A

{
    // className() 메소드는 클래스 B로 복사되므로,
    // className() 메소드의 유효 범위는 여전히 클래스 A임.
}
class C extends A
{
    private function className()
    {
        // 기존의 className() 메소드가 이 메소드로 대체되므로,
        // className() 메소드의 유효 범위는 이제부터 클래스 C가 됨.
    }
}

$b = new B();
③ $b->printClass(); // A
                     // A
$c = new C();
④ $c->printClass(); // A
                    // Fatal error : Call to private method C::className() from context 'A'
```

위의 예제에서 className() 메소드는 클래스 A에서 처음으로 정의된다.
그리고서 클래스 B가 클래스 A를 상속받지만, 클래스 B에서 className() 메소드를 재정의하지는 
않는다.
따라서 className() 메소드의 유효 범위는 여전히 클래스 A가 되며, ③번 라인의 결과처럼 
변수 $this나 static::은 모두 클래스 A를 가리키게 된다.
하지만 클래스 C가 클래스 A를 상속받으면서 className() 메소드를 재정의한다.
따라서 className() 메소드의 유효 범위는 이제부터 클래스 C로 변경될 것이다.
그러므로 ④번 라인의 결과처럼 변수 $this는 여전히 클래스 A를 가리키겠지만, 
static::은 클래스 C를 가리키게 될 것이다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-OOP_-b8a565afcc8548f4951e79c8f4227245?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_oop_binding](http://www.tcpschool.com/php/php_oop_binding)
