# [PHP] 예외 처리

**예외(exception)**

예외란 프로그램이 실행 중에 발생하는 런타임 오류를 의미한다.
이러한 예외가 발생하지 않도록 미리 방지하는 것도 중요하지만 발생한 예외를 처리하는 방법 또한 매우 중요하다.

예외 처리는 발생한 예외 상황을 처리할 수 있도록 코드 흐름을 바꾸는 행위를 의미한다.
PHP는 이러한 예외처리를 위해 객체 지향적인 방법을 제공하고 있다.
따라서 PHP에서 예외를 처리하는 방식은 쉽게 확장할 수 있으며 관리하기도 매우 쉽다.

---

**예외 처리(exception handling)**

PHP에서는 프로그램이 실행되는 도중 발생하는 예외를 처리하기 위해 try / catch / finally 문을 
사용한다.
try 블록 내부에서 예외가 발생하면 예외를 던지(throw)고, 잡아(catch)서 처리하는 구조이다.

자바와 같은 언어에서는 자동으로 예외를 던져주지만 PHP는 예외를 수동으로만 던질 수 있다.
PHP에서 throw 키워드를 사용하여 예외를 던질 수 있다.

```php
throw 예외객체;
```

이 때 예외 객체는 반드시 Exception 클래스나 Exception 클래스를 상속받은 자식 클래스이어야 
한다.

예외가 던저지고 나면 실행 중인 코드는 중지되고, try 블록 아래에 위치한 catch 블록에서 
해당 예외를 처리할 수 있다.
만약 던져진 예외가 끝까지 처리되지 않으면, 치명적인 오류가 발생한다.

```php
try
{
    예외를 처리하길 원하는 실행 코드;
}
catch(예외객체 매개변수)
{
    예외가 발생할 경우에 실행될 코드;
}
finally
{
    try 블록이 종료되면 무조건 실행될 코드;
}
```

1. try 블록 : 기본적으로 맨 먼저 실행되는 코드이며, 여기에서 발생한 예외는 catch 블록에서 처리될 수 있다.
2. catch 블록 : try 블록에서 던져진 예외코드나 Exception 객체를 인수로 전달받아 그 처리를 담당한다.
3. finally 블록 : 이 블록은 try 예외가 발생하건 안하건 맨 마지막에 무조건 실행된다.

catch 블록과 finally 블록은 선택적인 옵션으로 반드시 사용할 필요는 없다.

---

**Exception 클래스**

PHP는 미리 정의된 예외 클래스인 Exception 클래스르 제공하고 있다.
Exception 클래스는 PHP 5에서 발생하는 모든 예외의 조상 클래스이다.
또한 PHP 7에서는 모든 사용자 지정 예외의 조상 클래스가 된다.

<aside>
💡 PHP 7부터 Exception 클래스는 Throwable 인터페이스를 구현합니다.

</aside>

Exception 클래스는 다음과 같은 프로퍼티와 메소드를 가지고 있다.

<img src="https://file.notion.so/f/s/f2591017-0f20-4326-8bf6-ef60328a0dc7/Untitled.png?id=195f3d68-3c0e-4485-9721-0f40b0d8e498&table=block&spaceId=cbbefbcc-680a-4e93-a93e-800d7ccbe4ee&expirationTimestamp=1681204993844&signature=CaSkf0BX78IilVHtYxx0Ce1ppiLbBk4l7otAwp1PBH8&downloadName=Untitled.png">

```php
try
{
    throw new Exception("예외 메시지"); // 예외 객체 던짐.
}
catch(Exception $ex)                    // 예외 처리
{
    echo $ex->getMessage()."<br>";
    echo "예외가 발생한 파일 경로 : ".$ex->getFile()."<br>";

    echo "예외가 발생한 라인 번호 : ".$ex->getLine();
}
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-5e94d2327dbc4314b32d9ab38d761663?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_exception_handling](http://www.tcpschool.com/php/php_exception_handling)
