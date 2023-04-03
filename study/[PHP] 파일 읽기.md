# [PHP] 파일 읽기

**파일 처리**

파일이란 의미 있는 정보를 담고 있으며, 이름을 가지고 있는 저장 장치상의 논리적인 단위를 
의미한다.
PHP에서는 데이터를 파일에 저장할 수도 있으며 파일로부터 데이터를 읽어들일 수도 있다.

---

**파일 처리 과정**

PHP에서 파일을 읽고 쓰는 과정은 각각 다음과 같은 단계를 거쳐서 처리된다.

*파일 읽기*

1. 파일 열기, 열리지 않으면 종료함
2. 파일에서 데이터 읽기
3. 파일 닫기

*파일 쓰기*

1. 파일 열기, 파일이 존재하지 안으면 생성함
2. 파일에 데이터 쓰기
3. 파일 닫기

다음 예제는 회원 가입을 위한 간단한 form 예제이다.

```jsx
<form action="request.php" method="post">
    이름 : <input type="text" name="name"><br>
    성별 :
    <input type="radio" name="gender" value="female">여자
    <input type="radio" name="gender" value="male">남자<br>
    이메일 : <input type="text" name="email"><br>
    <input type="submit">
</form>
```

다음 예제는 위의 예제를 통해 사용자가 입력한 회원 가입 정보를 서버 측에서 처리하는 PHP 
스크립트 예제이다.

```php
$name = $_POST["name"];          // 전송받은 데이터 대입
$gender = $_POST["gender"];
$email = $_POST["email"];

echo "이름 : ".$name."<br>";     // 데이터 출력
echo "성별 : ".$gender."<br>";
echo "이메일 : ".$email;
```

위의 예제는 단순히 입력받은 내용을 출력하는 예제이다.

---

**파일 열기**

PHP에서 파일은 fopen() 함수를 이용하여 열 수 있다.
fopen() 함수에는 첫 번째 인수로 열 파일의 주소를 전달 한다.
두 번째 인수로는 파일에 대한 접근 권한을 명시하는 파일 모드를 전달해야 한다.

fopen() 함수에서 사용할 수 있는 파일 모드는 다음과 같다.

<img src="https://file.notion.so/f/s/7d258ca2-b4b9-431c-a3b4-7939c8e0a562/Untitled.png?id=7a4b120b-a67c-4667-bd63-a0eb8bb4bb24&table=block&spaceId=cbbefbcc-680a-4e93-a93e-800d7ccbe4ee&expirationTimestamp=1680592063711&signature=KxxpPRRm60kXWx1i2qHt-fF8iAPQrQfJ-2cLFW4Q6aU&downloadName=Untitled.png">

또한 윈도우 시스템에서는 위와 같은 파일 모드 뒤에 다음과 같은 플래그를 추가하여 해당 파일의 
텍스트모드와 바이너리 모드를 명시할 수 있다.

파일 모드에서 ‘t’ 플래그를 추가하면 해당 파일을 텍스트 모드로 열게 된다.
텍스트 모드로 열린 파일은 파일 내부에 존재하는 줄 바꿈 문자('\n', '\r\n')를 해석하여 실제로 
줄 바꿈 된 상태로 전달할 것이다.

파일 모드에 ‘b’ 플래그를 추가하면 해당 파일을 바이너리 모드로 열게 된다.
바이너리 모드로 열린 파일은 파일 내부에 존재하는 줄 바꿈 문자('\n', '\r\n')르르 해석하지 않고 
그대로 전달할 것이다.

<aside>
💡 이러한 플래그의 기본 설정값은 PHP 버전마다 다르게 적용될 것이다. 따라서 fopen() 함수를 사용하여 파일을 열 때는 서로 다른 운영체제와 PHP 버전 간의 이식성을 고려하여 항상 ‘b’ 플래그를 추가하는 것이 좋다.

</aside>

다음 예제는 list.txt 파일을 쓰기 전용으로 연 후, 파일 포인터를 파일의 끝부분에 위치시키는 
예제이다.

```php
$fp = fopen("list.txt", 'a');
```

위의 예제에서 fopen() 함수는 해당 파일을 가리키고 있는 파일 포인터를 반환하여 변수 $fp에 
대입한다.
이렇게 저장된 파이리 포인터를 이용하여 해당 파일에 접근할 수 있다.

---

**파일 읽기**

fopen() 함수를 이용하여 파일을 연 후에는 데이터를 읽어올 수 있다.
PHP에서는 파일의 데이터를 읽기 위한 여러 함수를 제공한다.

1. fgets()
2. fgetc()
3. readfile()

---

**fgets() 함수**

fgets() 함수는 해당 파일에 데이터를 한 번에 한 줄씩 읽어들인다.
이 함수는 파일 포인터가 파일의 끝에 도달하거나 줄 바꿈 문자를 만날 때까지 계속 수행된다.

```php
$fp = fopen("list.txt", 'r');    // list.txt 파일을 읽기 전용으로 열고 반환된 파일 포인터를 $fp에 저장함.

while(!feof($fp)){               // 파일의 끝까지
    $member = fgets($fp);        // 한 줄씩 $member 변수에 저장하고 
    echo $member."<br>";         // 출력함.
}
```

위의 예제에서는 파일 의 끝을 알아보기 위해서 feof() 함수를 사용한다.
feof() 함수는 전달받은 파일 포인터가 파일의 끝에 도달하면 true를 반환한다.

<aside>
💡 EOF는 파일의 끝이라는 'End Of File'의 의미이다.

</aside>

---

**fgetc() 함수**

fgetc() 함수는 해당 파일에서 데이터를 한 번에 한 글자씩 읽어들인다.
이 함수는 전달받은 파일 포인터가 가리키는 문자를 반환한다.

다음 예제는 앞서 살펴본 fgets() 함수 예제를 fgetc() 함수를 이용하여 구현한 예제이다.

```php
$fp = fopen("list.txt", 'r');    // list.txt 파일을 읽기 전용으로 열고 반환된 파일 포인터를 $fp에 저장함.

while(!feof($fp)){               // 파일의 끝까지
    $char = fgetc($fp);          // 한 글자씩 $char 변수에 저장하고

    if($char == "\n")            // 출력함.
        $char = "<br>";

    if(!feof($fp))
        echo $char;
}
```

위의 예제에서 첫 번째 if문은 반환된 문자가 줄 바꿈 문자일 때, 해당 문자를  HTML <br> 태그로 
바꿔주는 역할을 한다.
두 번째 if문은 파일의 끝을 출력하지 않기 위해 사용된다.

<aside>
💡 fgetc() 함수는 바이너리 데이터를 안전하게 처리(binary-safe)할 수 있다.

</aside>

---

**readfile() 함수**

readfile() 함수는 해당 파일에서 데이터를 한 번에 모두 읽어들인다.
이 함수는 전달받은 파일 포인터가 가리키는 파일의 데이터를 모두 읽은 후, 출력 버퍼에 저장한다.

```php
echo readfile("list.txt");
```

---

**파일 닫기**

PHP에서 사용이 모두 끝난 파일은 fclose() 함수를 이용하여 닫을 수 있다.

```php
fclose($fp);
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-202875d7fa8441fe83458d3f3339c415?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_fileHandling_read](http://www.tcpschool.com/php/php_fileHandling_read)
