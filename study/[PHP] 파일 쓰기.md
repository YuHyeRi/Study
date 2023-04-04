# [PHP] 파일 쓰기

**파일 쓰기 처리 과정**

PHP에서 파일을 쓰는 과정은 다음과 같은 단계를 거쳐 처리된다.

1. 파일 열기, 파일이 존재하지 않으면 생성함
2. 파일에 데이터 쓰기
3. 파일 닫기

---

**파일 열기**

파일 읽기와 마찬가지로 fopen() 함수를 이용하여 파일을 열 수 있다.
파일에 데이터를 쓸 경우에는 파일 모드를 쓰기가 가능한 모드로 설정해야 한다.

```php
$fp = fopen("list.txt", 'w');
```

---

**파일 쓰기**

fopen() 함수를 이용하여 파일을 연 후에는 해당 파일에 데이터를 쓸 수 있다.

PHP에서는 파일에 데이터를 쓰기 위해 fwrite() 함수와 fputs() 함수를 제공한다. 
위의 두 함수 모두 해당 파일에 문자열을 저장하는 작업을 수행한다.

```php
$str = $name."\t".$gender."\t".$email."\n";
fwrite($fp, $str);
```

위의 예제처럼 fwrite() 함수에는 파일 포인터와 파일에 저장할 데이터가 저장된 문자열을 인수로 전달한다.

<aside>
💡 fwrite() 함수는 바이너리 데이터를 안전하게 처리할 수 있다.

</aside>

---

**파일 닫기**

PHP에서 사용이 모두 끝난 파일은 fclose() 함수를 이용하여 닫아줘야 한다.

```php
fclose($fp);
```

위의 예제처럼 fclose() 함수에는 닫고자 하는 파일을 가리키는 파일 포인터를 인수로 전달한다.
파일이 정상적으로 닫혔을 때는 true를 반환하며 그렇지 않을 때는 false를 반환한다.

---

**파일 쓰기 예제**

다음 예제는 PHP 스크립트에서 파일에 전송받은 데이터를 쓰는 과정을 나타내는 예제이다.

```php
$name = $_POST["name"];          // 전송받은 데이터 대입
$gender = $_POST["gender"];
$email = $_POST["email"];

echo "이름 : ".$name."<br/>";    // 데이터 출력
echo "성별 : ".$gender."<br/>";
echo "이메일 : ".$email;

$fp = fopen("list.txt", 'a');    // list.txt 파일을 쓰기 전용으로 열고 반환된 파일 포인터를 $fp에 저장.

$str = $name."\t".$gender."\t".$email."\n";
fwrite($fp, $str);               // list.txt 파일에 $str 변수를 저장함.

fclose($fp);                     // list.txt 파일 닫음.

echo "회원 등록 완료";
```

<br><br>
👉🏻 노션 : https://www.notion.so/tgmary09/PHP-2c0c654c50fb43be973feeb85dd49ac3?pvs=4
<br>
👉🏻 출처 : [http://www.tcpschool.com/php/php_fileHandling_write](http://www.tcpschool.com/php/php_fileHandling_write)
