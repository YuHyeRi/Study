# [PHP] OOP_오버로딩

**다형성(polymorphism)**

다형성이란 하나의 프로퍼티가 여러가지 상태를 가질 수 있는 것을 의미한다.
PHP에서는 이러한 다형성을 오버로딩과 지연 정적 바인딩을 통해 구현하고 있다.
다형성으느 상속, 추상화와 더불어 객체 지향 프로그래밍을 구성하는 중요한 특징 중 하나이다.

---

**오버로딩(overloading)**

다른 대부분의 객체 지향 프로그래밍 언어에서 오버로딩은 매개변수의 개수와 타입을 달리하여 
같은 이름의 메소드를 중복하여 정의하는 것을 의미한다.
하지만 PHP에서는 다른 언어와는 달리 프로퍼티나 메소드를 동적으로 ‘생성한다’는 의미로 
오버로딩을 사용한다.

이렇게 동적으로 생성된 멤버는 해당 클래스의 매직 메소드를 통해 다양한 형태로 처리할 수 있다.
이 때 오버로딩되는 메소드는 반드시 public으로 정의되어야만 한다.

<aside>
💡 매직 메소드란 PHP에서 특수한 기능을 위해 미래 정의된 메소드를 가리킨다. 이러한 매직 메소드는 메소드 이름과 매개변수, 반환 타입, 호출의 타이밍만이 정해져있으며, 그 내용은 사용자가 직접 작성하여 사용할 수 있다. PHP에서 모든 매직 메소드의 이름은 두 개의 언더스코어(__)로 시작한다.

</aside>

---

**프로퍼티 오버로딩(property overloading)**

PHP에서는 접근 불가 프로퍼디(inaccessible property)를 오버로딩하기 위해 다음과 같은 
매직 메소드를 구현해야 한다.

💜 매직 메소드의 원형

<aside>
💡 1. public void __set(string $name, mixed $value)

2. public mixed __get(string $name)

3. public bool __isset(string $name)

4. public bool __unset(string $name)

</aside>

1. __set() 메소드는 접근 불가 프로퍼티의 값을 설정할 때 호출된다.
2. __get() 메소드는 접근 불가 프로퍼티의 값을 읽을 때 호출된다.
3. __isset() 메소드는 접근 불가 프로퍼티에 대해 isset() 함수나 empty() 함수가 호출될 때 호출된다.
4. __unset() 메소드는 접근 불가 프로퍼티에 대해 unset() 함수가 호출될 때 호출된다.

<aside>
💡 접근불가 프로퍼티랑 현재 영역에서는 정의되어 있지 않거나 접근 제어로 인해 보이지 않는 프로퍼티를 의미한다.

</aside>

```php
class PropertyOverloading

{
    private $data = array(); // 오버로딩된 변수가 저장될 배열 생성
    public $declared = 10;   // public으로 선언된 프로퍼티
    private $hidden = 20;    // private로 선언된 프로퍼티

    public function __set($name, $value)
    {
        echo "$name 프로퍼티를 {$value}의 값으로 생성합니다!";
        $this->data[$name] = $value;
    }
    public function __get($name)
    {
        echo "$name 프로퍼티의 값을 읽습니다!<br>";
        if (array_key_exists($name, $this->data)) {
            return $this->data[$name];
        } else {
            return null;
        }
    }

    public function __isset($name)
    {
        echo "$name 프로퍼티가 설정되어 있는지 확인합니다!<br>";
        return isset($this->data[$name]);
    }

    public function __unset($name)
    {
        echo "$name 프로퍼티를 해지합니다!";
        unset($this->data[$name]);
    }
}

$obj = new PropertyOverloading(); // PropertyOverloading 객체 생성

① $obj->prop = 1;              // 동적 프로퍼티 생성
② echo $obj->prop;             // 동적 프로퍼티에 접근
③ var_dump(isset($obj->prop)); // 동적 프로퍼티로 isset() 함수 호출
④ unset($obj->prop);           // 동적 프로퍼티로 unset() 함수 호출
⑤ var_dump(isset($obj->prop)); // 동적 프로퍼티로 isset() 함수 호출
⑥ echo $obj->declared; // 선언된 프로퍼티는 오버로딩을 사용하지 않음.
⑦ echo $obj->hidden;   // private로 선언된 프로퍼티는 클래스 외부에서 접근할 수 없으므로, 오버로딩을 사용함.
```

위 예제에서는 프로퍼티를 오버로딩하기 위해 __set(), __get(), __isset(), __unset() 메소드를 구현하고 있다.

①번 라인에서는 동적으로 프로퍼티를 생성하고, ②번 라인에서는 그 값에 접근한다.
③과 ⑤번 라인에서는 생성된 동적 프로퍼티를 isset() 함수에 인수로 전달하고, 
④번 라인에서는 unset() 함수에 인수로 전달한다.
이때 ①번부터 ⑤번 라인까지의 모든 동작은 앞서 구현한 네 가지 메소드가 상황에 맞게 자동 호출됨으로써 이루어진다.
하지만 ⑥번 라인과 같이 일반적인 방법으로 선언된 프로퍼티에 접근할 때는 __get() 메소드를 호출하지 않는다.
다만, ⑦번 라인처럼 private로 선언된 프로퍼티는 클래스 외부에서는 접근할 수 없으므로, 
__get() 메소드를 호출하게 된다.

<aside>
💡 array_key_exists() 함수는 인수로 전달받은 키가 해당 배열에 저장되어 있으면 true를 반환하고, 저장되어 있지 않으면 false를 반환하는 함수이다.

</aside>

---

**메소드 오버로딩(method overloading)**

PHP에서는 접근불가 메소드를 오버로딩하기 위해 다음과 같은 매직 메소드를 구현해야 한다.

💜 매직 메소드의 원형

<aside>
💡 1. public mixed __call(string $name, array $arguments)

2. public static mixed __callStatic(string $name, array $arguments)

</aside>

1. __call() 메소드는 클래스 영역에서 접근 불가 메소드를 호출할 때 호출됩니다.
2. __callStatic() 메소드는 정적(static) 영역에서 접근 불가 메소드를 호출할 때 호출됩니다.

```php
class MethodOverloading

{
    public function __call($name, $arguments)
    {
        echo join(", ", $arguments)."에서 접근 불가 메소드를 호출합니다!";
    }
    public static function __callStatic($name, $arguments)
    {
        echo join(", ", $arguments)."에서 접근 불가 메소드를 호출합니다!";
    }
}

$obj = new MethodOverloading();             // MethodOverloading 객체 생성

① $obj->testMethod("클래스 영역");            // 클래스 영역에서 접근 불가 메소드 호출
② MethodOverloading::testMethod("정적 영역"); // 정적 영역에서 접근 불가 메소드 호출
```

위의 예제에서는 메소드를 오버로딩하기 위해 __call()과 __callStatic() 메소드를 구현하고 있다.

①번 라인에서는 동적으로 testMethod() 메소드를 생성하고, 바로 그 값에 접근한다.
이때 클래스 영역에서 생성된 동적 메소드에 접근하므로, 
사용자가 구현한 __call() 메소드가 호출된다.
②번 라인에서는 MethodOverloading 클래스의 정적 영역에서 동적 메소드에 접근한다. 
이때 정적 영역에서 생성된 동적 메소드에 접근하므로, 사용자가 구현한 __callStatic() 메소드가 호출된다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-OOP_-42fd4fcf11e54eb4811cd1267eb98967?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_oop_overloading](http://www.tcpschool.com/php/php_oop_overloading)
