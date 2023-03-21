# [PHP] 클래스의 사용

**인스턴스의 생성**

클래스가 선언되고 나면 선언된 클래스로부터 인스턴스를 생성할 수 있다.
PHP에서는 new 키워드를 사용하여 인스턴스를 생성할 수 있다.

이 때 클래스 이름을 통해 생성자로 필요한 인수를 전달할 수 있다.

```php
$객체이름 = new 클래스이름(인수1, 인수2, ...);
```

---

**클래스 멤버에 접근**

클래스와 프로퍼티에 접근하거나 메소드를 호출할 때는 화살표 기호(→)를 사용한다.

객체의 이름 뒤에 화살표 기호(→)를 붙이고 접근하려고 하는 프로퍼티나 호출하고자 하는 
메소드의 이름을 사용하면 된다.

```php
$객체이름->프로퍼티이름;
$객체이름->메소드이름;
```

PHP에서는 프로퍼티와 메소드의 접근 범위를 제한할 수 있으므로, 클래스 외부에서는 접근 제어자에 따라 접근이 가능할 수도 있고 또는 불가능할 수도 있다.

또한, 객체 내부에서 해당 인스턴스의 프로퍼티에 접근하고 싶을 때는 특별한 변수인 $this를 사용
할 수 있다.

$this 변수는 해당 인스턴스가 바로 자기 자신을 가리키는 데 사용하는 변수이다.

```php
$this->프로퍼티이름;
```

---

**접근 제어(access midifier)**

객체 지향 프로그래밍에서 정보 은닉이란 사용자가 굳이 알 필요 없는 정보는 사용자로부터 숨겨야 한다는 개념이다.
그렇게 함으로써 사용자는 언제나 최소한의 정보만으로 프로그램을 손쉽게 사용할 수 있게 된다.

PHP에서는 클래스 멤버에 public, private, protected 키워드를 사용하여 각각의 멤버에 대한 접근 
제어를 명시할 수 있다.

public으로 선언된 멤버는 외부로 공개되며, 해당 객체를 사용하는 어디에서나 직접 접근할 수 있게된다.
private로 선언된 멤버는 외부로 공개되지 않으며, 해당 클래스의 멤버에서만 접근할 수 있다.
protected로 선언된 멤버는 상위 클래스에 대해서는 public 멤버처럼 취급되며, 
외부에서는 private 멤버처럼 취급된다. 
즉, 해당 클래스의 멤버와 해당 클래스를 상속받은 자식 클래스에서만 접근할 수 있다,
var 키워드를 사용하여 클래스의 프로퍼티를 정의하면, 해당 프로퍼티의 접근 제어는 public으로 
자동 정의된다.
또한, 메소드를 작성할 때 접근 제어자를 생략하면 public으로 자동 정의된다.

```php
class ClassName
{
    public $publicVar;
    private $privateVar;
    protected $protectedVar;

    public function __constructor()
    {
        $this->publicVar = "public property<br>";
        $this->privateVar = "private property<br>";
        $this->protectedVar = "protected property<br>";
    }

    public function publicMethod()
    {
        echo "public method<br>";

    }
    protected function protectedMethod()
    {
        echo "protected method<br>";
    }
    private function privateMethod()
    {
        echo "private method<br>";
    }
}

$object = new ClassName();

echo $object->publicVar;      // 접근 가능
//echo $object->protectedVar; // 접근 불가능
//echo $object->privatev;     // 접근 불가능

$object->publicMethod();      // 호출 가능
//$object->protectedMethod(); // 호출 불가능
//$object->privateMethod();   // 호출 불가능
```

위의 예제처럼 외부에서는 접근 제어자가 public으로 명시된 프로퍼티와 메소드만을 호출할 수 있다.

---

**정보 은닉(data hiding)**

클래스 외부에서는 접근 제어 때문에 private 멤버나 protected 멤버로는 직접 접근할 수 없다.
하지만 public 메소드를 사용하면 해당 클래스의 private 멤버나 protected 멤버에도 접근할 수 
있다.

이렇게 public 메소드는 private 멤버나 protected 멤버와 프로그램 사이의 인터페이스(interface) 
역할을 수행한다.
이렇게 외부에서 바로 데이터로 접근하지 못하게 하는 것을 정보 은닉(data hiding)이라고 한다.

```php
class ClassName
{
    private $privateVar;

    public function __constructor()
    {
        $this->privateVar = "private property";
    }

    public function getValue()
    {
        return $this->privateVar;
    }

    public function setValue($value)
    {
        $this->privateVar = $value;
    }
}
$object = new ClassName();
$object->setValue("hello"); // setValue() 함수를 통해 $private의 값을 변경할 수 있음.
echo $object->getValue;     // getValue() 함수를 통해 $private의 값을 출력할 수 있음.
```

위의 예제는 클래스의 외부에서 public 메소드인 getValue()와 setValue() 메소드를 사용하여 해당 
클래스의 private 멤버에 접근할 수 있음을 보여주고 있다.

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-c68b0fe1c67949f1b017ec33c63b11b2?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_class_use](http://www.tcpschool.com/php/php_class_use)
